package com.example.comics.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ComicRepository (private val comicsApi: ComicsApi) {

    suspend fun getComics(): Result<GetComicResponse> {
        val response = comicsApi.getComics(
            apikey = "b7e14bab409c70a5c4e7c2b319c09d7b",
            ts = "1682982412",
            hash = "3482f01e9bf207a437a4b621c91339ad"
        )
        return if (response.body() != null && response.isSuccessful) {
            Result.success(response.body()!!)
        } else {
            Result.failure(RuntimeException("Failed to load content."))
        }
    }
}