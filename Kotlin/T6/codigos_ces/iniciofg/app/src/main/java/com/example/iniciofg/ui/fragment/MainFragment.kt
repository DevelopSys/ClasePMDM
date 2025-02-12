package com.example.iniciofg.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.iniciofg.R
import com.example.iniciofg.databinding.FragmentDosBinding
import com.example.iniciofg.databinding.FragmentMainBinding
import com.example.iniciofg.databinding.FragmenteLoginBinding
import com.example.iniciofg.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var usuario: Usuario
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onAttach(context: Context) {
        super.onAttach(context)
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://compras-ec8a2-default-rtdb.europe-west1.firebasedatabase.app/")
        // usuario = arguments?.getSerializable("usuario") as Usuario
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML -> inflater-> View
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()


        binding.btnLeer.setOnClickListener { }
        binding.btnEscribir.setOnClickListener {
            Log.v("datos", "Pulsacion detectada")
            firebaseDatabase.reference.child("datos")
                .child("version_app").setValue("compras_app")
        }


    }
}