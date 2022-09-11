package com.example.proyectodialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectodialogos.dialog.DialogoConfirmacion;
import com.example.proyectodialogos.dialog.DialogoInformacion;
import com.example.proyectodialogos.dialog.DialogoListas;
import com.example.proyectodialogos.dialog.DialogoPersonalizado;
import com.example.proyectodialogos.utils.Persona;

public class MainActivity extends AppCompatActivity implements DialogoPersonalizado.OnDialogoPersoListener {

    private TextView textNombre, textPass;
    private EditText editComunicar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    private void instancias() {
        textNombre = findViewById(R.id.text_nombre);
        textPass = findViewById(R.id.text_pass);
        editComunicar = findViewById(R.id.edit_enviar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_op1:
                //Toast.makeText(getApplicationContext(),"Opcion1", Toast.LENGTH_SHORT).show();
                // dialogo info
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(), "informacion");

                break;
            case R.id.menu_op2:
                //Toast.makeText(getApplicationContext(),"Opcion2", Toast.LENGTH_SHORT).show();
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(), "confirmacion");
                break;
            case R.id.menu_op3:
                //Toast.makeText(getApplicationContext(),"Opcion3", Toast.LENGTH_SHORT).show();
                DialogoListas dialogoListas = new DialogoListas();
                dialogoListas.show(getSupportFragmentManager(),"listas");

                break;
            case R.id.menu_op4:
                //Toast.makeText(getApplicationContext(),"Opcion4", Toast.LENGTH_SHORT).show();
                //DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
                String dato = editComunicar.getText().toString();
                DialogoPersonalizado dialogoPersonalizado = DialogoPersonalizado.newInstance(dato);
                dialogoPersonalizado.show(getSupportFragmentManager(),"personalizado");


                break;
        }
        return true;
    }

    @Override
    public void onPersonaSelected(Persona persona) {
        //Toast.makeText(getApplicationContext(),"comunicacion ok",Toast.LENGTH_SHORT).show();
        textNombre.setText(persona.getNombre());
        textPass.setText(persona.getPass());
    }
}