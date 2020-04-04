package com.develop.usuariosfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        TextView textView = findViewById(R.id.textologin);
        String firebaseUser = getIntent().getExtras().getString("user");
        textView.setText(firebaseUser);

    }
}
