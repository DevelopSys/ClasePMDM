package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonSaludar: Button
    lateinit var editNombre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonSaludar = findViewById(R.id.btnSaludar)
        editNombre = findViewById(R.id.editNombre)

        botonSaludar.setOnClickListener {
            // obtener el texto del edit
            val nombre: String = editNombre.text.toString()

            if (nombre.isEmpty()){
                Snackbar.make(
                    it, "Por favor introduce datos",
                    Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(
                    it, "Enhorabuena $nombre, " +
                            "primera app completa",
                    Snackbar.LENGTH_SHORT).show()
            }


        }

    }


}