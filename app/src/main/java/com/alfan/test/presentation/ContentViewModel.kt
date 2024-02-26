package com.alfan.test.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.alfan.test.core.Resource
import com.alfan.test.data.remote.response.NewsResponse
import com.alfan.test.domain.usecase.IDataUseCase

class ContentViewModel(private val useCase: IDataUseCase) : ViewModel() {

    fun getTopHeadlinesNews(
        category: String
    ): LiveData<Resource<NewsResponse>> {
        return useCase.getTopHeadlinesNews(category).asLiveData()
    }

}