package com.develop.t6_menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.develop.t6_menus.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var texto: String = ""

        when (item.itemId) {
            R.id.menu_op1 -> {
                texto = "Elemento 1"
            }
            R.id.menu_op2 -> {
                texto = "Elemento 2"
            }
            R.id.menu_op1_1 -> {
                texto = "Elemento 1_1"
            }
            R.id.menu_op1_2 -> {
                texto = "Elemento 1_2"
            }
            else ->{
                texto = "Elemento no identificado"
            }
        }

        Snackbar.make(binding.root,texto,Snackbar.LENGTH_SHORT).show()


        return true
    }


}