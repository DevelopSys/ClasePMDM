package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t5_navegacion.R
import com.example.t5_navegacion.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

    private lateinit var auth: FirebaseAuth;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonLogin.setOnClickListener {

            auth.signInWithEmailAndPassword(
                binding.editNombreLogin.text.toString(),
                binding.editPassLogin.text.toString()
            )
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val bundle = Bundle();
                        bundle.putString("nombre",binding.editNombreLogin.text.toString())
                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment,bundle)
                    } else {
                        Snackbar.make(binding.root, "Datos incorrectos", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }


        }

        binding.botonCrearLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_sigInFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}