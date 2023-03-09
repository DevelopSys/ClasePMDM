package com.example.t8sqlite.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Alumno(
    @ColumnInfo var nombre: String,
    @ColumnInfo var apellido: String,
    @ColumnInfo var edad: Int,
    @ColumnInfo var correo: String
): java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 1;

    fun mostrarDatos() {
        print("nombre ${nombre}")
        print("apellido ${apellido}")
        print("correo ${correo}")
        print("edad ${edad}")
    }
}
