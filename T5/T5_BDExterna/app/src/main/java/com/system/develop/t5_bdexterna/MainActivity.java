package com.system.develop.t5_bdexterna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bInsertar, bConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bConsultar = findViewById(R.id.consultar);
        bInsertar = findViewById(R.id.insertar);
        bConsultar.setOnClickListener(this);
        bInsertar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.consultar:
                String url = "http://192.168.64.2/colegio/seleccion.php";
                Volley.newRequestQueue(getApplicationContext())
                        .add(new JsonObjectRequest(Request.Method.GET,
                                url,
                                null,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Log.v("volleytag", response.toString());
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }));
                break;
            case R.id.insertar:
                HashMap mapaDatos = new HashMap();
                mapaDatos.put("nombre", "NombreInsertado");
                mapaDatos.put("apellidos", "ApellidoInsertado");
                mapaDatos.put("correo", "CorreoInsertado");
                JSONObject jsonObject = new JSONObject(mapaDatos);

                String urlInsertar = "http://192.168.64.2/colegio/insercion.php";


                Volley.newRequestQueue(getApplicationContext()).add(
                        new JsonObjectRequest(Request.Method.POST,
                                urlInsertar,
                                jsonObject,
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        // Procesar la respuesta Json
                                        try {
                                            Log.v("volleytag", response.getString("mensaje"));
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.d("Volley", "Error Volley: " + error.getMessage());
                                    }
                                })
                );


                break;
        }
    }
}
