package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.components.Bars.BottomBar
import com.example.movieappmad24.components.moviefunctions.MovieList
import com.example.movieappmad24.components.Bars.TopBar
import com.example.movieappmad24.models.getMovies

@Composable
fun WatchlistScreen(navController: NavController){
    Scaffold (
        topBar = { TopBar(navController = navController, title = "Your Watchlist") },
        bottomBar = { BottomBar(navController = navController) }
    ){ innerPadding ->
        MovieList(
            modifier = Modifier.padding(innerPadding),
            movies = getMovies(),
            navController = navController,
            filter = {movie -> //movie.favorit
                movie.title.uppercase().contains('S') }
        )
    }
}