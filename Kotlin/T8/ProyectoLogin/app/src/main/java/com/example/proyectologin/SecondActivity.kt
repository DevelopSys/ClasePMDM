package com.example.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.proyectologin.databinding.ActivitySecondBinding
import com.example.proyectologin.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.math.log

class SecondActivity : AppCompatActivity() {

    private var nombre: String? = null
    private var uid: String? = null
    private lateinit var fDataBase: FirebaseDatabase
    private lateinit var binding: ActivitySecondBinding
    private lateinit var arrayProductos: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arrayProductos = ArrayList();

        fDataBase =
            FirebaseDatabase.getInstance("https://fir-ces2023-bmh-default-rtdb.firebaseio.com/")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI()




        binding.botonAgregar.setOnClickListener {

            val nombreProducto = binding.editNombre.text.toString()
            val valorProducto = binding.editValor.text.toString().toInt()

            val producto = Producto(binding.editNombre.text.toString(),binding.editValor.text.toString().toInt())
            val referciaProducto = fDataBase.getReference("usuarios")
                .child(uid!!)
                .child("productos_fav")
                .child(producto.nombre.toString())


            referciaProducto.setValue(producto)


            //referciaProducto.child("nombre").setValue(nombreProducto)
            //referciaProducto.child("valor").setValue(valorProducto)

            // uid
            // productos_fav
            // binding.editNombre.text.toString()
            // nomnbre = binding.editNombre.text.toString()
            // valor = binding.editNombre.text.toString()
        }
        binding.botonRecuperar.setOnClickListener {

            fDataBase.getReference("usuarios")
                .child(uid!!)
                .child("productos_fav")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {

                        // snapshot --> estado actual
                        // Log.v("salida",snapshot.key.toString())
                        for (i in snapshot.children){
                            //Log.v("salida",i.key.toString())
                            val producto = i.getValue(Producto::class.java)
                            Log.v("salida",producto!!.valor.toString())
                            arrayProductos.add(producto)
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // error en la comunicacion
                    }

                })

        }



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