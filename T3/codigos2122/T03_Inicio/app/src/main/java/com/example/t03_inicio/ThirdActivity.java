package com.example.t03_inicio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.t03_inicio.utils.Persona;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre, editApellido, editTelefono;
    private CheckBox checkExperiencia;
    private Button botonRegistro;
    private ImageView imagenExperiencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        instancias();
        acciones();
    }

    private void acciones() {
        botonRegistro.setOnClickListener(this);
    }


    private void instancias() {
        editApellido = findViewById(R.id.edit_apellido);
        editNombre = findViewById(R.id.edit_nombre);
        editTelefono = findViewById(R.id.edit_telefono);
        checkExperiencia = findViewById(R.id.check_experiencia);
        botonRegistro = findViewById(R.id.boton_registrar);
        imagenExperiencia = findViewById(R.id.imagen_experiencia);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_registrar:

                String nombre, apellido;
                int telefono;
                boolean experiencia;


                if (!editNombre.getText().toString().isEmpty()
                && !editTelefono.getText().toString().isEmpty()
                && !editApellido.getText().toString().isEmpty()) {

                    nombre = editNombre.getText().toString();
                    apellido = editApellido.getText().toString();
                    telefono = Integer.parseInt(editTelefono.getText().toString());
                    experiencia = checkExperiencia.isChecked();


                    Intent intent = new Intent(getApplicationContext(), FourActivity.class);
                    /*intent.putExtra("nombre",nombre);
                    intent.putExtra("apellido",apellido);
                    intent.putExtra("experiencia",experiencia);
                    intent.putExtra("telefono",telefono);*/
                    intent.putExtra("persona",new Persona(nombre,apellido,telefono,experiencia));



                    //startActivity(intent);
                    if (experiencia){
                        startActivityForResult(intent,1);
                    } else {
                        startActivityForResult(intent,0);
                    }


                } else {
                    Toast.makeText(getApplicationContext(),
                            "Falta algo",Toast.LENGTH_SHORT).show();
                }




                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 0){
           imagenExperiencia.setImageResource(R.drawable.sinex);
        } else if(resultCode ==1){
            imagenExperiencia.setImageResource(R.drawable.conex);
        }
    }
}