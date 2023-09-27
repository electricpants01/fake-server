package com.example.newnetworkingapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newnetworkingapp.data.model.Post
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _myPost = MutableLiveData<List<Post>>()
    val myPost: LiveData<List<Post>> = _myPost
    private val postRepository = PostRepository()


    fun fetchAllPosts() {
        viewModelScope.launch {
            println("chris go here")
            val response = postRepository.getAllPosts()
            println("chris response ${response.size}")
            _myPost.value = response
        }
    }

}