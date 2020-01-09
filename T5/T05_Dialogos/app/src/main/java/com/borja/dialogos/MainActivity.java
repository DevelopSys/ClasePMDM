package com.borja.dialogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.borja.dialogos.dialogos.DialogoInformacion;
import com.borja.dialogos.dialogos.DialogoItems;
import com.borja.dialogos.dialogos.DialogoSINOPerso;
import com.borja.dialogos.dialogos.DialogoSiNo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoSiNo.OnDialogoSINOListener, DialogoItems.OnDialogoItemSelected {

    Button btnDialogoInfo, btnDialogoSiNo, btnDialogoSiNoPerso, btnDialogoItems;
    TextView respuestaSINO, respuestaSINOPerso, respuestaItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnDialogoInfo.setOnClickListener(this);
        btnDialogoSiNo.setOnClickListener(this);
        btnDialogoSiNoPerso.setOnClickListener(this);
        btnDialogoItems.setOnClickListener(this);
    }

    private void instancias() {
        btnDialogoInfo = findViewById(R.id.boton_dialogo_informacion);
        btnDialogoSiNo = findViewById(R.id.boton_dialogo_sino);
        btnDialogoSiNoPerso = findViewById(R.id.boton_dialogo_perso_sino);
        btnDialogoItems = findViewById(R.id.boton_dialogo_item);
        respuestaSINO = findViewById(R.id.texto_sino_respuesta);
        respuestaSINOPerso = findViewById(R.id.texto_sino_perso_respuesta);
        respuestaItems = findViewById(R.id.texto_item_respuesta);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.boton_dialogo_informacion:
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "ejemplo");
                break;
            case R.id.boton_dialogo_sino:
                DialogoSiNo dialogoSiNo = new DialogoSiNo();
                dialogoSiNo.show(getSupportFragmentManager(), "ejemplo");
                break;
            case R.id.boton_dialogo_perso_sino:
                DialogoSINOPerso dialogoSINOPerso = DialogoSINOPerso.newInstance("Borja");
                dialogoSINOPerso.show(getSupportFragmentManager(), "perso");
                break;
            case R.id.boton_dialogo_item:
                DialogoItems dialogoItems = new DialogoItems();
                dialogoItems.show(getSupportFragmentManager(),"items");
                break;
        }
    }

    @Override
    public void onDialogoSelected(String s) {
        //Toast.makeText(getApplicationContext(),
        //        "la opcion seleccionada es "+s,Toast.LENGTH_SHORT).show();
        respuestaSINO.setText(s);
    }

    @Override
    public void onItemSelected(String s) {
        respuestaItems.setText(s);
    }
}
