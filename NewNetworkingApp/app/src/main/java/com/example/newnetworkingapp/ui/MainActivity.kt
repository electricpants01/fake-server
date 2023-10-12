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

        binding.apply {
            btnFetchAllPosts.setOnClickListener {
                mainActivityViewModel.fetchAllPosts()
            }

            btnCreate.setOnClickListener {
                mainActivityViewModel.createPost()
            }
        }
        mainActivityViewModel.homeEvent.observe(this) { homeEvent ->
            when(homeEvent) {
                is HomeEvent.PostSuccess -> {
                    binding.textView.text = homeEvent.post.body.toString()
                }
                is HomeEvent.PostFailure -> {
                    binding.textView.text = getString(homeEvent.message)
                }
            }
        }


    }
}