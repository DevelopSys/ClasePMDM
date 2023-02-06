package com.example.iniciofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.iniciofragments.databinding.ActivityMainBinding
import com.example.iniciofragments.fragments.FragmentDos
import com.example.iniciofragments.fragments.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonF1.setOnClickListener( this)
        binding.botonF2.setOnClickListener( this)



    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           binding.botonF1.id ->{
               val fm = supportFragmentManager;
               val ft = fm.beginTransaction();
               ft.replace(binding.sitioFragments.id,FragmentUno())
               ft.commit()
           }
           binding.botonF2.id ->{
               val fm = supportFragmentManager;
               val ft = fm.beginTransaction();
               ft.replace(binding.sitioFragments.id,FragmentDos())
               ft.commit()
           }
       }
    }
}