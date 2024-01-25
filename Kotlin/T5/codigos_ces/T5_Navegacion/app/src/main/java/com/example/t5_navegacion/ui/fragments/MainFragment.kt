package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t5_navegacion.adapters.AdapterProductos
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.databinding.FragmentSiginBinding
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
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
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val uid = arguments?.getString("uid") ?:""
        adapterProductos = AdapterProductos(context,uid)
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
        getAllProducts()
        database.getReference("usuarios").child("usuario1").setValue("asdasd")
        database.getReference("usuarios").child("usuario2").setValue("fghdfhfghfg")
    }

    private fun getAllProducts() {
        val peticion: JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products", {
            val productos = it.getJSONArray("products")
            for (i in 0 until productos.length()) {
                val imagenes: ArrayList<String> = ArrayList()
                imagenes.add("Imagen1")
                imagenes.add("Imagen2")
                imagenes.add("Imagen3")
                imagenes.add("Imagen4")
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}