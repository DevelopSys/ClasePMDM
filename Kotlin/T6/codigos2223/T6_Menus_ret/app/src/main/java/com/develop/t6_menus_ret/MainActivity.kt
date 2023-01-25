package com.develop.t6_menus_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.t6_menus_ret.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var menuOP1: MenuItem;
    private lateinit var adaptadorAsignaturas: AdaptadorAsignaturas;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptadorAsignaturas = AdaptadorAsignaturas(ArrayList(),this)
        binding.recyclerAsignaturas.adapter = adaptadorAsignaturas

        binding.recyclerAsignaturas.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        // binding.recyclerAsignaturas
        // adaptador
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_asignaturas,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

           R.id.menu_agregar->{
               adaptadorAsignaturas.agregarDato("prueba")
           }
           R.id.menu_vaciar->{
               adaptadorAsignaturas.vaciarLista()
           }
        }

        // Crear un menu con 7 opciones
        // cada pulscion muestra un Snackbar con el siguiente texto
        // Pulsado elemento {1-5}
        // Pulsado elemento desconocido {100}

        return true
    }


}