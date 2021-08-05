package com.example.kotlincoroutines_codienger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlincoroutines_codienger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            doSomeTask()
        }
    }

    private fun doSomeTask() {
        Thread.sleep(5000)
        Toast.makeText(this,"Task Done",Toast.LENGTH_LONG).show()
    }
}