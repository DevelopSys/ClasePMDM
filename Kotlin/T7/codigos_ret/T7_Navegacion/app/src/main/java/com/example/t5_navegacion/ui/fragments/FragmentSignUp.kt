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
import com.google.firebase.database.FirebaseDatabase

class FragmentSignUp : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var datasabe: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        datasabe =
            FirebaseDatabase.getInstance("https://proyectoret-bmh2023-default-rtdb.firebaseio.com/")
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

            val condicion =
                binding.editPass2.text.isEmpty() ||
                        binding.editPass.text.isEmpty() ||
                        binding.editCorreo.text.isEmpty() ||
                        binding.editDireccion.text.isEmpty() ||
                        binding.editNombre.text.isEmpty() ||
                        binding.editTelefono.text.isEmpty()
            if (condicion) {
                Snackbar.make(
                    binding.root,
                    "Faltan datos",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                if (binding.editPass.text.toString().equals(binding.editPass2.text.toString())) {
                    auth.createUserWithEmailAndPassword(
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString()
                    )
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val referencia =
                                    datasabe.getReference("usuarios").child(auth.currentUser!!.uid)
                                referencia.child("conocimientos").child("cosa")
                                referencia.child("nombre")
                                    .setValue(binding.editNombre.text.toString())
                                referencia.child("direccion")
                                    .setValue(binding.editDireccion.text.toString())
                                referencia.child("perfil")
                                    .setValue(binding.spinnerPerfil.selectedItem.toString())
                                referencia.child("telefono")
                                    .setValue(binding.editTelefono.text.toString().toInt())
                                referencia.child("correo")
                                    .setValue(binding.editCorreo.text.toString())
                                referencia.child("tutorial").setValue(true)


                                Snackbar.make(
                                    binding.root,
                                    "Usuario creado con exito",
                                    Snackbar.LENGTH_SHORT
                                ).setAction("¿Quieres iniciar sesion?") {

                                    val bundle = Bundle();
                                    bundle.putString("correo", binding.editCorreo.text.toString())
                                    bundle.putString("pass", binding.editPass.text.toString())
                                    bundle.putString("uid", auth.currentUser!!.uid)
                                    findNavController().navigate(
                                        R.id.action_fragmentSignUp_to_fragmentLogin,
                                        bundle
                                    )
                                }
                                    .show()

                                /*limpiar los edit*/

                            } else {
                                Snackbar.make(
                                    binding.root,
                                    "Fallo en la creacion",
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        }
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