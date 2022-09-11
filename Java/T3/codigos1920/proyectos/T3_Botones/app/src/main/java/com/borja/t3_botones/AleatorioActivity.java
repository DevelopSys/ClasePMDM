package com.borja.t3_botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AleatorioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    CheckBox cDecimales;
    RadioButton sinRango, conRango;
    RadioGroup gRango;
    EditText eDecimales, eMin, eMax;
    LinearLayout linearRango;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instancias();
        acciones();
    }

    private void acciones() {
        gRango.setOnCheckedChangeListener(this);
        cDecimales.setOnCheckedChangeListener(this);
    }

    private void instancias() {
        cDecimales = findViewById(R.id.check_decimales);
        sinRango = findViewById(R.id.radio_sin_rango);
        conRango = findViewById(R.id.radio_con_rango);
        gRango = findViewById(R.id.grupoRango);
        eDecimales = findViewById(R.id.edit_decimales);
        linearRango = findViewById(R.id.linear_rango);
        eMax = findViewById(R.id.edit_max);
        eMin = findViewById(R.id.edit_min);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {


        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.radio_sin_rango:
                eMax.setEnabled(false);
                eMin.setEnabled(false);
                break;
            case R.id.radio_con_rango:
                eMax.setEnabled(true);
                eMin.setEnabled(true);
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b){
            eDecimales.setEnabled(true);
        }else {
            eDecimales.setEnabled(false);
        }
    }
}
