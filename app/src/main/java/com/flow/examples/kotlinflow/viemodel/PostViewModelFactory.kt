package com.flow.examples.kotlinflow.viemodel


/**
 * Created by Vijay on 17-02-2022.
 */
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.flow.examples.kotlinflow.repository.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }
}