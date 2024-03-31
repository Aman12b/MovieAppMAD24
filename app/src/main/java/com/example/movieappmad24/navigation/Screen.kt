package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
    data object Watchlist : Screen(route = "watchlist_screen")
    data object Detail: Screen(route = "detail_screen/{movieId}"){
        fun transferMovieID(movieId: String) = "detail_screen/$movieId"
    }

}