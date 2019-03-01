package com.system.develop.t5_examenbd.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.system.develop.t5_examenbd.R;
import com.system.develop.t5_examenbd.adaptadores.RecyclerAdapter;
import com.system.develop.t5_examenbd.basedatos.DatosBD;
import com.system.develop.t5_examenbd.basedatos.HelperDB;
import com.system.develop.t5_examenbd.utils.Alumno;

import java.util.ArrayList;

public class FragmentLista extends Fragment {


    View v;
    RecyclerView recyclerView;
    ArrayList lista;
    static String TAG_CURSO = "curso";

    public static FragmentLista newInstance(String curso) {
        Bundle args = new Bundle();
        args.putString(TAG_CURSO, curso);
        FragmentLista fragment = new FragmentLista();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            lista = new ArrayList();
            String curso = getArguments().getString(TAG_CURSO);
            HelperDB helperDB = new HelperDB(context, DatosBD.DB_NAME, null, 1);
            SQLiteDatabase database = helperDB.getReadableDatabase();
            String query = "SELECT %s,%s FROM %s WHERE %s='%s'";
            Cursor c = database.rawQuery(String.format(query, DatosBD.TAB_ALU_COL_NOM, DatosBD.TAB_ALU_COL_AP,
                    DatosBD.TAB_ALU, DatosBD.TAB_ALU_COL_CICL, curso), null);
            if (c != null) {
                while (c.moveToNext()) {
                    String nom = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_NOM));
                    String ape = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_AP));
                    lista.add(new Alumno(nom, ape));
                }
            }

            database.close();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = v.findViewById(R.id.recycler);
        recyclerView.setAdapter(new RecyclerAdapter(getContext(),lista));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        return v;
    }
}
