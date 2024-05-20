package com.example.navegacion

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.databinding.FragmentDosBinding
import com.example.navegacion.databinding.FragmentUnoBinding

class FragmentDos : Fragment() {

    private lateinit var binding: FragmentDosBinding
    private var nombre: String? = null;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = arguments?.getString("nombre")
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonF2.setOnClickListener {
           findNavController().navigate(R.id.action_fragmentDos_to_fragmentUno)
        }
    }

}