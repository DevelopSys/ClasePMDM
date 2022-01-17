package com.example.peticionesjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.peticionesjson.fragments.FragmentLista;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragments,new FragmentLista());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        /*String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
        JsonObjectRequest peticionJSON = new JsonObjectRequest(1,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.v("peticion",response.toString());
                        procesarPeticion(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("peticion","peticion incorrecta");
            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(peticionJSON);*/

    }

    private void procesarPeticion(JSONObject response) {
        try {
            JSONArray arrayResultado = response.getJSONArray("teams");
            for (int i = 0; i < arrayResultado.length(); i++) {
                JSONObject equipo = arrayResultado.getJSONObject(i);
                String nombre = equipo.getString("strTeam");
                Log.v("peticion",nombre);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}