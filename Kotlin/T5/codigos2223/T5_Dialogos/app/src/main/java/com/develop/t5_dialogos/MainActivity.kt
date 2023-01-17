package com.develop.t5_dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.develop.t5_dialogos.databinding.ActivityMainBinding
import com.develop.t5_dialogos.dialogs.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener,
    DialogoConfirmacion.OnDialogoConfirmListener, DialogoLista.OnListaListener,
    DialogoListaSimple.OnListaSimpleListener, DatePickerDialog.OnDateSetListener,
TimePickerDialog.OnTimeSetListener{

    private lateinit var binding: ActivityMainBinding
    private var dialogoConfirm: DialogoConfirmacion;

    init {
        dialogoConfirm = DialogoConfirmacion()
        dialogoConfirm.funcionNula = { elemento ->
            if (elemento){
                Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonLista.setOnClickListener(this)
        binding.botonListaSimple.setOnClickListener(this)
        binding.botonListaMultiple.setOnClickListener(this)
        binding.botonPersonalizado.setOnClickListener(this)
        binding.botonComunicar.setOnClickListener(this)
        binding.botonFecha.setOnClickListener(this)
        binding.botonHora.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.botonFecha.id -> {
                DialgoFecha().show(supportFragmentManager,"")
            }
            binding.botonHora.id -> {
                DialogoHora().show(supportFragmentManager,"")
            }
            binding.botonComunicar.id -> {
                // lanzar cuadro de dialogo con comunicacion
                DialogoComunicar.newInstance("Borja").show(supportFragmentManager,"")
                //DialogoComunicar().show(supportFragmentManager,"")
            }
            binding.botonConfirmacion.id -> {
                // saltar en cuadro de diálogo
                // show() parte del DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager, "")
            }
            binding.botonLista.id ->{
                DialogoLista().show(supportFragmentManager,"")
            }
            binding.botonListaSimple.id ->{
                DialogoListaSimple().show(supportFragmentManager,"")
            }
            binding.botonListaMultiple.id ->{
                DialogoMultiple().show(supportFragmentManager,"")
            }
            binding.botonPersonalizado.id -> {
                DialogoPersonalizado().show(supportFragmentManager,"")
            }
        }
    }

    override fun onDialogoSelected(seleccionado: Boolean) {
        if (seleccionado) {
            Snackbar.make(binding.root, "Seleccionado true", Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(binding.root, "Seleccionado false", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onElementoListaSelected(elemento: String) {
        binding.listaConfirmacion.text = elemento
    }

    override fun onListaSelected(elemento: String?) {
        binding.listaSimpleConfirmacion.text = elemento?:"Sin comunicacion"
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Log.v("fecha","${p1} ${p2+1} ${p3}")

    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Log.v("hora","${p1} ${p2}")
    }
}