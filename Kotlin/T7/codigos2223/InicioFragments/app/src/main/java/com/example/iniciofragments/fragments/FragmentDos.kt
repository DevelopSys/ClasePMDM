package com.example.iniciofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragments.databinding.FragmentDosBinding
import com.example.iniciofragments.databinding.FragmentHeaderBinding
import com.example.iniciofragments.databinding.FragmentUnoBinding

class FragmentDos: Fragment() {

    private lateinit var binding: FragmentDosBinding
    private lateinit var nombre: String

    // TODO 1. Creo el objeto que permite el paso de parametros
    companion object{
        fun newInstance(nombre: String): FragmentDos {

            val fragmentDos = FragmentDos()
            // TODO 2. Creo un bundle para poder argumentos
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            fragmentDos.arguments = bundle
            return fragmentDos
        }
    }

    // TODO 3. Recuperar argumentos
    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = this.arguments?.getString("nombre") ?: "defecto"
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textoNombreF2.setText(nombre)
    }
}