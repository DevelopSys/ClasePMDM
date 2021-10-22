package com.borja.examenpmdm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.borja.examenpmdm.adaptadores.AdaptadorSpinnerCoches;
import com.borja.examenpmdm.utils.Coche;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    Spinner spinnerCoches;
    ImageView imageCoche;
    TextView cvCoche;
    Button bAgregar;
    ArrayList<Coche> listaCoches;
    AdaptadorSpinnerCoches adaptadorSpinnerCoches;
    final static int COD_RES_OK = 0;
    final static int COD_RES_FAIL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        instancias();
        rellenarSpinner();
        acciones();
    }

    private void acciones() {
        bAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FormScreen.class);
                startActivityForResult(i,1);
            }
        });
        spinnerCoches.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Coche coche = (Coche) spinnerCoches.getSelectedItem();
                imageCoche.setImageResource(coche.getImagen());
                cvCoche.setText("Caballos: "+coche.getCv());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void rellenarSpinner() {
        spinnerCoches.setAdapter(adaptadorSpinnerCoches);
    }

    private void instancias() {
        spinnerCoches = findViewById(R.id.spinner_coches);
        imageCoche = findViewById(R.id.imagen_coche);
        listaCoches = new ArrayList();
        adaptadorSpinnerCoches = new AdaptadorSpinnerCoches(listaCoches,getApplicationContext());
        bAgregar = findViewById(R.id.boton_principal_agregar);
        cvCoche = findViewById(R.id.cv_coche);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==COD_RES_OK){
            Coche coche = (Coche) data.getExtras().get(FormScreen.TAG_COCHE);
            listaCoches.add(coche);
            adaptadorSpinnerCoches.notifyDataSetChanged();
        }
    }
}
