package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.t5_navegacion.R
import com.example.t5_navegacion.databinding.FragmentLoginBinding
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.databinding.FragmentSignupBinding

class FragmentSignUp : Fragment() {

    private lateinit var binding: FragmentSignupBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonCrear.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("correo",binding.editCorreo.text.toString())
            bundle.putString("pass",binding.editPass.text.toString())
            findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentLogin,bundle)}
    }

    override fun onDetach() {
        super.onDetach()
    }
}