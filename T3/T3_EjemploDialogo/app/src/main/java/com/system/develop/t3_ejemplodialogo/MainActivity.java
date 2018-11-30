package com.system.develop.t3_ejemplodialogo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.system.develop.t3_ejemplodialogo.dialogo.DialogoPerso;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.botonDialogo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoPerso d = new DialogoPerso();
                d.show(getSupportFragmentManager(),"dialogo");
            }
        });
    }
}
