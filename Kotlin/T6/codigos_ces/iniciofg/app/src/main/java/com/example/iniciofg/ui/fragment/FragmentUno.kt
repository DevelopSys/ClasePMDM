package com.example.iniciofg.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.iniciofg.R
import com.example.iniciofg.databinding.FragmentUnoBinding

class FragmentUno: Fragment() {

    private lateinit var binding: FragmentUnoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(inflater,container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnFragment1.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentUno_to_fragmentDos)
        }

    }

}