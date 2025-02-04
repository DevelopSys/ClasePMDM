package com.example.navegacion.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.dataset.DataSet

class FragmentLogin : Fragment() {

    private lateinit var binding: FragmentLoginBinding

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
        binding.textoRegistro.setOnClickListener {
            // navegar al fragment registro
            if (DataSet.realizarLogin("2323", "2323") != null) {
                findNavController().navigate(R.id.action_fragmentLogin_to_fragmentRegister)
            } else {
                findNavController().navigate(R.id.action_fragmentLogin_to_dialogoAviso)
            }
        }

    }
}