package com.example.t8sqlite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.t8sqlite.model.Alumno

@Dao
interface AlumnoDAO {
    @Query("SELECT * FROM Alumno")
    fun getAlumnos(): List<Alumno>

    @Query("SELECT * FROM Alumno WHERE nombre = :nombre")
    fun getAlumnosByName(nombre: String): List<Alumno>

    @Insert
    fun insertarAlumno(alumno: Alumno)
}