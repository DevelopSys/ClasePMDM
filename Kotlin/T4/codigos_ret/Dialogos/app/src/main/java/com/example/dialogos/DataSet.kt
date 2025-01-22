package com.example.dialogos

import com.example.dialogos.model.Pregunta

class DataSet {

    companion object {
        val preguntas: ArrayList<Pregunta> = arrayListOf(
            Pregunta("Pregunta 1", arrayOf("una", "dos", "tres", "cuatro"), 0),
            Pregunta("Pregunta 2", arrayOf("una", "dos", "tres", "cuatro"), 1),
            Pregunta("Pregunta 3", arrayOf("una", "dos", "tres", "cuatro"), 2),
            Pregunta("Pregunta 4", arrayOf("una", "dos", "tres", "cuatro"), 3),

        )
    }
}