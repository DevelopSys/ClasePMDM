package com.system.develop.t2_01_botones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener{


    CheckBox checkBox1;
    Button boton;
    RadioButton radioInd1, radioGrupo1, radioGrupo2;
    RadioGroup grupoRadios;
    ToggleButton togButton;
    Switch aSwitch;
    SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        checkBox1 = findViewById(R.id.checkBox);
        boton = findViewById(R.id.botonNormal);
        radioInd1 = findViewById(R.id.radioIndividual);
        radioGrupo1 = findViewById(R.id.radioGrupo1);
        radioGrupo2 = findViewById(R.id.radioGrupo2);
        grupoRadios = findViewById(R.id.grupoRadios);
        togButton = findViewById(R.id.botonToggle);
        aSwitch = findViewById(R.id.botonSwitch);
        seekBar = findViewById(R.id.seekBar);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkBox:
                Toast.makeText(getApplicationContext(),
                        "El estado ha pasado a: " + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonToggle:
                Toast.makeText(getApplicationContext(),
                        "El estado ha pasado a: " + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
                break;
            case R.id.botonSwitch:
                Toast.makeText(getApplicationContext(),
                        "El estado ha pasado a: " + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.grupoRadios:
                switch (checkedId) {
                    case R.id.radioGrupo1:
                        Toast.makeText(getApplicationContext(),
                                "Seleccionado uno", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioGrupo2:
                        Toast.makeText(getApplicationContext(),
                                "Seleccionado dos", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }
    }
}
