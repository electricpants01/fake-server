package com.example.newnetworkingapp.ui

import com.example.newnetworkingapp.R
import com.example.newnetworkingapp.data.RetrofitInstance
import com.example.newnetworkingapp.data.model.Post
import com.example.newnetworkingapp.data.service.NetworkResult
import com.example.newnetworkingapp.data.service.PostService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class PostRepository(
    private val ioScope: CoroutineScope = CoroutineScope(Dispatchers.IO),
    private val postService: PostService = RetrofitInstance.instance.create(PostService::class.java)
) {

    suspend fun getAllPosts(): List<Post> {
        return withContext(Dispatchers.IO) {
            val response = postService.getAllPosts()
            if (response.isSuccessful) {
                response.body()!!
            } else { // something went wrong
                emptyList()
            }
        }
    }

    suspend fun getPost(postId: Int): NetworkResult {
        return try {
            withContext(Dispatchers.IO) {
                val response = postService.getPost(postId)
                if (response.isSuccessful) {
                    NetworkResult.NetworkSuccess(response.body()!!)
                } else { // http status code 300-500
                    NetworkResult.NetworkFailure(R.string.user_error)
                }
            }
        } catch (e: UnknownHostException) {
            NetworkResult.NetworkFailure(R.string.network_error)
        } catch (e: Exception) {
            NetworkResult.NetworkFailure(R.string.something_went_wrong)
        }
    }

    suspend fun createPost(post: Post) {
        return withContext(Dispatchers.IO) {
            postService.createPost(post)
        }
    }
}