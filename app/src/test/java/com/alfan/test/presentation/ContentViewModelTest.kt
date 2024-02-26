package com.alfan.test.presentation

import com.alfan.test.base.BaseTestClass
import com.alfan.test.core.Resource
import com.alfan.test.data.remote.response.NewsResponse
import com.alfan.test.domain.model.ArticlesItem
import com.alfan.test.domain.model.Source
import com.alfan.test.domain.usecase.IDataUseCase
import com.alfan.test.utils.ConstantsTest
import com.alfan.test.utils.getOrAwaitValue
import kotlinx.coroutines.flow.flow
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class ContentViewModelTest : BaseTestClass() {
    @Mock
    private lateinit var useCase: IDataUseCase
    private lateinit var viewModel: ContentViewModel

    @Before
    fun setUp() {
        viewModel = ContentViewModel(useCase)
    }

    @Test
    fun `get getTopHeadlinesNews with success mock response should return success`() {
        val category = "entertainment"
        // Given
        Mockito.`when`(useCase.getTopHeadlinesNews(category)).thenReturn(flow {
            emit(
                Resource.Success(
                    dataDummy
                )
            )
        })
        //when
        val result = viewModel.getTopHeadlinesNews(category).getOrAwaitValue()
        //then
        Mockito.verify(useCase, Mockito.atLeastOnce()).getTopHeadlinesNews(category)
        Assert.assertTrue(result is Resource.Success)
        Assert.assertEquals(dataDummy, result.data)
    }

    @Test
    fun `get getTopHeadlinesNews with error mock response should return error`() {
        val category = "entertainment"
        // Given
        Mockito.`when`(useCase.getTopHeadlinesNews(category)).thenReturn(flow {
            emit(
                Resource.Error(
                    message = ConstantsTest.ERROR_MESSAGE
                )
            )
        })

        // When
        val result = viewModel.getTopHeadlinesNews(category).getOrAwaitValue()
        // Then
        Mockito.verify(useCase, Mockito.atLeastOnce()).getTopHeadlinesNews(category)
        Assert.assertTrue(result is Resource.Error)
        Assert.assertEquals(null, result.data)
        Assert.assertEquals(
            ConstantsTest.ERROR_MESSAGE, result.message
        )
    }


    companion object {
        private val dataList = ArticlesItem().apply {
            publishedAt = "2024-02-24T16:40:45Z"
            author = "Vatican News"
            urlToImage =
                "https://www.vaticannews.va/content/dam/vaticannews/agenzie/images/srv/2024/02/14/2024-02-14-udienza-generale-/1707901383659.JPG/_jcr_content/renditions/cq5dam.thumbnail.cropped.1500.844.jpeg,"
            description = "desa ku"
            source = sourceData
            title = "jek"
            url = "kwldjdlsa"
            content = "conten ku"
        }
        private val sourceData = Source().apply {
            name = " jhon ef kenedy"
            id = "1"
        }

        val dataDummy = NewsResponse().apply {
            totalResults = 200
            articles = listOf(dataList)
            status = "oke"
        }

    }
}