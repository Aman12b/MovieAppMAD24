package com.example.movieappmad24.components.moviefunctions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.Screen

@Composable
fun MovieList(modifier: Modifier, movies: List<Movie> = getMovies(), navController : NavController, filter: (Movie) -> Boolean = {true}){
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        items(movies) { movie ->
            if(filter(movie)) {
                MovieRow(movie) { movieId ->
                    navController.navigate(Screen.DetailScreen.withId(movieId))
                }
            }
        }
    }
}