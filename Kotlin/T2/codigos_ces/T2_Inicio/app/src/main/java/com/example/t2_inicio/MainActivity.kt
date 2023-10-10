package com.example.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var botonPulsar: Button;
    lateinit var botonVaciar: Button;
    lateinit var editNombre: EditText;
    lateinit var editTelefono: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        botonPulsar.setOnClickListener(this)
        botonVaciar.setOnClickListener(this)
    }

    private fun instancias() {
        botonPulsar = findViewById(R.id.boton_pulsar);
        botonVaciar = findViewById(R.id.boton_vaciar);
        editNombre = findViewById(R.id.edit_nombre);
        editTelefono = findViewById(R.id.edit_telefono);
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_pulsar->{
                if (!editNombre.text.isEmpty() && !editTelefono.text.isEmpty()) {
                    // hay cosas dentro
                    Snackbar.make(
                        p0!!,
                        "${resources.getString(R.string.text_superada)} ${editNombre.text} " +
                                "${resources.getString(R.string.text_superada_dos)}",
                        Snackbar.LENGTH_INDEFINITE
                    ).setAction(R.string.text_pulsar) {
                        // ocultar la notificacion
                        // notificion.dismiss()
                        Snackbar.make(it, "Tu telefono es: ${editTelefono.text}", Snackbar.LENGTH_SHORT)
                            .show()
                    }.show()
                }
                else {
                    // no hay cosas dentro
                    Snackbar.make(p0!!, "Faltan datos", Snackbar.LENGTH_LONG).show()
                }
            }
            R.id.boton_vaciar->{
                editNombre.text.clear()
                editTelefono.text.clear()
            }
        }
    }
}