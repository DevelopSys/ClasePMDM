package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.dataset.DataSet
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FragmentLogin : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private var currentFBUser: FirebaseUser? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Glide.with(requireContext())
            .load("https://t4.ftcdn.net/jpg/01/19/11/55/360_F_119115529_mEnw3lGpLdlDkfLgRcVSbFRuVl6sMDty.jpg")
            .into(binding.imagenLogin)


        binding.bntIniciar.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    // Snackbar.make(binding.root,"Inicio correcto",Snackbar.LENGTH_SHORT).show()
                    currentFBUser = auth.currentUser
                    Log.v("usuario", currentFBUser?.uid ?:"no hay nadie en login")
                    findNavController().navigate(R.id.action_fragmentLogin_to_dialogoAviso)
                } else {
                    Snackbar.make(binding.root,"Inicio incorrecto",Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        binding.textoRegistro.setOnClickListener {

            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(binding.root, "Creado con exito", Snackbar.LENGTH_SHORT)
                            .show()
                    } else {
                        Snackbar.make(binding.root, "Fallo en la creacion", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
            // navegar al fragment registro
            /*if (DataSet.realizarLogin("2323", "2323") != null) {
                    findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister)
                } else {
                    findNavController().navigate(R.id.action_fragmentLogin_to_dialogoAviso)
                }*/
        }

    }
}