package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.graphics.ColorSpace.Adaptation
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5_navegacion.adapters.ProductoAdapter
import com.example.t5_navegacion.databinding.FavFsragmentBinding
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FragmentFavs : Fragment() {

    private lateinit var binding: FavFsragmentBinding
    private lateinit var uid: String
    private lateinit var adapter: ProductoAdapter
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database =
            FirebaseDatabase.getInstance("https://proyectoret-bmh2023-default-rtdb.firebaseio.com/")
        this.uid = this.arguments?.getString("uid") ?: ""
        adapter = ProductoAdapter(context, uid)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FavFsragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerFavs.adapter = adapter;
        binding.recyclerFavs.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        database.getReference("usuarios").child(uid).child("favoritos")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        val producto: Producto = it.getValue(Producto::class.java) as Producto
                        adapter.addProducto(producto)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })


    }

}