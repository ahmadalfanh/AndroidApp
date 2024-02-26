package com.alfan.test.data

import com.alfan.test.core.ApiResponse
import com.alfan.test.core.NetworkBoundResource
import com.alfan.test.core.Resource
import com.alfan.test.data.remote.IRemoteDataSource
import com.alfan.test.data.remote.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getTopHeadlinesNews(
        category: String
    ): Flow<Resource<NewsResponse>>
}

class Repository(private val remoteDataSource: IRemoteDataSource) : IRepository {

    override fun getTopHeadlinesNews(
        category: String
    ): Flow<Resource<NewsResponse>> {
        return object : NetworkBoundResource<NewsResponse, NewsResponse>() {
            override fun shouldFetch(data: NewsResponse?): Boolean {
                return false
            }

            override suspend fun createCall(): Flow<ApiResponse<NewsResponse>> {
                return remoteDataSource.getTopHeadlinesNews(
                    "us",
                    category,
                    "d4899fe8350a461b947bd7c6b7bea44c"
                )
            }
        }.asFlow()
    }

}