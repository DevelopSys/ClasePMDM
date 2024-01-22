package com.example.t5_navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t5_navegacion.databinding.FragmentSiginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SigInFragment : Fragment() {

    private var _binding: FragmentSiginBinding? = null
    private lateinit var auth: FirebaseAuth;
    private lateinit var databese: FirebaseDatabase


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        databese =
            FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSiginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonSignIn.setOnClickListener {

            if (binding.editPassSigin.text.toString()
                    .equals(binding.editPass2Sigin.text.toString())
            ) {
                auth.createUserWithEmailAndPassword(
                    binding.editCorreoSigin.text.toString(),
                    binding.editPassSigin.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Snackbar.make(
                                binding.root,
                                "Cuenta creada con exito",
                                Snackbar.LENGTH_SHORT
                            ).show()

                            val referencia =
                                databese.getReference("usuarios").child(auth.currentUser!!.uid)
                            referencia.child("nombre").setValue(binding.editNombreSigin.text.toString())
                            referencia.child("apellido").setValue(binding.editApellidoSigin.text.toString())
                            referencia.child("correo").setValue(binding.editCorreoSigin.text.toString())
                            referencia.child("direccion").setValue(binding.editDireccionSigin.text.toString())
                        } else {
                            Snackbar.make(
                                binding.root,
                                "Fallo en la creacion del usuario",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }
            }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}