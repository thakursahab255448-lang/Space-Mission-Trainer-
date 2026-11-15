package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AcademyProgressRepository
import com.example.data.CompletedLessonEntity
import com.example.data.LessonsCatalogPart2
import com.example.data.PlanetsCatalog
import com.example.data.QuizAttemptEntity
import com.example.data.RecentTopicEntity
import com.example.data.SpaceAcademyDatabase
import com.example.model.AcademyPage
import com.example.model.AchievementBadge
import com.example.model.Lesson
import com.example.model.PlanetData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class DashboardSummaryState(
    val totalLessonsCount: Int = LessonsCatalogPart2.allLessonsFlat.size,
    val completedLessons: List<CompletedLessonEntity> = emptyList(),
    val completedLessonIds: Set<String> = emptySet(),
    val quizAttempts: List<QuizAttemptEntity> = emptyList(),
    val recentTopics: List<RecentTopicEntity> = emptyList(),
    val completedActivities: Set<String> = emptySet(),
    val totalStars: Int = 0,
    val unlockedBadges: List<AchievementBadge> = emptyList(),
    val highestTitle: String = "Young Space Explorer",
    val highestHindiTitle: String = "युवा अंतरिक्ष खोजकर्ता",
    val cadetName: String = "Young Explorer",
    val showHindi: Boolean = true
) {
    val progressPercent: Int
        get() = if (totalLessonsCount == 0) 0 else ((completedLessonIds.size * 100) / totalLessonsCount).coerceIn(0, 100)
}

class AcademyViewModel(application: Application) : AndroidViewModel(application) {
    private val db = SpaceAcademyDatabase.getInstance(application)
    private val repository = AcademyProgressRepository(db.spaceAcademyDao(), application)
    val ttsManager = SpaceTtsManager(application)

    private val _currentPage = MutableStateFlow(AcademyPage.HOME)
    val currentPage: StateFlow<AcademyPage> = _currentPage.asStateFlow()

    private val _pageHistory = MutableList<AcademyPage>(0) { AcademyPage.HOME }

    private val _selectedPlanet = MutableStateFlow<PlanetData>(PlanetsCatalog.allPlanets[3]) // Default Mars
    val selectedPlanet: StateFlow<PlanetData> = _selectedPlanet.asStateFlow()

    private val _activeLesson = MutableStateFlow<Lesson?>(null)
    val activeLesson: StateFlow<Lesson?> = _activeLesson.asStateFlow()

    private val _dailyFactIndex = MutableStateFlow(0)
    val dailyFactIndex: StateFlow<Int> = _dailyFactIndex.asStateFlow()

    private val _preselectedQuizModuleId = MutableStateFlow<String?>(null)
    val preselectedQuizModuleId: StateFlow<String?> = _preselectedQuizModuleId.asStateFlow()

