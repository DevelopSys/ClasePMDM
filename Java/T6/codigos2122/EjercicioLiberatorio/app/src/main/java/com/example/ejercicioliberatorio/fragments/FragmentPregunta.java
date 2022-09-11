package com.example.ejercicioliberatorio.fragments;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ejercicioliberatorio.R;
import com.example.ejercicioliberatorio.adaptadores.AdaptadorRecycler;
import com.example.ejercicioliberatorio.utils.Pregunta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FragmentPregunta extends Fragment {

    private RecyclerView recyclerView;
    private View view;
    private String url = "https://opentdb.com/api.php?amount=10&category=21&type=boolean";
    private AdaptadorRecycler adaptadorRecycler;

    public static FragmentPregunta newInstance(String url) {

        Bundle args = new Bundle();
        args.putString("url",url);

        FragmentPregunta fragment = new FragmentPregunta();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        adaptadorRecycler = new AdaptadorRecycler(context);
        this.url = getArguments().getString("url");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout, container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        recyclerView = view.findViewById(R.id.recycler_preguntas);
        recyclerView.setAdapter(adaptadorRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        JsonObjectRequest request = new JsonObjectRequest(1, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray("results");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject preguntaJson = array.getJSONObject(i);
                        if (preguntaJson.getString("type").equals("boolean")){
                            String question = preguntaJson.getString("question");
                            boolean correct = Boolean.parseBoolean(preguntaJson.getString("correct_answer"));
                            Pregunta pregunta = new Pregunta(question, correct);
                            adaptadorRecycler.addPregunta(pregunta);
                        }


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
        Volley.newRequestQueue(getContext()).add(request);

    }
}
