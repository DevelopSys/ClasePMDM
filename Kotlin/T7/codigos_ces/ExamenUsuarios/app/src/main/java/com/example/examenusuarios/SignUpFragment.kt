package com.example.examenusuarios

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examenusuarios.databinding.FragmentSigupBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SignUpFragment : Fragment() {

    private var _binding: FragmentSigupBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSigupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonLogin.setOnClickListener {

            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    //auth.currentUser.uid
                    val referencia: DatabaseReference =
                        database.getReference("usuarios").child(auth.currentUser!!.uid)
                    referencia.child("correo").setValue(binding.editCorreo.text.toString())
                    referencia.child("veces").setValue(0)
                    referencia.child("perfil").setValue(binding.spinnerPerfil.selectedItem.toString())
                    findNavController().navigate(R.id.action_sigupFragment_to_loginFragment)

                } else {
                    Snackbar.make(binding.root, "Registro incorrecto", Snackbar.LENGTH_SHORT).show()
                }
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}