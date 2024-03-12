package com.example.comics.ui.state

import com.example.comics.domain.usecase.ComicModel

sealed class ComicsUiState {
    object Loading : ComicsUiState()
    data class Success(val list: List<ComicModel>) : ComicsUiState()
    data class ErrorState(val error: String?) : ComicsUiState()
}