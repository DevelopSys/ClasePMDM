package com.example.iniciofragment_ret.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.iniciofragment_ret.R
import com.example.iniciofragment_ret.databinding.FragmentBannerBinding

class FragmentBanner: Fragment() {


    // al pulsar el boton salga un cuadro de dialogo de conformacion donde ponga:

    // Primera app de fragemnets realizada por XXXXXXX

    private lateinit var binding: FragmentBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBannerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonEstatico.setOnClickListener {
            // lanzo el dialogo
            lanzarDialogoAyuda().show()
        }
    }

    fun lanzarDialogoAyuda(): AlertDialog{
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Dialogo de ayuda")
        builder.setMessage("Primera app de fragments realizada por Borja")
        return builder.create()
    }

}