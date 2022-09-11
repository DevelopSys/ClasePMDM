package com.borja.t03_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    final static String TAG_ELEMENTO= "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),EjemploActivity.class);
                intent.putExtra(TAG_ELEMENTO,"palabra_pasada");
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
