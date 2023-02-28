package com.example.proyectologin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.proyectologin.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth ;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        auth = Firebase.auth;
        // auth = FirebaseAuth.getInstance();
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext()).
        load("https://ps.w.org/login-customizer/assets/icon-256x256.png?rev=2455454")
            .placeholder(R.drawable.log_back)
            .into(binding.imagenLogin)

        binding.botonLogin.setOnClickListener {
            // auth.createUserWithEmailAndPassword()

            if (!binding.editNombre.text.isEmpty() && !binding.editPass.text.isEmpty()){
                auth.signInWithEmailAndPassword(binding.editNombre.text.toString(),binding.editPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            val bundle =Bundle()
                            bundle.putString("nombre",binding.editNombre.text.toString())
                            bundle.putString("uid",auth.currentUser!!.uid)
                            findNavController().navigate(R.id.action_LoginFragment_to_secondActivity,bundle)
                        }else {
                            Snackbar.make(binding.root, "Alguno de los datos es incorrecto", Snackbar.LENGTH_SHORT).show()

                        }
                    }
            }
            else {
                Snackbar.make(binding.root, "Alguno de los datos es incorrecto o está vacío", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.botonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}