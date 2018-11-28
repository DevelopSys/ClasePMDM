package com.system.develop.t3_dialogos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.system.develop.t3_dialogos.dialogos.DialogoConfirmacion;
import com.system.develop.t3_dialogos.dialogos.DialogoConfirmacionDos;
import com.system.develop.t3_dialogos.dialogos.DialogoListaMultiple;
import com.system.develop.t3_dialogos.dialogos.DialogoListaSimple;
import com.system.develop.t3_dialogos.dialogos.DialogoPerso;
import com.system.develop.t3_dialogos.dialogos.DialogoSiNo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogoConfirmacion.OnDialogoConfirmacionListener, DialogoSiNo.OnDialogoSINOListener,
        DialogoListaSimple.OnDialogoListaListener {

    Button bDialogoConfirmar, bDialogoConfirmarDos, bDialogoSINO, bDialogoLista, bDialogoListaM, bDialogoPerso;
    TextView textoConfirmar, textoConfirmarDos, textoDialogoSINO, textoDialogoLista, textoDialogoListaM, textoDialogoPerso;
    final static String TAG_DCONFIR = "confirmacion";
    final static String TAG_DCONFIR_COM = "confirmacion_com";
    final static String TAG_DSINO = "confirmacion_sino";
    final static String TAG_DLISTA = "confirmacion_lista";
    final static String TAG_DLISTAMUL = "confirmacion_listam";
    final static String TAG_DPERSO = "confirmacion_perso";

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
                dialogoPerso.show(getSupportFragmentManager(),TAG_DPERSO);
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
}
