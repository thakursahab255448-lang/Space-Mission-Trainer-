package com.example.model

import androidx.compose.ui.graphics.Color

enum class AcademyPage(
    val id: String,
    val title: String,
    val hindiTitle: String,
    val emoji: String,
    val shortTitle: String
) {
    HOME("home", "Home", "होम पेज", "🚀", "Home"),
    EXPLORE_SPACE("explore_space", "Explore Space", "अंतरिक्ष की खोज", "🌌", "Space"),
    SOLAR_SYSTEM("solar_system", "Solar System", "सौर मंडल", "☀️", "Solar"),
    PLANET_EXPLORER("planet_explorer", "Planet Explorer", "ग्रह एक्सप्लोरर", "🪐", "Planets"),
    MOON_EXPLORATION("moon_exploration", "Moon Exploration", "चंद्रमा मिशन", "🌙", "Moon"),
    MARS_EXPLORATION("mars_exploration", "Mars Exploration", "मंगल ग्रह की खोज", "🔴", "Mars"),
    ASTRONAUT_LIFE("astronaut_life", "Astronaut Life", "अंतरिक्ष यात्री का जीवन", "👨‍🚀", "Astronaut"),
    ROCKETS_TECH("rockets_tech", "Rockets & Technology", "रॉकेट और तकनीक", "🛰️", "Rockets"),
    GALAXY_UNIVERSE("galaxy_universe", "Galaxies & Universe", "आकाशगंगा और ब्रह्मांड", "🌀", "Galaxy"),
    ACTIVITIES("activities", "Interactive Activities", "मजेदार गतिविधियाँ", "🎮", "Activities"),
    QUIZ_CENTER("quiz_center", "Quiz Center", "क्विज़ सेंटर", "🏆", "Quizzes"),
    DASHBOARD("dashboard", "My Learning Dashboard", "मेरा डैशबोर्ड", "⭐", "Dashboard"),
    ABOUT_US("about_us", "NASA & About Us", "नासा और हमारे बारे में", "🔭", "NASA & Info")
}

enum class SceneAnimationType {
    STARFIELD_NEBULA,
    ORBITING_PLANETS,
    MOON_ORBIT,
    MARS_ROVER_DRIVE,
    ASTRONAUT_FLOAT,
    ROCKET_BLASTOFF,
    SPIRAL_GALAXY,
    BLACK_HOLE_GRAVITY
}

data class LessonMiniQuiz(
    val question: String,
    val hindiQuestion: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val hindiExplanation: String
)

data class Lesson(
    val id: String,
    val moduleId: String,
    val moduleName: String,
    val lessonNumber: Int,
    val title: String,
    val hindiTitle: String,
    val emoji: String,
    val simpleExplanation: List<String>,
    val everydayExample: String,
    val hindiExplanation: String,
    val importantFacts: List<String>,
    val whatDidYouLearn: List<String>,
    val sceneType: SceneAnimationType,
    val miniQuiz: LessonMiniQuiz
)

data class LearningModule(
    val id: String,
    val number: Int,
    val title: String,
    val hindiTitle: String,
    val subtitle: String,
    val emoji: String,
    val accentColor: Color,
    val targetPage: AcademyPage,
    val lessons: List<Lesson>
)

data class PlanetData(
    val id: String,
    val orderFromSun: Int,
    val name: String,
    val hindiName: String,
    val nickname: String,
    val hindiNickname: String,
    val emoji: String,
    val primaryColor: Color,
    val secondaryColor: Color,
    val hasRings: Boolean,
    val relativeSizeRatio: Float, // Earth = 1.0f (visual scaled for UI)
    val realDiameterKm: String,
    val sizeComparisonText: String,
    val temperatureInfo: String,
    val distanceFromSunKm: String,
    val orbitalPeriod: String,
    val moonsCount: Int,
    val moonsNotable: String,
    val introduction: String,
    val hindiIntroduction: String,
    val interestingFacts: List<String>,
    val funFact: String,
    val hindiFunFact: String,
    val miniQuiz: LessonMiniQuiz
)

enum class QuizDifficulty(val label: String, val hindiLabel: String, val starsReward: Int) {
    EASY("Easy", "आसान", 1),
    MEDIUM("Medium", "मध्यम", 2),
    ADVANCED("Advanced", "कठिन", 3)
}

enum class QuizQuestionType(val label: String) {
    MULTIPLE_CHOICE("Multiple Choice"),
    TRUE_FALSE("True or False"),
    PICTURE_BASED("Picture Clue")
}

data class QuizQuestion(
    val id: String,
    val moduleId: String,
    val moduleTitle: String,
    val difficulty: QuizDifficulty,
    val type: QuizQuestionType,
    val visualEmoji: String,
    val visualCaption: String,
    val question: String,
    val hindiQuestion: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String,
    val hindiExplanation: String
)

data class SpaceFact(
    val id: Int,
    val title: String,
    val fact: String,
    val hindiFact: String,
    val source: String,
    val emoji: String
)

data class AchievementBadge(
    val id: String,
    val title: String,
    val hindiTitle: String,
    val description: String,
    val emoji: String,
    val requiredStars: Int,
    val requiredLessons: Int
)

data class NasaResource(
    val id: String,
    val title: String,
    val category: String,
    val description: String,
    val hindiDescription: String,
    val verifiedDataHighlight: String,
    val url: String,
    val emoji: String
)

data class SpaceVocabItem(
    val term: String,
    val hindiTerm: String,
    val simpleMeaning: String,
    val hindiMeaning: String,
    val exampleSentence: String,
    val emoji: String
)

data class MoonPhaseInfo(
    val index: Int,
    val name: String,
    val hindiName: String,
    val emoji: String,
    val illuminationFraction: Float,
    val waxing: Boolean,
    val description: String,
    val hindiDescription: String
)
