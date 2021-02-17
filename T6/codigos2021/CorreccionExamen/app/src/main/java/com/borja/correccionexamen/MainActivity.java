package com.borja.correccionexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.borja.correccionexamen.fragments.AddFragment;
import com.borja.correccionexamen.fragments.ListFragment;
import com.borja.correccionexamen.utils.Persona;

public class MainActivity extends AppCompatActivity implements AddFragment.OnElementoAddListener {

    private Toolbar toolbar;
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        configurToolbar();


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.sitio_master,new ListFragment(),"list");
        ft.addToBackStack(null);
        ft.commit();

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.sitio_master,new AddFragment(),"add");
        ft.addToBackStack(null);
        ft.commit();

    }

    private void configurToolbar() {
        setSupportActionBar(toolbar);
    }

    private void instancias() {
        toolbar= findViewById(R.id.toobar);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
     switch (item.getItemId()){
         case R.id.menu_ver_lista:
             fm = getSupportFragmentManager();

             FragmentManager.BackStackEntry bk = getSupportFragmentManager().getBackStackEntryAt(8);
             ListFragment listFragment = (ListFragment) fm.findFragmentByTag("list");
             ft = fm.beginTransaction();
             ft.replace(R.id.sitio_master,listFragment,"list");
             ft.addToBackStack(null);
             ft.commit();
             break;
     }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public void onElementoAdd(Persona persona) {
        // añadir persona a la lista de fragment list
        // en el fragment que ya está. añadelo a su lista
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag("list");
        listFragment.addPersona(persona);

    }
}