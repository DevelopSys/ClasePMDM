package com.example.contador

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var counter: Int = 800;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI(savedInstanceState)
    }

    private fun initGUI(state: Bundle?) {
        counter = state?.getInt("counter") ?: 0
        binding.textCounter.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }

    override fun onStart() {
        super.onStart()
        actions()
    }

    private fun actions() {
        binding.buttonInc.setOnClickListener(this)
        binding.buttonDec.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.buttonInc.id -> {
                // binding.textCounter.setText((binding.textCounter.text.toString().toInt()+1).toString())
                if (counter == 15) {
                    Snackbar.make(binding.root, "Limite alcanzado", Snackbar.LENGTH_SHORT).show()
                } else {
                    counter++
                }
            }

            binding.buttonDec.id -> {
                // binding.textCounter.setText((binding.textCounter.text.toString().toInt()-1).toString())
                counter--
            }
        }

        binding.textCounter.text = counter.toString()
    }
}