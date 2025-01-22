package com.example.repaso

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.repaso.adapter.AdapterTrivial
import com.example.repaso.databinding.ActivityMainBinding
import com.example.repaso.model.Pregunta
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterTrivial: AdapterTrivial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        adapterTrivial = AdapterTrivial(this)
        binding.recyclerPreguntas.adapter = adapterTrivial
        binding.recyclerPreguntas.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val urlConsulta = "https://opentdb.com/api.php?amount=20"
        val gson: Gson = Gson()
        val peticion: JsonObjectRequest = JsonObjectRequest(urlConsulta,
            {
                val results = it.getJSONArray("results")
                for (i in 0..results.length() - 1) {
                    val question = results.getJSONObject(i)
                    val pregunta: Pregunta = gson.fromJson(question.toString(),Pregunta::class.java)
                    adapterTrivial.agregarPregunta(pregunta)
                    // val title= question.getString("question")
                    // val correct= question.getString("correct_answer")
                    // val incorrects= question.getJSONArray("incorrect_answers")
                    // val pregunta = Pregunta(title,correct,incorrects as Array<String>)
                    Log.v("preguntas",pregunta.question!!)
                }
            },
            {
                Log.v("preguntas",it.toString())
            })
        Volley.newRequestQueue(this).add(peticion)
    }
}