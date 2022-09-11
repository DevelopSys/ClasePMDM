package com.example.peticionesjson.fragments;

import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.peticionesjson.R;
import com.example.peticionesjson.adaptadores.AdaptadorEquipos;
import com.example.peticionesjson.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentLista extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private AdaptadorEquipos adaptadorEquipos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(getContext()).inflate(R.layout.fragment_lista, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        instancias();
        asociarDatos();
        realizarPeticion();
    }

    private void realizarPeticion() {

        String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);


        //adaptadorEquipos.notifyDataSetChanged();
    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray equipos = response.getJSONArray("teams");
            for (int i = 0; i < equipos.length(); i++) {
                JSONObject equipo = equipos.getJSONObject(i);
                String nombre = equipo.getString("strTeam");
                String estadio = equipo.getString("strStadium");
                String imagen = equipo.getString("strTeamBadge");
                String id = equipo.getString("idTeam");
                String detalle = equipo.getString("strDescriptionEN");
                Equipo equipoActual = new Equipo(nombre,estadio, imagen,id,detalle);
                adaptadorEquipos.agregarEquipo(equipoActual);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void asociarDatos() {
        recyclerView.setAdapter(adaptadorEquipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void instancias() {

        recyclerView = view.findViewById(R.id.lista_equipos);
        adaptadorEquipos = new AdaptadorEquipos(getContext());
    }
}
