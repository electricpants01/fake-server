package com.example.newnetworkingapp.ui

import com.example.newnetworkingapp.data.RetrofitInstance
import com.example.newnetworkingapp.data.model.Post
import com.example.newnetworkingapp.data.service.PostService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository(
    private val ioScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    private val postService: PostService = RetrofitInstance.instance.create(PostService::class.java)
) {

    suspend fun getAllPosts(): List<Post> {
        return withContext(Dispatchers.IO) {
            println("chris first")
            val response = postService.getAllPosts()
            println("chris response ${response.isSuccessful}")
            if (response.isSuccessful) {
                response.body()!!
            } else { // something went wrong
                emptyList()
            }
        }
    }
}