package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.filled.WorkspacePremium
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.LessonsCatalogPart2
import com.example.model.AcademyPage
import com.example.ui.AcademyViewModel
import com.example.ui.components.AnimatedSpaceBackground
import com.example.ui.screens.AboutAndNasaResourcesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.InteractiveActivitiesScreen
import com.example.ui.screens.InteractiveLessonDetailScreen
import com.example.ui.screens.LearningDashboardScreen
import com.example.ui.screens.ModuleLearningScreen
import com.example.ui.screens.PlanetExplorerScreen
import com.example.ui.screens.QuizCenterScreen
import com.example.ui.screens.SolarSystemInteractiveScreen
import com.example.ui.theme.CardBorderPurple
import com.example.ui.theme.CardSurfacePurple
import com.example.ui.theme.CosmicBlue
import com.example.ui.theme.CosmicPurple
import com.example.ui.theme.CyanNebula
import com.example.ui.theme.DeepSpaceNavy
import com.example.ui.theme.MarsOrange
import com.example.ui.theme.MoonSilver
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.SpaceBlack
import com.example.ui.theme.StarGold
import com.example.ui.theme.StarWhite
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Mars2077SpaceAcademyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Mars2077SpaceAcademyApp(
    viewModel: AcademyViewModel = viewModel()
) {
    val currentPage by viewModel.currentPage.collectAsStateWithLifecycle()
    val activeLesson by viewModel.activeLesson.collectAsStateWithLifecycle()
    val selectedPlanet by viewModel.selectedPlanet.collectAsStateWithLifecycle()
    val dailyFactIndex by viewModel.dailyFactIndex.collectAsStateWithLifecycle()
    val preselectedQuizModuleId by viewModel.preselectedQuizModuleId.collectAsStateWithLifecycle()
    val dashboardState by viewModel.dashboardState.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Handle back navigation across lessons and pages
    BackHandler(enabled = activeLesson != null || currentPage != AcademyPage.HOME) {
        viewModel.navigateBack()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = DeepSpaceNavy,
                drawerContentColor = StarWhite,
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🚀", fontSize = 32.sp)
                        Spacer(Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "MARS 2077",
                                style = MaterialTheme.typography.headlineSmall,
                                color = StarGold
                            )
                            Text(
                                text = "SPACE LEARNING ACADEMY",
                                style = MaterialTheme.typography.labelMedium,
                                color = CyanNebula
                            )
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Explore all 13 Space Academy destinations:",
                        style = MaterialTheme.typography.bodySmall,
                        color = MoonSilver
                    )
                    Spacer(Modifier.height(10.dp))
                    HorizontalDivider(color = CardBorderPurple)
                    Spacer(Modifier.height(8.dp))

                    AcademyPage.entries.forEach { page ->
                        val isSelected = currentPage == page && activeLesson == null
                        NavigationDrawerItem(
                            label = {
                                Column {
                                    Text(
                                        text = "${page.emoji} ${page.title}",
                                        style = MaterialTheme.typography.titleSmall,
                                        color = if (isSelected) StarGold else StarWhite
                                    )
                                    if (dashboardState.showHindi) {
                                        Text(
                                            text = page.hindiTitle,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MoonSilver
                                        )
                                    }
                                }
                            },
                            selected = isSelected,
                            onClick = {
                                viewModel.navigateToPage(page)
                                scope.launch { drawerState.close() }
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = MarsOrange.copy(alpha = 0.25f),
                                unselectedContainerColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .padding(vertical = 2.dp)
                                .testTag("drawer_item_${page.id}")
                        )
                    }
                }
            }
        }
    ) {
        AnimatedSpaceBackground {
            Scaffold(
                containerColor = Color.Transparent,
                contentWindowInsets = WindowInsets.safeDrawing,
                topBar = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(SpaceBlack.copy(alpha = 0.86f))
                    ) {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color.Transparent,
                                titleContentColor = StarWhite
                            ),
                            navigationIcon = {
                                IconButton(
                                    onClick = { scope.launch { drawerState.open() } },
                                    modifier = Modifier.testTag("open_drawer_button")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Open All 13 Academy Pages Menu",
                                        tint = StarGold
                                    )
                                }
                            },
                            title = {
                                Column(
                                    modifier = Modifier.clickable {
                                        viewModel.navigateToPage(AcademyPage.HOME)
                                    }
                                ) {
                                    Text(
                                        text = "🚀 MARS 2077 ACADEMY",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = StarGold,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Text(
                                        text = activeLesson?.title ?: "${currentPage.emoji} ${currentPage.title}",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = CyanNebula,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            },
                            actions = {
                                // Bilingual Hindi Toggle Pill
                                Surface(
                                    color = if (dashboardState.showHindi) CosmicBlue else CardSurfacePurple,
                                    border = BorderStroke(1.dp, CyanNebula),
                                    shape = RoundedCornerShape(50),
                                    modifier = Modifier
                                        .clickable { viewModel.toggleHindi(!dashboardState.showHindi) }
                                        .testTag("top_bar_hindi_toggle")
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Translate,
                                            contentDescription = "Toggle Hindi Explanation",
                                            tint = StarWhite,
                                            modifier = Modifier.size(15.dp)
                                        )
                                        Spacer(Modifier.width(4.dp))
                                        Text(
                                            text = if (dashboardState.showHindi) "हिंदी ON" else "हिंदी OFF",
                                            style = MaterialTheme.typography.labelMedium,
                                            color = StarWhite
                                        )
                                    }
                                }

                                Spacer(Modifier.width(8.dp))

                                // Stars Counter Pill -> Opens Dashboard & Certificate
                                Surface(
                                    color = StarGold.copy(alpha = 0.2f),
                                    border = BorderStroke(1.dp, StarGold),
                                    shape = RoundedCornerShape(50),
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .clickable { viewModel.navigateToPage(AcademyPage.DASHBOARD) }
                                        .testTag("top_bar_stars_badge")
                                ) {
                                    Text(
                                        text = "⭐ ${dashboardState.totalStars}",
                                        style = MaterialTheme.typography.labelLarge,
                                        color = StarGold,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                            }
                        )

                        // Scrollable All-13-Pages Quick Navigation Ribbon
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState())
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            AcademyPage.entries.forEach { page ->
                                val selected = currentPage == page && activeLesson == null
                                FilterChip(
                                    selected = selected,
                                    onClick = { viewModel.navigateToPage(page) },
                                    label = { Text("${page.emoji} ${page.title}") },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = MarsOrange,
                                        selectedLabelColor = StarWhite,
                                        containerColor = CardSurfacePurple,
                                        labelColor = MoonSilver
                                    ),
                                    border = FilterChipDefaults.filterChipBorder(
                                        enabled = true,
                                        selected = selected,
                                        borderColor = if (selected) StarGold else CardBorderPurple
                                    ),
                                    modifier = Modifier.testTag("nav_ribbon_${page.id}")
                                )
                            }
                        }
                    }
                },
                bottomBar = {
                    val bottomTabs = listOf(
                        Triple(AcademyPage.HOME, "Home", Icons.Default.Home),
                        Triple(AcademyPage.SOLAR_SYSTEM, "Solar", Icons.Default.Explore),
                        Triple(AcademyPage.PLANET_EXPLORER, "Planets", Icons.Default.Public),
                        Triple(AcademyPage.ACTIVITIES, "Activities", Icons.Default.SportsEsports),
                        Triple(AcademyPage.QUIZ_CENTER, "Quiz", Icons.Default.EmojiEvents),
                        Triple(AcademyPage.DASHBOARD, "Certificate", Icons.Default.WorkspacePremium)
                    )
                    NavigationBar(
                        containerColor = SpaceBlack.copy(alpha = 0.94f),
                        contentColor = StarWhite,
                        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars)
                    ) {
                        bottomTabs.forEach { (page, label, icon) ->
                            val selected = currentPage == page && activeLesson == null
                            NavigationBarItem(
                                selected = selected,
                                onClick = { viewModel.navigateToPage(page) },
                                icon = {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = label
                                    )
                                },
                                label = {
                                    Text(
                                        text = label,
                                        maxLines = 1,
                                        fontSize = 11.sp
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = StarGold,
                                    selectedTextColor = StarGold,
                                    indicatorColor = CosmicPurple,
                                    unselectedIconColor = MoonSilver,
                                    unselectedTextColor = MoonSilver
                                ),
                                modifier = Modifier.testTag("bottom_nav_${page.id}")
                            )
                        }
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    val currentLesson = activeLesson
                    if (currentLesson != null) {
                        InteractiveLessonDetailScreen(
                            lesson = currentLesson,
                            isCompleted = currentLesson.id in dashboardState.completedLessonIds,
                            showHindiDefault = dashboardState.showHindi,
                            ttsManager = viewModel.ttsManager,
                            onToggleHindiDefault = { viewModel.toggleHindi(it) },
                            onMarkCompleted = { viewModel.markLessonCompleted(currentLesson) },
                            onNextLesson = { viewModel.goToNextLesson(currentLesson) },
                            onBackToModule = { viewModel.closeActiveLesson() }
                        )
                    } else {
                        when (currentPage) {
                            AcademyPage.HOME -> HomeScreen(
                                dashboardState = dashboardState,
                                dailyFactIndex = dailyFactIndex,
                                ttsManager = viewModel.ttsManager,
                                onStartLearning = {
                                    viewModel.openLesson(LessonsCatalogPart2.allLessonsFlat.first())
                                },
                                onExploreSpace = {
                                    viewModel.navigateToPage(AcademyPage.SOLAR_SYSTEM)
                                },
                                onNavigatePage = { viewModel.navigateToPage(it) },
                                onOpenPlanet = { viewModel.openPlanetDetail(it) },
                                onOpenLesson = { viewModel.openLesson(it) },
                                onNextFact = { viewModel.nextDailyFact() },
                                onPrevFact = { viewModel.previousDailyFact() }
                            )

                            AcademyPage.EXPLORE_SPACE -> ModuleLearningScreen(
                                module = LessonsCatalogPart2.allModules.first { it.id == "mod_1" },
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule(it) }
                            )

                            AcademyPage.SOLAR_SYSTEM -> SolarSystemInteractiveScreen(
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenPlanetDetail = { viewModel.openPlanetDetail(it) },
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule("mod_2") }
                            )

                            AcademyPage.PLANET_EXPLORER -> PlanetExplorerScreen(
                                selectedPlanet = selectedPlanet,
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                ttsManager = viewModel.ttsManager,
                                onSelectPlanet = { viewModel.selectPlanetInExplorer(it) },
                                onMarkPlanetCompleted = { viewModel.markPlanetCompleted(it) }
                            )

                            AcademyPage.MOON_EXPLORATION -> ModuleLearningScreen(
                                module = LessonsCatalogPart2.allModules.first { it.id == "mod_4" },
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule(it) }
                            )

                            AcademyPage.MARS_EXPLORATION -> ModuleLearningScreen(
                                module = LessonsCatalogPart2.allModules.first { it.id == "mod_5" },
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule(it) }
                            )

                            AcademyPage.ASTRONAUT_LIFE -> ModuleLearningScreen(
                                module = LessonsCatalogPart2.allModules.first { it.id == "mod_6" },
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule(it) }
                            )

                            AcademyPage.ROCKETS_TECH -> ModuleLearningScreen(
                                module = LessonsCatalogPart2.allModules.first { it.id == "mod_7" },
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule(it) }
                            )

                            AcademyPage.GALAXY_UNIVERSE -> ModuleLearningScreen(
                                module = LessonsCatalogPart2.allModules.first { it.id == "mod_8" },
                                completedLessonIds = dashboardState.completedLessonIds,
                                showHindi = dashboardState.showHindi,
                                onOpenLesson = { viewModel.openLesson(it) },
                                onStartModuleQuiz = { viewModel.launchQuizForModule(it) }
                            )

                            AcademyPage.ACTIVITIES -> InteractiveActivitiesScreen(
                                completedActivities = dashboardState.completedActivities,
                                showHindi = dashboardState.showHindi,
                                onActivityCompleted = { actId, actName ->
                                    viewModel.recordActivityWin(actId, actName)
                                }
                            )

                            AcademyPage.QUIZ_CENTER -> QuizCenterScreen(
                                preselectedModuleId = preselectedQuizModuleId,
                                showHindi = dashboardState.showHindi,
                                onQuizCompleted = { modId, modTitle, diff, score, total, stars ->
                                    viewModel.recordQuizResult(modId, modTitle, diff, score, total, stars)
                                }
                            )

                            AcademyPage.DASHBOARD -> LearningDashboardScreen(
                                dashboardState = dashboardState,
                                onUpdateCadetName = { viewModel.updateCadetName(it) },
                                onResetProgress = { viewModel.resetProgress() }
                            )

                            AcademyPage.ABOUT_US -> AboutAndNasaResourcesScreen(
                                showHindi = dashboardState.showHindi
                            )
                        }
                    }
                }
            }
        }
    }
}
