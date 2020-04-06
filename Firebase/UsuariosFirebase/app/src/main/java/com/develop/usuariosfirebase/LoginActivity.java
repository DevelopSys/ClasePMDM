package com.develop.usuariosfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.develop.usuariosfirebase.utils.Usuario;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nombreLog, passLog, nombreSign, passSign;
    private Button btnLog, btnSign;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        nombreLog = findViewById(R.id.edit_usuario_log);
        nombreSign = findViewById(R.id.edit_usuario_sig);
        passLog = findViewById(R.id.edit_pass_log);
        passSign = findViewById(R.id.edit_pass_sig);
        btnLog = findViewById(R.id.button_log);
        btnSign = findViewById(R.id.button_sign);
        btnLog.setOnClickListener(this);
        btnSign.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();currentUser.getUid();
    }

    public void comprobarTipo(final String uid){
        DatabaseReference referenciaTipo =  FirebaseDatabase.getInstance().getReference().child("usuarios").child(uid);
        referenciaTipo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String tipo = (String) dataSnapshot.getValue();
                Usuario usuario = dataSnapshot.getValue(Usuario.class);
                Toast.makeText(getApplicationContext(),String.valueOf(usuario.getTipo()),Toast.LENGTH_SHORT).show();
                if (usuario.getTipo().equals("administrador")){
                    // TODO lo que sea de administrador y cargo su pantalla
                    Intent intent = new Intent(getApplicationContext(),AdministradorActivity);
                    intent.putExtra("user",nombreLog.getText().toString());
                    intent.putExtra("uid",uid);
                    startActivity(intent);
                } else if (usuario.getTipo().equals("usuario")){
                    // TODO lo que sea de usuario y cargo su pantalla
                    Intent intent = new Intent(getApplicationContext(),UsuarioActivity);
                    intent.putExtra("user",nombreLog.getText().toString());
                    intent.putExtra("uid",uid);
                    startActivity(intent);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_log:

                mAuth.signInWithEmailAndPassword(nombreLog.getText().toString(), passLog.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("login", "signInWithEmail:success");
                                    Intent i = new Intent(LoginActivity.this,PrincipalActivity.class);
                                    FirebaseUser currentUser = mAuth.getCurrentUser();
                                    String uid = currentUser.getUid();
                                    i.putExtra("user",nombreLog.getText().toString());
                                    i.putExtra("uid",uid);
                                    startActivity(i);

                                    // tambien se puede hacer aquí la comprobación del tipo de usuario para saber que pantalla se carga

                                    comprobarTipo(uid);



                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("login", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
            case R.id.button_sign:

                mAuth.createUserWithEmailAndPassword(nombreSign.getText().toString(), passSign.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("login", "createUserWithEmail:success");
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("login", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                break;
        }
    }
}
