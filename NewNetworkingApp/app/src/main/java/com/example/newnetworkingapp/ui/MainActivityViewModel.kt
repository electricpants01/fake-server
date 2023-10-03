package com.example.newnetworkingapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newnetworkingapp.data.model.Post
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _myPost = MutableLiveData<Post>()
    val myPost: LiveData<Post> = _myPost
    private val postRepository = PostRepository()


    fun fetchAllPosts() {
        viewModelScope.launch {
            val response = postRepository.getPost(1)
            _myPost.value = response
        }
    }

    fun createPost() {
        viewModelScope.launch {
            postRepository.createPost(Post("This is a new post", null, "New Post"))
        }
    }

}