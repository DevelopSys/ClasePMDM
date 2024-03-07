package com.example.t7_sqlite.ui.fragments

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.t7_sqlite.R
import com.example.t7_sqlite.database.DAOUsuarios
import com.example.t7_sqlite.database.DBHelper
import com.example.t7_sqlite.database.SchemeDB
import com.example.t7_sqlite.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){

    private lateinit var binding: FragmentLoginBinding
    private lateinit var daoUsuarios: DAOUsuarios

    override fun onAttach(context: Context) {
        super.onAttach(context)
        daoUsuarios = DAOUsuarios(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        binding.botonLogin.setOnClickListener {
            // CONSULTA EN LA BD
            daoUsuarios.consultarDatos()
        }
    }
}