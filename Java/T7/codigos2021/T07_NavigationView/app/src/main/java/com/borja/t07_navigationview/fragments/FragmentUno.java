package com.borja.t07_navigationview.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borja.t07_navigationview.R;
import com.borja.t07_navigationview.adaptadores.HobbiesAdapter;
import com.borja.t07_navigationview.database.DataSet;
import com.borja.t07_navigationview.utils.Hobbie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentUno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentUno extends Fragment {


    private RecyclerView recycler;
    private HobbiesAdapter adapter;
    private ArrayList<Hobbie> listaHobbies;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "detalle";


    // TODO: Rename and change types of parameters
    private String detalle;

    public FragmentUno() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentUno newInstance(String detalle) {
        FragmentUno fragment = new FragmentUno();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, detalle);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //listaHobbies = DataSet.newInstance().getListaFiltrada("futbol");
        /*listaHobbies.add(new Hobbie("Barsa", "futbol", R.drawable.barsa));
        listaHobbies.add(new Hobbie("Champion", "futbol", R.drawable.champion));
        listaHobbies.add(new Hobbie("España", "futbol", R.drawable.espania));
        listaHobbies.add(new Hobbie("Madrid", "futbol", R.drawable.madrid));
        listaHobbies.add(new Hobbie("Milan", "futbol", R.drawable.milan));
        listaHobbies.add(new Hobbie("Big Bang Theory", "pelicula", R.drawable.big));
        listaHobbies.add(new Hobbie("Stranger Things", "pelicula", R.drawable.stranger));
        listaHobbies.add(new Hobbie("Malditos", "pelicula", R.drawable.malditos));
        listaHobbies.add(new Hobbie("Perdidos", "pelicula", R.drawable.lost));
        listaHobbies.add(new Hobbie("Fifa 19", "juego", R.drawable.fifa19));
        listaHobbies.add(new Hobbie("GTA", "juego", R.drawable.gta));
        listaHobbies.add(new Hobbie("The last of us", "juego", R.drawable.last));*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            detalle = getArguments().getString(ARG_PARAM1);
            listaHobbies = DataSet.newInstance().getListaFiltrada(detalle);
        } else {
            listaHobbies = DataSet.newInstance().getListaCompleta();
        }
        adapter = new HobbiesAdapter(getContext(), listaHobbies);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_uno, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recycler = getView().findViewById(R.id.recycler_hobbies);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        recycler.setAdapter(adapter);
    }
}