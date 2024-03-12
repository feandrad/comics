package com.example.comics.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comics.domain.usecase.GetComicsUseCase
import com.example.comics.ui.state.ComicsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getComicsUseCase: GetComicsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<ComicsUiState>(ComicsUiState.Loading)
    val uiState: StateFlow<ComicsUiState> = _uiState.asStateFlow()

    init {
        loadComics()
    }

    fun loadComics() {
        viewModelScope.launch {
            _uiState.value = ComicsUiState.Loading
            getComicsUseCase().onSuccess { comics ->
                _uiState.value = ComicsUiState.Success(comics)
            }.onFailure {
                _uiState.value = ComicsUiState.ErrorState(it.localizedMessage)
            }
        }
    }
}