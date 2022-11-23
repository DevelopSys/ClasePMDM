package com.develop.t3_repaso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.develop.t3_repaso.databinding.ActivityThirdBinding
import com.develop.t3_repaso.model.Lenguaje

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nombreDetalle.text = savedInstanceState?.getString("nombre")

        var lenguajeRecuperado: Lenguaje = intent.extras!!.getSerializable("lenguaje") as Lenguaje;

        binding.imagenDetalle.setImageResource(lenguajeRecuperado.imagen)
        binding.nombreDetalle.setText(lenguajeRecuperado.nombre)
        binding.nota1Detalle.text =  intent.extras!!.getInt("nota1".toString()).toString()
        binding.nota2Detalle.text = intent.extras!!.getInt("nota2".toString()).toString()
        binding.nombreUsuarioDetalle.setText(intent.extras!!.getString("nombre".toString()))
        var nota1 = intent.extras!!.getInt("nota1");
        var nota2 = intent.extras!!.getInt("nota2");
        var media: Double = ((nota1.toDouble()+nota2.toDouble())/2)
        Log.v("media_calculada", media.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre", binding.nombreDetalle.text.toString());
    }
}