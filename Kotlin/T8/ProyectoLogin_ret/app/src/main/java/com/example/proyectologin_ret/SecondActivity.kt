package com.example.proyectologin_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyectologin_ret.adapter.AdaptadorProductos
import com.example.proyectologin_ret.databinding.ActivitySecondBinding
import com.example.proyectologin_ret.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var dataBase: FirebaseDatabase
    private lateinit var adaptadorProductos: AdaptadorProductos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBase =
            FirebaseDatabase.getInstance("https://fir-ces2023-bmh-default-rtdb.firebaseio.com/")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        adaptadorProductos = AdaptadorProductos(applicationContext)

        binding.reyclerProductos.adapter = adaptadorProductos
        binding.reyclerProductos.layoutManager =
            LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        val uid = intent.extras!!.getString("uid")
        val nombre = intent.extras!!.getString("nombre")
        val edad = intent.extras!!.getInt("edad")

        val referencia = dataBase.getReference("usuarios").child(uid!!)
        referencia.child("datos").child("nombre").setValue(nombre)
        referencia.child("datos").child("edad").setValue(edad)

        setContentView(binding.root)

        binding.botonAgregar.setOnClickListener {

            val referenciaProductos = referencia.child("productos")
            //referenciaProductos.child("telefono").child("nombre").setValue("iphone")
            //referenciaProductos.child("telefono").child("valor").setValue(230)
            referenciaProductos.child("coche").setValue(Producto("coche", 10000))

            // agregar datos a la base de datos
            //val referencia = dataBase.getReference("usuarios").child("usuario2")
            //referencia.child("dni").setValue("12312312")
            //referencia.child("experiencia").setValue(false)
        }
        binding.botonConsultar.setOnClickListener {
            referencia.child("productos").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    adaptadorProductos.vaciarLista()
                    for (item in snapshot.children) {

                        val producto = item.getValue(Producto::class.java)
                        adaptadorProductos.agregarProducto(producto!!)
                        Log.v("base_datos", "Producto ${producto!!.nombre} ${producto!!.cv}")

                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
        }
    }
}