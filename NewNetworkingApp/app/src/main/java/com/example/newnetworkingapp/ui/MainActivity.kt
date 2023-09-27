package com.example.newnetworkingapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.newnetworkingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnFetchAllPosts.setOnClickListener {
            mainActivityViewModel.fetchAllPosts()
        }
        mainActivityViewModel.myPost.observe(this) { posts ->
            binding.mainTextView.text = "your list has size: ${posts.size}"
        }
    }
}