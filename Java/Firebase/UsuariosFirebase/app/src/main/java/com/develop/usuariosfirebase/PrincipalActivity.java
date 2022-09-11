package com.develop.usuariosfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.develop.usuariosfirebase.utils.Usuario;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        TextView textView = findViewById(R.id.textologin);
        final String firebaseUser = getIntent().getExtras().getString("user");
        final String uid = getIntent().getExtras().getString("uid");
        textView.setText(firebaseUser);
        comprobaryCrear(new Usuario(uid,firebaseUser,"administrador",123));
        comprobarTipo(uid);
    }

    public void comprobaryCrear(final Usuario usuario){
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        // comprueba todos los nodos que tiene por debajo el nodo usuario
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(usuario.getUid())){
                    //Toast.makeText(getApplicationContext(),"El usuario ya existe",Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(getApplicationContext(),"Nodo del usuario creado",Toast.LENGTH_SHORT).show();
                    DatabaseReference mDatabaseInner = FirebaseDatabase.getInstance().getReference().child("usuarios").child(usuario.getUid());
                    mDatabaseInner.setValue(usuario);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void comprobarTipo(String uid){
        DatabaseReference referenciaTipo =  FirebaseDatabase.getInstance().getReference().child("usuarios").child(uid);
        referenciaTipo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String tipo = (String) dataSnapshot.getValue();
                Usuario usuario = dataSnapshot.getValue(Usuario.class);
                Toast.makeText(getApplicationContext(),String.valueOf(usuario.getTipo()),Toast.LENGTH_SHORT).show();
                if (usuario.getTipo().equals("administrador")){
                    // TODO lo que sea de administrador
                } else if (usuario.getTipo().equals("usuario")){
                    // TODO lo que sea de usuario
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
