package com.example.filtradorestaurantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filtradorestaurantes.data.DataSet
import com.example.filtradorestaurantes.model.Restaurante

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        // obtener la lista filtrada
        val localidad = intent.extras!!.getString("localidad")
        val comida = intent.extras!!.getString("comida")
        val puntuacion = intent.extras!!.getInt("puntuacion")

        val listaFiltrada: ArrayList<Restaurante>
        = DataSet.listaRestaurantes().filter {
            it.comida.equals(comida)
                    && it.puntuacion >= puntuacion
                    && it.localidad.equals(localidad)
        } as ArrayList<Restaurante>

    }
}