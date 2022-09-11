package com.borja.t6_bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.borja.t6_bottomnav.fragments.DosFragment;
import com.borja.t6_bottomnav.fragments.TresFragment;
import com.borja.t6_bottomnav.fragments.UnoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView navigation;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.opcion1:
                        ft.replace(R.id.sitio_fragments,new UnoFragment());
                        break;
                    case R.id.opcion2:
                        ft.replace(R.id.sitio_fragments,new DosFragment());
                        break;
                    case R.id.opcion3:
                        ft.replace(R.id.sitio_fragments,new TresFragment());
                        break;
                }
                ft.commit();
                return false;
            }
        });
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        navigation = findViewById(R.id.bottom_nav);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setTitle("asdasdasd");


    }
}
