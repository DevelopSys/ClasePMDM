package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.activities.HomeActivity
import com.example.login.activities.RegistroActivity
import com.example.login.data.DataSet
import com.example.login.databinding.ActivityMainBinding
import com.example.login.model.User
import com.google.android.material.snackbar.Snackbar

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
        binding.grupoUsuario.setOnCheckedChangeListener { _, i ->
            var enable: Boolean = false;
            when(i){
                binding.radioUsuario.id->{enable = true}
                binding.radioInvitado.id->{ enable = false}
            }
            binding.chekRecordar.isEnabled = enable

        }
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
                val mail = binding.editMail.text.toString()
                val pass = binding.editPass.text.toString()
                val user: User? = DataSet.getLogin(mail, pass)
                if (user != null) {
                    val intent = Intent(applicationContext, HomeActivity::class.java)
                    // val bundle = Bundle()
                    // bundle.putSerializable("user",user)
                    // si esta seleccionado el radio usuario
                    val radioSelected: Int = binding.grupoUsuario.checkedRadioButtonId
                    if (radioSelected == binding.radioUsuario.id) {
                        intent.putExtra("user", user)
                    }

                    startActivity(intent)
                } else {
                    Snackbar.make(binding.root, "Login incorrecto", Snackbar.LENGTH_LONG).show()
                }
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