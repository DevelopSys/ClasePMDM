package com.example.t5_fragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t5_fragments.MainActivity
import com.example.t5_fragments.databinding.FragmentListaBinding

class ListadoFragment: Fragment() {

    private lateinit var binding: FragmentListaBinding
    private lateinit var listener: OnListadoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnListadoListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonComunicar.setOnClickListener {

            listener.onListadoSelected()

        }
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnListadoListener{
        fun onListadoSelected()
    }

}