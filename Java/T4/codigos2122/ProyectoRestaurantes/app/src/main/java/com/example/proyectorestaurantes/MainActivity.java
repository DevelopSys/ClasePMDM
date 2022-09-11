package com.example.proyectorestaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerComida, spinnerPuntuacion, spinnerLocalidad;
    private ArrayList listaComidas, listaLocalidades, listaPuntuacion;
    private ArrayAdapter adapterComidas, adapterLocalidad, adapterPuntuacion;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarListas();
        asociarDatos();
        acciones();
    }

    private void acciones(){
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicacionContext(),RestauranteActivity.class);
                String localidad = adapterLocalidad.getItem(spinnerLocalidad.getSelectedItemPosition());
                String tipo  = adapterComidas.getItem(spinnerComida.getSelectedItemPosition());
                int puntuacion =  adapterPuntuacion.getItem(spinnerPuntuacion.getSelectedItemPosition());;
                intent.putExtra("puntuacion",puntuacion);
                intent.putExtra("tipo",tipo);
                intent.putExtra("localidad",localidad);
                startActivity(intent);
            }
        });
    }

    private void asociarDatos(){
        spinnerComida.setAdapter(adapterComidas);
        spinnerPuntuacion.setAdatper(adapterPuntuacion);
        spinnerLocalidad.setAdapter(adapterLocalidad);
    }

    private void rellenarListas(){
        listaLocalidades.add("Alcorcón");
        listaLocalidades.add("Mostoles");
        listaLocalidades.add("Pozuelo");
        listaLocalidades.add("Majadahonda");
        listaLocalidades.add("Alcobendas");

        listaComidas.add("Mediterranea");
        listaComidas.add("Americana");
        listaComidas.add("Italiana");
        listaComidas.add("China");
        listaComidas.add("Japonesa");

        for (int i = 1; i < 11; i++) {
            listaPuntuacion.add(i);
        }
    }

    private void instancias() {
        listaPuntuacion = new ArrayList();
        listaLocalidades = new ArrayList();
        listaComidas = new ArrayList();
        adapterComidas = new ArrayAdapter(getApplicationContext()
                , android.R.layout.simple_spinner_item, listaComidas);
        adapterLocalidad = new ArrayAdapter(getApplicationContext()
                , android.R.layout.simple_spinner_item, listaLocalidades);
        adapterPuntuacion = new ArrayAdapter(getApplicationContext()
                , android.R.layout.simple_spinner_item, listaPuntuacion);
        this.spinnerComida = findViewById(R.id.spinner_comidas);
        this.spinnerLocalidad = findViewById(R.id.spinner_localidad);
        this.spinnerPuntuacion = findViewById(R.id.spinner_puntuacion);
        this.boton = findViewById(R.id.boton_buscar);
    }
}