package com.borja.t07_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.borja.t07_sqlite.database.HelperDB;
import com.borja.t07_sqlite.database.SchemaDB;
import com.borja.t07_sqlite.fragments.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HelperDB helperDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        agregarDB();
    }

    private void agregarDB() {
        SQLiteDatabase baseDatosAgregar = helperDB.getWritableDatabase();
        // opero
        String queryInsert = "INSERT INTO %s (%s,%s,%s,%s) " +
                "VALUES ('%s','%s','%s',%d)";
        baseDatosAgregar.execSQL(String.format(queryInsert,
                SchemaDB.NOMBRE_TABLA,
                SchemaDB.COL_NOMBRE,
                SchemaDB.COL_APELLIDO,
                SchemaDB.COL_PASS,
                SchemaDB.COL_TELEFONO,
                "Borja","Martin","Pass",1234));
        // cierro
        baseDatosAgregar.close();
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getApplicationContext(),getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        helperDB = new HelperDB(getApplicationContext(), SchemaDB.NOMBRE_DB,null,1);
    }
}
