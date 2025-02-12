package com.example.iniciofg.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://compras-ec8a2-default-rtdb.europe-west1.firebasedatabase.app/")
    }

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

            /*val usuario =
                Usuario(
                    binding.editNombre.text.toString(),
                    binding.editCorreo.text.toString(),
                    binding.editPass1.text.toString()
                )*/

            // comprobaciones de campos
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass1.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    // Log.v("registro","usuario registrado con exito")
                    val usuario =
                        Usuario(
                            binding.editNombre.text.toString(),
                            binding.editCorreo.text.toString(),
                            binding.editPass1.text.toString()
                        )
                    val currenUser = auth.currentUser
                    val reference = database.reference.child("usuarios").child(currenUser!!.uid)
                    reference.setValue(usuario)
                    /*reference
                        .child("nombre").setValue(binding.editNombre.text.toString())
                    reference
                        .child("correo").setValue(binding.editCorreo.text.toString())
                    reference
                        .child("pass").setValue(binding.editPass1.text.toString())*/
                    findNavController().navigate(R.id.action_registroFragment_to_registroDialog)

                } else {
                    Snackbar.make(binding.root, "Hay algun fallo en auth", Snackbar.LENGTH_SHORT)
                        .show()
                    Log.v("registro", "fallo en el registrado del usuario")
                }
            }

            // DataSet.registrarUsuario(usuario)
            // findNavController().navigate(R.id.action_registroFragment_to_registroDialog)
        }
    }
}