package com.example.comics.data


data class GetComicResponse(
    val data: ComicData?
)

data class ComicData(
    val results: List<ComicResults> = listOf()
)

data class ComicResults (
    val title: String,
    val description: String?,
    val thumbnail: ThumbnailResp?
)

data class ThumbnailResp(
    val path: String?,
    val extension: String?,
)
