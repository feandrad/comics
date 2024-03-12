package com.example.comics.di

import com.example.comics.data.ComicRepository
import com.example.comics.data.ComicsApi
import com.example.comics.domain.usecase.GetComicsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideComicRepository(apiService: ComicsApi): ComicRepository =
        ComicRepository(apiService)

    @Provides
    fun provideGetComicsUseCase(repository: ComicRepository): GetComicsUseCase =
        GetComicsUseCase(repository)
}