package com.example.iniciofragment_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.iniciofragment_ret.databinding.ActivityMainBinding
import com.example.iniciofragment_ret.fragments.FragmentBanner

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)
        binding.botonF3.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonF1.id ->{
                val fm = supportFragmentManager
                val ft = fm.beginTransaction();

                ft.replace(binding.sitioFragments.id,FragmentBanner())
                ft.addToBackStack("")
                ft.commit()

            }
            binding.botonF2.id ->{

            }
            binding.botonF3.id ->{}
        }
    }
}