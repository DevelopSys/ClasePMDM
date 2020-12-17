package com.borja.t04_dialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.borja.t04_dialogos.dialogos.DialogoComunicar;
import com.borja.t04_dialogos.dialogos.DialogoConfirmacion;
import com.borja.t04_dialogos.dialogos.DialogoFecha;
import com.borja.t04_dialogos.dialogos.DialogoHora;
import com.borja.t04_dialogos.dialogos.DialogoInfoApp;
import com.borja.t04_dialogos.dialogos.DialogoLista;
import com.borja.t04_dialogos.dialogos.DialogoMultiple;
import com.borja.t04_dialogos.dialogos.DialogoPersonalizado;
import com.borja.t04_dialogos.dialogos.DialogoSingle;
import com.borja.t04_dialogos.utils.Equipo;

public class MainActivity extends AppCompatActivity implements DialogoConfirmacion.OnDialogoConfirmacion,
        DialogoLista.OnDialogoLista, DialogoSingle.OnDialogoSingle,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener,
        DialogoPersonalizado.OnDialogoPersoListener {

    private TextView textView;
    private String user = "borja", pass = "1234";

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
                DialogoMultiple dialogoMultiple = new DialogoMultiple();
                dialogoMultiple.show(getSupportFragmentManager(), "multiple");
                break;

            case R.id.menu_dialogo_fecha:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(), "fecha");
                break;

            case R.id.menu_dialogo_hora:

                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(), "hora");
                break;

            case R.id.menu_dialogo_perso:

                //DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
                //dialogoPersonalizado.show(getSupportFragmentManager(), "perso");

                //DialogoComunicar dialogoComunicar = DialogoComunicar.newInstance("Nuevo titulo");

                DialogoComunicar dialogoComunicar = new DialogoComunicar();
                dialogoComunicar.show(getSupportFragmentManager(),"comunicar");

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
        textView.setText(String.format("%d/%d/%d", i2, i1 + 1, i));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        textView.setText(String.format("%d;%d", i, i1));
    }

    @Override
    public void onDialogoPersoSelected(String user, String pass, boolean check) {
        if (this.user.toLowerCase().equals(user.toLowerCase()) && this.pass.equals(pass)) {
            if (check) {
                textView.setText("Login correcto, usuario recordado");
            } else {
                textView.setText("Login correcto");
            }
        } else {
            textView.setText("Login incorrecto");
        }

    }
}



















