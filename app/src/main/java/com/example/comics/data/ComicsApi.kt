package com.example.comics.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicsApi {
    @GET("comics")
    suspend fun getComics(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String
    ) : Response<GetComicResponse>
}