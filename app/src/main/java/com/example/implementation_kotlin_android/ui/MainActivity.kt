package com.example.implementation_kotlin_android.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.implementation_kotlin_android.R
import com.example.implementation_kotlin_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //profile image
        Glide
            .with(this)
            .load("https://lh3.googleusercontent.com/a/ACg8ocJKzsRo9-DhdWKlTXxioVeNMrZq2FB8WgXCDP0J3VWFq0fsHOYE=s288-c-no")
            .into(binding.profileImage)

        binding.btnFirst.setOnClickListener {
            val intent = Intent(this, DataTypeAndVariable::class.java)
            startActivity(intent)
        }
    }
}