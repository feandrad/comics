package com.example.comics.domain.usecase

import com.example.comics.data.ComicRepository

class GetComicsUseCase(private val repository: ComicRepository) {
    suspend operator fun invoke(): Result<List<ComicModel>> =
        repository.getComics().map { resp ->
            resp.data?.results?.map {
                ComicModel(
                    title = it.title,
                    imageUrl = it.thumbnail.toUri(),
                    description = it.description?: "",
                )
            } ?: listOf()
        }
}



