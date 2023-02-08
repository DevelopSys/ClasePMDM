package com.example.iniciofragment_ret.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragment_ret.databinding.FragmentNombreBinding
import com.google.android.material.snackbar.Snackbar

class FragmentNombre: Fragment() {


    private lateinit var binding: FragmentNombreBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNombreBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.botonNombre.setOnClickListener {
            // it --> boton
            if (binding.editNombre.text.isEmpty()){
                Snackbar.make(binding.root, "Nombre vacio",Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, binding.editNombre.text.toString(),Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}