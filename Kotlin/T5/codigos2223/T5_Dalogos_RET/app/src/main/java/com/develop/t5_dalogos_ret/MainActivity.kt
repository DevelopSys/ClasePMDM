package com.develop.t5_dalogos_ret

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TimePicker
import androidx.recyclerview.widget.LinearLayoutManager
import com.develop.t5_dalogos_ret.adapters.AdaptadorRecycler
import com.develop.t5_dalogos_ret.databinding.ActivityMainBinding
import com.develop.t5_dalogos_ret.dialogs.*
import com.develop.t5_dalogos_ret.model.Usuario
import com.google.android.material.snackbar.Snackbar
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity(), OnClickListener,
    DialogoConfirmacion.OnDialogoConfirmListener,
    DialogoPerso.OnRecyclerUsuariosListener,
    TimePickerDialog.OnTimeSetListener,
AdaptadorRecycler.OnRecyclerListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterRecycler: AdaptadorRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterRecycler = AdaptadorRecycler(this, ArrayList<Usuario>())
        binding.recyclerUsuarios.adapter = adapterRecycler;
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        binding.dialogoConfirmacion.setOnClickListener(this)
        binding.dialogoListas.setOnClickListener(this)
        binding.dialogoSimple.setOnClickListener(this)
        binding.dialogoPersonalizado.setOnClickListener(this)
        binding.dialogoMultiple.setOnClickListener(this)
        binding.dialogoHora.setOnClickListener(this)
        binding.dialogoComunica.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            binding.dialogoConfirmacion.id -> {
                // objeto del dialogo --> la clase
                // show
                DialogoConfirmacion().show(supportFragmentManager, null)
            }
            binding.dialogoComunica.id -> {
                DialogoComunica.newInstance("Borja","Martin").show(supportFragmentManager,"")
                //DialogoComunica().show(supportFragmentManager,"")
            }
            binding.dialogoMultiple.id -> {
                DialogoMultiple().show(supportFragmentManager, null)
            }
            binding.dialogoHora.id -> {
                DialogoHora().show(supportFragmentManager, null)
            }
            binding.dialogoListas.id -> {
                DialogoSeleccion().show(supportFragmentManager, null)
            }
            binding.dialogoSimple.id -> {
                DialogoSimple().show(supportFragmentManager, null)
            }
            binding.dialogoPersonalizado.id -> {
                DialogoPerso().show(supportFragmentManager, null)
            }
        }
    }

    override fun onDialogoSelected(comunicacion: String) {
        binding.respuestaConfirmacion.text = comunicacion
    }

    override fun usuarioSelected(usuario: Usuario) {
        adapterRecycler.addUser(usuario)
    }

    override fun onRecyclerSelected(usuario: Usuario) {
        Snackbar.make(binding.root,"${usuario.pass} ${usuario.recordad}", Snackbar.LENGTH_SHORT).show()
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {

    }

}