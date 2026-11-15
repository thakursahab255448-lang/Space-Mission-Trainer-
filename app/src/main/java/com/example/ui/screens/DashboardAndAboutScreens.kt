package com.example.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.print.PrintAttributes
import android.print.PrintManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.LessonsCatalogPart2
import com.example.ui.DashboardSummaryState
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LearningDashboardScreen(
    dashboardState: DashboardSummaryState,
    onUpdateCadetName: (String) -> Unit,
    onResetProgress: () -> Unit
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    var nameInput by remember(dashboardState.cadetName) { mutableStateOf(dashboardState.cadetName) }
    var showResetConfirm by remember { mutableStateOf(false) }

    val todayFormatted = remember {
        SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(Date())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // 1. DASHBOARD SUMMARY METRICS
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, CyanNebula),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "⭐ My Space Learning Dashboard",
                    style = MaterialTheme.typography.headlineMedium,
                    color = StarWhite
                )
                if (dashboardState.showHindi) {
                    Text(
                        text = "मेरा लर्निंग डैशबोर्ड और उपलब्धियाँ",
                        style = MaterialTheme.typography.titleSmall,
                        color = StarGold
                    )
                }

                Spacer(Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    DashboardStatCard(
                        emoji = "📘",
                        value = "${dashboardState.completedLessonIds.size}/${dashboardState.totalLessonsCount}",
                        label = "Lessons Done",
                        modifier = Modifier.weight(1f)
                    )
                    DashboardStatCard(
                        emoji = "⭐",
                        value = "${dashboardState.totalStars}",
                        label = "Learning Stars",
                        modifier = Modifier.weight(1f)
                    )
                    DashboardStatCard(
                        emoji = "🏆",
                        value = "${dashboardState.quizAttempts.size}",
                        label = "Quizzes Taken",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(Modifier.height(14.dp))
                Text(
                    text = "Overall Academy Progress: ${dashboardState.progressPercent}%",
                    style = MaterialTheme.typography.titleMedium,
                    color = AuroraGreen
                )
                Spacer(Modifier.height(6.dp))
                LinearProgressIndicator(
                    progress = { dashboardState.progressPercent / 100f },
                    color = AuroraGreen,
                    trackColor = SpaceBlack,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(14.dp)
                        .clip(RoundedCornerShape(50))
                )
            }
        }

        // 2. JUNIOR ASTRONAUT CERTIFICATE GENERATOR
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1344)),
            border = BorderStroke(3.dp, StarGold),
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🎓 Printable Junior Astronaut Certificate",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarGold
                )
                Text(
                    text = "Enter your chosen Space Explorer display name below (no personal information needed!):",
                    style = MaterialTheme.typography.bodySmall,
                    color = MoonSilver,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = nameInput,
                        onValueChange = {
                            nameInput = it
                            onUpdateCadetName(it)
                        },
                        label = { Text("Space Explorer Display Name") },
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = StarGold,
                            unfocusedBorderColor = CyanNebula,
                            focusedTextColor = StarWhite,
                            unfocusedTextColor = StarWhite,
                            focusedLabelColor = StarGold,
                            unfocusedLabelColor = MoonSilver
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("certificate_name_input")
                    )
                }

                Spacer(Modifier.height(16.dp))

                // Visual Certificate Preview Card
                Surface(
                    color = Color(0xFF100826),
                    border = BorderStroke(2.5.dp, StarGold),
                    shape = RoundedCornerShape(22.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color(0xFF1F1147),
                                        Color(0xFF11082B),
                                        Color(0xFF24134E)
                                    )
                                )
                            )
                            .padding(22.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("🚀 ✨ 🪐 ✨ 🚀", fontSize = 24.sp)
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = "MARS 2077 – SPACE LEARNING ACADEMY",
                            style = MaterialTheme.typography.labelLarge,
                            color = CyanNebula,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "JUNIOR ASTRONAUT CERTIFICATE",
                            style = MaterialTheme.typography.headlineSmall,
                            color = StarGold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "This official cosmic honor is proudly awarded to",
                            style = MaterialTheme.typography.bodySmall,
                            color = MoonSilver
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = dashboardState.cadetName.uppercase(),
                            style = MaterialTheme.typography.displaySmall,
                            color = StarWhite,
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(8.dp))
                        Surface(
                            color = MarsOrange.copy(alpha = 0.25f),
                            border = BorderStroke(1.dp, MarsOrange),
                            shape = RoundedCornerShape(50)
                        ) {
                            Text(
                                text = "Achievement Rank: ${dashboardState.highestTitle}",
                                style = MaterialTheme.typography.titleMedium,
                                color = StarGold,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                            )
                        }
                        Spacer(Modifier.height(10.dp))
                        Text(
                            text = "For exploring the Solar System, completing ${dashboardState.completedLessonIds.size} space lessons, and earning ${dashboardState.totalStars} Learning Stars ⭐!",
                            style = MaterialTheme.typography.bodyMedium,
                            color = StarWhite,
                            textAlign = TextAlign.Center
                        )
                        Spacer(Modifier.height(12.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Date: $todayFormatted",
                                style = MaterialTheme.typography.labelMedium,
                                color = CyanNebula
                            )
                            Text(
                                text = "Seal: MARS 2077 ACADEMY 🎖️",
                                style = MaterialTheme.typography.labelMedium,
                                color = StarGold
                            )
                        }
                    }
                }

                Spacer(Modifier.height(14.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = {
                            printJuniorAstronautCertificate(
                                context = context,
                                cadetName = dashboardState.cadetName,
                                rankTitle = dashboardState.highestTitle,
                                stars = dashboardState.totalStars,
                                lessonsCount = dashboardState.completedLessonIds.size,
                                dateStr = todayFormatted
                            )
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = MarsOrange),
                        modifier = Modifier
                            .weight(1f)
                            .testTag("print_certificate_button")
                    ) {
                        Icon(Icons.Default.Print, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text("Print Certificate")
                    }

                    OutlinedButton(
                        onClick = {
                            val shareText = "🚀 MARS 2077 – SPACE LEARNING ACADEMY\n" +
                                "Official Junior Astronaut Certificate\n" +
                                "Cadet: ${dashboardState.cadetName}\n" +
                                "Rank: ${dashboardState.highestTitle}\n" +
                                "Stars Earned: ${dashboardState.totalStars} ⭐ | Lessons: ${dashboardState.completedLessonIds.size}\n" +
                                "Date: $todayFormatted"
                            val intent = Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, shareText)
                            }
                            context.startActivity(Intent.createChooser(intent, "Share Certificate"))
                        },
                        border = BorderStroke(1.5.dp, StarGold),
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(Icons.Default.Share, contentDescription = null, tint = StarGold)
                        Spacer(Modifier.width(6.dp))
                        Text("Share", color = StarGold)
                    }
                }
            }
        }

        // 3. ACHIEVEMENT BADGES SHOWCASE
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(1.5.dp, ElectricPurple),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "🎖️ Junior Astronaut Achievement Badges",
                    style = MaterialTheme.typography.titleLarge,
                    color = StarWhite
                )
                LessonsCatalogPart2.achievementBadges.forEach { badge ->
                    val isUnlocked = badge in dashboardState.unlockedBadges
                    Surface(
                        color = if (isUnlocked) Color(0xFF1B333E) else SpaceBlack.copy(alpha = 0.55f),
                        border = BorderStroke(1.5.dp, if (isUnlocked) AuroraGreen else CardBorderPurple),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = badge.emoji, fontSize = 32.sp)
                            Spacer(Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "${badge.title} (${badge.hindiTitle})",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = if (isUnlocked) StarGold else MoonSilver
                                )
                                Text(
                                    text = badge.description,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = StarWhite
                                )
                            }
                            Surface(
                                color = if (isUnlocked) AuroraGreen else CosmicPurple,
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(
                                    text = if (isUnlocked) "UNLOCKED" else "${badge.requiredStars}⭐",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = if (isUnlocked) SpaceBlack else MoonSilver,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // 4. RECENT QUIZ SCORES & RECENTLY EXPLORED TOPICS
        if (dashboardState.quizAttempts.isNotEmpty()) {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
                border = BorderStroke(1.5.dp, RocketAmber),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "📊 Recent Quiz Scores",
                        style = MaterialTheme.typography.titleLarge,
                        color = RocketAmber
                    )
                    dashboardState.quizAttempts.take(5).forEach { attempt ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${attempt.moduleTitle} (${attempt.difficulty})",
                                style = MaterialTheme.typography.bodyMedium,
                                color = StarWhite
                            )
                            Text(
                                text = "${attempt.score}/${attempt.totalQuestions} (+${attempt.starsEarned}⭐)",
                                style = MaterialTheme.typography.titleSmall,
                                color = AuroraGreen
                            )
                        }
                    }
                }
            }
        }

        if (dashboardState.recentTopics.isNotEmpty()) {
            Card(
                colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
                border = BorderStroke(1.5.dp, CardBorderPurple),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = "🕒 Recently Explored Topics",
                        style = MaterialTheme.typography.titleLarge,
                        color = CyanNebula
                    )
                    Spacer(Modifier.height(8.dp))
                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        dashboardState.recentTopics.take(8).forEach { topic ->
                            Surface(
                                color = CosmicPurple,
                                border = BorderStroke(1.dp, CardBorderPurple),
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(
                                    text = "${topic.emoji} ${topic.title}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = StarWhite,
                                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                )
                            }
                        }
                    }
                }
            }
        }

        // 5. RESET PROGRESS OPTION
        OutlinedButton(
            onClick = { showResetConfirm = true },
            border = BorderStroke(1.5.dp, DangerRed),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("reset_progress_button")
        ) {
            Icon(Icons.Default.DeleteForever, contentDescription = null, tint = DangerRed)
            Spacer(Modifier.width(8.dp))
            Text("Reset Learning Progress", color = DangerRed)
        }

        if (showResetConfirm) {
            AlertDialog(
                onDismissRequest = { showResetConfirm = false },
                title = { Text("Reset All Learning Progress?") },
                text = { Text("This will clear your completed lessons, quiz scores, and stars so you can start a fresh journey.") },
                confirmButton = {
                    Button(
                        onClick = {
                            onResetProgress()
                            showResetConfirm = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = DangerRed)
                    ) {
                        Text("Yes, Reset")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showResetConfirm = false }) {
                        Text("Cancel")
                    }
                }
            )
        }

        Spacer(Modifier.height(24.dp))
    }
}

