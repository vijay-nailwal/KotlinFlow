package com.flow.examples.kotlinflow.viemodel


/**
 * Created by Vijay on 17-02-2022.
 */
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flow.examples.kotlinflow.model.PostModel
import com.flow.examples.kotlinflow.repository.PostRepository
import com.flow.examples.util.LogUtil
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository)
    : ViewModel() {

    val postData: MutableLiveData<List<PostModel>> = MutableLiveData()

    /*  way 1 */
    fun getPost() {
        viewModelScope.launch {
            postRepository.getPost()
                .catch { e ->
                    LogUtil.d(e.message.toString())
                }
                .collect { postData1 ->
                    postData.value = postData1
                }
        }
    }

    /*
       way 2
     val postData1:LiveData<List<Post>> = liveData {
          postRepository.getPost()
              .catch {  }
              .collect {postData->
                  emit(postData)
              }
      }
     */

    /*
    way 3
     val postData2:LiveData<List<Post>> = postRepository.getPost()
         .catch {  }
         .asLiveData()
     */
}