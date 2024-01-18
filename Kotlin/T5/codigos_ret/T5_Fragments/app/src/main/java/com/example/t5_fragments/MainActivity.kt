package com.example.t5_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Menu
import android.view.MenuItem
import com.example.t5_fragments.databinding.ActivityMainBinding
import com.example.t5_fragments.ui.fragments.DetalleFragment
import com.example.t5_fragments.ui.fragments.ListadoFragment

class MainActivity : AppCompatActivity(), ListadoFragment.OnListadoListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        //val fm = supportFragmentManager
        //val ft = fm.beginTransaction()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.sitioFragments.id, ListadoFragment())
        ft.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when (item.itemId) {
            R.id.menu_detelle -> {
                ft.replace(binding.sitioFragments.id, DetalleFragment())
                ft.addToBackStack(null)
            }
            R.id.menu_listado -> {
                ft.replace(binding.sitioFragments.id, ListadoFragment())
                ft.addToBackStack(null)
            }
        }
        ft.commit()

        return true
    }

    override fun onListadoSelected() {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        ft.replace(binding.sitioFragments.id, DetalleFragment())
        ft.addToBackStack(null)
        ft.commit()
    }


}