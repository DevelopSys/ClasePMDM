package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t5_navegacion.adapters.AdapterProductos
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapterProductos: AdapterProductos
    private lateinit var database: FirebaseDatabase
    private lateinit var uid: String;
    override fun onAttach(context: Context) {
        super.onAttach(context)
        uid = arguments?.getString("uid") ?: ""
        adapterProductos = AdapterProductos(context, uid)
        database =
            FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // toda la parte grafica esta asociada

        binding.textoUsuario.text = arguments?.getString("nombre")
        binding.recyclerProductos.adapter = adapterProductos;
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        getAllProductsFB()
        val referencia =

            /* database.getReference("datos").child("products").child("0")
                 .child("price").setValue(100)*/
        database.getReference("datos").child("products").orderByChild("title")
            .equalTo("iPhone 9").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    Log.v("datos2", snapshot.value.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        Log.v("datos2", referencia.toString())
        //getAllProducts()
        //database.getReference("usuarios").child(uid).child("nombre").setValue("asdasd")
        //database.getReference("usuarios").child(uid).child("apellido").setValue("fghdfhfghfg")
        /* binding.botonEscuchar.setOnClickListener {
             *//*val reference = database.getReference("datos").child("products")
            reference.addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.v("datos", snapshot.toString())
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })*//*
            *//*reference.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val hijos = snapshot.children
                    hijos.forEach {

                        val producto = it.getValue(Producto::class.java)
                        adapterProductos.addProducto(producto)
                        // Log.v("datos", producto!!.nombre.toString())
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })*/
    }

    /*
    * Crear el recycler con los productos
    * una vez se pulse el boton
    * los productos deben ser leidos desde firebase
    * */

    private fun getAllProducts() {
        val peticion: JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products", {
            val productos = it.getJSONArray("products")
            for (i in 0 until productos.length()) {
                val imagenes: ArrayList<String>? = ArrayList()
                imagenes!!.add("Imagen1")
                imagenes!!.add("Imagen2")
                imagenes!!.add("Imagen3")
                imagenes!!.add("Imagen4")
                val item = productos.getJSONObject(i)
                val itemProducto = Producto(
                    item.getInt("id"),
                    item.getString("title"),
                    item.getDouble("price"),
                    item.getString("description"),
                    item.getString("category"),
                    item.getString("thumbnail"),
                    imagenes
                )



                adapterProductos.addProducto(itemProducto)
            }
        }, {})
        Volley.newRequestQueue(context).add(peticion)
    }

    private fun getAllProductsFB() {

        database.getReference("datos").child("products").orderByChild("title")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    adapterProductos.borrarLista()
                    snapshot.children.forEach {
                        val producto: Producto? = it.getValue(Producto::class.java)
                        Log.v("datos", producto!!.title.toString())
                        adapterProductos.addProducto(producto)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        //database.getReference("datos").child("productos").child("0").child("precio").
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}