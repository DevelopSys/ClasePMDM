package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.activities.RegistroActivity
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener(this)
        binding.btnRegistro.setOnClickListener(this)
    }

    override fun onRestart() {
        super.onRestart()
        binding.editMail.text.clear()
        binding.editPass.text.clear()
        binding.chekRecordar.isChecked = false;
        binding.grupoUsuario.clearCheck()
    }


    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.btnRegistro.id -> {

                val intent: Intent = Intent(this, RegistroActivity::class.java)
                startActivity(intent)
            }

            binding.btnLogin.id -> {

            }
        }
    }
}


/*
Al registar, llevar el usaurio a la lista del companion
    Si ya hay un usuario con ese correo -> aviso
    Si lo registra bien, snackbar con la accion

Al logear,
    Si el usuario existe en la lista -> cambia de pantalla
    Si el usuario no existe en la lista -> saca aviso en snack

 */