    val dashboardState: StateFlow<DashboardSummaryState> = combine(
        repository.completedLessons,
        repository.quizAttempts,
        repository.recentTopics,
        combine(
            repository.cadetName,
            repository.bonusStars,
            repository.completedActivities,
            repository.showHindiByDefault
        ) { name, bonus, acts, hindi ->
            Quadruple(name, bonus, acts, hindi)
        }
    ) { lessons, quizzes, recents, prefsQuad ->
        val (name, bonus, acts, hindi) = prefsQuad
        val lessonStars = lessons.sumOf { it.starsEarned }
        val quizStars = quizzes.sumOf { it.starsEarned }
        val totalStars = lessonStars + quizStars + bonus
        val completedIds = lessons.map { it.lessonId }.toSet()

        val unlocked = LessonsCatalogPart2.achievementBadges.filter { badge ->
            totalStars >= badge.requiredStars || completedIds.size >= badge.requiredLessons
        }
        val highestBadge = unlocked.lastOrNull()

        DashboardSummaryState(
            totalLessonsCount = LessonsCatalogPart2.allLessonsFlat.size,
            completedLessons = lessons,
            completedLessonIds = completedIds,
            quizAttempts = quizzes,
            recentTopics = recents,
            completedActivities = acts,
            totalStars = totalStars,
            unlockedBadges = unlocked,
            highestTitle = highestBadge?.title ?: "Junior Space Cadet",
            highestHindiTitle = highestBadge?.hindiTitle ?: "जूनियर स्पेस कैडेट",
            cadetName = name,
            showHindi = hindi
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = DashboardSummaryState()
    )

    fun navigateToPage(page: AcademyPage) {
        ttsManager.stop()
        _activeLesson.value = null
        if (_currentPage.value != page) {
            _pageHistory.add(_currentPage.value)
            _currentPage.value = page
        }
        viewModelScope.launch {
            repository.recordRecentTopic(
                topicId = "page_${page.id}",
                title = page.title,
                category = "Section",
                emoji = page.emoji
            )
        }
    }

    fun openPlanetDetail(planet: PlanetData) {
        ttsManager.stop()
        _selectedPlanet.value = planet
        navigateToPage(AcademyPage.PLANET_EXPLORER)
        viewModelScope.launch {
            repository.recordRecentTopic(
                topicId = "planet_${planet.id}",
                title = "Planet ${planet.name}",
                category = "Planet Explorer",
                emoji = planet.emoji
            )
        }
    }

    fun selectPlanetInExplorer(planet: PlanetData) {
        ttsManager.stop()
        _selectedPlanet.value = planet
        viewModelScope.launch {
            repository.recordRecentTopic(
                topicId = "planet_${planet.id}",
                title = "Planet ${planet.name}",
                category = "Planet Explorer",
                emoji = planet.emoji
            )
        }
    }

    fun openLesson(lesson: Lesson) {
        ttsManager.stop()
        _activeLesson.value = lesson
        viewModelScope.launch {
            repository.recordRecentTopic(
                topicId = "lesson_${lesson.id}",
                title = lesson.title,
                category = lesson.moduleName,
                emoji = lesson.emoji
            )
        }
    }

    fun closeActiveLesson() {
        ttsManager.stop()
        _activeLesson.value = null
    }

    fun goToNextLesson(currentLesson: Lesson) {
        ttsManager.stop()
        markLessonCompleted(currentLesson)
        val allLessons = LessonsCatalogPart2.allLessonsFlat
        val idx = allLessons.indexOfFirst { it.id == currentLesson.id }
        if (idx in 0 until allLessons.lastIndex) {
            _activeLesson.value = allLessons[idx + 1]
        } else {
            _activeLesson.value = null
        }
    }

    fun markLessonCompleted(lesson: Lesson, stars: Int = 3) {
        viewModelScope.launch {
            repository.completeLesson(
                lessonId = lesson.id,
                moduleId = lesson.moduleId,
                title = lesson.title,
                stars = stars
            )
        }
    }

    fun markPlanetCompleted(planet: PlanetData) {
        viewModelScope.launch {
            repository.completeLesson(
                lessonId = "m3_${planet.id}",
                moduleId = "mod_3",
                title = "Planet #${planet.orderFromSun}: ${planet.name}",
                stars = 3
            )
        }
    }

    fun recordQuizResult(
        moduleId: String,
        moduleTitle: String,
        difficulty: String,
        score: Int,
        totalQuestions: Int,
        starsEarned: Int
    ) {
        viewModelScope.launch {
            repository.saveQuizAttempt(
                moduleId = moduleId,
                moduleTitle = moduleTitle,
                difficulty = difficulty,
                score = score,
                totalQuestions = totalQuestions,
                starsEarned = starsEarned
            )
        }
    }

    fun recordActivityWin(activityId: String, activityName: String, stars: Int = 4) {
        repository.recordActivityCompleted(activityId, stars)
        viewModelScope.launch {
            repository.recordRecentTopic(
                topicId = "act_$activityId",
                title = activityName,
                category = "Space Activity",
                emoji = "🎮"
            )
        }
    }

    fun launchQuizForModule(moduleId: String?) {
        _preselectedQuizModuleId.value = moduleId
        navigateToPage(AcademyPage.QUIZ_CENTER)
    }

    fun nextDailyFact() {
        val total = LessonsCatalogPart2.dailySpaceFacts.size
        _dailyFactIndex.value = (_dailyFactIndex.value + 1) % total
    }

    fun previousDailyFact() {
        val total = LessonsCatalogPart2.dailySpaceFacts.size
        _dailyFactIndex.value = (_dailyFactIndex.value - 1 + total) % total
    }

    fun updateCadetName(name: String) {
        repository.updateCadetName(name)
    }

    fun toggleHindi(enabled: Boolean) {
        repository.toggleHindiDefault(enabled)
    }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
        }
    }

    fun canNavigateBack(): Boolean {
        return _activeLesson.value != null || _pageHistory.isNotEmpty() || _currentPage.value != AcademyPage.HOME
    }

    fun navigateBack() {
        ttsManager.stop()
        if (_activeLesson.value != null) {
            _activeLesson.value = null
            return
        }
        if (_pageHistory.isNotEmpty()) {
            _currentPage.value = _pageHistory.removeAt(_pageHistory.lastIndex)
        } else {
            _currentPage.value = AcademyPage.HOME
        }
    }

    override fun onCleared() {
        super.onCleared()
        ttsManager.shutdown()
    }
}

private data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
