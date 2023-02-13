package com.example.iniciofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.iniciofragments.adapters.AdaptadorUsuarios
import com.example.iniciofragments.databinding.FragmentTresBinding
import com.example.iniciofragments.model.Usuario

class FragmentTres: Fragment() {

    private lateinit var binding: FragmentTresBinding
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // inicio cosas sin dependencia gráfica
        val arrayUsuarios = ArrayList<Usuario>()
        // rellenar el arraylist
        adaptadorUsuarios = AdaptadorUsuarios(arrayUsuarios,requireContext())
        binding.recyclerUsuarios
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTresBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.recyclerUsuarios.adapter = adaptadorUsuarios
        // linear (V - H)
        // grid (V - H, column)
        // staggered (V - H, column)
        // binding.recyclerUsuarios.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recyclerUsuarios.layoutManager = GridLayoutManager(requireContext(),2,LinearLayoutManager.VERTICAL,false)
        binding.recyclerUsuarios.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)

    }



}