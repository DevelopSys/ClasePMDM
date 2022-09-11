package com.example.ejercicioliberatorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ejercicioliberatorio.adaptadores.AdaptadorRecycler;
import com.example.ejercicioliberatorio.dialogos.DialogoPerso;
import com.example.ejercicioliberatorio.fragments.FragmentPregunta;
import com.example.ejercicioliberatorio.utils.Pregunta;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnPreguntaListener, DialogoPerso.OnDialogoListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private boolean respuesta = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragments, FragmentPregunta.newInstance("https://opentdb.com/api.php?amount=10&category=21&type=boolean"));
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (item.getItemId()){
            case R.id.menu_games:

                fragmentTransaction.replace(R.id.sitio_fragments, FragmentPregunta.newInstance("https://opentdb.com/api.php?amount=10&category=15&type=boolean"));

                break;
            case R.id.menu_sport:
                fragmentTransaction.replace(R.id.sitio_fragments, FragmentPregunta.newInstance("https://opentdb.com/api.php?amount=10&category=21&type=boolean"));

                break;
            case R.id.menu_tv:
                fragmentTransaction.replace(R.id.sitio_fragments, FragmentPregunta.newInstance("https://opentdb.com/api.php?amount=10&category=11&type=boolean"));

                break;
            case R.id.menu_salir:
                finish();
                break;
        }
        fragmentTransaction.commit();
        return true;
    }

    @Override
    public void onPreguntaSelected(Pregunta pregunta) {
        this.respuesta = pregunta.isRespuesta();
        DialogoPerso dialogoPerso = new DialogoPerso();
        dialogoPerso.show(getSupportFragmentManager(),"test");
    }

    @Override
    public void onDialogoSelect(boolean respuesta) {
        if (respuesta == this.respuesta){
            Toast.makeText(getApplicationContext(), "Has acertado", Toast.LENGTH_SHORT).show();
            Log.v("respuesta","Has acertado");
        } else{
            Toast.makeText(getApplicationContext(), "No has acertado", Toast.LENGTH_SHORT).show();
            Log.v("respuesta","No has acertado");
        }
    }
}