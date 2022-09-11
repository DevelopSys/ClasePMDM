package com.example.t03_inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.v("ciclo_vida","Pasando por onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("ciclo_vida","Pasando por onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("ciclo_vida","Pasando por onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("ciclo_vida","Pasando por onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("ciclo_vida","Pasando por onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("ciclo_vida","Pasando por onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("ciclo_vida","Pasando por onStop");
    }
}