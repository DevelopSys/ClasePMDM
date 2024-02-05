package com.example.usuarios

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.usuarios.data.Usuarios
import com.example.usuarios.databinding.FragmentMainBinding
import com.example.usuarios.model.Usuario


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var perfil: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.perfil = arguments?.getString("perfil") ?: ""
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (perfil.equals("administrador",true)){
            val lista: ArrayList<Usuario> = Usuarios.getUsuario();
        } else {
            val url: String = "https://"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}