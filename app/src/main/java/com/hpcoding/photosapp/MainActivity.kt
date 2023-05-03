package com.hpcoding.photosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.hpcoding.photosapp.presentation.PhotosListScreen
import com.hpcoding.photosapp.presentation.PhotosViewModel
import com.hpcoding.photosapp.ui.theme.PhotosAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<PhotosViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        viewModel.getPhotos()
        setContent {
            PhotosAppTheme {
                PhotosListScreen(state = viewModel.state.value)
            }
        }
    }
}

