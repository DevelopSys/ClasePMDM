package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.json.utils.Equipo;

public class SecondActivity extends AppCompatActivity {

    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imagen = findViewById(R.id.imagen_recepcion);

        if (getIntent().getExtras()!=null){
            Equipo equipo = (Equipo) getIntent().getExtras().getSerializable("equipo");
            Glide.with(getApplicationContext()).load(equipo.getEscudo()).placeholder(R.drawable.escudo).into(imagen);
        }

    }
}