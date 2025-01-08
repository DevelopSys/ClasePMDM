package com.example.dialogos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.ui.dialog.DialogoInfo
import com.example.dialogos.ui.dialog.DialogoLista
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DialogoInfo.OnDialogoListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.barraSuperior)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_dialogo->{
                //val dialogo = DialogoInfo()
                val dialogo = DialogoLista()
                dialogo.show(supportFragmentManager,null)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDialogoSelected(respuesta: String, respuestaNum: Int) {
        Snackbar.make(binding.root, respuesta,Snackbar.LENGTH_SHORT).show()
        if (respuestaNum==1){
            // borra de la base de datos
        } else {
            // cancela el borrado
        }
    }

    override fun onDialogoSelectedAll() {
        TODO("Not yet implemented")
    }
}