package com.example.login.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.R
import com.example.login.databinding.ActivityHomeBinding
import com.example.login.model.User

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    fun getExtras() {
        if (intent.getSerializableExtra("user") != null) {
            user = intent.getSerializableExtra("user") as User
        }
    }

    override fun onStart() {
        super.onStart()
        binding.textSaludo.text = "Bienvenido ${user?.name ?: " invidado"}"
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogOut.setOnClickListener { finish() }
    }
}