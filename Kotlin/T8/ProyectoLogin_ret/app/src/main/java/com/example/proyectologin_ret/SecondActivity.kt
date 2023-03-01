package com.example.proyectologin_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectologin_ret.databinding.ActivitySecondBinding
import com.google.firebase.database.FirebaseDatabase

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var dataBase: FirebaseDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBase =
            FirebaseDatabase.getInstance("https://fir-ces2023-bmh-default-rtdb.firebaseio.com/")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonAgregar.setOnClickListener {
            // agregar datos a la base de datos

            val referencia = dataBase.getReference("usuarios").child("usuario2")
            referencia.child("dni").setValue("12312312")
            referencia.child("experiencia").setValue(false)
            referencia.child("experiencia").setValue(false)

        }
    }
}