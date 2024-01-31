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

class FragmentLogin : Fragment() {

    // para crear una cuenta es necesario tener todos los datos
    // es necesario que la pass y pass2 sean iguales
    // es necesario que el correo tenga 1 y solo 1@
    // en caso de fallo en el proceso, salta un snackbar
    // en caso de exito, salta un snackbar preguntado si quiero hacer login
        // si, comunica mis datos al login
        // no, no comunica mis dato al login

    // no hay usuarios-> al crear una cuenta
    // al crear una cuenta meter en un array de usuarios
    // la cuenta con los datos introducidos

    // hacer el login
    // algun usuario que esta en la lista, coincide
    // con correo y pass con lo que pone en los edit???

    private lateinit var binding: FragmentLoginBinding
    private  var correo: String? = null
    private  var pass: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.correo = this.arguments?.getString("correo")
        this.pass = this.arguments?.getString("pass")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       if (correo!=null && pass !=null){
           binding.editUsuario.setText(this.correo)
           binding.editPass.setText(this.pass)
       }

        binding.botonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentMain)
        }
        binding.botonCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentSignUp)
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}