package com.example.newnetworkingapp.data.service

import com.example.newnetworkingapp.data.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts") // https://jsonplaceholder.typicode.com/posts
    suspend fun getAllPosts(): Response<List<Post>>


}