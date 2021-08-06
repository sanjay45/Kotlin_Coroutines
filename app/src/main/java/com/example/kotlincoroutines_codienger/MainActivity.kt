package com.example.kotlincoroutines_codienger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.kotlincoroutines_codienger.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
           val result = networkCall()
            withContext(Dispatchers.Main) {
                binding.textView.text = result
            }
        }

    }

    private suspend fun networkCall(): String {
        Log.i("MainActivity","networkCall: start")
        delay(5000)
        Log.i("MainActivity","networkCall: end")
        return "Result"
    }
}