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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class FragmentSignUp : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
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

            /*Al crear la cuenta (con todos los datos del formulario)
            *   si hay alguno no completo, o las pass no coinciden -> Snackbar
            *   si hay fallo en la creacion -> Snackbar
            *   si hay exito.
            *       Snackbar, quires iniciar sesion?
            *           ok ->navega a la pantalla de login pasando los datos
            *               y poniendolos en los edit correspondientes
            * */

            auth.createUserWithEmailAndPassword("bmartin@gmail.com", "Retamar1a")
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Snackbar.make(
                            binding.root,
                            "Usuario creado con exito",
                            Snackbar.LENGTH_SHORT
                        ).show()

                    } else {
                        Snackbar.make(
                            binding.root,
                            "Fallo en la creacion",
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }


            /*    val bundle = Bundle()
                bundle.putString("correo",binding.editCorreo.text.toString())
                bundle.putString("pass",binding.editPass.text.toString())
                findNavController().navigate(R.id.action_fragmentSignUp_to_fragmentLogin,bundle)*/
        }
    }

    override fun onDetach() {
        super.onDetach()
    }
}