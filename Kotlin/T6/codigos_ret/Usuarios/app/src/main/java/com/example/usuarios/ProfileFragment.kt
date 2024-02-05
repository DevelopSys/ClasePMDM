package com.example.usuarios

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.usuarios.databinding.FragmentProfileBinding
import com.example.usuarios.model.Usuario


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var usuario: Usuario;
    private lateinit var contexto: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        usuario = (arguments?.getSerializable("usuario") ?: Usuario()) as Usuario
        this.contexto = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textoNombre.text = usuario.correo
        val perfil = usuario.perfil;
        var url: String = ""
        if (perfil.equals("administrador", true)) {
            url = ""
        } else {
            if (usuario.genero.equals("masculino", true)) {
                url = ""
            } else if (usuario.genero.equals("femenino", true)) {
                url = ""
            }
        }
        Glide.with(contexto).load(url).into(binding.imageView2)

        binding.botonDatos.setOnClickListener {
            val bundle: Bundle = Bundle()
            bundle.putString("perfil", usuario.perfil)
            findNavController().navigate(R.id.action_profileFragment_to_mainFragment, bundle)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}