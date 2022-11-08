package com.develop.t3_estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.develop.t3_estados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding
    var contador: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view: View = binding.root;
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador",0)?:0
        binding.textoContador.text = contador.toString()
        
        acciones();
    }



    private fun acciones() {
        binding.botonIncrementar.setOnClickListener(this)
        binding.botonDecrementar.setOnClickListener(this)
        binding.botonReset.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_incrementar->{
                // sumar uno al textView
                contador++;
            }
            R.id.boton_decrementar->{
                // restar uno al textView
                contador--
            }
            R.id.boton_reset->{
                // poner a 0 el textView
                contador =0;
            }
        }

        binding.textoContador.setText(contador.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }
}