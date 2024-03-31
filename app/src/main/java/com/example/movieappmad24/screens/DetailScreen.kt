package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.getMovies
import androidx.compose.ui.Modifier
import com.example.movieappmad24.components.moviefunctions.MovieDetail
import com.example.movieappmad24.components.Bars.TopBar

@Composable
fun DetailScreen(movieId: String?,navController: NavController){
    val movie = getMovies().find {
        it.id == movieId
    } ?: return

    Scaffold(
        topBar ={ TopBar(navController = navController, title = movie.title, Icons.Filled.ArrowBack) }
    )
        { innerPadding -> MovieDetail(modifier = Modifier.padding(innerPadding), movie = movie)
    }
}