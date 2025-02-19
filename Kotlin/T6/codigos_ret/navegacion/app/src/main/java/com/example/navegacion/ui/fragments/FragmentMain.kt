package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navegacion.databinding.FragmentMainBinding
import com.google.firebase.database.FirebaseDatabase

class FragmentMain : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://comprasret-dae09-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnEscribir.setOnClickListener {
            database.reference.child("usuarios").child("nombre").setValue("Borja")
        }
        binding.btnLeer.setOnClickListener {  }
    }
}