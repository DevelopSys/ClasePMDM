package com.example.vuelos

import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TimePicker
import com.example.vuelos.ui.dialog.HoraDialog

class MainActivity : AppCompatActivity(), OnTimeSetListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_fecha->{

            }
            R.id.menu_hora->{
                val dialogoHora = HoraDialog()
                dialogoHora.show(supportFragmentManager,null)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {

    }
}