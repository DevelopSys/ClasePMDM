package com.borja.t06navigation;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.borja.t06navigation.adaptadores.AdaptadorEquipos;
import com.borja.t06navigation.utils.Equipo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentEquipos extends Fragment {

    private RecyclerView recyclerView;
    private AdaptadorEquipos adaptadorEquipos;
    private int id = 4335;
    private String url = "https://www.thesportsdb.com/api/v1/json/1/lookup_all_teams.php?id=";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        adaptadorEquipos = new AdaptadorEquipos(context);
        url = url+id;
    }

    @Nullable







    
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_equipos,container,false);
        recyclerView = v.findViewById(R.id.recycler_equipos);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        realizarConsulta();
        recyclerView.setAdapter(adaptadorEquipos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));


    }

    private void realizarConsulta() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("teams");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                String nombre = object.getString("strTeam");
                                String escudo = object.getString("strTeamBadge");
                                Equipo equipo = new Equipo(nombre,escudo);
                                adaptadorEquipos.agregarEquipo(equipo);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);
    }
}
