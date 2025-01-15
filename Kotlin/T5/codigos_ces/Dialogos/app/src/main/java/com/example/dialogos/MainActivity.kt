package com.example.dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.model.Pregunta
import com.example.dialogos.ui.dialog.DialogoComunicacion
import com.example.dialogos.ui.dialog.DialogoFecha
import com.example.dialogos.ui.dialog.DialogoHora
import com.example.dialogos.ui.dialog.DialogoInfo
import com.example.dialogos.ui.dialog.DialogoLista
import com.example.dialogos.ui.dialog.DialogoListaMultiple
import com.example.dialogos.ui.dialog.DialogoListaSimple
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), DialogoInfo.OnDialogoListener,
    DialogoLista.OnDialogoListaListener, DialogoListaSimple.OnDialogoSimpleListener,
    DialogoListaMultiple.OnDialogoMultipleListener, DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener
{

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.barraSuperior)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_dialogo -> {
                //val dialogo = DialogoInfo()
                //val dialogo = DialogoLista()
                // val dialogo = DialogoListaSimple()
                // val dialogo = DialogoListaMultiple()
                // val dialogo = DialogoFecha()
                // val dialogo = DialogoHora()
                val dialogo = DialogoComunicacion.newInstance("Borja","PMDM")
                dialogo.show(supportFragmentManager, null)

/*                TimePickerDialog(this
                    ,this
                    , Calendar.getInstance().get(Calendar.HOUR),
                    Calendar.getInstance().get(Calendar.MINUTE),true).show()*/
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDialogoSelected(respuesta: String, respuestaNum: Int) {
        Snackbar.make(binding.root, respuesta, Snackbar.LENGTH_SHORT).show()
        if (respuestaNum == 1) {
            // borra de la base de datos
        } else {
            // cancela el borrado
        }
    }

    override fun onDialogoSelectedAll() {

    }

    override fun onOpcionSelected(x: String) {
        binding.textoRespuesta.text = x
    }

    override fun onOpcionSimpleSelected(posicion: Int, opcion: String) {
        Log.v("preguntas",posicion.toString())
        Log.v("preguntas",opcion.toString())
    }

    override fun onOpcionMultpleSelected(respuestas: ArrayList<Int>) {
        Log.v("respuesta",respuestas.toString())
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Log.v("calendario",p1.toString())
        Log.v("calendario",(p2+1).toString())
        Log.v("calendario",p3.toString())
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Log.v("calendario",p1.toString())
        Log.v("calendario",p2.toString())
    }


}