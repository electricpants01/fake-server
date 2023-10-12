package com.example.newnetworkingapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newnetworkingapp.data.model.Post
import com.example.newnetworkingapp.data.service.NetworkResult
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val _homeEvent = MutableLiveData<HomeEvent>()
    val homeEvent: LiveData<HomeEvent> = _homeEvent
    private val postRepository = PostRepository()


    fun fetchAllPosts() {
        viewModelScope.launch {
            val dataResult = postRepository.getPost(1)
            when(dataResult) {
                is NetworkResult.NetworkSuccess<*> -> {
                    _homeEvent.value = HomeEvent.PostSuccess(dataResult.data as Post)
                }
                is NetworkResult.NetworkFailure -> {
                    _homeEvent.value = HomeEvent.PostFailure(dataResult.message)
                }
            }
        }
    }

    fun createPost() {
        viewModelScope.launch {
            postRepository.createPost(Post("This is a new post", null, "New Post"))
        }
    }

}