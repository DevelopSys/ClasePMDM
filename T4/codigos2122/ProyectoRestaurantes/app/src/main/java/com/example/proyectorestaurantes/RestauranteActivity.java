package com.example.proyectorestaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RestauranteActivity extends AppCompatActivity {

    private int puntuacion;
    private String localidad, tipo;
    // todos los restaurantes pasados
    private ArrayList<Restaurante> listaRestaurantes;
    private ArrayList<Restaurante> listaFiltrada;
    private AdaptadorLista adaptadorLista;
    private ListView listaGrafica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante.xml);

        instancias();
        asociarElementos();

        if (getIntent().getExtra() != null){
            recuperarDatos();
        }

        filtrarLista();

    }

    private void asociarElementos(){
        this.listaGrafica.setAdapter(adaptadorLista);
    }

    private void instancias(){
        listaRestaurantes = new ArrayList():
        listaFiltrada = new ArrayList():
        adaptadorLista = new AdaptadorLista(getApplicationContext(),listaFiltrada);
        listaGrafica = findViewById(R.id.lista);
    }

    private void filtrarLista(){
        for ( Restaurante item : listaRestaurantes ) {
            if (item.getTipo().equalIgnoreCase(tipo)
                    && item.getLocalidad().equalsIgnoreCase(localidad)
                    && item.getPuntuation() == puntuacion)
            {
                listaFiltrada.add(item);
                adaptadorLista.notifyDataSetChanged();
            }
        }
    }

    private void recuperarDatos(){
        localidad = getIntent().getExtras().getString("localidad");
        tipo = getIntent().getExtras().getString("tipo");
        puntuacion = getIntent().getExtras().getInt("puntuacion");
    }


}