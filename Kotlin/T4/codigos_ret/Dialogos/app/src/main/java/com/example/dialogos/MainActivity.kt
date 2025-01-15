package com.example.dialogos

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.ui.dialog.ConfirmDialog
import com.example.dialogos.ui.dialog.InfoDialog
import com.example.dialogos.ui.dialog.ListDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),
    ConfirmDialog.OnDialogoConfirmacionListener, ListDialog.OnListaMultipleListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "Cambio"
        // supportActionBar?.title  = "Aplicacion de trivial"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_dialogo -> {
                // val dialogo = InfoDialog()
                //val dialogo = ConfirmDialog()
                val dialogo = ListDialog()
                dialogo.show(supportFragmentManager, null)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onConfirmacionSelected(resultado: String) {
        // binding.textoRespuesta.text = resultado
        if (resultado == "OK") {
            val dialogo = InfoDialog()
            dialogo.show(supportFragmentManager, null)
        }
    }

    override fun onListaMultipleSelected(opcionesResultado: ArrayList<Int>) {
        Log.v("respuesta",opcionesResultado.toString())
    }


    // arraylist
}