package com.example.proyectologin

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.proyectologin.databinding.ActivityDudasBinding
import com.example.proyectologin.model.Producto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class DudasActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDudasBinding
    private lateinit var dataBase: FirebaseDatabase;
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // dataBase = Firebase.database
        dataBase =
            FirebaseDatabase.getInstance("https://fir-ces2023-bmh-default-rtdb.firebaseio.com/")

        // auth = Firebase.auth;
        auth = FirebaseAuth.getInstance() // no es null - es Unit

        // en la pantalla de registro
        auth.createUserWithEmailAndPassword("mail", "pass").addOnCompleteListener {
            if (it.isSuccessful) {
                // auth.currentUser!!.uid // FirebaseUser --> login
                // SnackBar Usuario creado correctamento --> ¿Quieres logearte?
                // si pulso el boton -> al second con el uid
                // si pulso el boton -> al login con el usuario y pass, y lo pongo en los
                // edits
                // vas a la pantalla de login
            } else {
                auth.currentUser // Unit
            }
        }

        dataBase.getReference("productos").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    val p: Producto = i.getValue(Producto::class.java)!!
                    if (p.usuarios.find {
                            it.equals("UID")
                        } != null) {
                        // marca el elemento como fav
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


        binding = ActivityDudasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_dudas)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_dudas)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}