package com.newsapp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.newsapp.ui.AllNews
import com.newsapp.ui.Categories
import com.newsapp.ui.NewsDetails

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screens.AllNewsScreen.name
    ) {

        composable(route = Screens.AllNewsScreen.name) { entry ->
            AllNews(navController)
        }
        composable(route = Screens.NewsDetailsScreen.name) { entry ->
            NewsDetails(navController)
        }
        composable(route = Screens.NewsCategoriesScreen.name) { entry ->
            Categories(navController)
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
}