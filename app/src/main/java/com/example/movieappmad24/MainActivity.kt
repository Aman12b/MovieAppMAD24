package com.example.movieappmad24

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

data class BottomItem(
    val title: String,
    val icon: ImageVector,
)
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                val items = listOf(
                    BottomItem(
                        title = "Home",
                        icon = Icons.Filled.Home,
                    ),
                    BottomItem(
                        title = "Watchlist",
                        icon = Icons.Filled.Star,
                    )
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(title = {
                                Text(text = "Movie App",
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center) })
                        },
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed{i, item ->
                                    NavigationBarItem(
                                        onClick = {},
                                        selected = false,
                                        label = {
                                            Text(text = item.title)
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = item.icon,
                                                contentDescription = item.title
                                            )
                                        })
                                }
                            }
                        }
                    ) {
                        Box(modifier = Modifier
                            .padding(top = 80.dp, bottom = 80.dp)) {
                            MovieList()
                        }
                    }

                }
            }
        }
    }
}


@Composable
fun MovieList(movies: List<Movie> = getMovies()){
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie)
        }
    }
}


@Composable
fun MovieRow(movie: Movie){
    var showDetails by remember {
        mutableStateOf(false)
    }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp),
        shape = ShapeDefaults.Large,
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = movie.images.first(),
                    contentScale = ContentScale.Crop,
                    contentDescription = "placeholder image"
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    contentAlignment = Alignment.TopEnd
                ){
                    Icon(
                        tint = MaterialTheme.colorScheme.secondary,
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Add to favorites")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = movie.title)
                Icon(modifier = Modifier
                    .clickable {
                       showDetails = !showDetails
                    },
                    imageVector =
                        if (showDetails) Icons.Filled.KeyboardArrowDown
                        else Icons.Default.KeyboardArrowUp, contentDescription = "show more"
                )
            }
        }
        AnimatedVisibility (showDetails) {
            Column {
                Text(text = "Director: ${movie.director}")
                Text(text = "Released: ${movie.year}")
                Text(text = "Genre: ${movie.genre}")
                Text(text = "Actors: ${movie.actors}")
                Text(text = "Rating: ${movie.rating}")
                Divider()
                Text(text = "Plot: ${movie.plot}")
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview(){
    MovieAppMAD24Theme {
       MovieList(movies = getMovies())
    }
}
