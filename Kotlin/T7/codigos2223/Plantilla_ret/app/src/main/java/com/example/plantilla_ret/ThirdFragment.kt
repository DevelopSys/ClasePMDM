package com.example.plantilla_ret

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.plantilla_ret.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {
    private lateinit var nombre: String;
    private var edad: Int? = null;
    private lateinit var correo: String;
    private lateinit var binding: FragmentThirdBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = arguments?.getString("nombre") ?: "defecto"
        correo = arguments?.getString("correo") ?: "defecto"
        edad = arguments?.getInt("edad") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        //binding.imagenDetalle.setImageResource(R.drawable.ejemplo)
        Glide.with(requireContext())
            .load("https://upload.wikimedia.org/wikipedia/commons/6/64/Ejemplo.png")
            .placeholder(R.drawable.load)
            .into(binding.imagenDetalle)

        binding.textoRecepcion.text = "${nombre} ${edad} ${correo}"
        binding.botonFragmentUno.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
        }
    }
}