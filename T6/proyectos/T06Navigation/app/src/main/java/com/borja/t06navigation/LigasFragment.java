package com.borja.t06navigation;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.borja.t06navigation.adaptadores.AdaptadorLigas;
import com.borja.t06navigation.utils.Liga;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LigasFragment extends Fragment {


    private RecyclerView lista;
    private ArrayList<Liga> listaLigas;
    AdaptadorLigas adaptadorLigas;

    public LigasFragment() {
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        adaptadorLigas = new AdaptadorLigas(getContext());
        listaLigas = new ArrayList();
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ligas, container, false);
        lista = v.findViewById(R.id.lista_completa);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        JsonObjectRequest peticionJson = new JsonObjectRequest(Request.Method.GET,
                "https://www.thesportsdb.com/api/v1/json/1/all_leagues.php", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // Log.v("volley",response.toString());
                try {
                    JSONArray jsonArray = response.getJSONArray("leagues");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String deporte = jsonObject.getString("strSport");
                        String nombre = jsonObject.getString("strLeague");
                        int id = jsonObject.getInt("idLeague");
                        if (deporte.toLowerCase().equals("soccer") && deporte.toLowerCase().length()>0){
                            //Log.v("volley",nombre);
                            Liga liga = new Liga(id,nombre);
                            adaptadorLigas.agregarElemento(liga);
                        }

                        Log.v("volley", String.valueOf(listaLigas.size()));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("volley","Error en la conexion asdfghjklkjhgfdsasdfghj");
            }
        });
        Volley.newRequestQueue(getContext()).add(peticionJson);
        lista.setAdapter(adaptadorLigas);
        lista.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }
}
