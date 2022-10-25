package com.develop.t3_botones_ret

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener,
    CompoundButton.OnCheckedChangeListener {

    private lateinit var grupoRadios: RadioGroup;
    private lateinit var radioUno: RadioButton;
    private lateinit var radioDos: RadioButton;
    private lateinit var radioTres: RadioButton;
    private lateinit var botonPulsar: Button;
    private lateinit var toggleEstado: ToggleButton
    private lateinit var checkEstado: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun acciones() {
        botonPulsar.setOnClickListener(this)
        //toggleEstado.setOnClickListener(this)
        grupoRadios.setOnCheckedChangeListener { radioGroup, i ->
            var radioSeleccionado: RadioButton = findViewById(grupoRadios.checkedRadioButtonId);
            Snackbar.make(radioSeleccionado, radioSeleccionado.text, Snackbar.LENGTH_SHORT).show()
        }
        toggleEstado.setOnCheckedChangeListener(this)

        checkEstado.setOnCheckedChangeListener(this)

    }

    private fun instancias() {
        grupoRadios = this.findViewById(R.id.grupo_radios)
        radioUno = this.findViewById(R.id.radio_uno)
        radioDos = this.findViewById(R.id.radio_dos)
        radioTres = this.findViewById(R.id.radio_tres)
        botonPulsar = this.findViewById(R.id.boton_pulsar)
        toggleEstado = this.findViewById(R.id.toggle_estado)
        checkEstado = this.findViewById(R.id.check_estado)
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.boton_pulsar -> {
                toggleEstado.isChecked =  !toggleEstado.isChecked;
                checkEstado.isChecked = !checkEstado.isChecked
                // numero (id) -> View
                /*toggleEstado.isChecked =  !toggleEstado.isChecked;
                var radioSeleccionado: RadioButton = findViewById(grupoRadios.checkedRadioButtonId);
                Snackbar.make(p0, radioSeleccionado.text, Snackbar.LENGTH_LONG).show()

                when (radioSeleccionado.id) {
                    R.id.radio_uno -> {}
                    R.id.radio_dos -> {}
                    R.id.radio_tres -> {}
                }*/
            }
            R.id.toggle_estado -> {
                Snackbar.make(p0, toggleEstado.isChecked.toString() ,
                    Snackbar.LENGTH_LONG).show()

            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p0!!.id){
            R.id.toggle_estado->{
                Snackbar.make(p0, p1.toString(), Snackbar.LENGTH_SHORT).show()
            }
            R.id.check_estado->{
                Snackbar.make(p0, p1.toString(), Snackbar.LENGTH_SHORT).show()
            }
        }

    }
}