@Composable
private fun DashboardStatCard(emoji: String, value: String, label: String, modifier: Modifier = Modifier) {
    Surface(
        color = CosmicPurple,
        border = BorderStroke(1.5.dp, CardBorderPurple),
        shape = RoundedCornerShape(18.dp),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = emoji, fontSize = 26.sp)
            Spacer(Modifier.height(4.dp))
            Text(text = value, style = MaterialTheme.typography.headlineSmall, color = StarGold)
            Text(text = label, style = MaterialTheme.typography.bodySmall, color = MoonSilver, textAlign = TextAlign.Center)
        }
    }
}

private fun printJuniorAstronautCertificate(
    context: Context,
    cadetName: String,
    rankTitle: String,
    stars: Int,
    lessonsCount: Int,
    dateStr: String
) {
    try {
        val webView = WebView(context)
        val html = """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="utf-8"/>
                <style>
                    body { font-family: sans-serif; background: #0f0826; color: #ffffff; padding: 32px; text-align: center; }
                    .cert { border: 6px double #FFD600; border-radius: 24px; padding: 36px; background: #1c1042; }
                    h1 { color: #FFD600; font-size: 28px; margin-bottom: 4px; }
                    h2 { color: #00E5FF; font-size: 18px; margin-top: 0; }
                    .name { font-size: 36px; font-weight: bold; color: #ffffff; margin: 20px 0; text-decoration: underline; }
                    .rank { font-size: 22px; color: #FF9100; font-weight: bold; margin: 12px 0; }
                    .meta { margin-top: 28px; font-size: 14px; color: #D6CEFF; }
                </style>
            </head>
            <body>
                <div class="cert">
                    <h2>🚀 MARS 2077 – SPACE LEARNING ACADEMY 🚀</h2>
                    <h1>OFFICIAL JUNIOR ASTRONAUT CERTIFICATE</h1>
                    <p>Explore the Universe, One Discovery at a Time!</p>
                    <p>This certificate is proudly awarded to</p>
                    <div class="name">${cadetName}</div>
                    <div class="rank">Achievement Rank: ${rankTitle}</div>
                    <p>For completing ${lessonsCount} interactive space lessons and earning ${stars} Learning Stars ⭐!</p>
                    <div class="meta">Completion Date: ${dateStr} • Verified by Mars 2077 Space Learning Academy</div>
                </div>
            </body>
            </html>
        """.trimIndent()

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String?) {
                val printManager = context.getSystemService(Context.PRINT_SERVICE) as? PrintManager
                val adapter = view.createPrintDocumentAdapter("Mars2077_Junior_Astronaut_Certificate")
                printManager?.print(
                    "Mars 2077 Junior Astronaut Certificate",
                    adapter,
                    PrintAttributes.Builder().build()
                )
            }
        }
        webView.loadDataWithBaseURL(null, html, "text/HTML", "UTF-8", null)
    } catch (_: Exception) {
    }
}

