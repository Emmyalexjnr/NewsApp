package com.newsapp.navigation

//enum class Screens {
//    AllNewsScreen,
//    NewsDetailsScreen,
//    NewsCategoriesScreen,
//}

enum class Screens(val route: String) {
    AllNewsScreen("allNews"),
    NewsDetailsScreen("newsDetails/{newsId}"), // Define the parameter in the route
    NewsCategoriesScreen("newsCategories/{sourceName}")
}

