package com.borja.toolbardialogo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        imageView = findViewById(R.id.imagen_glide);


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nuevo titulo del proyecto");

        // https://blog.cambridge.es/wp-content/uploads/2017/09/ejemplo-aprendizaje.jpg

        Glide.with(MainActivity.this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTc4PErVKDEhxom0g6iqIpWaVVWRPQXI5faew&usqp=CAU").circleCrop().into(imageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_uno:
                Toast.makeText(getApplicationContext(),"Pulsado",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}