package com.develop.t5_dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.develop.t5_dialogos.databinding.ActivityMainBinding
import com.develop.t5_dialogos.dialogs.DialogoConfirmacion

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConfirmacion.id ->{
                // saltar en cuadro de diálogo
                // show() parte del DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager,"")
            }
        }
    }
}