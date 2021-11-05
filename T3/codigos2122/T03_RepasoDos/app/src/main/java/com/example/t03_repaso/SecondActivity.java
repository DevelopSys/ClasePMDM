package com.example.t03_repaso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t03_repaso.utils.Persona;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNombre, editApellido, editTelefono;
    private CheckBox checkExperiencia;
    private Button botonPasar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        acciones();
    }

    private void acciones() {
        botonPasar.setOnClickListener(this);
    }

    private void instancias() {
        editApellido = findViewById(R.id.edit_apellido);
        editNombre = findViewById(R.id.edit_nombre);
        editTelefono = findViewById(R.id.edit_telefono);
        checkExperiencia = findViewById(R.id.check_experiencia);
        botonPasar = findViewById(R.id.boton_pasar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){

            Log.v("test","arrancado con experiencia");
            if (resultCode ==1) {
                Persona persona = (Persona) data.getExtras().getSerializable("dato_contestar");
                Log.v("test", persona.getApellido());
            }
        } else if(requestCode == 2) {
            Log.v("test","arrancado sin experiencia");
            if (resultCode ==1) {
                Persona persona = (Persona) data.getExtras().getSerializable("dato_contestar");
                Log.v("test", persona.getNombre());
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_pasar:

                if (!editNombre.getText().toString().isEmpty() && !editApellido.getText().toString().isEmpty()
                && !editTelefono.getText().toString().isEmpty()){
                    String nombre = editNombre.getText().toString() ;
                    String apellido = editApellido.getText().toString();
                    int telefono = Integer.parseInt(editTelefono.getText().toString());
                    boolean experiencia = checkExperiencia.isChecked();
                    Persona persona = new Persona(nombre,apellido,telefono,experiencia);


                    //Toast.makeText(getApplicationContext(),nombre+apellido+telefono+experiencia,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),ThirdActivity.class);
                    intent.putExtra("persona",persona);
                    //intent.putExtra("nombre",nombre);
                    //intent.putExtra("apellido",apellido);
                    //intent.putExtra("telefono",telefono);
                    //intent.putExtra("experiencia",experiencia);
                    //startActivity(intent);
                    if (experiencia) {
                        startActivityForResult(intent, 1);
                    } else{
                        startActivityForResult(intent, 2);
                    }

                }else {
                    Toast.makeText(getApplicationContext(),"Faltan datos",Toast.LENGTH_SHORT).show();

                }


                break;
        }
    }
}