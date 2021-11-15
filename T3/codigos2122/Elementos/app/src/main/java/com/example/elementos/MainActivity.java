package com.example.elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton toggle;
    private TextView textoToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        toggle.setOnCheckedChangeListener(this);
    }

    private void instancias() {
        toggle = findViewById(R.id.toggle_inical);
        textoToggle = findViewById(R.id.texto_toggle);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            textoToggle.setText("Toggle seleccionado");
        } else {
            textoToggle.setText("Toggle deseleccionado");
        }
    }
}