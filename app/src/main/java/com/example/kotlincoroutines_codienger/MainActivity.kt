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

        lifecycleScope.launch {
            //testLaunch()
            testAsync()
        }

    }

    private suspend fun testLaunch() {
       val job =  lifecycleScope.launch {
            delay(5000)
            Log.i("MainActivity","5 seconds to finish")
        }
        // If want to run this "test: " after delaying 5 sec then we have to use  job.join()
        job.join()
        Log.i("MainActivity","testLaunch: ")
    }

    private suspend fun testAsync() {
        val deferred: Deferred<String> = lifecycleScope.async {
            delay(5000)
            Log.i("MainActivity","5 seconds to finish")
            "Return value of async()"
        }

      val value = deferred.await()
        Log.i("MainActivity","testAsync: $value")
    }

}