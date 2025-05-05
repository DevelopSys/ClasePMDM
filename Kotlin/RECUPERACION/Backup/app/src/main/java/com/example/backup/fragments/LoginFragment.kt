package com.example.recuperacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recuperacion.R
import com.example.recuperacion.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonRegistro.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    // cuenta creada ok
                } else {
                    // cuenta creada no ok
                }
            }
        }
        binding.botonIniciar.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    // login y navego a otro fragment
                    val bundle: Bundle = Bundle()
                    bundle.putString("usuario", binding.editCorreo.text.toString());
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment, bundle)
                } else {
                    // aviso del fallo
                }
            }
            /*if (binding.editPass.text.toString().equals("1234") && binding.editCorreo.text.toString().equals("borja@gmail.com")){
                val bundle: Bundle = Bundle()
                bundle.putString("usuario", binding.editCorreo.text.toString());
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment, bundle)
            } else {
                Snackbar.make(binding.root, "Fallo de inicio", Snackbar.LENGTH_SHORT).show()
            }*/
        }
    }

}