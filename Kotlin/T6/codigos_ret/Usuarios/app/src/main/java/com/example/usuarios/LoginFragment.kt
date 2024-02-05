package com.example.usuarios

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.usuarios.data.Usuarios

import com.example.usuarios.databinding.FragmentLoginBinding
import com.example.usuarios.model.Usuario
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonLogin.setOnClickListener {
            val correo = binding.editNombre.text.toString()
            val pass = binding.editPass.text.toString()

            val usuario: Usuario = Usuarios.getUsuario().find {
                it.correo == correo && it.pass == pass
            } as Usuario

            if (usuario!=null){
                val bundle: Bundle = Bundle();
                bundle.putSerializable("usuario",usuario)
                findNavController().navigate(R.id.action_loginFragment_to_profileFragment, bundle)
            } else {
                Snackbar.make(binding.root, "No esta en la lista",Snackbar.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}