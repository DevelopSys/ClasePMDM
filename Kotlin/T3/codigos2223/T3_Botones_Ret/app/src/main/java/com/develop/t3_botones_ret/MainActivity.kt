package com.develop.t3_botones_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import at.markushi.ui.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private lateinit var botonPulsar: Button;
    private lateinit var grupoRadios: RadioGroup;
    private lateinit var radioUno: RadioButton;
    private lateinit var radioDos: RadioButton;
    private lateinit var radioTres: RadioButton;
    private lateinit var toggleEstado: ToggleButton;
    private lateinit var checkEstado: CheckBox;
    private lateinit var botonCircular: CircleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias();
        acciones();
    }

    private fun acciones() {
        toggleEstado.setOnClickListener(this)
        botonPulsar.setOnClickListener(this)
        grupoRadios.setOnCheckedChangeListener { radioGroup, i ->
            var radioSeleccioando: RadioButton = findViewById(i);
            Snackbar.make(grupoRadios,radioSeleccioando.text,Snackbar.LENGTH_SHORT).show()
        }
        botonCircular.setOnClickListener {  }
        toggleEstado.setOnCheckedChangeListener(this)
        checkEstado.setOnCheckedChangeListener(this)
    }

    private fun instancias() {
        botonPulsar = findViewById(R.id.boton_pulsar);
        grupoRadios = findViewById(R.id.grupo_radios);
        radioUno = findViewById(R.id.radio_uno);
        radioDos = findViewById(R.id.radio_dos);
        radioTres = findViewById(R.id.radio_tres);
        toggleEstado = findViewById(R.id.toggle_estado);
        checkEstado = findViewById(R.id.check_estado);
    }
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.toggle_estado->{
                Snackbar.make(p0, "Toggle pulsado", Snackbar.LENGTH_SHORT).show()
            }
            R.id.boton_pulsar -> {
                //toggleEstado.isChecked = !toggleEstado.isChecked
                checkEstado.isChecked = !checkEstado.isChecked;
                /*Snackbar.make(p0, toggleEstado.isChecked.toString(),
                    Snackbar.LENGTH_SHORT).show()*/
                // obtener el radio seleccionado
                lateinit var radioSeleccioando: RadioButton;
                radioSeleccioando = findViewById(grupoRadios.checkedRadioButtonId);
                if (grupoRadios.checkedRadioButtonId >= 0) {
                   Snackbar.make(p0, radioSeleccioando.text, Snackbar.LENGTH_SHORT).show()

                    when (radioSeleccioando.id){
                        R.id.radio_uno->{}
                        R.id.radio_dos->{}
                        R.id.radio_tres->{}
                    }
                }
            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p0!!.id){
            R.id.toggle_estado->{
                radioUno.isEnabled = p1
                radioDos.isEnabled = p1
                radioTres.isEnabled = p1
            }R.id.check_estado->{
                toggleEstado.isEnabled = p1;
            }
        }
    }

}