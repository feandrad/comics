package com.example.comics.data.repository

import com.example.comics.data.ComicData
import com.example.comics.data.ComicResults
import com.example.comics.data.GetComicResponse
import com.example.comics.data.ThumbnailResp

val mockThumbnailResp = ThumbnailResp(
    path = "http://example.com/image",
    extension = "jpg"
)

val mockComicResults = ComicResults(
    title = "Mock Comic Title",
    description = "Mock Description",
    thumbnail = mockThumbnailResp
)

val mockComicData = ComicData(
    results = listOf(mockComicResults) // Add more instances if needed
)

val mockGetComicResponse = GetComicResponse(
    data = mockComicData
)
