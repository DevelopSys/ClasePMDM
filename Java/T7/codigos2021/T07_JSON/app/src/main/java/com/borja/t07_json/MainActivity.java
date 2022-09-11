package com.borja.t07_json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.borja.t07_json.utils.Persona;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Persona> listaPersonas;
    private RecyclerView recyclerPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPersonas = new ArrayList<>();
        realizarPeticion();
    }

    private void procesarPeticion(JSONObject response){
        try {
            JSONArray arrayResultados = response.getJSONArray("results");
            //Log.v("prueba",arrayResultados.toString());
            for (int i=0;i<arrayResultados.length();i++){
                JSONObject persona = arrayResultados.getJSONObject(i);
                String email = persona.getString("email");
                String phone = persona.getString("cell");

                JSONObject nombre = persona.getJSONObject("name");
                String titulo = nombre.getString("title");
                String nombrePersona = nombre.getString("first");
                String apellidoPersona = nombre.getString("last");
                JSONObject imagen = persona.getJSONObject("picture");
                String imagenPersona = imagen.getString("large");
                Persona personaAgregar = new Persona(nombrePersona,apellidoPersona,email,phone,imagenPersona);
                //listaPersonas.add(personaAgregar);
                adaptador.addPersonas(personas);
                public void addPersona(Persona p){
                    this.lista.add(p);
                    this.notify();
                }
            }


            // crear un objeto de tipo persona Nombre, apellido, telefono, email, imagen (string con glide)
            // crear una lista de todas las personas que estan en el JSON

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void realizarPeticion() {

        String url = "https://randomuser.me/api/?results=100";

        // petición volley

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                procesarPeticion(response);
                Toast.makeText(getApplicationContext(),"Personas "+listaPersonas.size(),Toast.LENGTH_SHORT).show();
                adaptador = new Adaptador(MainActivity.this);
                recyclerPersonas.setAdapter(adaptador);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("prueba","error");
            }
        });

        // pila volley

        RequestQueue request = Volley.newRequestQueue(getApplicationContext());
        request.add(jsonObjectRequest);
    }


}