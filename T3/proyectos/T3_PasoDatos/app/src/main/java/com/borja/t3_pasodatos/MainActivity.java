package com.borja.t3_pasodatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.borja.t3_pasodatos.utils.Persona;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText textoCaptura, apellidoCaptura, telefonoCaptura;
    private CheckBox checkBoxPermitir;
    private Button btnPaso, btnPasoParam;
    static final String TAG_1 = "texto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        btnPaso.setOnClickListener(this);
        btnPasoParam.setOnClickListener(this);
    }

    private void instancias() {
        checkBoxPermitir = findViewById(R.id.checkPermitir);
        textoCaptura = findViewById(R.id.textoNombre);
        apellidoCaptura = findViewById(R.id.textoApellido);
        telefonoCaptura = findViewById(R.id.textoTelefono);
        btnPaso = findViewById(R.id.botonPaso);
        btnPasoParam = findViewById(R.id.botonPasoParametros);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.botonPaso:

                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(i);

                /*if(!textoCaptura.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), textoCaptura.getText().toString(), Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Vacio", Toast.LENGTH_SHORT).show();*/

                break;
            case R.id.botonPasoParametros:

                if (!textoCaptura.getText().toString().isEmpty()
                        && !apellidoCaptura.getText().toString().isEmpty()
                        && telefonoCaptura.getText().toString().length()==9
                        && checkBoxPermitir.isChecked()) {

                    String nombre = textoCaptura.getText().toString();
                    String apellido = apellidoCaptura.getText().toString();
                    int telefono = Integer.valueOf(telefonoCaptura.getText().toString());

                    // Ejemplo de modificacion realizada desde AS

                    Persona persona = new Persona(nombre,apellido,telefono);

                    Intent iPasar = new Intent(getApplicationContext(), SecondActivity.class);
                    //iPasar.putExtra(TAG_1,textoCaptura.getText().toString());
                    iPasar.putExtra(TAG_1,persona);
                    startActivity(iPasar);
                } else
                    Toast.makeText(getApplicationContext(), "Por favor introduce datos", Toast.LENGTH_SHORT).show();

                break;
        }
    }
}
