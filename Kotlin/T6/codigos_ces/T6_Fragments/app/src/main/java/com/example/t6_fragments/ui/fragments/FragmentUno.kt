package com.example.t6_fragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t6_fragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class FragmentUno : Fragment() {

    private lateinit var contexto: Context
    private lateinit var binding: FragmentUnoBinding
    private lateinit var listener: OnFragmentUnoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
        this.listener = context as OnFragmentUnoListener
        // iniciar las interfaces de callback
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.botonComunicar.setOnClickListener {
            listener.onNombreSelected(binding.editNombre.text.toString())
            //binding.editNombre.text.clear()
        //Snackbar.make(binding.root, binding.editNombre.text.toString(), Snackbar.LENGTH_SHORT)
            //    .show()
        }

    }

    interface OnFragmentUnoListener{
        fun onNombreSelected(nombre: String)
    }

    override fun onDetach() {
        super.onDetach()
        // eliminar cualquier dependencia
    }

}