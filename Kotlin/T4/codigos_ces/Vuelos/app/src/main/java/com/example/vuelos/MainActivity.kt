package com.example.vuelos

import android.app.DatePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.vuelos.databinding.ActivityMainBinding
import com.example.vuelos.ui.dialog.FechaDialog
import com.example.vuelos.ui.dialog.HoraDialog

class MainActivity : AppCompatActivity(), OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_fecha->{
                val fechaDialog = FechaDialog()
                fechaDialog.show(supportFragmentManager,null)
            }
            R.id.menu_hora->{
                val dialogoHora = HoraDialog()
                dialogoHora.show(supportFragmentManager,null)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        binding.textoHora.text = "$hourOfDay:$minute"
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        binding.textoFecha.text = "$dayOfMonth/${month + 1}/$year"
    }
}