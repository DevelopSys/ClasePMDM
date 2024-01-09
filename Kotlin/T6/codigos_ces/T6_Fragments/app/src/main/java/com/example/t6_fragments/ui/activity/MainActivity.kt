package com.example.t6_fragments.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.t6_fragments.R
import com.example.t6_fragments.databinding.ActivityMainBinding
import com.example.t6_fragments.ui.fragments.FragmentDos
import com.example.t6_fragments.ui.fragments.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener, FragmentUno.OnFragmentUnoListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)

        //binding.sitioFragments
        // supportFragmentManager-> gestion de fragments
        // supportFragmentManager-> fragmentTransaction

        var ft = supportFragmentManager.beginTransaction();
        // replace
        ft.replace(binding.sitioFragments.id,FragmentUno(),"f1")
        ft.addToBackStack("f1")
        ft.commit()

        ft = supportFragmentManager.beginTransaction();
        //ft.setCustomAnimations(android.R.)
        ft.replace(binding.sitioFragments.id,FragmentUno(),"f11")
        ft.addToBackStack("f11")
        ft.commit()

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonF1.id->{
                var ft = supportFragmentManager.beginTransaction();
                // replace
                ft.replace(binding.sitioFragments.id,FragmentUno(),"f1")
                ft.addToBackStack("f1")
                ft.commit()
            }
            binding.botonF2.id->{
                var ft = supportFragmentManager.beginTransaction();
                //ft.setCustomAnimations(android.R.)
                ft.replace(binding.sitioFragments.id,FragmentDos(),"f11")
                ft.addToBackStack("f11")
                ft.commit()
            }
        }
    }

    override fun onNombreSelected(nombre: String) {
        var ft = supportFragmentManager.beginTransaction();
        //ft.setCustomAnimations(android.R.)
        ft.replace(binding.sitioFragments.id,FragmentDos.newInstance(nombre),"f11")
        ft.addToBackStack("f11")
        ft.commit()
    }


}