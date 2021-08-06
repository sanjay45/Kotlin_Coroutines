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

        GlobalScope.launch {
            Log.i("MainActivity","Thread name: ${Thread.currentThread().name}")
            Log.i("MainActivity","Start :")
            networkCall1()
            networkCall2()
            Log.i("MainActivity","End :")
        }
    }

    private suspend fun networkCall1() {
        delay(3000)
        Log.i("MainActivity","networkCall1 :")
    }
    private suspend fun networkCall2() {
        delay(3000)
        Log.i("MainActivity","networkCall2 :")
    }
}