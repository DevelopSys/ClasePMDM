package com.develop.t3_spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.develop.t3_spinner.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()

    }

    private fun recuperarDatos() {
        // intent --> bundle --> dato
        var bundle = intent.extras
    }
}