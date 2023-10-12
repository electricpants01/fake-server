package com.example.newnetworkingapp.ui

import androidx.annotation.StringRes
import com.example.newnetworkingapp.data.model.Post

sealed class HomeEvent {
    data class PostSuccess(val post: Post) : HomeEvent()
    data class PostFailure(@StringRes val message: Int) : HomeEvent()
}