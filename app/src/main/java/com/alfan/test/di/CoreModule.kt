package com.alfan.test.di

import com.alfan.test.data.IRepository
import com.alfan.test.data.Repository
import com.alfan.test.data.remote.IRemoteDataSource
import com.alfan.test.data.remote.RemoteDataSource
import com.alfan.test.data.remote.network.ApiService
import com.alfan.test.domain.usecase.DataUseCase
import com.alfan.test.domain.usecase.IDataUseCase
import com.alfan.test.presentation.ContentViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}
val repositoryModule = module {
    single<IRepository> { Repository(get()) }
    single<IDataUseCase> { DataUseCase(get()) }
    single<IRemoteDataSource> { RemoteDataSource(get()) }

}
val viewModelModule = module {
    viewModel { ContentViewModel(get()) }
}
