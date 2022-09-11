package com.example.dialogos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dialogos.dialogos.DialogoComunicacion;
import com.example.dialogos.dialogos.DialogoConfirmacion;
import com.example.dialogos.dialogos.DialogoFecha;
import com.example.dialogos.dialogos.DialogoHora;
import com.example.dialogos.dialogos.DialogoInformacion;
import com.example.dialogos.dialogos.DialogoListas;
import com.example.dialogos.dialogos.DialogoLogin;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoListener,
        TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();

    }

    private void instancias() {
        /*fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        switch (item.getItemId()) {
            case R.id.menu_op1:
                // Toast.makeText(getApplicationContext(), "Opcion 1", Toast.LENGTH_SHORT).show();
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(fragmentManager, "info");
                break;
            case R.id.menu_op2:
                //Toast.makeText(getApplicationContext(), "Opcion 2", Toast.LENGTH_SHORT).show();
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(fragmentManager, "confirm");
                break;
            case R.id.menu_op3:
                //Toast.makeText(getApplicationContext(), "Opcion 3", Toast.LENGTH_SHORT).show();
                DialogoListas dialogoListas = new DialogoListas();
                dialogoListas.show(fragmentManager, "lists");
                break;
            case R.id.menu_op4:
                // Toast.makeText(getApplicationContext(), "Opcion 4", Toast.LENGTH_SHORT).show();
                DialogoLogin dialogoLogin = new DialogoLogin();
                dialogoLogin.show(fragmentManager, "login");
                break;

            case R.id.menu_op5:

                DialogoComunicacion dialogoComunicacion = DialogoComunicacion.newInstance("ASDASDASDA ASDASDASD");
                dialogoComunicacion.show(fragmentManager, "comunicacion");
                break;

            case R.id.menu_op6:
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(fragmentManager,"hora");

                break;
            case R.id.menu_op7:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(fragmentManager,"fecha");

                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogoSelected(String n, String p) {
        // escribo las acciones que quiero que se ejecuten
        Toast.makeText(getApplicationContext(), "Toast desde main " + n, Toast.LENGTH_SHORT).show();
        Intent intent = null;

        //new Intent(getApplicationContext(),SecondA);
        intent.putExtra("nombre", n);
        intent.putExtra("pass", p);
        startActivity(intent);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        Toast.makeText(getApplicationContext(),i+":"+i1, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Date date = new Date();
        TimF
        Toast.makeText(getApplicationContext(),i+"/"+i1+"/"+i2, Toast.LENGTH_SHORT).show();

    }
}