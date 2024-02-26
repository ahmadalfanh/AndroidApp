package com.alfan.test.data.remote

import com.alfan.test.core.ApiResponse
import com.alfan.test.data.remote.network.ApiService
import com.alfan.test.data.remote.response.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class RemoteDataSource(private val apiService: ApiService) : IRemoteDataSource {

    override fun getTopHeadlinesNews(
        country: String, category: String?, key: String
    ): Flow<ApiResponse<NewsResponse>> {
        return flow {
            try {
                val response = apiService.getTopHeadlinesNews(
                    "us",
                    category,
                    "d4899fe8350a461b947bd7c6b7bea44c"
                )
                emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e))
            }
        }.flowOn(Dispatchers.IO)
    }


}