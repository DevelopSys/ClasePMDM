package com.borja.t08_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre, editPass;
    private Button buttonAdd, buttonVer, buttonLogin;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        instancias();
        acciones();
    }

    private void acciones() {
        buttonAdd.setOnClickListener(this);
        buttonVer.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
    }

    private void instancias() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        editNombre = findViewById(R.id.edit_nombre);
        editPass = findViewById(R.id.edit_pass);
        buttonAdd = findViewById(R.id.button_add);
        buttonVer = findViewById(R.id.button_ver);
        buttonLogin = findViewById(R.id.button_login);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_add:

                firebaseAuth.createUserWithEmailAndPassword(editNombre.getText().toString(),editPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.v("usuarios","el usuario se ha creado correctamente");
                            FirebaseUser usuario = firebaseAuth.getCurrentUser();
                            Log.v("usuarios",usuario.getUid());
                        } else {
                            Log.v("usuarios","el usuario no se ha creado correctamente");
                        }
                    }
                }) ;
                break;

            case R.id.button_ver:
                FirebaseUser usuario = firebaseAuth.getCurrentUser();
                Log.v("usuarios",usuario.getUid());
                break;
            case R.id.button_login:
                firebaseAuth.signInWithEmailAndPassword(editNombre.getText().toString(),editPass.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    //Log.v("usuario","login correcto");
                                    //Log.v("usuario",firebaseAuth.getCurrentUser().getUid());
                                    Intent intent =new Intent(RegistroActivity.this, BaseDatosActivity.class);
                                    Log.v("usuarios",firebaseAuth.getCurrentUser().getUid());
                                    intent.putExtra("uid",firebaseAuth.getCurrentUser().getUid());
                                    startActivity(intent);
                                } else {
                                    Log.v("usuario","login incorrecto");
                                }
                            }
                        });
                break;
        }
    }
}