package com.system.develop.t2_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.system.develop.t2_cardview.utils.Juego;

public class SecondActivity extends AppCompatActivity {

    TextView nombre;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void instancias() {
        nombre = findViewById(R.id.textoNombre);
        imagen = findViewById(R.id.imagenDetalle);
    }

    private void recuperarDatos() {
        Juego juego = (Juego) getIntent().getSerializableExtra(MainActivity.TAG_JUEGO);
        nombre.setText(juego.getNombre());
        imagen.setImageResource(juego.getImagen());
    }
}
