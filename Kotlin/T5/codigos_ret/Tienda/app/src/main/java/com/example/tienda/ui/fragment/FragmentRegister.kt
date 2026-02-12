package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentLoginBinding
import com.example.tienda.databinding.FragmentRegisterBinding
import com.example.tienda.dateset.DataSet
import com.example.tienda.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FragmentRegister : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var adapterEdad: ArrayAdapter<Int>
    private var correo: String? = null;
    private var pass: String? = null;
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        // utilizo para inicializacion logica
        super.onAttach(context)
        database =
            FirebaseDatabase.getInstance("https://bmh2526-ret-default-rtdb.europe-west1.firebasedatabase.app/")
        auth = FirebaseAuth.getInstance()
        val lista: ArrayList<Int> = ArrayList()
        for (i in 16..90) {
            lista.add(i)
        }
        correo = this.arguments?.getString("correo")
        pass = this.arguments?.getString("pass")
        adapterEdad = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item,
            lista
        )
        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        // poner los datos recuperados en los input
        binding.editCorreo.setText(correo)
        binding.editPass.setText(pass)
        // logica del registro
        binding.spinnerEdad.adapter = adapterEdad
        binding.btnRegister.setOnClickListener {
            // llamar a la funcion del registro
            /*
            if (DataSet.agregarUsuario(
                    User(
                        binding.editNombre.text.toString(),
                        binding.editApellido.text.toString(),
                        binding.spinnerEdad.selectedItem.toString().toInt(),
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString()
                    )
                )
            ) {
                findNavController().navigate(R.id.action_fragmentRegister_to_dialogRegisterOK)
            } else {
                findNavController().navigate(R.id.action_fragmentRegister_to_dialogRegisterFAIL)
            }

             */
            // validar que los campos estar ok
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    database.reference
                        .child("usuarios")
                        .child(auth.currentUser!!.uid)
                        .setValue(
                            User(
                                binding.editNombre.text.toString(),
                                binding.editApellido.text.toString(),
                                binding.spinnerEdad.selectedItem.toString().toInt(),
                                binding.editCorreo.text.toString()
                            )
                        )

                    findNavController().navigate(R.id.action_fragmentRegister_to_dialogRegisterOK)
                } else {
                    findNavController().navigate(R.id.action_fragmentRegister_to_dialogRegisterFAIL)
                }
            }


        }
    }

}