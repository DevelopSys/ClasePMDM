package com.example.iniciofg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.iniciofg.R
import com.example.iniciofg.databinding.FragmentDosBinding
import com.example.iniciofg.databinding.FragmenteLoginBinding
import com.example.iniciofg.dataset.DataSet
import com.example.iniciofg.model.Usuario
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FragmenteLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML -> inflater-> View
        binding = FragmenteLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Glide.with(requireContext())
            .load("https://t3.ftcdn.net/jpg/09/58/18/64/360_F_958186432_84vwMW2cxRFvstnRaUEUDFhvgcYpqHoH.jpg")
            .into(binding.imagenLogin)

        binding.btnLogin.setOnClickListener {
            val bundle = Bundle()
            val usuario: Usuario? = DataSet.realizarLogin(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            )

            if (usuario != null) {
                bundle.putSerializable("usuario", usuario)
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment, bundle)
            } else {
                Snackbar.make(binding.root, "Fallo de credenciales", Snackbar.LENGTH_SHORT).show()
            }

        }

        binding.textoRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }
}