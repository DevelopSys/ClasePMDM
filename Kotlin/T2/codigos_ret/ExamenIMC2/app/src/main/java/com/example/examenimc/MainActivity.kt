package com.example.examenimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var editAltura: AppCompatEditText;
    private lateinit var editPeso: AppCompatEditText;
    private lateinit var textoIMC: AppCompatTextView;
    private lateinit var botonHombre: AppCompatButton;
    private lateinit var botonMujer: AppCompatButton;
    private lateinit var imagenEstado: AppCompatImageView;
    var imagen: Int = 0;
    lateinit var estado: String;
    var imc: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias();
        imc = savedInstanceState?.getDouble("imc")?:0.0
        estado = savedInstanceState?.getString("estado")?:""
        imagen = savedInstanceState?.getInt("imagen")?:-1
        acciones();
    }

    private fun acciones() {
        botonHombre.setOnClickListener(this)
        botonMujer.setOnClickListener(this)
    }

    private fun instancias() {
        botonMujer = findViewById(R.id.boton_mujer)
        botonHombre = findViewById(R.id.boton_hombre)
        editAltura = findViewById(R.id.edit_altura)
        editPeso = findViewById(R.id.edit_peso)
        imagenEstado = findViewById(R.id.imagen_imc)
    }

    override fun onClick(v: View?) {
        if (editAltura.text!!.isEmpty() || editPeso.text!!
                 .isEmpty()){
            Snackbar.make(v!!,resources.getString(R.string.aviso_datos), Snackbar.LENGTH_SHORT).show()
        } else {

            imc = editPeso.text.toString().toDouble() / (2*editAltura.text.toString().toDouble())
            when(v!!.id){
                R.id.boton_hombre->{
                    if (imc<19.5){
                        estado = "Por debajo"
                        imagen = R.drawable.bajo
                    } else if (imc>19.5 && imc<24){
                        estado = "normal"
                        imagen = R.drawable.normal
                    }
                }
                R.id.boton_mujer->{
                    if (imc<18.5){
                        estado = "Por debajo"
                        imagen = R.drawable.bajo
                    } else if (imc>18.5 && imc<22){
                        estado = "normal"
                        imagen = R.drawable.normal
                    }
                }
            }
            Snackbar.make(v!!, "${resources.getString(R.string.aviso_imc)} ${estado}", Snackbar.LENGTH_LONG)
                .setAction("OK"){
                    textoIMC.text = imc.toString()
                    imagenEstado.setImageResource(imagen)
                }
                .show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("imagen",imagen)
        outState.putString("estado",estado)
        outState.putDouble("imc",imc)
    }
}