package com.example.dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.ui.dialog.ConfirmDialog
import com.example.dialogos.ui.dialog.DateDialog
import com.example.dialogos.ui.dialog.DialogoComunicacion
import com.example.dialogos.ui.dialog.InfoDialog
import com.example.dialogos.ui.dialog.ListDialog
import com.example.dialogos.ui.dialog.TimeDialog
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(),
    ConfirmDialog.OnDialogoConfirmacionListener,
    ListDialog.OnListaMultipleListener,
    DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // val fecha: Date = Date()
        /*val calendario: Calendar = Calendar.getInstance()
        calendario.set(2025,0,12)
        calendario.*/
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbar.title = "Cambio"
        // supportActionBar?.title  = "Aplicacion de trivial"
        binding.textFechaSalida.setOnClickListener {

            val dialog: DateDialog = DateDialog();
            dialog.show(supportFragmentManager, null)
        }
        binding.textFechaLlegada.setOnClickListener {

            if (binding.textFechaSalida.text != "Salida") {
                val dialog: DateDialog = DateDialog();
                dialog.show(supportFragmentManager, null)
            } else {
                Snackbar.make(
                    binding.root,
                    "Por favor selecciona una salida antes",
                    Snackbar.LENGTH_SHORT
                ).setAction("Selecciona fecaha ahora") {}.show()
            }

        }




        binding.btnValidar.setOnClickListener {
            val dialogo: DialogoComunicacion = DialogoComunicacion.newInstance("borja", "1234A")
            dialogo.show(supportFragmentManager, null)
        }

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
                // val dialogo = ListDialog()
                // val dialogo = DateDialog()
                val dialogo = TimeDialog()
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
        Log.v("respuesta", opcionesResultado.toString())
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        // Log.v("calendario","Año: ${p1} Mes: ${p2+1} Dia: ${p3}")
        if (binding.textFechaSalida.text != "Salida") {
            binding.textFechaLlegada.setPaintFlags(binding.textFechaLlegada.getPaintFlags()

                    or Paint.UNDERLINE_TEXT_FLAG)
            binding.textFechaLlegada.text = "$p3/${p2 + 1}/$p1"
        } else {
            binding.textFechaSalida.text = "$p3/${p2 + 1}/$p1"
        }
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Log.v("calendario", "Hora: ${p1} Minutos: ${p2}")
    }


    // arraylist
}