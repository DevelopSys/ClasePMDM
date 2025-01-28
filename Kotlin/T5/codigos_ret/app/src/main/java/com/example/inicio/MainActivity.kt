package com.example.inicio

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.inicio.databinding.ActivityMainBinding
import com.example.inicio.ui.fragment.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnF1.setOnClickListener(this)
        binding.btnF2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.btnF1.id -> {
                // poner en el sitioFragments F1
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.replace(binding.sitioFragments.id,
                    FragmentUno(), "f1")
                ft.commit()
                ft.addToBackStack(null)
            }

            binding.btnF2.id -> {
                // poner en el sitioFragments F2
                fm = supportFragmentManager
                Log.v("pila",fm.fragments.toString())
            }
        }
    }
}