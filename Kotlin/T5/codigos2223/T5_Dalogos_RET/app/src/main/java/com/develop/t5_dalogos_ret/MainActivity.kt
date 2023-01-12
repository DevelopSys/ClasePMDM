package com.develop.t5_dalogos_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.develop.t5_dalogos_ret.databinding.ActivityMainBinding
import com.develop.t5_dalogos_ret.dialogs.DialogoConfirmacion
import com.develop.t5_dalogos_ret.dialogs.DialogoSeleccion
import com.develop.t5_dalogos_ret.dialogs.DialogoSimple
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity(), OnClickListener,
    DialogoConfirmacion.OnDialogoConfirmListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dialogoConfirmacion.setOnClickListener(this)
        binding.dialogoListas.setOnClickListener(this)
        binding.dialogoSimple.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.dialogoConfirmacion.id -> {
                // objeto del dialogo --> la clase
                // show
                DialogoConfirmacion().show(supportFragmentManager,null)
            }
            binding.dialogoListas.id ->{
                DialogoSeleccion().show(supportFragmentManager,null)
            }
            binding.dialogoSimple.id ->{
                DialogoSimple().show(supportFragmentManager,null)
            }
        }
    }

    override fun onDialogoSelected(comunicacion: String) {
        binding.respuestaConfirmacion.text = comunicacion
    }

}