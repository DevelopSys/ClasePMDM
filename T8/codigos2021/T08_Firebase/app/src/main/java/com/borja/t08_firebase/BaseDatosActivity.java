package com.borja.t08_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Iterator;

public class BaseDatosActivity extends AppCompatActivity {

    private TextView textoUID;
    private Button btnAddMain, btnObjeto, btnGetDato, btnGetObj;
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
        btnObjeto = findViewById(R.id.button_nodo_secundario);
        btnGetDato = findViewById(R.id.button_get_dato);
        btnGetObj = findViewById(R.id.button_get_objeto);
        btnGetDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase
                        .getReference("usuarios").child(recuperado).child("favoritos")
                        .child("Barcelona");
                nodoReferencia.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        Equipo equipo = task.getResult().getValue(Equipo.class);
                        Log.v("recuperado",equipo.getLiga());
                    }
                });
                //Log.v("recuperado",nodoReferencia.get)
            }
        });

        btnGetObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase
                        .getReference("usuarios").child(recuperado).child("favoritos");
                nodoReferencia.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        DataSnapshot dataSnapshot = task.getResult();
                        //dataSnapshot.getValue(Equipo.class);
                        Iterator<DataSnapshot> iterator = dataSnapshot.getChildren().iterator();
                        while (iterator.hasNext()){
                            Equipo equipo = iterator.next().getValue(Equipo.class);
                            Log.v("iterador",equipo.getLiga());
                        }
                    }
                });

            }
        });
        btnObjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Equipo equipo = new Equipo("Madrid","Española");
                DatabaseReference nodoReferencia = firebaseDatabase
                        .getReference("usuarios").child(recuperado).child("favoritos").child("Madrid");
                nodoReferencia.setValue(equipo);

            }
        });
        btnAddMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference nodoReferencia = firebaseDatabase
                        .getReference("usuarios").child(recuperado);
                nodoReferencia.setValue(recuperado);
            }
        });
    }
}