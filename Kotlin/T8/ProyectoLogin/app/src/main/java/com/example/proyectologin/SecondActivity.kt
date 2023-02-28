package com.example.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectologin.databinding.ActivitySecondBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SecondActivity : AppCompatActivity() {

    private var nombre: String? = null
    private var uid: String? = null
    private lateinit var fDataBase: FirebaseDatabase
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fDataBase =
            FirebaseDatabase.getInstance("https://fir-ces2023-bmh-default-rtdb.firebaseio.com/")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI()

        // nada mas arrancar
            // en un textview de la pantalla aparezca bienvenido: nombre usuario
        // en el formulario al agregar un dato
            // en el nodo del usuario
                // crear un nodo productos_fav
                    // nombre_producto
                        // nombre: nombre del edit
                        // valor: valor del edit

        // quiero que se guarde en un nodo
            // usuarios
                // uid
                    // nombre: valor

    }

    private fun initGUI() {
        nombre = intent.extras!!.getString("nombre")
        uid = intent.extras!!.getString("uid")

        fDataBase.getReference("usuarios")
            .child(uid.toString())
            .child("nombre")
            .setValue(nombre)


    }
}