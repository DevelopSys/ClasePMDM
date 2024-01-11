package com.example.t4_comunicaciondialogo

import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.t4_comunicaciondialogo.databinding.ActivityMainBinding
import com.example.t4_comunicaciondialogo.ui.dialogs.DialogoFecha
import com.example.t4_comunicaciondialogo.ui.dialogs.DialogoHora
import com.example.t4_comunicaciondialogo.ui.dialogs.DialogoNombre
import com.example.t4_comunicaciondialogo.ui.dialogs.DialogoResumen
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),
    DialogoNombre.OnDialogoNombreListener, OnTimeSetListener, OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nombre: String
    private lateinit var hora: String
    private lateinit var fecha: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_nombre -> {
                val dialogoNombre = DialogoNombre()
                dialogoNombre.show(supportFragmentManager, null)
            }

            R.id.menu_fecha -> {
                val dialogoFecha = DialogoFecha()
                dialogoFecha.show(supportFragmentManager, null)
            }

            R.id.menu_hora -> {
                val dialogoHora = DialogoHora()
                dialogoHora.show(supportFragmentManager, null)
            }

            R.id.menu_resumen -> {

                val dialogoResumen: DialogoResumen =
                    DialogoResumen.newInstance(fecha,hora,nombre)
                dialogoResumen.show(supportFragmentManager,null)
            }
        }

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onNombreSelected(nombre: String) {
        this.nombre = nombre
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        // Snackbar.make(binding.root,"${hourOfDay}:${minute}"
        //    ,Snackbar.LENGTH_SHORT).show()
        this.hora = "$hourOfDay:$minute";
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        //Snackbar.make(binding.root,"${dayOfMonth}/${month+1}/${year}",Snackbar.LENGTH_SHORT).show()
        fecha = "${dayOfMonth}/${month+1}/${year}"
    }


}