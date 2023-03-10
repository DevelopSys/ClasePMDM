package com.example.t8sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.Room
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.Response.Listener
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t8sqlite.database.DatabaseAlumnos
import com.example.t8sqlite.databinding.ActivityMainBinding
import com.example.t8sqlite.model.Alumno
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // texto = findViewById(R.id.texto):

        //val database = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()
        /*val database1 = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()
        val database2 = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()
        val database3 = Room.databaseBuilder(applicationContext, DatabaseAlumnos::class.java,"alumnos.db").build()*/


        GlobalScope.launch(Dispatchers.IO) {
            val database = DatabaseAlumnos.getInstance(applicationContext)
            /*database.alumnoDAO()
                .insertarAlumno(Alumno("Borja", "Martin", 123, "correo@gmail.com"))*/
            database.alumnoDAO().getAlumnosByName("ejemplo")
            database.alumnoDAO().getAlumnos().forEach {
                val alumno = it;
                Log.v("base_datos", it.nombre)
                withContext(Dispatchers.Main) {
                    binding.textoCambiar.text = alumno.nombre
                }
            }
        }

        val url: String = "https://www.thesportsdb.com/api/v1/json/3/all_leagues.php\n"
        var peticion: JsonObjectRequest = JsonObjectRequest(
            Method.GET, url, null,
            Response.Listener {
                val ligas: JSONArray = it.getJSONArray("leagues")
                val ligaObjeto: JSONObject =  ligas.getJSONObject(0)
                val nombreLiga: String = ligaObjeto.getString("strLeague")
                Log.v("base_datos",nombreLiga)
                              },
            null
        )

        Volley.newRequestQueue(applicationContext).add(peticion)




        // MAIN
        // IO


    }
}