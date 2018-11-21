package com.system.develop.t2_cardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.system.develop.t2_cardview.adaptadores.AdaptadorRecycler;
import com.system.develop.t2_cardview.utils.Juego;

public class MainActivity extends AppCompatActivity implements AdaptadorRecycler.OnRecyclerListener {

    RecyclerView recyclerView;
    final static String TAG_JUEGO ="juego";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        contruirRecycler();
    }

    private void contruirRecycler() {
        AdaptadorRecycler adaptadorRecycler = new AdaptadorRecycler(this);
        recyclerView.setAdapter(adaptadorRecycler);
        //recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),
        //        2,LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recyclerJuegos);
    }

    @Override
    public void onJuegoSelected(Juego juego) {
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        intent.putExtra(TAG_JUEGO,juego);
        startActivity(intent);
    }
}
