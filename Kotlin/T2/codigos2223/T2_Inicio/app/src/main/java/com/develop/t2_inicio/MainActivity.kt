package com.develop.t2_inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var botonPulsar: Button
    lateinit var botonPasar: Button
    lateinit var textoSaludo: TextView
    lateinit var editNombre: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // xml + kt
        Log.v("ciclo_vida", "Método onCreate ejecutado")
        botonPulsar = findViewById(R.id.boton_pulsar)
        textoSaludo = findViewById(R.id.texto_bienvenida);
        editNombre = findViewById(R.id.edit_nombre);
        botonPasar = findViewById(R.id.boton_pasar)

        // onClickListener --> View el elemento que ha producido el evento
        botonPasar.setOnClickListener(this)
        // parametro onClick -> View el elemento que provoca el evento
        botonPulsar.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Método onStart ejecutado")

    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Método onResume ejecutado")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Método onRestart ejecutado")

    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Método onPause ejecutado")

    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Método onStop ejecutado")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Método onDestroy ejecutado")

    }

    override fun onClick(p0: View?) {
        //Snackbar.make(p0!!,"Pulsado boton",Snackbar.LENGTH_SHORT).show();
        when (p0!!.id) {
            R.id.boton_pulsar -> {
                if (!editNombre.text.isEmpty()){
                    val texto = editNombre.text;
                    textoSaludo.setText(texto)
                    editNombre.setText("")
                } else {
                    Toast.makeText(applicationContext, "Faltan datos",Toast.LENGTH_SHORT).show()
                }
            }
            R.id.boton_pasar -> {
                var notificacion =
                    Snackbar.make(p0!!, "Snack completado", Snackbar.LENGTH_INDEFINITE)
                notificacion.setAction("Seguro que quieres cambiar", {
                    // pasar de activity
                    // INTENT -> acciones
                    var intent: Intent = Intent(applicationContext,SecondActivity::class.java);
                    var datos: Bundle = Bundle();
                    datos.putString("nombre",editNombre.text.toString())
                    intent.putExtras(datos)
                    startActivity(intent)
                    //startActivity(intent)
                    //finish();
                })
                notificacion.show()
            }
        }
    }


}