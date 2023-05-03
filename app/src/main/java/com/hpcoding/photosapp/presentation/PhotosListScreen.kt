package com.hpcoding.photosapp.presentation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hpcoding.photosapp.common.NetworkImage
import com.hpcoding.photosapp.domain.model.PhotoItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotosListScreen(state: PhotosScreenState) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Crossfade(targetState = state.isLoading) { isLoading ->
            if (isLoading)
                Loader()
            else {
                PhotoList(photos = state.photos, modifier = Modifier.fillMaxSize())
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PhotoList(photos: List<PhotoItem>, modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(photos) {
            PhotoCard(
                url = it.url, modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}

@Composable
fun PhotoCard(url: String, modifier: Modifier = Modifier) {
    NetworkImage(
        imageUrl = url,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun Loader() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}