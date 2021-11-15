package com.example.elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton toggle;
    private TextView textoToggle, textoCheck, textoGrupo;
    private CheckBox check;
    private RadioGroup grupoRadios;
    private EditText campoCambios;
    private Button btnComprobar;
    private int cambios =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        inicializarElementos();
        acciones();
    }

    private void inicializarElementos() {
        toggle.setChecked(true);
        textoToggle.setText("Toggle seleccionado");
        check.setChecked(true);
        textoCheck.setText("Check seleccionado");
    }

    private void acciones() {

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),String.valueOf(cambios),Toast.LENGTH_SHORT).show();
                campoCambios.append(String.valueOf(toggle.isChecked()));
                campoCambios.append(String.valueOf(check.isChecked()));
                campoCambios.append(String.valueOf(grupoRadios.getCheckedRadioButtonId()));

            }
        });
        toggle.setOnCheckedChangeListener(this);
        check.setOnCheckedChangeListener(this);
        grupoRadios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){
                    case R.id.radio_uno:
                        // si hay accion diferente
                        campoCambios.append("Cambios en radio1 \n");
                        Toast.makeText(getApplicationContext(), "Uno seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_dos:
                        // si hay accion diferente
                        campoCambios.append("Cambios en radio2 \n");
                        Toast.makeText(getApplicationContext(), "Dos seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radio_tres:
                        // si hay accion diferente
                        campoCambios.append("Cambios en radio3 \n");
                        Toast.makeText(getApplicationContext(), "Tres seleccionado", Toast.LENGTH_SHORT).show();
                        break;
                }

                cambios++;

                RadioButton bAux = findViewById(checkedId);
                textoGrupo.setText(bAux.getText());

            }
        });
    }

    private void instancias() {
        toggle = findViewById(R.id.toggle_inical);
        check = findViewById(R.id.check_inical);
        textoToggle = findViewById(R.id.texto_toggle);
        textoCheck = findViewById(R.id.texto_check);
        grupoRadios = findViewById(R.id.grupo_radios);
        textoGrupo = findViewById(R.id.texto_grupo);
        campoCambios = findViewById(R.id.campo_cambios);
        btnComprobar = findViewById(R.id.btnComprobar);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()){

            case R.id.check_inical:
                campoCambios.append("Cambios en check \n");
                if (isChecked){
                    textoCheck.setText("Check "+getResources().getString(R.string.seleccionado));
                } else {
                    textoCheck.setText("Check "+getResources().getString(R.string.deseleccionado));
                }
                break;

            case R.id.toggle_inical:
                // si se ha pulsado el toggle
                campoCambios.append("Cambios en toggle \n");
                if (isChecked){
                    textoToggle.setText("Toggle "+getResources().getString(R.string.seleccionado));
                } else {
                    textoToggle.setText("Toggle "+getResources().getString(R.string.seleccionado));
                }

                check.setEnabled(isChecked);
                break;
        }
        cambios++;

    }
}