package com.borja.t06navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private SwitchCompat switchCompat;
    private String urlPeticion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
        peticionInicial();
    }

    private void peticionInicial() {

        JsonObjectRequest peticionJson = new JsonObjectRequest(Request.Method.GET,
                urlPeticion, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("volley",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("volley","Error en la conexion");
            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(peticionJson);

    }

    private void acciones() {


        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Toast.makeText(getApplicationContext(),String.valueOf(b),Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_competiciones:
                        textView.setText("Competiciones");
                        break;
                    case R.id.liga_ale_nav:
                        textView.setText("Bundesliga");
                        break;
                    case R.id.liga_esp_nav:
                        textView.setText("LaLiga");
                        break;
                    case R.id.liga_ing_nav:
                        textView.setText("Premiere");
                        break;
                }

                drawerLayout.closeDrawers();

                return true;
            }
        });
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        switchCompat = (SwitchCompat) navigationView.getMenu()
                .findItem(R.id.switch_nav).getActionView();
        textView = navigationView.getHeaderView(0)
                .findViewById(R.id.texto_header);
        urlPeticion = "https://www.thesportsdb.com/api/v1/json/1/all_leagues.php";
    }
}
