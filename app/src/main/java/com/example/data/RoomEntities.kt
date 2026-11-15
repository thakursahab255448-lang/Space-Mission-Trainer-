package com.example.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Entity(tableName = "completed_lessons")
data class CompletedLessonEntity(
    @PrimaryKey val lessonId: String,
    val moduleId: String,
    val title: String,
    val starsEarned: Int,
    val completedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "quiz_attempts")
data class QuizAttemptEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val moduleId: String,
    val moduleTitle: String,
    val difficulty: String,
    val score: Int,
    val totalQuestions: Int,
    val starsEarned: Int,
    val timestamp: Long = System.currentTimeMillis()
)

@Entity(tableName = "recent_topics")
data class RecentTopicEntity(
    @PrimaryKey val topicId: String,
    val title: String,
    val category: String,
    val emoji: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Dao
interface SpaceAcademyDao {
    @Query("SELECT * FROM completed_lessons ORDER BY completedAt DESC")
    fun getAllCompletedLessons(): Flow<List<CompletedLessonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletedLesson(lesson: CompletedLessonEntity)

    @Query("SELECT * FROM quiz_attempts ORDER BY timestamp DESC")
    fun getAllQuizAttempts(): Flow<List<QuizAttemptEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuizAttempt(attempt: QuizAttemptEntity)

    @Query("SELECT * FROM recent_topics ORDER BY timestamp DESC LIMIT 12")
    fun getRecentTopics(): Flow<List<RecentTopicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentTopic(topic: RecentTopicEntity)

    @Query("DELETE FROM completed_lessons")
    suspend fun clearCompletedLessons()

    @Query("DELETE FROM quiz_attempts")
    suspend fun clearQuizAttempts()

    @Query("DELETE FROM recent_topics")
    suspend fun clearRecentTopics()
}

@Database(
    entities = [
        CompletedLessonEntity::class,
        QuizAttemptEntity::class,
        RecentTopicEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SpaceAcademyDatabase : RoomDatabase() {
    abstract fun spaceAcademyDao(): SpaceAcademyDao

    companion object {
        @Volatile
        private var INSTANCE: SpaceAcademyDatabase? = null

        fun getInstance(context: Context): SpaceAcademyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpaceAcademyDatabase::class.java,
                    "mars_2077_academy.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}

class AcademyProgressRepository(
    private val dao: SpaceAcademyDao,
    context: Context
) {
    private val prefs = context.getSharedPreferences("mars_2077_prefs", Context.MODE_PRIVATE)

    val completedLessons: Flow<List<CompletedLessonEntity>> = dao.getAllCompletedLessons()
    val quizAttempts: Flow<List<QuizAttemptEntity>> = dao.getAllQuizAttempts()
    val recentTopics: Flow<List<RecentTopicEntity>> = dao.getRecentTopics()

    private val _cadetName = MutableStateFlow(prefs.getString("cadet_name", "Young Explorer") ?: "Young Explorer")
    val cadetName: StateFlow<String> = _cadetName.asStateFlow()

    private val _bonusStars = MutableStateFlow(prefs.getInt("bonus_stars", 0))
    val bonusStars: StateFlow<Int> = _bonusStars.asStateFlow()

    private val _completedActivities = MutableStateFlow(
        prefs.getStringSet("completed_activities", emptySet()) ?: emptySet()
    )
    val completedActivities: StateFlow<Set<String>> = _completedActivities.asStateFlow()

    private val _showHindiByDefault = MutableStateFlow(prefs.getBoolean("show_hindi", true))
    val showHindiByDefault: StateFlow<Boolean> = _showHindiByDefault.asStateFlow()

    fun updateCadetName(name: String) {
        val cleanName = name.trim().ifEmpty { "Young Explorer" }
        prefs.edit().putString("cadet_name", cleanName).apply()
        _cadetName.value = cleanName
    }

    fun toggleHindiDefault(enabled: Boolean) {
        prefs.edit().putBoolean("show_hindi", enabled).apply()
        _showHindiByDefault.value = enabled
    }

    fun recordActivityCompleted(activityId: String, starsAwarded: Int) {
        val updated = _completedActivities.value.toMutableSet().apply { add(activityId) }
        val newBonus = _bonusStars.value + starsAwarded
        prefs.edit()
            .putStringSet("completed_activities", updated)
            .putInt("bonus_stars", newBonus)
            .apply()
        _completedActivities.value = updated
        _bonusStars.value = newBonus
    }

    suspend fun completeLesson(lessonId: String, moduleId: String, title: String, stars: Int = 3) {
        dao.insertCompletedLesson(
            CompletedLessonEntity(
                lessonId = lessonId,
                moduleId = moduleId,
                title = title,
                starsEarned = stars
            )
        )
        dao.insertRecentTopic(
            RecentTopicEntity(
                topicId = "lesson_$lessonId",
                title = title,
                category = "Lesson",
                emoji = "📘"
            )
        )
    }

    suspend fun saveQuizAttempt(
        moduleId: String,
        moduleTitle: String,
        difficulty: String,
        score: Int,
        totalQuestions: Int,
        starsEarned: Int
    ) {
        dao.insertQuizAttempt(
            QuizAttemptEntity(
                moduleId = moduleId,
                moduleTitle = moduleTitle,
                difficulty = difficulty,
                score = score,
                totalQuestions = totalQuestions,
                starsEarned = starsEarned
            )
        )
        dao.insertRecentTopic(
            RecentTopicEntity(
                topicId = "quiz_${moduleId}_${System.currentTimeMillis()}",
                title = "$moduleTitle Quiz ($score/$totalQuestions)",
                category = "Quiz",
                emoji = "🏆"
            )
        )
    }

    suspend fun recordRecentTopic(topicId: String, title: String, category: String, emoji: String) {
        dao.insertRecentTopic(
            RecentTopicEntity(
                topicId = topicId,
                title = title,
                category = category,
                emoji = emoji
            )
        )
    }

    suspend fun resetAllProgress() {
        dao.clearCompletedLessons()
        dao.clearQuizAttempts()
        dao.clearRecentTopics()
        prefs.edit()
            .putInt("bonus_stars", 0)
            .putStringSet("completed_activities", emptySet())
            .apply()
        _bonusStars.value = 0
        _completedActivities.value = emptySet()
    }
}
