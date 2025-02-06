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
import com.google.firebase.auth.FirebaseAuth

class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
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
        // XML -> inflater-> View
        binding = FragmentRegistroBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistro.setOnClickListener {

            val usuario =
                Usuario(
                    binding.editNombre.text.toString(),
                    binding.editCorreo.text.toString(),
                    binding.editPass1.text.toString()
                )


            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass1.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    Log.v("registro","usuario registrado con exito")
                    Log.v("registro",auth.currentUser!!.uid)
                } else {
                    Log.v("registro","fallo en el registrado del usuario")
                }
            }

            // DataSet.registrarUsuario(usuario)
            // findNavController().navigate(R.id.action_registroFragment_to_registroDialog)
        }
    }
}