package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnUp, btnDown;
    private ImageView imagenCarta;
    private int[] cartas;
    private int numeroActual, numeroFuturo, aciertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        instancias();
        acciones();
    }

    private void acciones() {
        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
    }

    private void instancias() {
        btnDown = findViewById(R.id.btn_down);
        btnUp = findViewById(R.id.btn_up);
        imagenCarta = findViewById(R.id.fondo_carta);
        cartas = new int[]{R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5,
                R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10,
                R.drawable.c11, R.drawable.c12, R.drawable.c13};

        numeroActual = (int) (Math.random()*13);

        imagenCarta.setImageResource(cartas[numeroActual]);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_down:
                // pregunto si el número con el que juego es más pequeño que el que está puesto
                numeroFuturo = (int) (Math.random()*13);
                if (numeroActual>numeroFuturo){
                    aciertos++;
                    numeroActual=numeroFuturo;
                    imagenCarta.setImageResource(cartas[numeroActual]);

                } else {
                    Intent intent = new Intent();
                    intent.putExtra("record",aciertos);
                    setResult(0,intent);
                    finish();
                }

                break;
            case R.id.btn_up:
                // pregunto si el número con el que juego es más grade que el que está puesto
                numeroFuturo = (int) (Math.random()*13);
                if (numeroActual<numeroFuturo){
                    aciertos++;
                    numeroActual=numeroFuturo;
                    imagenCarta.setImageResource(cartas[numeroActual]);

                }else {
                    Intent intent = new Intent();
                    intent.putExtra("record",aciertos);
                    setResult(0,intent);
                    finish();
                }


                break;
        }
    }
}
