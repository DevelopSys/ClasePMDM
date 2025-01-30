package com.example.iniciofg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofg.databinding.FragmentDosBinding
import com.example.iniciofg.databinding.FragmentUnoBinding

class FragmentDos: Fragment() {

    private lateinit var binding: FragmentDosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater,container,
            false)
        return binding.root
    }

}