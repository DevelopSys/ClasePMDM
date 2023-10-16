package com.example.t2estructura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var botonComprobar: Button;
    private lateinit var botonVaciar: Button;
    private lateinit var editNombre: EditText;
    private lateinit var editTelefono: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        // setOnAction()
        botonComprobar.setOnClickListener(this)
        /*{
            // el texto no deberia ir aqui
            // si hay texto, lo capturas y lo pones en la noticicion
            // si no hay texto saltas un aviso
            /*val notificacion = Snackbar.make(it, R.string.texto_saludo, Snackbar.LENGTH_INDEFINITE)
            notificacion.setAction("ok") {
                notificacion.dismiss()
            }
            notificacion.show()*/
        }*/
        botonVaciar.setOnClickListener(this)
    }

    private fun instancias() {
        botonComprobar = findViewById(R.id.boton_pulsar)
        botonVaciar = findViewById(R.id.boton_vaciar)
        editNombre = findViewById(R.id.edit_nombre)
        editTelefono = findViewById(R.id.edit_telefono)
    }

    override fun onClick(p0: View?) {
        // decidir que boton es el pulsado
        // preguntar por el id
        when (p0!!.id) {
            R.id.boton_pulsar -> {
                if (editNombre.text.isEmpty() || editTelefono.text.isEmpty()) {
                    // si no hay datos en alqun edit
                    // notificacion larga
                    Snackbar.make(
                        p0, resources.getString(R.string.texto_datos), Snackbar.LENGTH_LONG
                    ).show()

                } else {
                    Snackbar.make(
                        p0, "${resources.getString(R.string.texto_perfecto)} " +
                                "${editNombre.text} ${resources.getString(R.string.texto_continuar)}",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction("OK") {
                        Snackbar.make(
                            p0, "${resources.getString(R.string.texto_telefono)} " +
                                    "${editTelefono.text}", Snackbar.LENGTH_SHORT
                        ).show()
                    }.show()
                }
                // sino
                // notificacion con accion indefinida
                // notifiacion corta
            }

            R.id.boton_vaciar -> {
                // vacia el contenido de los edit
                editNombre.text.clear()
                editTelefono.text.clear()
            }
        }
    }

}