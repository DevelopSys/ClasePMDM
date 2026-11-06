package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.login.activity.HomeActivity
import com.example.login.activity.RegisterActivity
import com.example.login.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRegister.setOnClickListener {
            // funcion a realizar
            // abrir formulario de registro -> intent
            // val intent: Intent = Intent(thi)
            val intent: Intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)

        }
        binding.btnLogin.setOnClickListener {
            // funcion a realizar
            // entrar en la app con el user indicado
            if (binding.editMail.text.toString()
                    .equals("borja@gmail.com", true)
                && binding.editPass.text.toString()
                    .equals("1234", true)
            ) {
                val intent: Intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("user_name", binding.editMail.text.toString())
                startActivity(intent)
            } else {
                Snackbar.make(binding.root, "Usuario invalido", Snackbar.LENGTH_SHORT).show()
            }

        }
        binding.btnClear?.setOnClickListener {
            // limpar los campos
            binding.editPass.text.clear()
            binding.editMail.text.clear()
        }
        Log.v("ciclo_vida", "Ejecutado onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Ejecutado onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Ejecutado onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Ejecutado onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Ejecutado onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Ejecutado onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Ejecutado onDestroy")
    }
}