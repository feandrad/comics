package com.example.comics.data.repository

import com.example.comics.data.ComicRepository
import com.example.comics.data.ComicsApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class ComicRepositoryTest {

    private lateinit var comicRepository: ComicRepository
    private val comicsApi = mockk<ComicsApi>()

    @Before
    fun setUp() {
        comicRepository = ComicRepository(comicsApi)
    }

    @Test
    fun `getComics returns success when API call is successful`() = runTest {
        coEvery { comicsApi.getComics(any(), any(), any()) } returns Response.success(mockGetComicResponse)

        val result = comicRepository.getComics()

        assert(result.isSuccess)
        assert(result.getOrNull() == mockGetComicResponse)
    }

    @Test
    fun `getComics returns failure when API call fails`() = runTest {
        coEvery { comicsApi.getComics(any(), any(), any()) } returns Response.error(400, mockk(relaxed = true))

        val result = comicRepository.getComics()

        assert(result.isFailure)
    }
}
