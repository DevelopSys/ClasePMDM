package com.system.develop.t3_dialogos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.system.develop.t3_dialogos.dialogos.DialogoConfirmacion;
import com.system.develop.t3_dialogos.dialogos.DialogoConfirmacionDos;
import com.system.develop.t3_dialogos.dialogos.DialogoFecha;
import com.system.develop.t3_dialogos.dialogos.DialogoHora;
import com.system.develop.t3_dialogos.dialogos.DialogoListaMultiple;
import com.system.develop.t3_dialogos.dialogos.DialogoListaSimple;
import com.system.develop.t3_dialogos.dialogos.DialogoPerso;
import com.system.develop.t3_dialogos.dialogos.DialogoSiNo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogoConfirmacion.OnDialogoConfirmacionListener, DialogoSiNo.OnDialogoSINOListener,
        DialogoListaSimple.OnDialogoListaListener, TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener {

    Button bDialogoConfirmar, bDialogoConfirmarDos, bDialogoSINO, bDialogoLista, bDialogoListaM, bDialogoPerso, bDialgoHora, bDialogoFecha;
    TextView textoConfirmar, textoConfirmarDos, textoDialogoSINO, textoDialogoLista, textoDialogoListaM, textoDialogoPerso, textDialogoHora, textoDialgoFecha;
    final static String TAG_DCONFIR = "confirmacion";
    final static String TAG_DCONFIR_COM = "confirmacion_com";
    final static String TAG_DSINO = "confirmacion_sino";
    final static String TAG_DLISTA = "confirmacion_lista";
    final static String TAG_DLISTAMUL = "confirmacion_listam";
    final static String TAG_DPERSO = "confirmacion_perso";
    final static String TAG_DHORA = "confirmacion_hora";
    final static String TAG_DFECHA = "confirmacion_fecha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bDialogoConfirmar.setOnClickListener(this);
        bDialogoConfirmarDos.setOnClickListener(this);
        bDialogoSINO.setOnClickListener(this);
        bDialogoLista.setOnClickListener(this);
        bDialogoListaM.setOnClickListener(this);
        bDialogoPerso.setOnClickListener(this);
        bDialgoHora.setOnClickListener(this);
        bDialogoFecha.setOnClickListener(this);
    }

    private void instancias() {
        bDialogoConfirmar = findViewById(R.id.dialogoConfirmacion);
        textoConfirmar = findViewById(R.id.respuestaConfirmacion);
        bDialogoConfirmarDos = findViewById(R.id.dialogoConfirmacionDos);
        textoConfirmarDos = findViewById(R.id.respuestaConfirmacionDos);
        bDialogoSINO = findViewById(R.id.dialogoSiNo);
        textoDialogoSINO = findViewById(R.id.respuestaSiNo);
        bDialogoLista = findViewById(R.id.dialogoLista);
        textoDialogoLista = findViewById(R.id.respuestaLista);
        bDialogoListaM = findViewById(R.id.dialogoListaMulti);
        textoDialogoListaM = findViewById(R.id.respuestaListaMulti);
        bDialogoPerso = findViewById(R.id.dialogoLPerso);
        textoDialogoPerso = findViewById(R.id.respuestaPerso);
        bDialgoHora = findViewById(R.id.dialogoHora);
        bDialogoFecha = findViewById(R.id.dialogoFecha);
        textDialogoHora = findViewById(R.id.respuestaHora);
        textoDialgoFecha = findViewById(R.id.respuestaFecha);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogoConfirmacion:
                DialogoConfirmacion d = new DialogoConfirmacion();
                d.show(getSupportFragmentManager(), TAG_DCONFIR);
                break;
            case R.id.dialogoConfirmacionDos:
                DialogoConfirmacionDos dDos = DialogoConfirmacionDos.newInstance("TÍTULO COMUNICADO");
                dDos.show(getSupportFragmentManager(), TAG_DCONFIR_COM);
                break;
            case R.id.dialogoSiNo:
                DialogoSiNo dialogoSiNo = DialogoSiNo.newInstance("TITULO SINO");
                dialogoSiNo.show(getSupportFragmentManager(), TAG_DSINO);
                break;
            case R.id.dialogoLista:
                DialogoListaSimple dialogoListaSimple = new DialogoListaSimple();
                dialogoListaSimple.show(getSupportFragmentManager(), TAG_DLISTA);
                break;
            case R.id.dialogoListaMulti:
                DialogoListaMultiple dialogoListaMultiple = new DialogoListaMultiple();
                dialogoListaMultiple.show(getSupportFragmentManager(), TAG_DLISTAMUL);
                break;
            case R.id.dialogoLPerso:
                DialogoPerso dialogoPerso = new DialogoPerso();
                dialogoPerso.show(getSupportFragmentManager(), TAG_DPERSO);
                break;
            case R.id.dialogoHora:
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(), TAG_DHORA);
                break;
            case R.id.dialogoFecha:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(), TAG_DFECHA);
                break;
        }
    }


    @Override
    public void onDialogoConfirmacionSelected() {
        textoConfirmar.setText("Confirmado");
    }

    @Override
    public void onDialogoSiSelected(String s) {
        textoDialogoSINO.setText(s);
    }

    @Override
    public void onDialogoNoSelected(String s) {
        textoDialogoSINO.setText(s);

    }

    @Override
    public void onDialogoNeutralSelected(String s) {
        textoDialogoSINO.setText(s);

    }

    @Override
    public void onElementoListaSelected(String s) {
        textoDialogoLista.setText(s);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textDialogoHora.setText(String.format("%2d:%2d", hourOfDay, minute));
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        textoDialgoFecha.setText(String.format("%2d/%2d/%4d", dayOfMonth, month+1, year));

    }
}
