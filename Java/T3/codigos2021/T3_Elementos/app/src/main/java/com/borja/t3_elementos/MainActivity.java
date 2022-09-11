package com.borja.t3_elementos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnBotones, btnOtros, btnListas, btnListasPerso, btnRecycler, btnRecyclerCoches;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // pone un menú en la ActionBar
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // indica que opcion del menú (colocado en la ActionBar) ha sido seleccionada

        Intent i = null;

        switch (item.getItemId()) {
            case R.id.menu_opcion_botones:
                i = new Intent(getApplicationContext(), BotonesActivity.class);
                break;
            case R.id.menu_opcion_otros:
                i = new Intent(getApplicationContext(), OtrosActivity.class);

                break;
            case R.id.menu_opcion_listas:
                i = new Intent(getApplicationContext(), ListasActivity.class);

                break;
            case R.id.menu_opcion_listas_perso:
                i = new Intent(getApplicationContext(), ListasPersoActivity.class);

                break;
            case R.id.menu_opcion_recycler:
                i = new Intent(getApplicationContext(), RecyclerActivity.class);

                break;
            case R.id.menu_opcion_recycler_coche:
                i = new Intent(getApplicationContext(), RecyclerCochesActivity.class);

                break;
        }

        startActivity(i);

        return true;
    }

    private void acciones() {
        btnBotones.setOnClickListener(this);
        btnOtros.setOnClickListener(this);
        btnListas.setOnClickListener(this);
        btnListasPerso.setOnClickListener(this);
        btnRecycler.setOnClickListener(this);
        btnRecyclerCoches.setOnClickListener(this);
    }

    private void instancias() {
        btnBotones = findViewById(R.id.boton_act_botones);
        btnOtros = findViewById(R.id.boton_act_otros);
        btnListas = findViewById(R.id.boton_act_listas);
        btnListasPerso = findViewById(R.id.boton_act_listas_perso);
        btnRecycler = findViewById(R.id.boton_act_recycler);
        btnRecyclerCoches = findViewById(R.id.boton_recycler_coches);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.boton_act_botones:
                intent = new Intent(getApplicationContext(), BotonesActivity.class);
                break;
            case R.id.boton_act_otros:
                intent = new Intent(getApplicationContext(), OtrosActivity.class);
                break;
            case R.id.boton_act_listas:
                intent = new Intent(getApplicationContext(), ListasActivity.class);
                break;
            case R.id.boton_act_listas_perso:
                intent = new Intent(getApplicationContext(), ListasPersoActivity.class);
                //imagen.setImageResource(R.drawable.add);
                //imagen.setImageDrawable(getResources().getDrawable(R.drawable.add,null));
                break;

            case R.id.boton_act_recycler:
                intent = new Intent(getApplicationContext(), RecyclerActivity.class);
                //imagen.setImageResource(R.drawable.add);
                //imagen.setImageDrawable(getResources().getDrawable(R.drawable.add,null));
                break;

            case R.id.boton_recycler_coches:
                intent = new Intent(getApplicationContext(), RecyclerCochesActivity.class);
                //imagen.setImageResource(R.drawable.add);
                //imagen.setImageDrawable(getResources().getDrawable(R.drawable.add,null));
                break;
        }

        startActivity(intent);

    }
}