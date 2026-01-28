package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.data.DataSet
import com.example.tienda.databinding.FramentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FramentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FramentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener {
            if (DataSet.loginUser(
                    binding.editCorreoLogin.text.toString(),
                    binding.editPassLogin.text.toString()
                )
            ) {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            } else {
                Snackbar
                    .make(binding.root, "Usuario no encontrado", Snackbar.LENGTH_SHORT)
                    .setAction("Quieres registrarlo",
                        { findNavController().navigate(R.id.action_loginFragment_to_registerFragment) })
                    .show()
            }
        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

}