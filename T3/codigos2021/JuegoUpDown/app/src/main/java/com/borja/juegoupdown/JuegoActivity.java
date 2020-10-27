package com.borja.juegoupdown;

import androidx.appcompat.app.AppCompatActivity;

import android.net.LinkAddress;
import android.os.Bundle;
import android.widget.LinearLayout;

public class JuegoActivity extends AppCompatActivity {


    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
       // linear.setBackgroundResource(R.drawable.fondo_cartas);
    }
}