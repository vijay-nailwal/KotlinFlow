package com.flow.examples.kotlinflow.network


/**
 * Created by Vijay on 17-02-2022.
 */
import com.flow.examples.kotlinflow.model.PostModel
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPost() : List<PostModel>
}