// ==================== ABOUT US & NASA EDUCATIONAL RESOURCES SCREEN ====================
@Composable
fun AboutAndNasaResourcesScreen(showHindi: Boolean) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // About MARS 2077 – SPACE LEARNING ACADEMY
        Card(
            colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
            border = BorderStroke(2.dp, MarsOrange),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "🚀 About MARS 2077 – SPACE LEARNING ACADEMY",
                    style = MaterialTheme.typography.headlineSmall,
                    color = StarGold
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Tagline: \"Explore the Universe, One Discovery at a Time!\"",
                    style = MaterialTheme.typography.titleMedium,
                    color = CyanNebula
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = "MARS 2077 – Space Learning Academy is an interactive educational platform designed especially for curious young explorers aged 7 to 12 years! Our goal is to make space science, planets, astronauts, rockets, and the cosmos simple, accurate, and exciting to learn independently.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = StarWhite
                )
                if (showHindi) {
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = "🇮🇳 'मार्स 2077 – स्पेस लर्निंग एकेडमी' 7 से 12 वर्ष के बच्चों के लिए बनाया गया एक इंटरएक्टिव शैक्षिक मंच है। यहाँ बच्चे बिना किसी शिक्षक की सहायता के सरल अंग्रेजी और हिंदी में अंतरिक्ष, ग्रहों, चंद्रमा, मंगल मिशन, रॉकेट और ब्रह्मांड के बारे में सीख सकते हैं!",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MoonSilver
                    )
                }
            }
        }

        // Child Safety & Accessibility Pledge
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFF152C38)),
            border = BorderStroke(1.5.dp, AuroraGreen),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.VerifiedUser, contentDescription = null, tint = AuroraGreen, modifier = Modifier.size(28.dp))
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = "Child Safety, Privacy & Accessibility Pledge",
                        style = MaterialTheme.typography.titleLarge,
                        color = AuroraGreen
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text("• 100% Child-Safe: No advertisements, no external chat, and no frightening content.", style = MaterialTheme.typography.bodyMedium, color = StarWhite)
                Text("• Zero Personal Data Collection: Learning progress is saved privately on your device without requiring registration or email.", style = MaterialTheme.typography.bodyMedium, color = StarWhite)
                Text("• Bilingual & Audio Friendly: Every lesson includes simple English, optional Hindi explanations, and Text-to-Speech voice narration.", style = MaterialTheme.typography.bodyMedium, color = StarWhite)
            }
        }

        // Authentic NASA Educational Resources Directory
        Text(
            text = "🔭 Authentic NASA Educational Resources & Open Science",
            style = MaterialTheme.typography.headlineSmall,
            color = StarWhite
        )
        Text(
            text = "All planetary diameters, temperatures, distances, moon counts, and mission milestones in Mars 2077 Academy are sourced from authentic NASA Planetary Fact Sheets and official NASA education portals:",
            style = MaterialTheme.typography.bodyMedium,
            color = MoonSilver
        )

        LessonsCatalogPart2.nasaResources.forEach { res ->
            Card(
                colors = CardDefaults.cardColors(containerColor = CardSurfacePurple),
                border = BorderStroke(1.5.dp, CyanNebula),
                shape = RoundedCornerShape(22.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = res.emoji, fontSize = 32.sp)
                        Spacer(Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(res.title, style = MaterialTheme.typography.titleLarge, color = StarGold)
                            Text(res.category, style = MaterialTheme.typography.labelMedium, color = CyanNebula)
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(res.description, style = MaterialTheme.typography.bodyMedium, color = StarWhite)
                    if (showHindi) {
                        Spacer(Modifier.height(4.dp))
                        Text("🇮🇳 ${res.hindiDescription}", style = MaterialTheme.typography.bodySmall, color = MoonSilver)
                    }
                    Spacer(Modifier.height(10.dp))
                    Surface(
                        color = SpaceBlack.copy(alpha = 0.55f),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "📊 ${res.verifiedDataHighlight}",
                            style = MaterialTheme.typography.labelLarge,
                            color = AuroraGreen,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    OutlinedButton(
                        onClick = {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(res.url))
                                context.startActivity(intent)
                            } catch (_: Exception) {
                            }
                        },
                        border = BorderStroke(1.dp, CyanNebula)
                    ) {
                        Text("Explore Official NASA Resource (${res.url})", color = CyanNebula)
                        Spacer(Modifier.width(6.dp))
                        Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = null, tint = CyanNebula, modifier = Modifier.size(16.dp))
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
    }
}
