package com.develop.t2_inicio_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonInicial: Button;
    lateinit var etiquetaSaludo: TextView;
    lateinit var editNombre: EditText;
    lateinit var imagenEstado: ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.v("ciclo_vida", "Ejecutando metodo onCreate")
        // asocia la parte lógica y la gráfica
        this.setContentView(R.layout.activity_main)
        instancias();
        acciones();
    }

    private fun acciones() {
        botonInicial.setOnClickListener({

            if (!editNombre.text.isEmpty()){
                var notification = Snackbar.make(it,
                    "Estas seguro que el nombre es "+editNombre.text
                    ,Snackbar.LENGTH_INDEFINITE)

                notification.setAction("Aceptar",{
                    //etiquetaSaludo.setText(editNombre.text)
                    //editNombre.setText("");
                    //notification.dismiss()
                    imagenEstado.setImageResource(R.drawable.shocked)
                })

                notification.show()

                //
            } else {
                Log.v("edit_nombre","texto vacio")
                Toast.makeText(applicationContext,"Texto vacio",
                    Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun instancias() {
        this.botonInicial = findViewById(R.id.boton_inicial)
        this.etiquetaSaludo = findViewById(R.id.texto_saludo);
        this.editNombre = findViewById(R.id.edit_nombre);
        this.imagenEstado = findViewById(R.id.imagen_estado)
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Ejecutando metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Ejecutando metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Ejecutando metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Ejecutando metodo onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Ejecutando metodo onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Ejecutando metodo onRestart")
    }

}