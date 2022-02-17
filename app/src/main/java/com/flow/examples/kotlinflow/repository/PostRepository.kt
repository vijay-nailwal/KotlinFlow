package com.flow.examples.kotlinflow.repository

/**
 * Created by Vijay on 17-02-2022.
 */

import com.flow.examples.kotlinflow.model.PostModel
import com.flow.examples.kotlinflow.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository {
    fun getPost(): Flow<List<PostModel>> = flow {
        val postList = RetrofitBuilder.api.getPost()
        emit(postList)
    }.flowOn(Dispatchers.IO)
}