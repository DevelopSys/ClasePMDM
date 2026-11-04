package com.example.login.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.MainActivity
import com.example.login.R
import com.example.login.data.DataSet
import com.example.login.databinding.ActivityRegistroBinding
import com.example.login.model.User
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


    override fun onStart() {
        super.onStart()
        binding.btnVolver.setOnClickListener {
            finish()
        }
        binding.btnRegistrar.setOnClickListener {
            // hay algo no relleno o el spinner tiene index 0
            var name: String = binding.editNombre.text.toString();
            var surname: String = binding.editApellido.text.toString();
            var mail: String = binding.editCorreo.text.toString()
            var pass: String = binding.editPass.text.toString()
            var profileIndex: Int = binding.spinnerPerfil.selectedItemPosition;
            var profileItem: String = binding.spinnerPerfil.adapter
                .getItem(binding.spinnerPerfil.selectedItemPosition).toString()
            // var profileIndex: Int = binding.spinnerPerfil.selectedItemPosition;
            // var profileItem: String = binding.spinnerPerfil.selectedItem.toString()

            if (name.isEmpty()
                || surname.isEmpty()
                || mail.isEmpty()
                || pass.isEmpty()
                || profileIndex == 0
            ) {
                Snackbar.make(binding.root, "Faltan datos por rellenar", Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                // crear el usuario y meterlo en una lsita
                // 0-> admin 1 -> user

                val user = User(name, surname, mail, pass, profileIndex - 1)
                if (DataSet.addUser(user)) {
                    Snackbar.make(
                        binding.root, "Usuario creado, ¿quieres login?",
                        Snackbar.LENGTH_LONG
                    )
                        .setAction("OK") {
                            val intent = Intent(applicationContext, HomeActivity::class.java)
                            intent.putExtra("user",user)
                            startActivity(intent)
                            finish()
                        }
                        .show()
                } else {
                    Snackbar.make(
                        binding.root, "Fallo en el registro",
                        Snackbar.LENGTH_LONG
                    )
                        .show()
                }

                // mensaje confirmacion
                // borrar todos
                clearData()
                // volver -> preguntando
            }
        }

    }

    fun clearData() {
        binding.editNombre.text.clear()
        binding.editPass.text.clear()
        binding.editApellido.text.clear()
        binding.editCorreo.text.clear()
        binding.spinnerPerfil.setSelection(0)
    }
}