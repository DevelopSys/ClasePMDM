package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.json.adapters.AdaptadorJSON;
import com.example.json.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorJSON adaptadorJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        adaptadorJSON = new AdaptadorJSON(MainActivity.this);
        recyclerView.setAdapter(adaptadorJSON);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));

        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
        JsonObjectRequest jsonRequest = new JsonObjectRequest(1,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray arrayEquipos = response.getJSONArray("teams");
                            for (int i = 0; i < arrayEquipos.length(); i++) {
                                JSONObject equipo =  arrayEquipos.getJSONObject(i);
                                String nombre = equipo.getString("strTeam");
                                String id = equipo.getString("idTeam");
                                String anio = equipo.getString("intFormedYear");
                                String escudo = equipo.getString("strTeamBadge");
                                String  estadio = equipo.getString("strStadium");
                                Equipo equipo1 = new Equipo(id,nombre,anio, estadio, escudo);
                                adaptadorJSON.agregarEquipo(equipo1);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //Log.v("resultado",response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(jsonRequest);
    }
}