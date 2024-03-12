package com.example.comics.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.comics.R
import com.example.comics.domain.usecase.ComicModel
import com.example.comics.ui.state.ComicsUiState
import com.example.comics.ui.viewmodel.MainViewModel
import com.example.comics.ui.widget.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val viewModel: MainViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

                when (val state = uiState) {
                    is ComicsUiState.Loading ->
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))

                    is ComicsUiState.ErrorState -> ErrorText(
                        text = state.error,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    is ComicsUiState.Success -> LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        items(state.list) {
                            ComicItem(it)
                        }
                    }
                }
            }
        }
    )
}


@Composable
fun ComicItem(comic: ComicModel) {
    Row(modifier = Modifier.padding(8.dp)) {
        comic.imageUrl?.let { url ->
            GlideImage(
                imageUrl = url,
                contentDescription = stringResource(R.string.comic_image_content_desc),
                modifier = Modifier.size(100.dp)
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {

            Text(
                text = comic.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = comic.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun ErrorText(
    text: String?,
    color: Color = MaterialTheme.colorScheme.error,
    modifier: Modifier
) {
    Text(
        text = text ?: stringResource(R.string.unknown_error),
        color = color,
        modifier = modifier
    )
}


