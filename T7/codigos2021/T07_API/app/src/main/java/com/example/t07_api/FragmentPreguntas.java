package com.example.t07_api;

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

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentPreguntas extends Fragment {


    private View view;
    private RecyclerView recycler;
    private AdaptadorPreguntas adaptador;
    private String numero;

    public static FragmentPreguntas newInstance(String numero) {

        Bundle args = new Bundle();
        FragmentPreguntas fragment = new FragmentPreguntas();
        args.putString("numero",numero);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getArguments() != null){
            this.numero = getArguments().getString("numero");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        recycler = view.findViewById(R.id.recycler);
        adaptador = new AdaptadorPreguntas(getActivity());
        recycler.setAdapter(adaptador);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        String url = "https://opentdb.com/api.php?amount=10&category="+numero+"&type=boolean";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray arrayResultados = response.getJSONArray("results");
                    for (int i = 0; i < arrayResultados.length(); i++) {
                        JSONObject preguntaJSON = arrayResultados.getJSONObject(i);
                        String question = preguntaJSON.getString("question");
                        boolean respuesta = Boolean.parseBoolean(preguntaJSON.getString("correct_answer").toLowerCase());
                        Pregunta pregunta = new Pregunta(question, respuesta);
                        adaptador.addPregunta(pregunta);
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
