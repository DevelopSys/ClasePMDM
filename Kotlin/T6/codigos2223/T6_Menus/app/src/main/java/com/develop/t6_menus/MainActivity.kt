package com.develop.t6_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.t6_menus.adapter.AdaptadorAsignaturas
import com.develop.t6_menus.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AdaptadorAsignaturas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptador = AdaptadorAsignaturas(ArrayList<String>(),this)

        binding.recyclerAsignaturas.adapter = adaptador;
        binding.recyclerAsignaturas.layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recycler, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {



        when (item.itemId) {
            R.id.menu_add -> {
                // agregar algo al recycler --> adaptador
                adaptador.addAsignatura("Prueba")
            }
            R.id.menu_clear -> {
                adaptador.clearAsignaturas()
            }
        }




        return true
    }


}