package com.example.examen1ev

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen1ev.databinding.ActivityMainBinding
import com.example.examen1ev.model.Alumno
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adaterSP1: ArrayAdapter<Int>
    private lateinit var adaterSP2: ArrayAdapter<Int>
    private lateinit var adaterSP3: ArrayAdapter<Int>
    private lateinit var arrayNotas: ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        if (savedInstanceState == null) {
            initGUI()
        } else {
            binding.spinnerN1.setSelection(savedInstanceState.getInt("sp1"))
            binding.spinnerN2.setSelection(savedInstanceState.getInt("sp2"))
            binding.spinnerN3.setSelection(savedInstanceState.getInt("sp3"))
        }
        actions()
    }

    private fun actions() {
        binding.btnPasar.setOnClickListener {
            if (binding.editNombre.text.isEmpty()) {
                Snackbar.make(binding.root,
                    "App: ${resources.getString(R.string.snack_empty)}",
                    Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(applicationContext,
                    SecondActivity::class.java)
                val alumno = Alumno(
                    binding.editNombre.text.toString(),
                    binding.spinnerN1.selectedItem.toString().toInt(),
                    binding.spinnerN2.selectedItem.toString().toInt(),
                    binding.spinnerN3.selectedItem.toString().toInt(),
                    binding.checkFFE.isChecked,
                    binding.checkPRO.isChecked,
                )
                intent.putExtra("alumno", alumno)
                startActivity(intent)
            }
        }
    }

    private fun initGUI() {
        binding.spinnerN1.setSelection(4)
        binding.spinnerN2.setSelection(4)
        binding.spinnerN3.setSelection(4)
    }

    private fun instances() {


        adaterSP1 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            (1..10).toList()
        )

        adaterSP1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerN1.adapter = adaterSP1


        adaterSP2 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            (1..10).toList()
        )
        adaterSP2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerN2.adapter = adaterSP2

        adaterSP3 = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            (1..10).toList()
        )
        adaterSP3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerN3.adapter = adaterSP3


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("sp1", binding.spinnerN1.selectedItemPosition)
        outState.putInt("sp2", binding.spinnerN2.selectedItemPosition)
        outState.putInt("sp3", binding.spinnerN3.selectedItemPosition)
    }

}