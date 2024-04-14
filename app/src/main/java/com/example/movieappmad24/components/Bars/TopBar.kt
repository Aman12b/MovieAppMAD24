package com.example.movieappmad24.components.Bars

import android.icu.text.CaseMap.Title
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, title: String, navigationIcon: ImageVector? = null){
        CenterAlignedTopAppBar(
            title = { Text(title)},
            navigationIcon = {
                if (navigationIcon != null) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = navigationIcon,
                            contentDescription = "Back"
                        )
                    }
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            )
        )
    }