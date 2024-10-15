package com.example.formulario.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formulario.R
import com.example.formulario.databinding.ActivityMainBinding
import com.example.formulario.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}