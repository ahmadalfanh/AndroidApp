package com.alfan.test.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadFromDB().firstOrNull()
        if (shouldFetch(dbSource)) {
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }

                is ApiResponse.Empty -> {
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }

                is ApiResponse.Error -> {
                    onFetchFailed()

                }
            }
        } else {
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    emit(Resource.Success(data = apiResponse.data))
                }

                is ApiResponse.Empty -> {
                    emit(Resource.Error("Empty"))
                }

                is ApiResponse.Error -> {
                    onFetchFailed()

                }
            }
        }
    }

    protected open fun onFetchFailed() {}

    protected open fun loadFromDB(): Flow<ResultType> {
        return emptyFlow()
    }

    protected open fun shouldFetch(data: ResultType?): Boolean {
        return true
    }

    protected open suspend fun createCall(): Flow<ApiResponse<ResultType>> {
        return emptyFlow()
    }

    protected open suspend fun saveCallResult(data: ResultType) {

    }

    fun asFlow(): Flow<Resource<ResultType>> = result


}