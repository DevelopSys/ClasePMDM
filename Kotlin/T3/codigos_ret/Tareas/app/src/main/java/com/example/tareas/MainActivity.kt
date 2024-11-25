package com.example.tareas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tareas.adapter.AdaptadorTarea
import com.example.tareas.databinding.ActivityMainBinding
import com.example.tareas.model.Tarea

class MainActivity : AppCompatActivity() {

    private lateinit var listaTareas: ArrayList<Tarea>
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorTarea: AdaptadorTarea
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        instancias()
        binding.btnAdd.setOnClickListener {
            if (binding.editNombre.text.isNotEmpty()
                && binding.editDescripcion.text.isNotEmpty()
            ) {

                listaTareas.add(
                    Tarea(
                        binding.editNombre.text.toString(),
                        binding.editDescripcion.text.toString(),
                        binding.spinnerTipo.selectedItemPosition
                    )
                )
                adaptadorTarea.notifyDataSetChanged()

                binding.editNombre.text.clear()
                binding.editDescripcion.text.clear()
                binding.spinnerTipo.setSelection(0)

            }
        }
        binding.spinnerFiltro.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //val prioridad = p0!!.adapter.getItem(p2).toString()
                if (p2!=0){
                    val listaFiltro: ArrayList<Tarea> = listaTareas.filter {
                        it.tipo == p2-1
                    } as ArrayList<Tarea>

                    adaptadorTarea.changeList(listaFiltro)
                }


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.listView.setOnItemClickListener { _, _, i, _ ->

            val bundle = Bundle();
            bundle.putSerializable("tarea",adaptadorTarea.getItem(i))
            val intent: Intent? = null// = Intent(this, SecondActivity::java.class)
            intent!!.putExtra("datos", bundle)
            startActivity(intent)

        }

    }

    private fun instancias() {

        listaTareas = ArrayList()
        adaptadorTarea = AdaptadorTarea(listaTareas,applicationContext)
        binding.listView.adapter = adaptadorTarea;
    }
}