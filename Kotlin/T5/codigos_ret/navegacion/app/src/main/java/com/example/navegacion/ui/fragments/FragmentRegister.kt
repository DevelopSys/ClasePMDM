package com.example.navegacion.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentRegisterBinding
import com.example.navegacion.dataset.DataSet

class FragmentRegister : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistrar.setOnClickListener {

            // si hay registro correcto -> DATASET
            val bundle = Bundle()
            bundle.putString("nombre", binding.editNombre.text.toString())
            findNavController().navigate(R.id.action_fragmentRegister_to_dialogoConfirmacion,bundle)
            // registro elemento

        }
    }

}