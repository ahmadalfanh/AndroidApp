package com.alfan.test.data.remote

import com.alfan.test.core.ApiResponse
import com.alfan.test.data.remote.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface IRemoteDataSource {
    fun getTopHeadlinesNews(
        country: String,
        category: String?,
        key: String
    ): Flow<ApiResponse<NewsResponse>>
}