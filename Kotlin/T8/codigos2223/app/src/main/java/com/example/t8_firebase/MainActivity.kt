package com.example.t8_firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.t8_firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        database = Firebase.database("https://fir-ces2023-bmh-default-rtdb.firebaseio.com/")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonCrear.setOnClickListener {
            auth.createUserWithEmailAndPassword("bmartinh3@gmail.com","Ces1234@")
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Log.v("firebase_ejemplo","usuario creado con exito")
                    } else {
                        Log.v("firebase_ejemplo","error en la creacion del usuario")
                    }
                }
        }
        binding.botonLogin.setOnClickListener {

            auth.signInWithEmailAndPassword("bmartinh1@gmail.com", "Ces1234@")
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        Log.v("firebase_ejemplo","usuario logeado con uuid: "+auth.currentUser!!.uid)

                    } else {
                        Log.v("firebase_ejemplo","error en el login del usuario")
                    }
                }

        }
        binding.botonNodo.setOnClickListener {
            // crear la referencia
            database.getReference("ejemplo").setValue("Valor nuevo del nodo ejemplo")
            database.getReference("nodo_nuevo")
                .child("ejemplo_hijo")
                .child("nodo_agregar")
                .setValue(1234)
        }


    }
}