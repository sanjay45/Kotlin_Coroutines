package com.example.kotlincoroutines_codienger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlincoroutines_codienger.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                doSomeTaskWithCoroutines()
            }
        }
    }

    private suspend fun doSomeTaskWithCoroutines() {
        delay(5000)
        withContext(Dispatchers.Main) {
            Toast.makeText(this@MainActivity,"Task Done", Toast.LENGTH_LONG).show()
        }
    }
}