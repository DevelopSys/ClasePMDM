package com.example.plantilla_ret

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.plantilla_ret.databinding.FragmentThirdBinding

class ThirdFragment: Fragment() {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentThirdBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonFragmentUno.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
        }
    }
}