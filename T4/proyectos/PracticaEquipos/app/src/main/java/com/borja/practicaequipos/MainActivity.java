package com.borja.practicaequipos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.borja.practicaequipos.adaptadores.AdaptadorEquipos;
import com.borja.practicaequipos.adaptadores.AdaptadorLigas;
import com.borja.practicaequipos.dataset.DataSet;
import com.borja.practicaequipos.utils.Equipo;
import com.borja.practicaequipos.utils.Jugador;
import com.borja.practicaequipos.utils.Liga;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorLigas.OnLigaSelectedListener,
        AdaptadorEquipos.OnEquipoSelectedListener {

    RecyclerView recyclerLigas, recyclerEquipos;
    AdaptadorLigas adaptadorLigas;
    AdaptadorEquipos adaptadorEquipos;
    ArrayList ligas, equipos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarLigas();
    }

    private void rellenarLigas() {
        ligas = new ArrayList();
        ligas.add(new Liga("LaLigaBBVA", "España", R.drawable.laliga));
        ligas.add(new Liga("Premiere League", "Inglaterra", R.drawable.premiere));
        ligas.add(new Liga("Calcio", "Italia", R.drawable.calcio));
    }

    private void instancias() {
        rellenarLigas();
        recyclerLigas = findViewById(R.id.recycler_ligas);
        adaptadorLigas = new AdaptadorLigas(ligas, MainActivity.this);
        recyclerLigas.setAdapter(adaptadorLigas);
        recyclerLigas.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        recyclerEquipos = findViewById(R.id.recycler_equipos);
        equipos = new ArrayList();
        adaptadorEquipos = new AdaptadorEquipos(equipos, MainActivity.this);
        recyclerEquipos.setAdapter(adaptadorEquipos);
        recyclerEquipos.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

    }

    @Override
    public void onLigaSelected(Liga l) {
        equipos.clear();
        ArrayList<Equipo> listaEquipos = null;
        if (l.getPais().equals("España")){
            listaEquipos = DataSet.newInstance().listaEquiposLiga();
        } else if (l.getPais().equals("Inglaterra")){
            listaEquipos = DataSet.newInstance().listaEquiposPremier();
        } else if (l.getPais().equals("Italia")){
            listaEquipos = DataSet.newInstance().listaEquiposItalia();
        }

        for (Equipo eq:listaEquipos) {
            equipos.add(eq);
        }

        adaptadorEquipos.notifyDataSetChanged();
    }


    @Override
    public void onEquipoSelected(Equipo e) {
        Intent i = new Intent(getApplicationContext(), EquipoActivity.class);
        i.putExtra("equipo",e.getNombre());
        startActivity(i);
    }
}
