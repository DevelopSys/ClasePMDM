package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // los VIEWS
    private lateinit var botonSaludo: Button;
    private lateinit var editSaludar: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botonSaludo = findViewById(R.id.botonSaludar)
        editSaludar = findViewById(R.id.editNombre);

        botonSaludo.setOnClickListener {
            Snackbar.make(
                it,
                "Enhorabuena ${editSaludar.text.toString()} " +
                        "has completado la primera app android",
                Snackbar.LENGTH_LONG
            ).show()
        }

    }
}