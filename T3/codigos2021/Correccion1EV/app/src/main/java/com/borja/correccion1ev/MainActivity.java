package com.borja.correccion1ev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorHobbies.OnElementoRecyclerListener {

    private Spinner spinnerHobbies;
    private ArrayAdapter adapterSpinner;
    private RecyclerView recyclerElementos;
    private ArrayList<Elemento> listaHobbiesCompleta, listaHobbiesFiltrada;
    private AdaptadorHobbies adaptadorHobbies;
    private ImageView imagenDetalle;
    private TextView nombreDetalle, detalleDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        personalizarListas();
        acciones();
    }

    private void acciones() {
        spinnerHobbies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categoria = (String) adapterSpinner.getItem(i);
                //Log.v("prueba", categoria);
                //listaHobbiesFiltrada.clear();
                adaptadorHobbies.limpiarLista();
                for ( Elemento elemento : listaHobbiesCompleta) {
                    if (elemento.getCategoria().toLowerCase().equals(categoria.toLowerCase())){
                        //listaHobbiesFiltrada.add(elemento);
                        adaptadorHobbies.agregarElemento(elemento);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void personalizarListas() {
        spinnerHobbies.setAdapter(adapterSpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        recyclerElementos.setAdapter(adaptadorHobbies);
        recyclerElementos.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));


        listaHobbiesCompleta.add(new Elemento("Messi", "FC. Barcelona", R.drawable.messi,"fútbol"));
        listaHobbiesCompleta.add(new Elemento("Ronaldo", "Brasil", R.drawable.ronaldo,"fútbol"));
        listaHobbiesCompleta.add(new Elemento("Maradona", "Argentina", R.drawable.maradona,"fútbol"));
        listaHobbiesCompleta.add(new Elemento("Zidane", "Francia", R.drawable.zidane,"fútbol"));

        listaHobbiesCompleta.add(new Elemento("Metal Gear", "Sigilo", R.drawable.metal,"juegos"));
        listaHobbiesCompleta.add(new Elemento("Gran Turismo", "Coches", R.drawable.gt,"juegos"));
        listaHobbiesCompleta.add(new Elemento("God Of War", "Plataformas", R.drawable.god,"juegos"));
        listaHobbiesCompleta.add(new Elemento("Final Fantasy X", "Rol", R.drawable.ffx,"juegos"));

        listaHobbiesCompleta.add(new Elemento("Stranger Things", "Fantastica", R.drawable.stranger,"series"));
        listaHobbiesCompleta.add(new Elemento("Juego de tronos", "Histórica", R.drawable.tronos,"series"));
        listaHobbiesCompleta.add(new Elemento("Lost", "Fantastica", R.drawable.lost,"series"));
        listaHobbiesCompleta.add(new Elemento("La casa de papel", "Accion", R.drawable.papel,"series"));

        adaptadorHobbies.notifyDataSetChanged();

        // ADAPTER(OK) --> LISTA(OK) --> XML(OK)

    }

    private void instancias() {
        String[] hobbies = {"Fútbol", "Juegos", "Series"};
        listaHobbiesCompleta = new ArrayList();
        listaHobbiesFiltrada = new ArrayList();
        spinnerHobbies = findViewById(R.id.spinner_hobbies);
        recyclerElementos = findViewById(R.id.recycler_elementos);
        nombreDetalle = findViewById(R.id.nombre_detalle);
        detalleDetalle = findViewById(R.id.detalle_detalle);
        imagenDetalle = findViewById(R.id.imagen_detalle);


        adapterSpinner = new ArrayAdapter(getApplicationContext()
                , android.R.layout.simple_spinner_item, hobbies);
        adaptadorHobbies = new AdaptadorHobbies(MainActivity.this,listaHobbiesFiltrada);
    }

    @Override
    public void onElementoSelected(Elemento elemento) {
        imagenDetalle.setImageResource(elemento.getImagen());
        nombreDetalle.setText(elemento.getNombre());
        detalleDetalle.setText(elemento.getDetalle());
    }
}




