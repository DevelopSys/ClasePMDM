package com.example.iniciofg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.iniciofg.R
import com.example.iniciofg.databinding.FragmentDosBinding
import com.example.iniciofg.databinding.FragmentRegistroBinding
import com.example.iniciofg.databinding.FragmenteLoginBinding
import com.example.iniciofg.dataset.DataSet
import com.example.iniciofg.model.Usuario

class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML -> inflater-> View
        binding = FragmentRegistroBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistro.setOnClickListener {

            val usuario =
                Usuario(binding.editNombre.text.toString(),
                    binding.editCorreo.text.toString(),
                    binding.editPass1.text.toString())
            DataSet.registrarUsuario(usuario)
            findNavController().navigate(R.id.action_registroFragment_to_registroDialog)
        }
    }
}