package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5_navegacion.adapters.ProductoAdapter
import com.example.t5_navegacion.databinding.FragmentLoginBinding
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.databinding.FragmentSignupBinding
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentMain : Fragment() {

    /*
    * Borrar todos los usuarios registrados
    * Cuando un usuario se registra, se guarda en base de datos sus datos
    * ademas tendrá un nodo tutorial: true
    * la primera vez que el usuario inicie sesion
    * el atributo cambia a false
    * */

    private lateinit var adapter: ProductoAdapter
    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var uid: String;
    private var contador: Int = 0;
    private lateinit var listener: OnMainListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        uid = arguments?.getString("uid")!!
        listener = context as OnMainListener
        listener.onMainSelected(uid)
        adapter = ProductoAdapter(context, uid, "producto")
        database = FirebaseDatabase
            .getInstance("https://proyectoret-bmh2023-default-rtdb.firebaseio.com/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerProductos.adapter = adapter;
        binding.recyclerProductos.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);


        database.getReference("productos")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        val producto: Producto = it.getValue(Producto::class.java)!!
                        adapter.addProducto(
                            producto
                        )

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
    }


    override fun onDetach() {
        super.onDetach()
    }

    interface OnMainListener{
        fun onMainSelected(x: String)
    }
}