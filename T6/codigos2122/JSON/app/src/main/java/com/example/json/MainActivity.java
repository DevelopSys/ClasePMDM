package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                                Log.v("resultado",nombre);
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