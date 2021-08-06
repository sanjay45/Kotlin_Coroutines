package com.example.kotlincoroutines_codienger

import android.content.Intent
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

        binding.button.setOnClickListener {
            navigateToNextActivity()
            finish()
        }

        GlobalScope.launch {
            while (true) {
                Log.i("Global","onCreate")
                delay(2000)
            }
        }

    }

    private fun navigateToNextActivity() {
        val intent = Intent(this,NextActivity::class.java)
        startActivity(intent)
    }
}