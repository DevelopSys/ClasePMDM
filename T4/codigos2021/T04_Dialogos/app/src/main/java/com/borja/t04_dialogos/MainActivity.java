package com.borja.t04_dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.borja.t04_dialogos.dialogos.DialogoConfirmacion;
import com.borja.t04_dialogos.dialogos.DialogoInfoApp;

public class MainActivity extends AppCompatActivity {

    Button b,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_informacion:
                DialogoInfoApp dialogoInfoApp = new DialogoInfoApp();
                dialogoInfoApp.show(getSupportFragmentManager(),"TAG1");
                break;
            case R.id.menu_dialogo_info:
                DialogoInfoApp dialogoInfoApp2 = new DialogoInfoApp();
                dialogoInfoApp2.show(getSupportFragmentManager(),"TAG1");
                break;
            case R.id.menu_dialogo_confirmacion:
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(),"TAG2");
                break;
            case R.id.menu_dialogo_lista:
                break;
        }

        return true;
    }

}