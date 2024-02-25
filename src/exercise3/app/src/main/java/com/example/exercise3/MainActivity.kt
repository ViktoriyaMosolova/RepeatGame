package com.example.exercise3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exercise3.screen.AboutScreen

import androidx.navigation.compose.rememberNavController
import com.example.exercise3.model.Sequence
import com.example.exercise3.screen.BasicGameScreen
import com.example.exercise3.screen.FreeGameScreen
import com.example.exercise3.screen.MenuScreen
import com.example.exercise3.model.SharedPrefManager
import com.example.exercise3.model.UserProgress


class MainActivity : ComponentActivity() {
    private lateinit var changeSharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeSharedPrefManager = SharedPrefManager(this)
        UserProgress.bestLevel = changeSharedPrefManager.getBestLevel()
        setContent {
            val navController = rememberNavController()
            NavigateToScreen(navController, changeSharedPrefManager)
        }
    }
}

@Composable
fun NavigateToScreen(navController: NavHostController, changeSharedBestLevel: SharedPrefManager) {
    NavHost(
        navController = navController,
        startDestination = "menu"
    ) {
        composable("menu") {
            MenuScreen { navController.navigate(it) }
        }
        composable("about") {
            MenuScaffold(onBackPressed = { navController.navigate("menu")}) {
                paddingValues -> AboutScreen(paddingValues, changeSharedBestLevel.getBestLevel())
            }
        }
        composable("basic_game") {
            MenuScaffold(onBackPressed = {
                navController.navigate("menu")
                UserProgress.level = 1
                Sequence.setInitSequences()
            }) {
                paddingValues -> BasicGameScreen(paddingValues) {
                    changeSharedBestLevel.saveBestLevel(it)
                }
            }
        }
        composable("free_game") {
            MenuScaffold(onBackPressed = { navController.navigate("menu")}) {
                paddingValues -> FreeGameScreen(paddingValues)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScaffold(onBackPressed: () -> Unit, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Menu") },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { padding -> content(padding) }
}