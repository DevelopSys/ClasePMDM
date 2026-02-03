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

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var user: User

    override fun onAttach(context: Context) {
        super.onAttach(context)
        user = this.arguments?.getSerializable("user") as User
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
        binding.textNombreMain.text = user.nombre
    }

}