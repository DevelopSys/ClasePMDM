package com.borja.t08_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BaseDatosActivity extends AppCompatActivity {

    private TextView textoUID;
    private Button btnAddMain;
    private FirebaseDatabase firebaseDatabase;
    private String recuperado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_datos);
        firebaseDatabase = FirebaseDatabase.getInstance("https://iniciofb-154ad-default-rtdb.europe-west1.firebasedatabase.app/");
        textoUID = findViewById(R.id.cabecera_uid);
        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            recuperado = bundle.get("uid").toString();
            Log.v("usuario",bundle.get("uid").toString());
            textoUID.setText(bundle.get("uid").toString());
        }

        btnAddMain = findViewById(R.id.button_nodo_princial);
        btnAddMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase.getReference("usuarios");
                nodoReferencia.setValue(recuperado);
            }
        });
    }
}