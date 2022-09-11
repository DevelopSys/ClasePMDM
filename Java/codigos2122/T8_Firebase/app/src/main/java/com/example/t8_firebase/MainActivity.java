package com.example.t8_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button botonLogin, botonRegistro, botonEscribirDB, botonLeerDB;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://iniciofb-9af91-default-rtdb.firebaseio.com/");
        botonRegistro = findViewById(R.id.boton_registo);
        botonLogin = findViewById(R.id.boton_login);
        botonEscribirDB = findViewById(R.id.escribir_db);
        botonLeerDB = findViewById(R.id.leer_db);


        botonEscribirDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = firebaseDatabase.getReference("usuarios");
                //reference.child("borja").child("aficiones").setValue(new String[]{1,2,3123,123});

            }
        });
        botonLeerDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    DatabaseReference reference = firebaseDatabase.getReference("usuarios");

                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Iterable<DataSnapshot> iterable = snapshot.getChildren();
                            Iterator<DataSnapshot> iterator = iterable.iterator();
                            while (iterator.hasNext()){
                                DataSnapshot data = iterator.next();
                                Log.v("test_fb",data.getValue().toString());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
            }
        });
        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword("sdfghjkjuytred@cesjuanpablosegundo.es","Password")
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"usuario registrado",Toast.LENGTH_SHORT).show();
                            FirebaseUser user =  mAuth.getCurrentUser();
                            //Toast.makeText(getApplicationContext(), user.getUid(), Toast.LENGTH_SHORT).show();
                            Log.v("firebase_prueba",user.getUid());
                            // DIALOGO ¿QUIERES INICIAR SESION?
                            // SI
                                //updateGUI(mAuth.getCurrentUser().getUid());
                                DatabaseReference referencia =
                                        firebaseDatabase.getReference("usuarios").child(mAuth.getCurrentUser().getUid()).child("correo");
                                        referencia.setValue("correo@correo.com");



                        } else {
                            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
                            Log.v("firebase_prueba",task.getException().getMessage());

                        }
                    }
                });
            }
        });
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mAuth.signInWithEmailAndPassword("b@asasd.com","asdasd")
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                            updateGUI(mAuth.getCurrentUser().getUid());
                                    } else {

                                    }
                                }
                            });
            }
        });

    }

    public void updateGUI(String uuid){
        // hago las acciones para un usuario logeado
    }
}