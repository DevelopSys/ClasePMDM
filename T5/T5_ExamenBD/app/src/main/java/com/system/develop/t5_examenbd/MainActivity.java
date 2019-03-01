package com.system.develop.t5_examenbd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.system.develop.t5_examenbd.basedatos.DatosBD;
import com.system.develop.t5_examenbd.basedatos.HelperDB;
import com.system.develop.t5_examenbd.fragments.FragmentLista;
import com.system.develop.t5_examenbd.utils.Alumno;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    NavigationView navigationView;
    Spinner spinner;
    DrawerLayout drawerLayout;
    HelperDB helperDB;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarSpinner();
        setSupportActionBar(toolbar);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.opcionMenu:
                        //TODO agregar a base de datos
                        agregarAlumno(new Alumno("NombreASIR","Apellido","ASIR"));
                        agregarAlumno(new Alumno("NombreASIR", "Apellido", "ASIR"));
                        agregarAlumno(new Alumno("NombreASIR", "Apellido", "ASIR"));
                        agregarAlumno(new Alumno("NombreDAM", "Apellido", "DAM"));
                        agregarAlumno(new Alumno("NombreDAM", "Apellido", "DAM"));
                        agregarAlumno(new Alumno("NombreDAM", "Apellido", "DAM"));
                        agregarAlumno(new Alumno("NombreAF", "Apellido", "AF"));
                        agregarAlumno(new Alumno("NombreAF", "Apellido", "AF"));
                        agregarAlumno(new Alumno("NombreAF", "Apellido", "AF"));
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                        return false;
                }
            }
        });
        acciones();
    }

    private void agregarAlumno(Alumno alumno) {
        database = helperDB.getWritableDatabase();
        String query = "INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')";
        database.execSQL(String.format(query,DatosBD.TAB_ALU,DatosBD.TAB_ALU_COL_NOM,DatosBD.TAB_ALU_COL_AP
                ,DatosBD.TAB_ALU_COL_CICL,alumno.getNombre(), alumno.getApellido(), alumno.getCurso()));
        database.close();
        rellenarSpinner();
    }

    private void acciones() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String curso = spinner.getAdapter().getItem(position).toString();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.sitioFragments, FragmentLista.newInstance(curso));
                ft.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void rellenarSpinner() {
        ArrayList lista = new ArrayList();
        database = helperDB.getReadableDatabase();
        String query = "SELECT DISTINCT %s FROM %s";
        Cursor cursor = database.rawQuery(String.format(query, DatosBD.TAB_ALU_COL_CICL, DatosBD.TAB_ALU), null);
        if (cursor != null) {
            //cursor.moveToFirst();
            while (cursor.moveToNext()) {
                String curso = cursor.getString(cursor.getColumnIndex(DatosBD.TAB_ALU_COL_CICL));
                lista.add(curso);
            }
        }

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(getApplicationContext(),
                android.R.layout.simple_spinner_item, lista);
        spinner.setAdapter(adapter);
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        spinner = findViewById(R.id.spinnerCurso);
        drawerLayout = findViewById(R.id.drawerLayout);
        helperDB = new HelperDB(getApplicationContext(), DatosBD.DB_NAME, null, 1);
    }
}