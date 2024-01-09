package com.example.t6_fragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t6_fragments.databinding.FragmentDosBinding

class FragmentDos: Fragment() {

    private lateinit var context: Context
    private lateinit var binding: FragmentDosBinding
    private lateinit var nombreRecuperado: String;

    companion object{
        fun newInstance(nombre: String): FragmentDos {
            val fragmentDos: FragmentDos = FragmentDos()
            val bundle: Bundle = Bundle()
            bundle.putString("nombre",nombre)
            fragmentDos.arguments = bundle
            return fragmentDos;
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
         nombreRecuperado = arguments?.getString("nombre") ?: "sin nombre"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textoNombre.text = nombreRecuperado
    }

    override fun onDetach() {
        super.onDetach()
    }
}