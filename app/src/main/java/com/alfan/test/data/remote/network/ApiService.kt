package com.alfan.test.data.remote.network

import com.alfan.test.data.remote.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    companion object {
        const val BASE_URL = "https://newsapi.org/v2/"

    }

    @GET("top-headlines")
    suspend fun getTopHeadlinesNews(
        @Query("country") country: String,
        @Query("category") category: String?,
        @Query("apiKey") key: String
    ): NewsResponse

}