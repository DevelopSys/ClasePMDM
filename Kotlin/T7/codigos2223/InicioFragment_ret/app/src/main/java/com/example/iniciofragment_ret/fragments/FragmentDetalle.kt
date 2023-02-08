package com.example.iniciofragment_ret.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragment_ret.databinding.FragmentDetalleBinding
import com.example.iniciofragment_ret.databinding.FragmentNombreBinding

class FragmentDetalle: Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater,container,false)
        return binding.root
    }

}