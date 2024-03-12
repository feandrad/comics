package com.example.comics.domain.usecase

import com.example.comics.data.ThumbnailResp

data class ComicModel(
    var title: String,
    var description: String,
    var imageUrl: String?,
)

fun ThumbnailResp?.toUri(): String? =
    if (this != null && path != null && extension != null) {
        "$path.$extension"
    } else {
        null
    }