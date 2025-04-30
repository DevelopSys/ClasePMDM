package com.example.recuperacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recuperacion.databinding.FragmentLoginBinding
import com.example.recuperacion.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private var correoRecuperado: String?=null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        correoRecuperado = arguments?.getString("correo")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // poner en el campo central el correo que me han pasado
        binding.textoUsuario.setText(binding.textoUsuario.text.toString()+ { correoRecuperado.toString() });
    }

}