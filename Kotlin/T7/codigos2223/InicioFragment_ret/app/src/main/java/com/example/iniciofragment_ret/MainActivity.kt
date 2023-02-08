package com.example.iniciofragment_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.iniciofragment_ret.databinding.ActivityMainBinding
import com.example.iniciofragment_ret.fragments.FragmentBanner
import com.example.iniciofragment_ret.fragments.FragmentDetalle
import com.example.iniciofragment_ret.fragments.FragmentNombre

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
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        when(p0!!.id){
            binding.botonF1.id ->{
                ft.replace(binding.sitioFragments.id, FragmentNombre())
                ft.commit()

            }
            binding.botonF2.id ->{
                ft.replace(binding.sitioFragments.id, FragmentDetalle())
                ft.commit()
            }
            binding.botonF3.id ->{}
        }
    }
}