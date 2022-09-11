package com.borja.t07_sqlite.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t07_sqlite.R;
import com.borja.t07_sqlite.adaptadores.ConsultaAdapter;
import com.borja.t07_sqlite.database.HelperDB;
import com.borja.t07_sqlite.database.SchemaDB;
import com.borja.t07_sqlite.utils.Usuario;

public class ConsultarFragment extends Fragment {

    private RecyclerView recyclerView;
    private HelperDB helperDB;
    private ConsultaAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        helperDB = new HelperDB(context, SchemaDB.NOMBRE_DB,null,1);
        adapter = new ConsultaAdapter(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_consulta, container,false);
        recyclerView = v.findViewById(R.id.recycler_consulta);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SQLiteDatabase baseDatos = helperDB.getReadableDatabase();
        String queryConsulta = "SELECT * FROM %s";
        String queryConsultaLogin = "SELECT * FROM %s WHERE %s = '%s' AND %s = '%s'";
        Cursor resultados = baseDatos.rawQuery(String.format(queryConsulta,SchemaDB.NOMBRE_TABLA),
                null);

        Cursor resultadosLogin = baseDatos.rawQuery(String.format(queryConsulta,SchemaDB.NOMBRE_TABLA,SchemaDB.COL_NOMBRE,"nombre",SchemaDB.COL_PASS,"pass"),
                null);

        int elementos=0;
        if (resultadosLogin.getCount()>0){
            // HAZ LOGIN
        };
        while (resultadosLogin.moveToNext()){
            elementos++;
        }
        if (elementos>0){
            // HAZ LOGIN
        }

        while (resultados.moveToNext()){
            String nombre = resultados.getString(resultados.getColumnIndex(SchemaDB.COL_NOMBRE));
            String apellido = resultados.getString(resultados.getColumnIndex(SchemaDB.COL_APELLIDO));
            int telefono = resultados.getInt(resultados.getColumnIndex(SchemaDB.COL_TELEFONO));
            Usuario u = new Usuario(nombre,apellido,telefono);
            adapter.agregarUsuario(u);
            Log.v("testdb",u.getNombre());
        }

        resultados.close();
        baseDatos.close();
    }
}
