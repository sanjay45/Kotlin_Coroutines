package com.example.kotlincoroutines_codienger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kotlincoroutines_codienger.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("MainActivity","onCreate : ${Thread.currentThread().name}")

        GlobalScope.launch {
            Log.i("MainActivity","coroutine launch in : ${Thread.currentThread().name}")
            delay(3000)
            Log.i("MainActivity","coroutine launch in : ${Thread.currentThread().name}")
        }

    }
}