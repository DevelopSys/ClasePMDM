package com.example.iniciofragment_ret.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragment_ret.databinding.FragmentNombreBinding

class FragmentNombre: Fragment() {


    private lateinit var binding: FragmentNombreBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNombreBinding.inflate(inflater,container,false)
        return binding.root
    }

}