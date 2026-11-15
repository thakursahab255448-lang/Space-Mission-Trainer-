package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.LessonsCatalogPart2
import com.example.data.PlanetsCatalog
import com.example.model.AcademyPage
import com.example.model.Lesson
import com.example.model.PlanetData
import com.example.ui.DashboardSummaryState
import com.example.ui.SpaceTtsManager
import com.example.ui.components.InteractiveSolarSystemCanvas
import com.example.ui.components.PlanetIllustrationCanvas
import com.example.ui.theme.AuroraGreen
import com.example.ui.theme.CardBorderPurple
import com.example.ui.theme.CardSurfacePurple
import com.example.ui.theme.CosmicBlue
import com.example.ui.theme.CosmicPurple
import com.example.ui.theme.CyanNebula
import com.example.ui.theme.DangerRed
import com.example.ui.theme.EarthColor
import com.example.ui.theme.ElectricPurple
import com.example.ui.theme.GalaxyPink
import com.example.ui.theme.MarsOrange
import com.example.ui.theme.MoonSilver
import com.example.ui.theme.RocketAmber
import com.example.ui.theme.SpaceBlack
import com.example.ui.theme.StarGold
import com.example.ui.theme.StarWhite

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    dashboardState: DashboardSummaryState,
    dailyFactIndex: Int,
    ttsManager: SpaceTtsManager,
    onStartLearning: () -> Unit,
    onExploreSpace: () -> Unit,
    onNavigatePage: (AcademyPage) -> Unit,
    onOpenPlanet: (PlanetData) -> Unit,
    onOpenLesson: (Lesson) -> Unit,
    onNextFact: () -> Unit,
    onPrevFact: () -> Unit
) {
    val scrollState = rememberScrollState()
    val dailyFact = LessonsCatalogPart2.dailySpaceFacts[dailyFactIndex % LessonsCatalogPart2.dailySpaceFacts.size]
    val isSpeaking by ttsManager.isSpeaking.collectAsState()
    val speakingId by ttsManager.speakingId.collectAsState()

    var previewPlanet by remember { mutableStateOf(PlanetsCatalog.allPlanets[3]) } // Mars

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // 1. HERO CARD: MARS 2077 LOGO + WELCOME + ASTRONAUT ILLUSTRATION + CTA BUTTONS
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, MarsOrange),
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                // Academy Logo Badge
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Surface(
                        color = MarsOrange.copy(alpha = 0.2f),
                        border = BorderStroke(1.5.dp, MarsOrange),
                        shape = RoundedCornerShape(50)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = "🚀", fontSize = 18.sp)
                            Spacer(Modifier.width(6.dp))
                            Text(
                                text = "MARS 2077 – SPACE LEARNING ACADEMY",
                                style = MaterialTheme.typography.labelLarge,
                                color = StarGold
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "Welcome, Young Space Explorer!",
                    style = MaterialTheme.typography.displaySmall,
                    color = StarWhite
                )
                if (dashboardState.showHindi) {
                    Text(
                        text = "स्वागत है, नन्हे अंतरिक्ष खोजकर्ता!",
                        style = MaterialTheme.typography.titleMedium,
                        color = StarGold
                    )
                }

                Spacer(Modifier.height(6.dp))
                Text(
                    text = "\"Explore the Universe, One Discovery at a Time!\"",
                    style = MaterialTheme.typography.titleMedium,
                    color = CyanNebula
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Ready to explore the universe? Put on your astronaut suit and begin your journey!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MoonSilver
                )

                Spacer(Modifier.height(14.dp))

                // Friendly 3D Astronaut Hero Image
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(195.dp)
                        .clip(RoundedCornerShape(22.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.img_hero_astronaut_1794726966015),
                        contentDescription = "Friendly cartoon astronaut waving in outer space with planets and rocket",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Surface(
                        color = SpaceBlack.copy(alpha = 0.72f),
                        shape = RoundedCornerShape(topStart = 14.dp),
                        modifier = Modifier.align(Alignment.BottomEnd)
                    ) {
                        Text(
                            text = "👨‍🚀 Cadet ${dashboardState.cadetName} • ${dashboardState.highestTitle}",
                            style = MaterialTheme.typography.labelMedium,
                            color = StarGold,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }

                Spacer(Modifier.height(16.dp))

                // Start Learning & Explore Space Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = onStartLearning,
                        colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
                        modifier = Modifier
                            .weight(1f)
                            .height(54.dp)
                            .testTag("home_start_learning_button")
                    ) {
                        Icon(Icons.Default.RocketLaunch, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Start Learning", style = MaterialTheme.typography.titleMedium)
                    }
                    Button(
                        onClick = onExploreSpace,
                        colors = ButtonDefaults.buttonColors(containerColor = CosmicBlue),
                        modifier = Modifier
                            .weight(1f)
                            .height(54.dp)
                            .testTag("home_explore_space_button")
                    ) {
                        Icon(Icons.Default.Explore, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Explore Space", style = MaterialTheme.typography.titleMedium)
                    }
                }
            }
        }

        // 2. LEARNING PROGRESS & JUNIOR ASTRONAUT STATUS BAR
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A123E)),
            border = BorderStroke(1.5.dp, CyanNebula),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onNavigatePage(AcademyPage.DASHBOARD) }
                .testTag("home_progress_card")
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.WorkspacePremium, contentDescription = null, tint = StarGold, modifier = Modifier.size(28.dp))
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Your Academy Progress",
                                style = MaterialTheme.typography.titleLarge,
                                color = StarWhite
                            )
                            Text(
                                text = "Rank: ${dashboardState.highestTitle} (${dashboardState.highestHindiTitle})",
                                style = MaterialTheme.typography.bodySmall,
                                color = CyanNebula
                            )
                        }
                    }
                    Surface(
                        color = StarGold.copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, StarGold),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = "⭐ ${dashboardState.totalStars} Stars",
                            style = MaterialTheme.typography.titleMedium,
                            color = StarGold,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))
                LinearProgressIndicator(
                    progress = { dashboardState.progressPercent / 100f },
                    color = AuroraGreen,
                    trackColor = SpaceBlack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .clip(RoundedCornerShape(50))
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "📘 ${dashboardState.completedLessonIds.size} / ${dashboardState.totalLessonsCount} Lessons Completed (${dashboardState.progressPercent}%)",
                        style = MaterialTheme.typography.bodySmall,
                        color = MoonSilver
                    )
                    Text(
                        text = "View Certificate →",
                        style = MaterialTheme.typography.labelLarge,
                        color = StarGold
                    )
                }
            }
        }

        // 3. DAILY SPACE FACT OF THE DAY
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF28164A)),
            border = BorderStroke(1.5.dp, StarGold),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = dailyFact.emoji, fontSize = 28.sp)
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "🌟 Space Fact of the Day",
                                style = MaterialTheme.typography.titleLarge,
                                color = StarGold
                            )
                            Text(
                                text = "Source: ${dailyFact.source}",
                                style = MaterialTheme.typography.bodySmall,
                                color = CyanNebula
                            )
                        }
                    }

                    val factSpeechId = "fact_${dailyFact.id}"
                    val isSpeakingFact = isSpeaking && speakingId == factSpeechId
                    IconButton(
                        onClick = {
                            ttsManager.speak(
                                factSpeechId,
                                "${dailyFact.title}. ${dailyFact.fact}",
                                hindi = false
                            )
                        }
                    ) {
                        Icon(
                            imageVector = if (isSpeakingFact) Icons.Default.Stop else Icons.AutoMirrored.Filled.VolumeUp,
                            contentDescription = "Listen to Space Fact",
                            tint = StarGold
                        )
                    }
                }

                Spacer(Modifier.height(8.dp))
                Text(
                    text = dailyFact.fact,
                    style = MaterialTheme.typography.bodyLarge,
                    color = StarWhite,
                    fontWeight = FontWeight.Medium
                )
                if (dashboardState.showHindi) {
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "🇮🇳 ${dailyFact.hindiFact}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MoonSilver
                    )
                }

                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onPrevFact,
                        border = BorderStroke(1.dp, CardBorderPurple)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous Fact", modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Prev Fact")
                    }
                    Text(
                        text = "Fact ${dailyFactIndex + 1} of ${LessonsCatalogPart2.dailySpaceFacts.size}",
                        style = MaterialTheme.typography.labelMedium,
                        color = MoonSilver
                    )
                    OutlinedButton(
                        onClick = onNextFact,
                        border = BorderStroke(1.dp, StarGold),
                        modifier = Modifier.testTag("next_daily_fact_button")
                    ) {
                        Text("Next Fact", color = StarGold)
                        Spacer(Modifier.width(4.dp))
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Fact", tint = StarGold, modifier = Modifier.size(16.dp))
                    }
                }
            }
        }

        // 4. INTERACTIVE ANIMATED SOLAR SYSTEM PREVIEW ON HOME PAGE
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, ElectricPurple),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "☀️ Interactive Solar System",
                            style = MaterialTheme.typography.titleLarge,
                            color = StarWhite
                        )
                        Text(
                            text = "Tap any orbiting planet below to inspect it!",
                            style = MaterialTheme.typography.bodySmall,
                            color = CyanNebula
                        )
                    }
                    OutlinedButton(
                        onClick = { onNavigatePage(AcademyPage.SOLAR_SYSTEM) },
                        border = BorderStroke(1.dp, CyanNebula)
                    ) {
                        Text("Full View", color = CyanNebula)
                    }
                }

                Spacer(Modifier.height(10.dp))
                InteractiveSolarSystemCanvas(
                    selectedPlanet = previewPlanet,
                    speedMultiplier = 1f,
                    showOrbitLines = true,
                    showLabels = true,
                    onPlanetTapped = { previewPlanet = it },
                    height = 270.dp
                )

                Spacer(Modifier.height(12.dp))
                // Selected Planet Quick Strip
                Surface(
                    color = CosmicPurple,
                    border = BorderStroke(1.dp, previewPlanet.primaryColor),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = previewPlanet.emoji, fontSize = 32.sp)
                            Spacer(Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "#${previewPlanet.orderFromSun} ${previewPlanet.name} (${previewPlanet.hindiName})",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = StarGold
                                )
                                Text(
                                    text = "${previewPlanet.nickname} • Moons: ${previewPlanet.moonsCount}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = StarWhite
                                )
                            }
                        }
                        Button(
                            onClick = { onOpenPlanet(previewPlanet) },
                            colors = ButtonDefaults.buttonColors(containerColor = MarsOrange)
                        ) {
                            Text("Explore")
                        }
                    }
                }
            }
        }

        // 5. ALL 8 LEARNING MODULES GRID
        Text(
            text = "🚀 8 Space Learning Modules",
            style = MaterialTheme.typography.headlineSmall,
            color = StarWhite
        )
        LessonsCatalogPart2.allModules.forEach { module ->
            val completedCount = module.lessons.count { it.id in dashboardState.completedLessonIds }
            Card(
                colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
                border = BorderStroke(1.5.dp, module.accentColor.copy(alpha = 0.8f)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigatePage(module.targetPage) }
                    .testTag("home_module_card_${module.id}")
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(module.accentColor.copy(alpha = 0.22f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = module.emoji, fontSize = 30.sp)
                    }
                    Spacer(Modifier.width(14.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Module ${module.number}: ${module.title}",
                            style = MaterialTheme.typography.titleMedium,
                            color = StarWhite
                        )
                        if (dashboardState.showHindi) {
                            Text(
                                text = module.hindiTitle,
                                style = MaterialTheme.typography.labelLarge,
                                color = StarGold
                            )
                        }
                        Text(
                            text = module.subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MoonSilver
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "$completedCount/${module.lessons.size}",
                            style = MaterialTheme.typography.titleMedium,
                            color = AuroraGreen
                        )
                        Text(
                            text = "Lessons",
                            style = MaterialTheme.typography.bodySmall,
                            color = MoonSilver
                        )
                    }
                }
            }
        }

        // 6. FEATURED LESSONS SECTION
        Text(
            text = "⭐ Featured Space Lessons",
            style = MaterialTheme.typography.headlineSmall,
            color = StarWhite
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val featured = listOf(
                LessonsCatalogPart2.allLessonsFlat.first { it.id == "m1_l1" },
                LessonsCatalogPart2.allLessonsFlat.first { it.id == "m5_l5" },
                LessonsCatalogPart2.allLessonsFlat.first { it.id == "m6_l3" },
                LessonsCatalogPart2.allLessonsFlat.first { it.id == "m8_l2" }
            )
            featured.forEach { lesson ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = CosmicPurple),
                    border = BorderStroke(1.5.dp, CyanNebula),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .width(240.dp)
                        .clickable { onOpenLesson(lesson) }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = lesson.emoji, fontSize = 32.sp)
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = lesson.title,
                            style = MaterialTheme.typography.titleMedium,
                            color = StarWhite,
                            maxLines = 1
                        )
                        Text(
                            text = lesson.hindiTitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = StarGold,
                            maxLines = 1
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = lesson.simpleExplanation.first(),
                            style = MaterialTheme.typography.bodySmall,
                            color = MoonSilver,
                            maxLines = 2
                        )
                    }
                }
            }
        }

        // 7. FUN SPACE ACTIVITIES & QUIZ BANNER
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1F1448)),
            border = BorderStroke(2.dp, GalaxyPink),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "🎮 Fun Space Activities & Quiz Center",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarWhite
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Play Match the Planet, Guess the Planet, Arrange Planets in Order, Space Vocabulary, Identify the Astronaut, Find the Space Object & Planet Memory Challenge!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MoonSilver
                )
                Spacer(Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Button(
                        onClick = { onNavigatePage(AcademyPage.ACTIVITIES) },
                        colors = ButtonDefaults.buttonColors(containerColor = GalaxyPink),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("home_activities_button")
                    ) {
                        Icon(Icons.Default.SportsEsports, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text("7 Activities")
                    }
                    Button(
                        onClick = { onNavigatePage(AcademyPage.QUIZ_CENTER) },
                        colors = ButtonDefaults.buttonColors(containerColor = RocketAmber),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("home_quiz_center_button")
                    ) {
                        Icon(Icons.Default.Quiz, contentDescription = null, tint = SpaceBlack)
                        Spacer(Modifier.width(6.dp))
                        Text("Quiz Center", color = SpaceBlack)
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SolarSystemInteractiveScreen(
    completedLessonIds: Set<String>,
    showHindi: Boolean,
    onOpenPlanetDetail: (PlanetData) -> Unit,
    onOpenLesson: (Lesson) -> Unit,
    onStartModuleQuiz: () -> Unit
) {
    val scrollState = rememberScrollState()
    val planets = PlanetsCatalog.allPlanets
    var selectedPlanet by remember { mutableStateOf(planets[2]) } // Default Earth
    var speedMultiplier by remember { mutableFloatStateOf(1f) }
    var showOrbits by remember { mutableStateOf(true) }

    val module2 = LessonsCatalogPart2.allModules.first { it.id == "mod_2" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Header
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, StarGold),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "☀️ Interactive 3D-Style Solar System",
                    style = MaterialTheme.typography.headlineMedium,
                    color = StarGold
                )
                if (showHindi) {
                    Text(
                        text = "इंटरएक्टिव सौर मंडल — किसी भी ग्रह पर टैप करें!",
                        style = MaterialTheme.typography.titleSmall,
                        color = CyanNebula
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Tap any planet in the orbit simulator or the planet chips below to explore its speed, distance, moons, and size!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MoonSilver
                )

                Spacer(Modifier.height(12.dp))
                InteractiveSolarSystemCanvas(
                    selectedPlanet = selectedPlanet,
                    speedMultiplier = speedMultiplier,
                    showOrbitLines = showOrbits,
                    showLabels = true,
                    onPlanetTapped = { selectedPlanet = it },
                    height = 330.dp
                )

                Spacer(Modifier.height(12.dp))
                // Orbit Controls
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        listOf(0f to "Pause", 0.5f to "0.5x", 1f to "1x", 2f to "2x").forEach { (spd, label) ->
                            FilterChip(
                                selected = speedMultiplier == spd,
                                onClick = { speedMultiplier = spd },
                                label = { Text(label) }
                            )
                        }
                    }
                    FilterChip(
                        selected = showOrbits,
                        onClick = { showOrbits = !showOrbits },
                        label = { Text("Orbits") }
                    )
                }

                Spacer(Modifier.height(8.dp))
                // Quick Planet Chips (Order 1 to 8 from the Sun)
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    planets.forEach { p ->
                        FilterChip(
                            selected = selectedPlanet.id == p.id,
                            onClick = { selectedPlanet = p },
                            label = { Text("${p.orderFromSun}. ${p.emoji} ${p.name}") },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = MarsOrange,
                                selectedLabelColor = StarWhite
                            )
                        )
                    }
                }
            }
        }

        // Selected Planet Inspector Card
        Card(
            colors = CardDefaults.cardColors(containerColor = CosmicPurple),
            border = BorderStroke(2.dp, selectedPlanet.primaryColor),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = selectedPlanet.emoji, fontSize = 38.sp)
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "Planet #${selectedPlanet.orderFromSun}: ${selectedPlanet.name}",
                                style = MaterialTheme.typography.headlineSmall,
                                color = StarWhite
                            )
                            Text(
                                text = "${selectedPlanet.hindiName} • ${selectedPlanet.nickname}",
                                style = MaterialTheme.typography.titleSmall,
                                color = StarGold
                            )
                        }
                    }
                    Button(
                        onClick = { onOpenPlanetDetail(selectedPlanet) },
                        colors = ButtonDefaults.buttonColors(containerColor = MarsOrange)
                    ) {
                        Text("Full Page →")
                    }
                }
                Spacer(Modifier.height(10.dp))
                Text(
                    text = selectedPlanet.introduction,
                    style = MaterialTheme.typography.bodyMedium,
                    color = StarWhite
                )
                Spacer(Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    StatMiniPill("Width", selectedPlanet.realDiameterKm, Modifier.weight(1f))
                    StatMiniPill("Orbit Year", selectedPlanet.orbitalPeriod, Modifier.weight(1f))
                    StatMiniPill("Moons", "${selectedPlanet.moonsCount}", Modifier.weight(1f))
                }
            }
        }

        // Visual Planet Size Comparison Chart
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, CyanNebula),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "📏 Compare Planet Sizes & Order from the Sun",
                    style = MaterialTheme.typography.titleLarge,
                    color = CyanNebula
                )
                Text(
                    text = "Memory Trick: \"My Very Educated Mother Just Served Us Noodles!\"",
                    style = MaterialTheme.typography.bodySmall,
                    color = StarGold
                )
                Spacer(Modifier.height(14.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    planets.forEach { planet ->
                        val circleSize = (planet.relativeSizeRatio * 34f).coerceIn(18f, 82f).dp
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable { onOpenPlanetDetail(planet) }
                                .padding(vertical = 4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(circleSize)
                                    .clip(CircleShape)
                                    .background(
                                        Brush.radialGradient(
                                            listOf(planet.primaryColor, planet.secondaryColor)
                                        )
                                    )
                            )
                            Spacer(Modifier.height(6.dp))
                            Text(
                                text = "${planet.orderFromSun}. ${planet.name}",
                                style = MaterialTheme.typography.labelLarge,
                                color = StarWhite
                            )
                            Text(
                                text = planet.realDiameterKm.substringBefore(" "),
                                style = MaterialTheme.typography.bodySmall,
                                color = MoonSilver
                            )
                        }
                    }
                }
            }
        }

        // Module 2 Lessons List
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "📘 Module 2: Solar System Lessons",
                style = MaterialTheme.typography.headlineSmall,
                color = StarWhite
            )
            OutlinedButton(
                onClick = onStartModuleQuiz,
                border = BorderStroke(1.dp, StarGold)
            ) {
                Text("Take Quiz", color = StarGold)
            }
        }

        module2.lessons.forEach { lesson ->
            val done = lesson.id in completedLessonIds
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (done) Color(0xFF1B2E3C) else CardSurfacePurple
                ),
                border = BorderStroke(1.5.dp, if (done) AuroraGreen else CardBorderPurple),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onOpenLesson(lesson) }
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = lesson.emoji, fontSize = 28.sp)
                    Spacer(Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Lesson ${lesson.lessonNumber}: ${lesson.title}",
                            style = MaterialTheme.typography.titleMedium,
                            color = StarWhite
                        )
                        if (showHindi) {
                            Text(
                                text = lesson.hindiTitle,
                                style = MaterialTheme.typography.bodySmall,
                                color = StarGold
                            )
                        }
                    }
                    if (done) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "Done", tint = AuroraGreen)
                    } else {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Open", tint = MarsOrange)
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun StatMiniPill(label: String, value: String, modifier: Modifier = Modifier) {
    Surface(
        color = SpaceBlack.copy(alpha = 0.5f),
        border = BorderStroke(1.dp, CardBorderPurple),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = label, style = MaterialTheme.typography.bodySmall, color = CyanNebula)
            Spacer(Modifier.height(2.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.labelLarge,
                color = StarWhite,
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PlanetExplorerScreen(
    selectedPlanet: PlanetData,
    completedLessonIds: Set<String>,
    showHindi: Boolean,
    ttsManager: SpaceTtsManager,
    onSelectPlanet: (PlanetData) -> Unit,
    onMarkPlanetCompleted: (PlanetData) -> Unit
) {
    val scrollState = rememberScrollState()
    val planets = PlanetsCatalog.allPlanets
    val isSpeaking by ttsManager.isSpeaking.collectAsState()
    val speakingId by ttsManager.speakingId.collectAsState()

    var selectedQuizAns by remember(selectedPlanet.id) { mutableStateOf<Int?>(null) }
    var quizSubmitted by remember(selectedPlanet.id) { mutableStateOf(false) }
    val isPlanetLearned = "m3_${selectedPlanet.id}" in completedLessonIds

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // 8 Planet Selector Tabs
        Text(
            text = "🪐 Module 3: Planet Explorer (Select Any Planet)",
            style = MaterialTheme.typography.titleLarge,
            color = StarGold
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            planets.forEach { planet ->
                val done = "m3_${planet.id}" in completedLessonIds
                FilterChip(
                    selected = selectedPlanet.id == planet.id,
                    onClick = { onSelectPlanet(planet) },
                    label = {
                        Text(
                            text = "${planet.orderFromSun}. ${planet.emoji} ${planet.name}" + if (done) " ✓" else ""
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MarsOrange,
                        selectedLabelColor = StarWhite
                    ),
                    modifier = Modifier.testTag("planet_chip_${planet.id}")
                )
            }
        }

        // Main Planet Hero Card with Custom Animated Planet Illustration
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, selectedPlanet.primaryColor),
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        color = selectedPlanet.primaryColor.copy(alpha = 0.25f),
                        border = BorderStroke(1.dp, selectedPlanet.primaryColor),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text(
                            text = "Planet #${selectedPlanet.orderFromSun} from the Sun",
                            style = MaterialTheme.typography.labelLarge,
                            color = StarWhite,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                    if (isPlanetLearned) {
                        Text("⭐ Explored (+3 Stars)", style = MaterialTheme.typography.labelLarge, color = AuroraGreen)
                    }
                }

                Spacer(Modifier.height(8.dp))
                PlanetIllustrationCanvas(planet = selectedPlanet, sizeDp = 165.dp)
                Spacer(Modifier.height(8.dp))

                Text(
                    text = "${selectedPlanet.emoji} ${selectedPlanet.name}",
                    style = MaterialTheme.typography.displaySmall,
                    color = StarWhite
                )
                Text(
                    text = "${selectedPlanet.hindiName} • ${selectedPlanet.nickname}",
                    style = MaterialTheme.typography.titleMedium,
                    color = StarGold
                )

                Spacer(Modifier.height(12.dp))
                // Listen in English & Hindi TTS Buttons
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    val enId = "planet_en_${selectedPlanet.id}"
                    val speakingEn = isSpeaking && speakingId == enId
                    Button(
                        onClick = {
                            val speech = "${selectedPlanet.name}, ${selectedPlanet.nickname}. " +
                                "${selectedPlanet.introduction} " +
                                "Size comparison: ${selectedPlanet.sizeComparisonText} " +
                                "Fun fact: ${selectedPlanet.funFact}"
                            ttsManager.speak(enId, speech, hindi = false)
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = if (speakingEn) DangerRed else MarsOrange),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(if (speakingEn) Icons.Default.Stop else Icons.AutoMirrored.Filled.VolumeUp, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text(if (speakingEn) "Stop" else "Listen (EN)")
                    }

                    val hiId = "planet_hi_${selectedPlanet.id}"
                    val speakingHi = isSpeaking && speakingId == hiId
                    Button(
                        onClick = {
                            ttsManager.speak(
                                hiId,
                                "${selectedPlanet.hindiName}। ${selectedPlanet.hindiIntroduction} ${selectedPlanet.hindiFunFact}",
                                hindi = true
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = if (speakingHi) DangerRed else CosmicBlue),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(if (speakingHi) Icons.Default.Stop else Icons.Default.Translate, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text(if (speakingHi) "रोकें" else "सुनें (Hindi)")
                    }
                }
            }
        }

        // Planet Introduction (English + Optional Hindi)
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, CardBorderPurple),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "📖 Planet Introduction",
                    style = MaterialTheme.typography.titleLarge,
                    color = CyanNebula
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = selectedPlanet.introduction,
                    style = MaterialTheme.typography.bodyLarge,
                    color = StarWhite
                )
                if (showHindi) {
                    Spacer(Modifier.height(12.dp))
                    Surface(
                        color = Color(0xFF28174E),
                        border = BorderStroke(1.dp, StarGold),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "🇮🇳 हिंदी में परिचय (${selectedPlanet.hindiNickname})",
                                style = MaterialTheme.typography.titleSmall,
                                color = StarGold
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = selectedPlanet.hindiIntroduction,
                                style = MaterialTheme.typography.bodyLarge,
                                color = StarWhite
                            )
                        }
                    }
                }
            }
        }

        // Key Planetary Telemetry Cards (Distance, Temperature, Moons, Size)
        Card(
            colors = CardDefaults.cardColors(containerColor = CosmicPurple),
            border = BorderStroke(1.5.dp, CyanNebula),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "🛰️ NASA Planetary Data Sheet",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarGold
                )
                PlanetDataRow("☀️ Distance from Sun", selectedPlanet.distanceFromSunKm)
                PlanetDataRow("🌡️ Temperature", selectedPlanet.temperatureInfo)
                PlanetDataRow("🌙 Number of Moons", selectedPlanet.moonsNotable)
                PlanetDataRow("📐 Diameter (Width)", selectedPlanet.realDiameterKm)
                PlanetDataRow("🗓️ Length of 1 Year", selectedPlanet.orbitalPeriod)
            }
        }

        // Visual Size Comparison vs Earth
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, ElectricPurple),
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "🌍 Size Comparison: ${selectedPlanet.name} vs Earth",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarWhite
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = selectedPlanet.sizeComparisonText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MoonSilver
                )
                Spacer(Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(CircleShape)
                                .background(EarthColor)
                        )
                        Spacer(Modifier.height(6.dp))
                        Text("Earth (12,742 km)", style = MaterialTheme.typography.labelMedium, color = StarWhite)
                    }
                    val targetSize = (44f * selectedPlanet.relativeSizeRatio).coerceIn(18f, 106f).dp
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(targetSize)
                                .clip(CircleShape)
                                .background(selectedPlanet.primaryColor)
                        )
                        Spacer(Modifier.height(6.dp))
                        Text("${selectedPlanet.name} (${selectedPlanet.realDiameterKm.substringBefore(" ")})", style = MaterialTheme.typography.labelMedium, color = StarGold)
                    }
                }
            }
        }

        // Interesting Facts + Fun Fact
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
                    text = "✨ Interesting Facts About ${selectedPlanet.name}",
                    style = MaterialTheme.typography.titleLarge,
                    color = CyanNebula
                )
                selectedPlanet.interestingFacts.forEach { fact ->
                    Row(verticalAlignment = Alignment.Top) {
                        Text("🌟", fontSize = 16.sp)
                        Spacer(Modifier.width(10.dp))
                        Text(fact, style = MaterialTheme.typography.bodyLarge, color = StarWhite)
                    }
                }

                Spacer(Modifier.height(6.dp))
                Surface(
                    color = MarsOrange.copy(alpha = 0.2f),
                    border = BorderStroke(1.5.dp, MarsOrange),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(14.dp)) {
                        Text(
                            text = "🎉 Super Fun Fact!",
                            style = MaterialTheme.typography.titleMedium,
                            color = StarGold
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = selectedPlanet.funFact,
                            style = MaterialTheme.typography.bodyLarge,
                            color = StarWhite
                        )
                        if (showHindi) {
                            Spacer(Modifier.height(4.dp))
                            Text(
                                text = selectedPlanet.hindiFunFact,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MoonSilver
                            )
                        }
                    }
                }
            }
        }

        // Planet Mini Quiz
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, StarGold),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "🏆 ${selectedPlanet.name} Mini Quiz (+3 ⭐)",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarGold
                )
                Text(
                    text = selectedPlanet.miniQuiz.question,
                    style = MaterialTheme.typography.titleMedium,
                    color = StarWhite
                )
                if (showHindi) {
                    Text(
                        text = selectedPlanet.miniQuiz.hindiQuestion,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MoonSilver
                    )
                }

                selectedPlanet.miniQuiz.options.forEachIndexed { idx, opt ->
                    val isSelected = selectedQuizAns == idx
                    val isRight = idx == selectedPlanet.miniQuiz.correctIndex
                    val bg = when {
                        quizSubmitted && isRight -> AuroraGreen.copy(alpha = 0.28f)
                        quizSubmitted && isSelected && !isRight -> DangerRed.copy(alpha = 0.28f)
                        else -> CosmicPurple
                    }
                    Surface(
                        color = bg,
                        border = BorderStroke(1.5.dp, if (quizSubmitted && isRight) AuroraGreen else CardBorderPurple),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedQuizAns = idx
                                quizSubmitted = true
                                if (isRight) onMarkPlanetCompleted(selectedPlanet)
                            }
                    ) {
                        Text(
                            text = "${('A' + idx)}. $opt",
                            style = MaterialTheme.typography.bodyLarge,
                            color = StarWhite,
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                }

                if (quizSubmitted) {
                    Text(
                        text = selectedPlanet.miniQuiz.explanation,
                        style = MaterialTheme.typography.bodyMedium,
                        color = AuroraGreen
                    )
                    if (showHindi) {
                        Text(
                            text = selectedPlanet.miniQuiz.hindiExplanation,
                            style = MaterialTheme.typography.bodySmall,
                            color = MoonSilver
                        )
                    }
                }
            }
        }

        // Next Planet Navigation
        val nextPlanetIndex = (selectedPlanet.orderFromSun) % planets.size
        val nextPlanet = planets[nextPlanetIndex]
        Button(
            onClick = {
                onMarkPlanetCompleted(selectedPlanet)
                onSelectPlanet(nextPlanet)
            },
            colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(
                text = "Complete ${selectedPlanet.name} & Visit ${nextPlanet.emoji} ${nextPlanet.name} →",
                style = MaterialTheme.typography.titleMedium
            )
        }

        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun PlanetDataRow(label: String, value: String) {
    Surface(
        color = SpaceBlack.copy(alpha = 0.45f),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleSmall,
                color = CyanNebula,
                modifier = Modifier.weight(0.42f)
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = StarWhite,
                modifier = Modifier.weight(0.58f)
            )
        }
    }
}
