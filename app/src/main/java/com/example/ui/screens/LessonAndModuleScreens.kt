package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.LessonsCatalogPart2
import com.example.model.LearningModule
import com.example.model.Lesson
import com.example.ui.SpaceTtsManager
import com.example.ui.components.EducationalSceneCanvas
import com.example.ui.components.MoonPhaseCanvas
import com.example.ui.theme.AuroraGreen
import com.example.ui.theme.CardBorderPurple
import com.example.ui.theme.CardSurfacePurple
import com.example.ui.theme.CosmicBlue
import com.example.ui.theme.CosmicPurple
import com.example.ui.theme.CyanNebula
import com.example.ui.theme.DangerRed
import com.example.ui.theme.ElectricPurple
import com.example.ui.theme.MarsOrange
import com.example.ui.theme.MoonSilver
import com.example.ui.theme.RocketAmber
import com.example.ui.theme.SpaceBlack
import com.example.ui.theme.StarGold
import com.example.ui.theme.StarWhite

@Composable
fun InteractiveLessonDetailScreen(
    lesson: Lesson,
    isCompleted: Boolean,
    showHindiDefault: Boolean,
    ttsManager: SpaceTtsManager,
    onToggleHindiDefault: (Boolean) -> Unit,
    onMarkCompleted: () -> Unit,
    onNextLesson: () -> Unit,
    onBackToModule: () -> Unit
) {
    val isSpeaking by ttsManager.isSpeaking.collectAsState()
    val speakingId by ttsManager.speakingId.collectAsState()

    var showHindi by remember(lesson.id, showHindiDefault) { mutableStateOf(showHindiDefault) }
    var selectedAnswer by remember(lesson.id) { mutableStateOf<Int?>(null) }
    var quizSubmitted by remember(lesson.id) { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Navigation Bar inside Lesson
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = onBackToModule,
                border = BorderStroke(1.5.dp, CyanNebula),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = StarWhite),
                modifier = Modifier.testTag("back_to_module_button")
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                Spacer(Modifier.width(6.dp))
                Text("All Lessons")
            }

            if (isCompleted || (quizSubmitted && selectedAnswer == lesson.miniQuiz.correctIndex)) {
                Surface(
                    color = AuroraGreen.copy(alpha = 0.2f),
                    border = BorderStroke(1.dp, AuroraGreen),
                    shape = RoundedCornerShape(50)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "Completed", tint = AuroraGreen, modifier = Modifier.size(18.dp))
                        Spacer(Modifier.width(6.dp))
                        Text("Completed (+3 ⭐)", style = MaterialTheme.typography.labelLarge, color = AuroraGreen)
                    }
                }
            }
        }

        // Lesson Header Card
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, ElectricPurple),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "${lesson.moduleName} • Lesson ${lesson.lessonNumber}",
                    style = MaterialTheme.typography.labelLarge,
                    color = CyanNebula
                )
                Spacer(Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = lesson.emoji, fontSize = 38.sp)
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.headlineMedium,
                            color = StarWhite
                        )
                        Text(
                            text = lesson.hindiTitle,
                            style = MaterialTheme.typography.titleMedium,
                            color = StarGold
                        )
                    }
                }

                Spacer(Modifier.height(14.dp))

                // Action Row: Listen to Lesson (English & Hindi TTS) + Hindi Toggle
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val englishSpeechId = "en_${lesson.id}"
                    val isSpeakingEnglish = isSpeaking && speakingId == englishSpeechId
                    Button(
                        onClick = {
                            val fullText = "${lesson.title}. " +
                                lesson.simpleExplanation.joinToString(" ") +
                                " Everyday Example: ${lesson.everydayExample}. " +
                                "Important facts: " + lesson.importantFacts.joinToString(". ")
                            ttsManager.speak(englishSpeechId, fullText, hindi = false)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSpeakingEnglish) DangerRed else MarsOrange
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("listen_lesson_en_button")
                    ) {
                        Icon(
                            imageVector = if (isSpeakingEnglish) Icons.Default.Stop else Icons.AutoMirrored.Filled.VolumeUp,
                            contentDescription = "Listen to lesson in English"
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(if (isSpeakingEnglish) "Stop Audio" else "Listen (English)")
                    }

                    val hindiSpeechId = "hi_${lesson.id}"
                    val isSpeakingHindi = isSpeaking && speakingId == hindiSpeechId
                    Button(
                        onClick = {
                            ttsManager.speak(
                                hindiSpeechId,
                                "${lesson.hindiTitle}। ${lesson.hindiExplanation}",
                                hindi = true
                            )
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSpeakingHindi) DangerRed else CosmicBlue
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("listen_lesson_hi_button")
                    ) {
                        Icon(
                            imageVector = if (isSpeakingHindi) Icons.Default.Stop else Icons.Default.Translate,
                            contentDescription = "Listen in Hindi"
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(if (isSpeakingHindi) "रोकें (Stop)" else "सुनें (Hindi)")
                    }
                }
            }
        }

        // Animated Educational Scene
        Card(
            colors = CardDefaults.cardColors(containerColor = CosmicPurple),
            border = BorderStroke(1.5.dp, CardBorderPurple),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "🎬 Animated Educational Space Scene",
                        style = MaterialTheme.typography.titleMedium,
                        color = CyanNebula
                    )
                    Text(
                        text = "Live Simulation",
                        style = MaterialTheme.typography.labelMedium,
                        color = StarGold
                    )
                }
                Spacer(Modifier.height(10.dp))
                EducationalSceneCanvas(sceneType = lesson.sceneType)
            }
        }

        // Simple Explanation Section
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, CardBorderPurple),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "📖 Simple Explanation",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarGold
                )
                lesson.simpleExplanation.forEachIndexed { idx, para ->
                    Surface(
                        color = CosmicPurple.copy(alpha = 0.75f),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(MarsOrange),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${idx + 1}",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = StarWhite
                                )
                            }
                            Spacer(Modifier.width(12.dp))
                            Text(
                                text = para,
                                style = MaterialTheme.typography.bodyLarge,
                                color = StarWhite
                            )
                        }
                    }
                }

                // Everyday Analogy Box
                Surface(
                    color = Color(0xFF1A2956),
                    border = BorderStroke(1.5.dp, CyanNebula),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = "Everyday Example",
                            tint = StarGold,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Imagine It Like This! (Everyday Example)",
                                style = MaterialTheme.typography.titleSmall,
                                color = CyanNebula
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = lesson.everydayExample,
                                style = MaterialTheme.typography.bodyMedium,
                                color = StarWhite
                            )
                        }
                    }
                }
            }
        }

        // Optional Hindi Explanation Card
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF28174E)),
            border = BorderStroke(1.5.dp, StarGold),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🇮🇳", fontSize = 24.sp)
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "हिंदी में सरल व्याख्या (Hindi Explanation)",
                            style = MaterialTheme.typography.titleMedium,
                            color = StarGold
                        )
                    }
                    Switch(
                        checked = showHindi,
                        onCheckedChange = {
                            showHindi = it
                            onToggleHindiDefault(it)
                        },
                        colors = SwitchDefaults.colors(checkedThumbColor = StarGold, checkedTrackColor = MarsOrange),
                        modifier = Modifier.testTag("lesson_hindi_switch")
                    )
                }
                AnimatedVisibility(visible = showHindi) {
                    Column(modifier = Modifier.padding(top = 10.dp)) {
                        Text(
                            text = lesson.hindiExplanation,
                            style = MaterialTheme.typography.bodyLarge,
                            color = StarWhite,
                            lineHeight = 26.sp
                        )
                    }
                }
            }
        }

        // Important Facts
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, CardBorderPurple),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "🌟 Important Space Facts",
                    style = MaterialTheme.typography.titleLarge,
                    color = CyanNebula
                )
                lesson.importantFacts.forEach { fact ->
                    Row(verticalAlignment = Alignment.Top) {
                        Text(text = "⭐", fontSize = 18.sp)
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = fact,
                            style = MaterialTheme.typography.bodyLarge,
                            color = StarWhite
                        )
                    }
                }
            }
        }

        // What Did You Learn? Section
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF142A3A)),
            border = BorderStroke(1.5.dp, AuroraGreen),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "🧠 What Did You Learn?",
                    style = MaterialTheme.typography.titleLarge,
                    color = AuroraGreen
                )
                lesson.whatDidYouLearn.forEach { summaryPoint ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = AuroraGreen,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = summaryPoint,
                            style = MaterialTheme.typography.bodyMedium,
                            color = StarWhite
                        )
                    }
                }
            }
        }

        // Short Lesson Quiz
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, MarsOrange),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Quiz, contentDescription = null, tint = StarGold)
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = "Quick Lesson Check (Earn 3 ⭐!)",
                        style = MaterialTheme.typography.titleLarge,
                        color = StarGold
                    )
                }

                Text(
                    text = lesson.miniQuiz.question,
                    style = MaterialTheme.typography.titleMedium,
                    color = StarWhite
                )
                if (showHindi) {
                    Text(
                        text = lesson.miniQuiz.hindiQuestion,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MoonSilver
                    )
                }

                lesson.miniQuiz.options.forEachIndexed { idx, opt ->
                    val isThisSelected = selectedAnswer == idx
                    val isCorrectOption = idx == lesson.miniQuiz.correctIndex
                    val bgColor = when {
                        !quizSubmitted && isThisSelected -> CosmicBlue.copy(alpha = 0.45f)
                        quizSubmitted && isCorrectOption -> AuroraGreen.copy(alpha = 0.30f)
                        quizSubmitted && isThisSelected && !isCorrectOption -> DangerRed.copy(alpha = 0.30f)
                        else -> CosmicPurple
                    }
                    val borderColor = when {
                        !quizSubmitted && isThisSelected -> CyanNebula
                        quizSubmitted && isCorrectOption -> AuroraGreen
                        quizSubmitted && isThisSelected && !isCorrectOption -> DangerRed
                        else -> CardBorderPurple
                    }

                    Surface(
                        color = bgColor,
                        border = BorderStroke(1.5.dp, borderColor),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedAnswer = idx
                                quizSubmitted = true
                                if (idx == lesson.miniQuiz.correctIndex) {
                                    onMarkCompleted()
                                }
                            }
                            .testTag("lesson_quiz_option_$idx")
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${('A' + idx)}.",
                                style = MaterialTheme.typography.titleMedium,
                                color = StarGold
                            )
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = opt,
                                style = MaterialTheme.typography.bodyLarge,
                                color = StarWhite
                            )
                        }
                    }
                }

                if (quizSubmitted) {
                    val isCorrect = selectedAnswer == lesson.miniQuiz.correctIndex
                    Surface(
                        color = if (isCorrect) AuroraGreen.copy(alpha = 0.18f) else MarsOrange.copy(alpha = 0.18f),
                        border = BorderStroke(1.dp, if (isCorrect) AuroraGreen else MarsOrange),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = if (isCorrect) "🎉 Correct! Awesome job, Space Explorer! (+3 ⭐)" else "💡 Good try! Look at the green answer above:",
                                style = MaterialTheme.typography.titleMedium,
                                color = if (isCorrect) AuroraGreen else StarGold
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = lesson.miniQuiz.explanation,
                                style = MaterialTheme.typography.bodyMedium,
                                color = StarWhite
                            )
                            if (showHindi) {
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = lesson.miniQuiz.hindiExplanation,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MoonSilver
                                )
                            }
                        }
                    }
                }
            }
        }

        // Next Lesson Button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (!isCompleted) {
                OutlinedButton(
                    onClick = onMarkCompleted,
                    border = BorderStroke(1.5.dp, AuroraGreen),
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Star, contentDescription = null, tint = StarGold)
                    Spacer(Modifier.width(6.dp))
                    Text("Mark Completed", color = AuroraGreen)
                }
            }
            Button(
                onClick = onNextLesson,
                colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
                modifier = Modifier
                    .weight(1f)
                    .height(54.dp)
                    .testTag("next_lesson_button")
            ) {
                Text("Next Lesson", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.width(8.dp))
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Lesson")
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ModuleLearningScreen(
    module: LearningModule,
    completedLessonIds: Set<String>,
    showHindi: Boolean,
    onOpenLesson: (Lesson) -> Unit,
    onStartModuleQuiz: (String) -> Unit
) {
    val scrollState = rememberScrollState()
    val completedInModule = module.lessons.count { it.id in completedLessonIds }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Module Banner Card
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, module.accentColor),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = module.accentColor.copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, module.accentColor),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = "MODULE ${module.number}",
                            style = MaterialTheme.typography.labelLarge,
                            color = module.accentColor,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp)
                        )
                    }
                    Text(
                        text = "$completedInModule / ${module.lessons.size} Completed ⭐",
                        style = MaterialTheme.typography.labelLarge,
                        color = StarGold
                    )
                }

                Spacer(Modifier.height(12.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = module.emoji, fontSize = 44.sp)
                    Spacer(Modifier.width(14.dp))
                    Column {
                        Text(
                            text = module.title,
                            style = MaterialTheme.typography.headlineLarge,
                            color = StarWhite
                        )
                        if (showHindi) {
                            Text(
                                text = module.hindiTitle,
                                style = MaterialTheme.typography.titleMedium,
                                color = StarGold
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = module.subtitle,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MoonSilver
                        )
                    }
                }

                // Module Hero Art for Mars or Rockets
                if (module.id == "mod_5") {
                    Spacer(Modifier.height(14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img_mars_rover_1794726968122),
                        contentDescription = "Mars Rover and Habitat Dome on Mars",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(175.dp)
                            .clip(RoundedCornerShape(18.dp))
                    )
                } else if (module.id == "mod_6" || module.id == "mod_7") {
                    Spacer(Modifier.height(14.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img_rocket_launch_1794726969844),
                        contentDescription = "Astronaut, Space Station and Rocket",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(175.dp)
                            .clip(RoundedCornerShape(18.dp))
                    )
                }

                Spacer(Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { onOpenLesson(module.lessons.first()) },
                        colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("start_first_lesson_${module.id}")
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text("Start Lesson 1")
                    }
                    OutlinedButton(
                        onClick = { onStartModuleQuiz(module.id) },
                        border = BorderStroke(1.5.dp, StarGold),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.Quiz, contentDescription = null, tint = StarGold)
                        Spacer(Modifier.width(6.dp))
                        Text("Module Quiz (10 Qs)", color = StarGold)
                    }
                }
            }
        }

        // Interactive Module Feature Labs!
        when (module.id) {
            "mod_4" -> InteractiveMoonPhasesLab(showHindi = showHindi)
            "mod_5" -> InteractiveMars2077HabitatLab(showHindi = showHindi)
            "mod_6" -> InteractiveSpaceSuitInspector(showHindi = showHindi)
            "mod_7" -> InteractiveRocketPartsInspector(showHindi = showHindi)
            "mod_8" -> InteractiveGalaxyTypesExplorer(showHindi = showHindi)
        }

        // Lessons List
        Text(
            text = "📚 Interactive Lessons in ${module.title}",
            style = MaterialTheme.typography.headlineSmall,
            color = StarWhite
        )

        module.lessons.forEach { lesson ->
            val done = lesson.id in completedLessonIds
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (done) Color(0xFF1B2E3C) else CardSurfacePurple
                ),
                border = BorderStroke(
                    width = 1.5.dp,
                    color = if (done) AuroraGreen else CardBorderPurple
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenLesson(lesson) }
                    .testTag("lesson_card_${lesson.id}")
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(module.accentColor.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = lesson.emoji, fontSize = 28.sp)
                    }
                    Spacer(Modifier.width(14.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Lesson ${lesson.lessonNumber}: ${lesson.title}",
                            style = MaterialTheme.typography.titleMedium,
                            color = StarWhite
                        )
                        if (showHindi) {
                            Text(
                                text = lesson.hindiTitle,
                                style = MaterialTheme.typography.bodyMedium,
                                color = StarGold
                            )
                        }
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = lesson.simpleExplanation.firstOrNull() ?: "",
                            style = MaterialTheme.typography.bodySmall,
                            color = MoonSilver,
                            maxLines = 2
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    if (done) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Default.CheckCircle, contentDescription = "Completed", tint = AuroraGreen)
                            Text("+3 ⭐", style = MaterialTheme.typography.labelMedium, color = StarGold)
                        }
                    } else {
                        Surface(
                            color = MarsOrange,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Open",
                                style = MaterialTheme.typography.labelLarge,
                                color = StarWhite,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InteractiveMoonPhasesLab(showHindi: Boolean) {
    val phases = LessonsCatalogPart2.moonPhases
    var selectedPhaseIdx by remember { mutableIntStateOf(4) } // Default Full Moon
    val phase = phases[selectedPhaseIdx]

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF18123E)),
        border = BorderStroke(1.5.dp, CyanNebula),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "🌙 Interactive Moon Phase Simulator",
                style = MaterialTheme.typography.titleLarge,
                color = CyanNebula
            )
            Text(
                text = "Tap any Moon phase below to see how sunlight lights up the Moon during its 29.5-day orbit!",
                style = MaterialTheme.typography.bodySmall,
                color = MoonSilver
            )
            Spacer(Modifier.height(12.dp))

            MoonPhaseCanvas(
                illuminationFraction = phase.illuminationFraction,
                waxing = phase.waxing,
                sizeDp = 125.dp
            )

            Spacer(Modifier.height(8.dp))
            Text(
                text = "${phase.emoji} ${phase.name}",
                style = MaterialTheme.typography.headlineSmall,
                color = StarGold
            )
            if (showHindi) {
                Text(
                    text = phase.hindiName,
                    style = MaterialTheme.typography.titleSmall,
                    color = CyanNebula
                )
            }
            Spacer(Modifier.height(4.dp))
            Text(
                text = phase.description,
                style = MaterialTheme.typography.bodyMedium,
                color = StarWhite
            )
            if (showHindi) {
                Text(
                    text = phase.hindiDescription,
                    style = MaterialTheme.typography.bodySmall,
                    color = MoonSilver
                )
            }

            Spacer(Modifier.height(12.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                phases.forEachIndexed { idx, p ->
                    FilterChip(
                        selected = selectedPhaseIdx == idx,
                        onClick = { selectedPhaseIdx = idx },
                        label = { Text("${p.emoji} ${p.name}") },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = CosmicBlue,
                            selectedLabelColor = StarWhite
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InteractiveMars2077HabitatLab(showHindi: Boolean) {
    val zones = remember {
        listOf(
            Triple(
                "🌱 Hydroponic Greenhouse Dome",
                "ग्लास ग्रीनहाउस गुंबद",
                "Astronauts grow potatoes, leafy greens, strawberries, and tomatoes using LED sunlight and recycled water!"
            ),
            Triple(
                "⚙️ MOXIE Oxygen Generator",
                "ऑक्सीजन बनाने की मशीन",
                "Pulls in Mars's 95% carbon dioxide air and splits off pure breathable oxygen for astronauts and rocket fuel!"
            ),
            Triple(
                "🧊 Polar Ice Water Extractor",
                "बर्फ से पानी निकालने का संयंत्र",
                "Melts and filters underground Martian water ice so astronauts have clean drinking water every day."
            ),
            Triple(
                "🏠 3D-Printed Regolith Shield",
                "3D-प्रिंटेड मिट्टी का सुरक्षा कवच",
                "Thick walls printed from Martian dirt protect astronauts from cosmic radiation and freezing -65°C cold!"
            )
        )
    }
    var selectedZone by remember { mutableIntStateOf(0) }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2B1328)),
        border = BorderStroke(1.5.dp, MarsOrange),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "🔴 Mars 2077 Colony Base Explorer",
                style = MaterialTheme.typography.titleLarge,
                color = MarsOrange
            )
            Text(
                text = "Tap each base station module to see how astronauts will live on Mars:",
                style = MaterialTheme.typography.bodySmall,
                color = MoonSilver
            )
            Spacer(Modifier.height(10.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                zones.forEachIndexed { idx, z ->
                    FilterChip(
                        selected = selectedZone == idx,
                        onClick = { selectedZone = idx },
                        label = { Text(z.first) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MarsOrange,
                            selectedLabelColor = StarWhite
                        )
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Surface(
                color = SpaceBlack.copy(alpha = 0.55f),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text(
                        text = zones[selectedZone].first,
                        style = MaterialTheme.typography.titleMedium,
                        color = StarGold
                    )
                    if (showHindi) {
                        Text(
                            text = zones[selectedZone].second,
                            style = MaterialTheme.typography.labelLarge,
                            color = CyanNebula
                        )
                    }
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = zones[selectedZone].third,
                        style = MaterialTheme.typography.bodyMedium,
                        color = StarWhite
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InteractiveSpaceSuitInspector(showHindi: Boolean) {
    val suitParts = remember {
        listOf(
            Triple("🥽 Gold-Coated Visor Helmet", "सोने की परत वाला हेलमेट", "Blocks blinding sunlight and harmful UV rays while keeping pressurized oxygen around the astronaut's head."),
            Triple("🎒 Life Support Backpack (PLSS)", "लाइफ सपोर्ट बैकपैक", "Supplies pure breathable oxygen, removes carbon dioxide, powers the radio, and circulates cooling water."),
            Triple("🧤 Heated Pressurized Gloves", "विशेष दस्ताने", "Built with built-in fingertip heaters so astronauts can use tools outside in -150°C shadow!"),
            Triple("🛡️ 16-Layer Suit Armor", "16 परतों वाला सुरक्षा कवच", "Stops tiny high-speed space dust (micrometeoroids) and insulates against boiling heat and freezing cold.")
        )
    }
    var selectedIdx by remember { mutableIntStateOf(0) }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF142A3A)),
        border = BorderStroke(1.5.dp, AuroraGreen),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "👨‍🚀 Interactive Space Suit Inspector",
                style = MaterialTheme.typography.titleLarge,
                color = AuroraGreen
            )
            Spacer(Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                suitParts.forEachIndexed { idx, part ->
                    FilterChip(
                        selected = selectedIdx == idx,
                        onClick = { selectedIdx = idx },
                        label = { Text(part.first) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = AuroraGreen.copy(alpha = 0.3f),
                            selectedLabelColor = StarWhite
                        )
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = "${suitParts[selectedIdx].first} (${suitParts[selectedIdx].second})",
                style = MaterialTheme.typography.titleMedium,
                color = StarGold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = suitParts[selectedIdx].third,
                style = MaterialTheme.typography.bodyMedium,
                color = StarWhite
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InteractiveRocketPartsInspector(showHindi: Boolean) {
    val stages = remember {
        listOf(
            Triple("1️⃣ Nose Cone & Payload", "पेलोड (सबसे ऊपरी भाग)", "Protects the astronauts' Crew Capsule, Mars Rover, or Space Telescope at the very top of the rocket."),
            Triple("2️⃣ Guidance System Brain", "गाइडेंस कंप्यूटर", "Radar, gyroscopes, and flight computers that steer the rocket smoothly into orbit."),
            Triple("3️⃣ Upper Stage (Stage 2)", "दूसरा चरण (Second Stage)", "Ignites high in the sky after the first booster drops away, pushing the spacecraft to 28,000 km/h!"),
            Triple("4️⃣ First Stage Booster & Engines", "मुख्य बूस्टर और इंजन", "Holds huge tanks of fuel and liquid oxygen to lift the heavy rocket off the launchpad against Earth's gravity.")
        )
    }
    var selectedStage by remember { mutableIntStateOf(0) }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF281D12)),
        border = BorderStroke(1.5.dp, RocketAmber),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "🚀 Interactive Rocket Stage Inspector",
                style = MaterialTheme.typography.titleLarge,
                color = RocketAmber
            )
            Spacer(Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                stages.forEachIndexed { idx, s ->
                    FilterChip(
                        selected = selectedStage == idx,
                        onClick = { selectedStage = idx },
                        label = { Text(s.first) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MarsOrange,
                            selectedLabelColor = StarWhite
                        )
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = "${stages[selectedStage].first} • ${stages[selectedStage].second}",
                style = MaterialTheme.typography.titleMedium,
                color = StarGold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stages[selectedStage].third,
                style = MaterialTheme.typography.bodyMedium,
                color = StarWhite
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InteractiveGalaxyTypesExplorer(showHindi: Boolean) {
    val items = remember {
        listOf(
            Triple("🌀 Spiral Galaxy (Milky Way & Andromeda)", "सर्पिल आकाशगंगा", "Flat spinning pinwheels with bright curving arms full of young stars, glowing nebulas, and cosmic dust!"),
            Triple("🥚 Elliptical Galaxy", "दीर्घवृत्ताकार आकाशगंगा", "Smooth round or oval spheres containing billions or trillions of older yellow and red stars."),
            Triple("☁️ Irregular Galaxy", "अनियमित आकाशगंगा", "Free-form cosmic star clouds without spiral arms, bursting with bright newborn stars!"),
            Triple("✨ Saptarishi / Big Dipper Constellation", "सप्तर्षि तारामंडल", "Seven bright stars in Ursa Major whose front two pointer stars guide travelers directly to Polaris (Dhruva Tara, the North Star)!")
        )
    }
    var selectedIdx by remember { mutableIntStateOf(0) }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF261238)),
        border = BorderStroke(1.5.dp, ElectricPurple),
        shape = RoundedCornerShape(24.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(
                text = "🌌 Galaxy & Constellation Explorer",
                style = MaterialTheme.typography.titleLarge,
                color = ElectricPurple
            )
            Spacer(Modifier.height(8.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items.forEachIndexed { idx, item ->
                    FilterChip(
                        selected = selectedIdx == idx,
                        onClick = { selectedIdx = idx },
                        label = { Text(item.first) }
                    )
                }
            }
            Spacer(Modifier.height(10.dp))
            Text(
                text = "${items[selectedIdx].first} (${items[selectedIdx].second})",
                style = MaterialTheme.typography.titleMedium,
                color = StarGold
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = items[selectedIdx].third,
                style = MaterialTheme.typography.bodyMedium,
                color = StarWhite
            )
        }
    }
}
