package com.system.develop.t3_menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button botonUno, botonDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonUno = findViewById(R.id.boton1);
        botonDos = findViewById(R.id.boton2);
        registerForContextMenu(botonUno);
        registerForContextMenu(botonDos);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()) {
            case R.id.boton1:
                getMenuInflater().inflate(R.menu.menu_contextual, menu);
                break;
            case R.id.boton2:
                getMenuInflater().inflate(R.menu.menu_contextual_dos, menu);
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion_menu1:
                Toast.makeText(getApplicationContext(), "Pulsado elemento 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu2:
                Toast.makeText(getApplicationContext(), "Pulsado elemento 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu3:
                Toast.makeText(getApplicationContext(), "Pulsado elemento 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu_sub:
                Toast.makeText(getApplicationContext(), "Pulsado elemento sub", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusub1:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusub2:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu1_ctx:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu1_ctx_dos:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
