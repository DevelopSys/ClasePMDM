package com.example.iniciofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragments.R
import com.example.iniciofragments.databinding.FragmentHeaderBinding
import com.example.iniciofragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class FragmentUno: Fragment() {

    private lateinit var binding: FragmentUnoBinding
    // TODO 2. creo un objeto de la interfaz
    private lateinit var listener: OnFragmentNombreListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // TODO 3. inicio el objeto de la interfaz, pasada a la interfaz
        listener = context as OnFragmentNombreListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.botonNombreF1.setOnClickListener {
            //it -> el elemento que provoca el evento boton
            if (binding.editNombreF1.text.isEmpty()){
                Snackbar.make(binding.root, "No hay nombre a mostrar",Snackbar.LENGTH_SHORT).show()
            } else {
                // pasar la informacion a la activity!
                // Snackbar.make(binding.root, binding.editNombreF1.text.toString(),Snackbar.LENGTH_SHORT).show()
                listener.onNombreSelected(binding.editNombreF1.text.toString())
            }
        }
    }

    //TODO 1. interfaz en el origen
    interface OnFragmentNombreListener{
        fun onNombreSelected(nombre: String)
    }

}