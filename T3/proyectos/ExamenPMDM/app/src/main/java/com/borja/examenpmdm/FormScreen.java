package com.borja.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.borja.examenpmdm.adaptadores.AdaptadorSpinnerMarcas;
import com.borja.examenpmdm.utils.Coche;
import com.borja.examenpmdm.utils.Marca;

import java.util.ArrayList;

public class FormScreen extends AppCompatActivity {

    Button bAgregar, bVolver;
    EditText editModelo, editCv;
    Spinner spinnerMarca;
    ArrayList<Marca> listaMarcas;
    AdaptadorSpinnerMarcas adaptadorSpinnerMarcas;
    final static String TAG_COCHE = "coche";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        instancias();
        rellenarSpinner();
        acciones();
    }

    private void acciones() {
        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                String marca = ((Marca) adaptadorSpinnerMarcas.getItem(spinnerMarca.getSelectedItemPosition())).getMarca();
                String modelo = editModelo.getText().toString();
                int imagen = ((Marca) adaptadorSpinnerMarcas.getItem(spinnerMarca.getSelectedItemPosition())).getLogo();
                int cv;

                if (!modelo.isEmpty() && editCv.getText().length() > 0) {
                    cv = Integer.valueOf(editCv.getText().toString());
                    i.putExtra(TAG_COCHE, new Coche(marca, modelo, cv, imagen));
                    setResult(HomeScreen.COD_RES_OK, i);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(HomeScreen.COD_RES_FAIL);
                finish();
            }
        });
    }

    private void rellenarSpinner() {
        listaMarcas.add(new Marca("Ford", R.drawable.ford));
        listaMarcas.add(new Marca("Audi", R.drawable.audi));
        listaMarcas.add(new Marca("Mercedes", R.drawable.mercedes));
        listaMarcas.add(new Marca("Toyota", R.drawable.toyota));
        listaMarcas.add(new Marca("BMW", R.drawable.bmw));
        listaMarcas.add(new Marca("Mini", R.drawable.mini));
        listaMarcas.add(new Marca("Nissan", R.drawable.nissan));
        listaMarcas.add(new Marca("Otra..", R.drawable.otra));
        spinnerMarca.setAdapter(adaptadorSpinnerMarcas);
    }

    private void instancias() {
        bAgregar = findViewById(R.id.boton_formulario_agregar);
        editModelo = findViewById(R.id.edit_modelo);
        editCv = findViewById(R.id.edit_cv);
        spinnerMarca = findViewById(R.id.spinner_marca);
        listaMarcas = new ArrayList();
        adaptadorSpinnerMarcas = new AdaptadorSpinnerMarcas(listaMarcas, getApplicationContext());
        bAgregar = findViewById(R.id.boton_formulario_agregar);
        bVolver = findViewById(R.id.boton_formulario_volver);

    }
}
