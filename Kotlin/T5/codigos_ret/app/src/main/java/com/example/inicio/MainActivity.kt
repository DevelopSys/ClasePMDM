package com.example.inicio

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.inicio.databinding.ActivityMainBinding
import com.example.inicio.ui.fragment.FragmentDos
import com.example.inicio.ui.fragment.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.btnF1.setOnClickListener(this)
        binding.btnF2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.btnF1.id -> {
                // poner en el sitioFragments F1
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                ft.replace(binding.sitioFragments.id,
                    FragmentUno(), "f1")
                ft.commit()
                ft.addToBackStack(null)
            }

            binding.btnF2.id -> {
                // poner en el sitioFragments F2
                fm = supportFragmentManager
                ft = fm.beginTransaction()
                ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                ft.replace(binding.sitioFragments.id, FragmentDos(),"f2")
                ft.commit();
                ft.addToBackStack(null)

            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_info->{
                Log.v("pila",supportFragmentManager.backStackEntryCount.toString())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

}