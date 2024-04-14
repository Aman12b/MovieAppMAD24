package com.example.movieappmad24.components.moviefunctions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie

@Composable
fun MovieDetail(movie: Movie, modifier: Modifier) {
    Column(modifier = modifier) {
        MovieRow(movie = movie) {
        }

        LazyRow(
            modifier = Modifier
                .padding(25.dp)
                .height(220.dp)
        ) {
            items(movie.images.size) { img ->
                MovieImage(
                    imageUrl = movie.images[img],
                    modifier = Modifier.padding(horizontal = 10.dp)
                        .clip(shape = ShapeDefaults.Large)
                )
            }
        }
    }
}