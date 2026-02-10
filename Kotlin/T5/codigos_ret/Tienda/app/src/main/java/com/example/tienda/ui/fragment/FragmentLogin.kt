package com.example.tienda.ui.fragment


import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R

import com.example.tienda.databinding.FragmentLoginBinding
import com.example.tienda.dateset.DataSet
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FragmentLogin : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            // logica del login
            // findNavController().navigate(R.id.action_fragmentLogin_to_fragmentMain)
            /*
            if (DataSet.login(
                    binding.editCorreo.text.toString(), binding.editPass.text.toString()
                ) != null
            ) {
                findNavController().navigate(R.id.action_fragmentLogin_to_fragmentMain)
            } else {
                Snackbar
                    .make(binding.root, "Usuario no encontrado", Snackbar.LENGTH_SHORT)
                    .setAction("¿Registrarlo?") {
                        // bundle
                        val bundle = Bundle()
                        bundle.putString("correo", binding.editCorreo.text.toString())
                        bundle.putString("pass", binding.editPass.text.toString())
                        findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister,bundle)
                    }
                    .show()
            }
            */
            auth.signInWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if(it.isSuccessful){
                    val bundle = Bundle()
//                    bundle.putString("uid", auth.currentUser!!.uid)
                    findNavController().navigate(R.id.action_fragmentLogin_to_fragmentMain)
                } else {
                    Snackbar
                        .make(binding.root, "Usuario no encontrado", Snackbar.LENGTH_SHORT)
                        .setAction("¿Registrarlo?") {
                            // bundle
                            val bundle = Bundle()
                            bundle.putString("correo", binding.editCorreo.text.toString())
                            bundle.putString("pass", binding.editPass.text.toString())
                            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister,bundle)
                        }
                        .show()
                }
            }

        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }

    }

}