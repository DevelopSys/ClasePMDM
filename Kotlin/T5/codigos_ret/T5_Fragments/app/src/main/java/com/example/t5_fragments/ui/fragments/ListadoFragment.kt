package com.example.t5_fragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.t5_fragments.MainActivity
import com.example.t5_fragments.adapter.AdaptadorProductos
import com.example.t5_fragments.databinding.FragmentListaBinding
import com.example.t5_fragments.model.Producto
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray

class ListadoFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    private lateinit var listener: OnListadoListener
    private lateinit var adaptadorProductos: AdaptadorProductos

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListadoListener
        adaptadorProductos = AdaptadorProductos(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerProductos.adapter = adaptadorProductos
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        realizarPeticion()

    }

    fun realizarPeticion() {
        val peticion = JsonObjectRequest("https://dummyjson.com/products", {
            val productos: JSONArray = it.getJSONArray("products")
            for (i in 0 until productos.length()) {
                val producto = productos.getJSONObject(i);
                val listaJSONImagnes = producto.getJSONArray("images")
                val listaImagenes = ArrayList<String>()

                for (i in 0..listaJSONImagnes.length()-1) {
                    listaImagenes.add(listaJSONImagnes[i].toString())
                }


                val productoLista = Producto(
                    producto.getInt("id"),
                    producto.getString("title"),
                    producto.getInt("price"),
                    producto.getString("brand"),
                    producto.getString("category"),
                    producto.getString("thumbnail"),
                    listaImagenes
                )
                adaptadorProductos.agregarProducto(productoLista)
            }
        }, {
            Snackbar.make(binding.root, "Fallo en la conexion con el api", Snackbar.LENGTH_SHORT)
                .show()
        })

        Volley.newRequestQueue(context).add(peticion)
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnListadoListener {
        fun onListadoSelected()
    }

}