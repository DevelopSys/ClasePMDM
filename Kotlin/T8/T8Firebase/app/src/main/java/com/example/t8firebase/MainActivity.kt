package com.example.t8firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContentView(R.layout.activity_main)

        // crear un usuario con mail / pass
        /*auth.createUserWithEmailAndPassword("bmartinh1@gmail.com","Retamar1a")
            .addOnCompleteListener {
                if (it.isSuccessful){
                    Log.v("prueba_fb","creacion de usuario correcta")
                } else {
                    Log.v("prueba_fb","creacion de usuario incorrecta")
                }
            }*/

        auth.currentUser

        auth.signInWithEmailAndPassword("bmartinh@gmail.com","Retamar1a")
            .addOnCompleteListener {
                if (it.isSuccessful){
                    val usuarioLogeado = auth.currentUser;
                    Log.v("prueba_fb","Login correcto con uid ${usuarioLogeado?.ui}")
                    // sacar a la siguiente parte

                } else {
                    Log.v("prueba_fb","Login incorrecto")
                    auth.currentUser // null

                }
            }


    }
}