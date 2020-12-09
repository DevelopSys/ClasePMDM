package com.borja.t04_dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.borja.t04_dialogos.dialogos.DialogoConfirmacion;
import com.borja.t04_dialogos.dialogos.DialogoFecha;
import com.borja.t04_dialogos.dialogos.DialogoInfoApp;
import com.borja.t04_dialogos.dialogos.DialogoLista;
import com.borja.t04_dialogos.dialogos.DialogoMultiple;
import com.borja.t04_dialogos.dialogos.DialogoSingle;
import com.borja.t04_dialogos.utils.Equipo;

public class MainActivity extends AppCompatActivity implements DialogoConfirmacion.OnDialogoConfirmacion,
        DialogoLista.OnDialogoLista, DialogoSingle.OnDialogoSingle, DatePickerDialog.OnDateSetListener {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();

    }

    private void instancias() {
        textView = findViewById(R.id.contestacion_dialogo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_informacion:
                DialogoInfoApp dialogoInfoApp = new DialogoInfoApp();
                dialogoInfoApp.show(getSupportFragmentManager(), "TAG1");
                break;
            case R.id.menu_dialogo_info:
                DialogoInfoApp dialogoInfoApp2 = new DialogoInfoApp();
                dialogoInfoApp2.show(getSupportFragmentManager(), "TAG1");
                break;
            case R.id.menu_dialogo_confirmacion:
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(), "TAG2");
                break;
            case R.id.menu_dialogo_lista:

                DialogoLista dialogoLista = new DialogoLista();
                dialogoLista.show(getSupportFragmentManager(), "lista");
                break;

            case R.id.menu_dialogo_single:
                DialogoSingle dialogoSingle = new DialogoSingle();
                dialogoSingle.show(getSupportFragmentManager(), "single");
                break;

            case R.id.menu_dialogo_multiple:
                /*DialogoMultiple dialogoMultiple = new DialogoMultiple();
                dialogoMultiple.show(getSupportFragmentManager(),"multiple");*/

                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(),"fecha");
                break;
        }

        return true;
    }

    @Override
    public void onDialogoConfirmacionSelected(String confirmacion) {
        textView.setText(confirmacion);
    }

    @Override
    public void onDialogoListaSelectect(String opcion) {
        textView.setText(opcion);
    }

    @Override
    public void onDialogoSingleListener(String opcion) {
        textView.setText(opcion);
    }

    @Override
    public void onDialogoSingleEquipoListener(Equipo equipo) {
        textView.setText(equipo.getNombre());

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }
}