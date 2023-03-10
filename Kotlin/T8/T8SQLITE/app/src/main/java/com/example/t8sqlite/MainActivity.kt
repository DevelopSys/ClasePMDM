package com.example.t8sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.t8sqlite.database.DatabaseAlumnos
import com.example.t8sqlite.model.Alumno
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val database = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()
        /*val database1 = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()
        val database2 = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()
        val database3 = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()*/




        /*GlobalScope.launch(Dispatchers.IO) {
            val database = DatabaseAlumnos.getInstance(applicationContext)
            database.alumnoDAO()
                .insertarAlumno(Alumno("Borja", "Martin", 123, "correo@gmail.com"))
        }*/


        // MAIN
        // IO


    }
}