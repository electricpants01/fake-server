package com.example.newnetworkingapp.data.service

import com.example.newnetworkingapp.data.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>

    @GET("posts/{post_id}")
    suspend fun getPost(@Path("post_id") postId: Int): Response<Post>

    @POST("posts")
    suspend fun createPost(@Body post: Post): Response<Post>

}