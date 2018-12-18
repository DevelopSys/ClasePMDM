package com.system.develop.examendialogos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements DialogoConfirmacion.OnConfirmacionListener,
        DialogoNombre.OnNombreListener, TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener, DialogoNota.OnNotaListener {

    public static final String TAG_HORA = "dhora";
    public static final String TAG_FECHA = "dfecha";
    public static final String TAG_CONFIRMACION = "dconfiracion";
    public static final String TAG_NOMBRE = "dnombre";
    public static final String TAG_NOTA = "dnota";
    private Button boton;
    private String nombre;
    private int nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton= findViewById(R.id.botonPRincipal);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(),TAG_CONFIRMACION);
            }
        });
    }

    @Override
    public void onConfirmacionSelected() {
        DialogoNombre dialogoNombre = new DialogoNombre();
        dialogoNombre.show(getSupportFragmentManager(),TAG_NOMBRE);
    }

    @Override
    public void onNombreSelected(String s) {
        nombre = s;
        DialogoHora dialogoHora = new DialogoHora();
        dialogoHora.show(getSupportFragmentManager(), TAG_HORA);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        DialgoFecha dialgoFecha = new DialgoFecha();
        dialgoFecha.show(getSupportFragmentManager(), TAG_FECHA);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        DialogoNota dialogoNota = DialogoNota.newInstance(nombre);
        dialogoNota.show(getSupportFragmentManager(),TAG_NOTA);
    }

    @Override
    public void onNotaSelected(int n) {
        nota = n;
        if (nombre!=null){
            DialogoResumen dialogoResumen = DialogoResumen.newInstance(nombre,nota);
            dialogoResumen.show(getSupportFragmentManager(),"resumen");
        }
    }
}
