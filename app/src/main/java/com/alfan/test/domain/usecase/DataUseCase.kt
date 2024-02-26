package com.alfan.test.domain.usecase

import com.alfan.test.core.Resource
import com.alfan.test.data.IRepository
import com.alfan.test.data.remote.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface IDataUseCase {
    fun getTopHeadlinesNews(
        category: String
    ): Flow<Resource<NewsResponse>>
}

class DataUseCase(private val repository: IRepository) : IDataUseCase {
    override fun getTopHeadlinesNews(
        category: String
    ): Flow<Resource<NewsResponse>> {
        return repository.getTopHeadlinesNews(category)
    }

}