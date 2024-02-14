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
import com.example.t5_navegacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

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

    private lateinit var auth: FirebaseAuth;
    private lateinit var binding: FragmentLoginBinding
    private var correo: String? = null
    private var pass: String? = null
    private var uid: String? = null
    private lateinit var listaUsuarios: ArrayList<Usuario>;


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("asd", "asd"))
        this.correo = this.arguments?.getString("correo")
        this.pass = this.arguments?.getString("pass")
        this.uid = this.arguments?.getString("uid")
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

        if (correo != null && pass != null) {
            binding.editUsuario.setText(this.correo)
            binding.editPass.setText(this.pass)
        }

        binding.botonLogin.setOnClickListener {
            // editUsuario.text && editPass.text
            if (!binding.editUsuario.text.toString().isEmpty() && !binding.editPass.text.toString()
                    .isEmpty()
            ) {
                auth.signInWithEmailAndPassword(binding.editUsuario.text.toString(),binding.editPass.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val bundle = Bundle();
                        bundle.putString("uid", auth.currentUser!!.uid)
                        findNavController().navigate(
                            R.id.action_fragmentLogin_to_fragmentMain,bundle
                        )
                    } else {
                        Snackbar.make(binding.root, "Fallo de credenciales", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
                /*if (listaUsuarios.find {
                            it.correo == binding.editUsuario.text.toString()
                                    && it.pass == binding.editPass.text.toString()
                        } != null) {
                        findNavController().navigate(R.id.action_fragmentLogin_to_fragmentMain)
                    } else {
                        Snackbar.make(binding.root, "Datos incorrectos",Snackbar.LENGTH_SHORT).show()
                    }*/
            } else {
                Snackbar.make(binding.root, "Por favor introduce datos", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
        binding.botonCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentLogin_to_fragmentSignUp)
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}