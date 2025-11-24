package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen.databinding.ActivityMainBinding
import com.example.examen.model.Coche
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()

    }

    private fun acciones() {

        binding.btnEnvio.setOnClickListener {
            if (binding.editNombre.text.isEmpty() || binding.editMatricula.text.isEmpty()
                || binding.editAnio.text.isEmpty()
            ) {
                Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_SHORT).show()
            } else {
                val intent: Intent = Intent(this, SecondActivity::class.java)
                val coche =
                    Coche(
                        binding.editNombre.text.toString(),
                        binding.editMatricula.text.toString(),
                        binding.spinnerCombustible.selectedItem.toString(),
                        binding.editAnio.text.toString().toInt(),
                        binding.editAutonomia.text.toString().toInt()
                    )
                intent.putExtra("coche",coche);
                startActivity(intent)
            }
        }
        binding.spinnerCombustible.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val combustible = parent!!.adapter.getItem(position).toString();
                when(combustible){
                    "hibrido"->{
                        binding.editAutonomia.isEnabled = true;
                        binding.editAnio.setText("2018")
                    }
                    "electrico"->{
                        binding.editAutonomia.isEnabled = false;
                        binding.editAnio.setText("2018")
                    }
                    else ->{
                        binding.editAutonomia.isEnabled = false;
                        binding.editAnio.setText("")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }
}