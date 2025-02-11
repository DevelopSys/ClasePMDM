package com.example.iniciofg.ui.fragment

import android.content.Context
import android.os.Bundle
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

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var usuario:Usuario

    override fun onAttach(context: Context) {
        super.onAttach(context)
        usuario = arguments?.getSerializable("usuario") as Usuario
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML -> inflater-> View
        binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textoLogin.text = "Enhorabuena ${usuario.nombre}"

    }
}