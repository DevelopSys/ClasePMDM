package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tienda.databinding.FragmentMainBinding
import com.example.tienda.databinding.FragmentRegistroBinding
import com.example.tienda.databinding.FramentLoginBinding
import com.example.tienda.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var uid: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser!!.uid
        database =
            FirebaseDatabase.getInstance("https://bmhces2526-default-rtdb.europe-west1.firebasedatabase.app/")
        database.reference.child("usuarioLogeado").setValue(auth.currentUser!!.uid)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.textNombreMain.text = uid
        binding.guardarDatos.setOnClickListener {
            val referencia = database.reference.child("nombreAPP")
            referencia.setValue("App Firebase")
        }

        binding.elimiarDatos.setOnClickListener {
            val referencia = database.reference.child("nombreAPP")
            referencia.setValue(null)
        }
    }

}