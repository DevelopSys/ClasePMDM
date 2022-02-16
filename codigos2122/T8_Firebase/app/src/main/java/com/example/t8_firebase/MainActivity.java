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

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button botonLogin, botonRegistro;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        botonRegistro = findViewById(R.id.boton_registo);
        botonLogin = findViewById(R.id.boton_login);



        botonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword("b@cesjuanpablosegundo.es","Password")
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
                                updateGUI(mAuth.getCurrentUser().getUid());
                                

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