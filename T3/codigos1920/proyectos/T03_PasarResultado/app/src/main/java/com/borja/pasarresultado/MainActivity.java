package com.borja.pasarresultado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button botonImagen, botonAgregar;
    ImageView imagen;
    EditText textoAgregar, textoNombre;
    ArrayList<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {

        botonImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*int numero = (int) (Math.random() * 6) + 1;
                int[]posibilidades = {R.drawable.dado_cinco,R.drawable.dado_cuatro};
                //imagen.setImageDrawable(getResources().getDrawable(R.drawable.dado_cinco, null));
                imagen.setImageResource(posibilidades[1]);*/
                /*int numero = (int)(Math.random()*nombres.size());
                String nombreGanador = nombres.get(numero);
                Toast.makeText(getApplicationContext(),nombreGanador,Toast.LENGTH_SHORT).show();*/
                setResult(InicialActivity.RES_COD, new Intent());
                finish();

            }
        });
        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = textoAgregar.getText().toString();
                textoAgregar.setText("");
                nombres.add(nombre);
                textoNombre.append(nombre+"\n");

            }
        });
    }

    private void instancias() {
        botonImagen = findViewById(R.id.boton_tirada);
        botonAgregar = findViewById(R.id.boton_agregar);
        imagen = findViewById(R.id.imagenDados);
        textoAgregar = findViewById(R.id.texto_agregar);
        textoNombre = findViewById(R.id.texto_nombres);
        nombres = new ArrayList<>();
    }
}
