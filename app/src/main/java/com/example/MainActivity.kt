package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.BottomTab
import com.example.ui.NewsViewModel
import com.example.ui.ScreenDestination
import com.example.ui.ThemeMode
import com.example.ui.components.AppDrawerContent
import com.example.ui.components.NewsHubBottomNavigation
import com.example.ui.screens.ArticleDetailScreen
import com.example.ui.screens.CategoryViewScreen
import com.example.ui.screens.FavoritesScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.NewspaperDetailScreen
import com.example.ui.screens.RateUsScreen
import com.example.ui.screens.SearchScreen
import com.example.ui.screens.SettingsScreen
import com.example.ui.screens.SourcesScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.theme.NewsHubTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val themeMode by viewModel.themeMode.collectAsStateWithLifecycle()
            val isDark = when (themeMode) {
                ThemeMode.SYSTEM -> isSystemInDarkTheme()
                ThemeMode.LIGHT -> false
                ThemeMode.DARK -> true
            }

            NewsHubTheme(darkTheme = isDark) {
                NewsHubApp(
                    viewModel = viewModel,
                    onExitApp = { finish() }
                )
            }
        }
    }
}

@Composable
fun NewsHubApp(
    viewModel: NewsViewModel,
    onExitApp: () -> Unit
) {
    var showSplash by remember { mutableStateOf(true) }
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()
    val activeArticleId by viewModel.activeArticleId.collectAsStateWithLifecycle()
    val activeNewspaperId by viewModel.activeNewspaperId.collectAsStateWithLifecycle()
    val activeCategory by viewModel.activeCategory.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // Collect snackbar events
    LaunchedEffect(Unit) {
        viewModel.snackbarMessage.collectLatest { message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    // System Back Handler
    BackHandler(enabled = !showSplash) {
        if (drawerState.isOpen) {
            scope.launch { drawerState.close() }
        } else {
            val handled = viewModel.handleBack()
            if (!handled) {
                onExitApp()
            }
        }
    }

    if (showSplash) {
        SplashScreen(onDismiss = { showSplash = false })
    } else {
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = false,
            drawerContent = {
                AppDrawerContent(
                    selectedTab = selectedTab,
                    onSelectTab = { tab ->
                        viewModel.navigateToTab(tab)
                    },
                    onSelectCategory = { cat ->
                        viewModel.openCategory(cat)
                    },
                    onCloseDrawer = {
                        scope.launch { drawerState.close() }
                    }
                )
            }
        ) {
            Scaffold(
                bottomBar = {
                    if (currentScreen == ScreenDestination.MAIN_TABS) {
                        NewsHubBottomNavigation(
                            selectedTab = selectedTab,
                            onTabSelected = { tab -> viewModel.navigateToTab(tab) }
                        )
                    }
                },
                snackbarHost = { SnackbarHost(snackbarHostState) },
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    AnimatedContent(
                        targetState = currentScreen,
                        transitionSpec = { fadeIn() togetherWith fadeOut() },
                        label = "screen_transition"
                    ) { targetScreen ->
                        when (targetScreen) {
                            ScreenDestination.MAIN_TABS -> {
                                when (selectedTab) {
                                    BottomTab.HOME -> HomeScreen(
                                        viewModel = viewModel,
                                        onOpenSearch = { viewModel.openSearch() },
                                        onOpenArticle = { id -> viewModel.openArticle(id) },
                                        onOpenNewspaper = { id -> viewModel.openNewspaper(id) },
                                        onSeeAllNews = { viewModel.navigateToTab(BottomTab.SOURCES) },
                                        onOpenMenu = { scope.launch { drawerState.open() } }
                                    )
                                    BottomTab.SOURCES -> SourcesScreen(
                                        viewModel = viewModel,
                                        onOpenNewspaper = { id -> viewModel.openNewspaper(id) },
                                        onOpenSearch = { viewModel.openSearch() },
                                        onOpenMenu = { scope.launch { drawerState.open() } }
                                    )
                                    BottomTab.FAVORITES -> FavoritesScreen(
                                        viewModel = viewModel,
                                        onOpenArticle = { id -> viewModel.openArticle(id) },
                                        onOpenNewspaper = { id -> viewModel.openNewspaper(id) },
                                        onExploreSources = { viewModel.navigateToTab(BottomTab.SOURCES) },
                                        onOpenMenu = { scope.launch { drawerState.open() } }
                                    )
                                    BottomTab.RATE_US -> RateUsScreen(
                                        viewModel = viewModel,
                                        onOpenMenu = { scope.launch { drawerState.open() } }
                                    )
                                    BottomTab.SETTINGS -> SettingsScreen(
                                        viewModel = viewModel,
                                        onOpenMenu = { scope.launch { drawerState.open() } },
                                        onExitApp = onExitApp
                                    )
                                }
                            }
                            ScreenDestination.ARTICLE_DETAIL -> {
                                activeArticleId?.let { articleId ->
                                    ArticleDetailScreen(
                                        articleId = articleId,
                                        viewModel = viewModel,
                                        onBack = { viewModel.handleBack() }
                                    )
                                }
                            }
                            ScreenDestination.NEWSPAPER_DETAIL -> {
                                activeNewspaperId?.let { newspaperId ->
                                    NewspaperDetailScreen(
                                        newspaperId = newspaperId,
                                        viewModel = viewModel,
                                        onBack = { viewModel.handleBack() },
                                        onOpenArticle = { id -> viewModel.openArticle(id) }
                                    )
                                }
                            }
                            ScreenDestination.CATEGORY_VIEW -> {
                                activeCategory?.let { category ->
                                    CategoryViewScreen(
                                        category = category,
                                        viewModel = viewModel,
                                        onBack = { viewModel.handleBack() },
                                        onOpenNewspaper = { id -> viewModel.openNewspaper(id) },
                                        onOpenSearch = { viewModel.openSearch() }
                                    )
                                }
                            }
                            ScreenDestination.SEARCH -> {
                                SearchScreen(
                                    viewModel = viewModel,
                                    onBack = { viewModel.handleBack() },
                                    onOpenArticle = { id -> viewModel.openArticle(id) },
                                    onOpenNewspaper = { id -> viewModel.openNewspaper(id) },
                                    onOpenCategory = { cat -> viewModel.openCategory(cat) }
                                )
                            }
                            ScreenDestination.SPLASH -> {
                                // Handled above
                            }
                        }
                    }
                }
            }
        }
    }
}
