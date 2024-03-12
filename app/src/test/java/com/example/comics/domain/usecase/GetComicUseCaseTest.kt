package com.example.comics.domain.usecase

import com.example.comics.data.ComicRepository
import com.example.comics.data.ComicResults
import com.example.comics.data.ThumbnailResp
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetComicsUseCaseTest {

    private lateinit var getComicsUseCase: GetComicsUseCase
    private val comicRepository = mockk<ComicRepository>()

    @Before
    fun setUp() {
        getComicsUseCase = GetComicsUseCase(comicRepository)
    }

    @Test
    fun `invoke returns list of ComicModel on successful data retrieval`() = runTest {
        val mockComicData = listOf(
            ComicModel(title = "Test Comic", imageUrl = "http://example.com/test.jpg", description = "Test Description")
        )

        coEvery { comicRepository.getComics() } returns Result.success(mockk {
            every { data?.results } returns listOf(
                ComicResults(title = "Test Comic", thumbnail = ThumbnailResp("http://example.com/test", "jpg"), description = "Test Description")
            )
        })

        val result = getComicsUseCase()

        assertTrue(result.isSuccess)
        assertEquals(mockComicData, result.getOrNull())
    }

    @Test
    fun `invoke returns an empty list when data retrieval is unsuccessful`() = runTest {
        coEvery { comicRepository.getComics() } returns Result.failure(Exception("Network Error"))

        val result = getComicsUseCase()

        assertTrue(result.isFailure)
        assertEquals("Network Error", result.exceptionOrNull()?.message)
    }
}
