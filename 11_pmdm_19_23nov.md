**Diálogos** 
*****
### Creación de diálogos hhttp://www.developandsys.es/dialogos/
1. Crear una clase que extienda de DialogFragment y sobreescribir el método onCreateDialog()
````
public class DialogoConfirmacion extends DialogFragment {

    OnDialogoConfirmacionListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return null;
    }
}

````
2. Crear un objeto de tipo builder, rellenarlo y devolverlo creado
````
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Diálogo Confirmación");
        builder.setMessage("Mensaje del diálogo confirmación");
        builder.setNeutralButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return builder.create();
    }
````
3. Desde la actividad se construye el objeto y se llama al método show()
````
final static String TAG_DCONFIR = "confirmacion";
DialogoConfirmacion d = new DialogoConfirmacion();
d.show(getSupportFragmentManager(), TAG_DCONFIR);
````
### Comunicar un diálogo con la activity - http://www.developandsys.es/comunicacion-dialogos/

1. Crear una interfaz de en la clase del diálogo, un objeto y utilizar el método de la interfaz. Se necesita igualar el objeto de tipo interfaz al contexto en el método onAttach()
````
public class DialogoConfirmacion extends DialogFragment {

    OnDialogoConfirmacionListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Diálogo Confirmación");
        builder.setMessage("Mensaje del diálogo confirmación");
        builder.setNeutralButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogoConfirmacionSelected();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnDialogoConfirmacionListener) context;
        }catch (ClassCastException exception){
            Log.v("test","no se ha podido instanciar");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnDialogoConfirmacionListener{
        public void onDialogoConfirmacionSelected();
    }
}
````
2. Implementar la interfaz en el destino de los datos y se utiliza la interfaz - http://www.developandsys.es/comunicacion-dialogos/
````
public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoConfirmacion.OnDialogoConfirmacionListener {

    Button bDialogoConfirmar, bDialogoConfirmarDos;
    TextView textoConfirmar, textoConfirmarDos;
    final static String TAG_DCONFIR = "confirmacion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bDialogoConfirmar.setOnClickListener(this);
    }

    private void instancias() {
        bDialogoConfirmar = findViewById(R.id.dialogoConfirmacion);
        textoConfirmar = findViewById(R.id.respuestaConfirmacion);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogoConfirmacion:
                DialogoConfirmacion d = new DialogoConfirmacion();
                d.show(getSupportFragmentManager(), TAG_DCONFIR);
                break;
        }
    }

    @Override
    public void onDialogoConfirmacionSelected() {
        textoConfirmar.setText("Confirmado");
    }
}
````
### Comunicar la activity con un diálogo
1. Crear una clase que extienda de DialogFragment con un método estático que devuelva un objeto de tipo de la clase y que admita como parámetros lo que se le quiere comunicar
````
public class DialogoConfirmacionDos extends DialogFragment {

    String titulo;
    final static String TAG_ARG1 ="argumento1";
    public static DialogoConfirmacionDos newInstance(String titulo){

        DialogoConfirmacionDos dialogoConfirmacionDos = new DialogoConfirmacionDos();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacionDos.setArguments(b);
    }

}
````
2. Crear un objeto en el método, ponerle como argumentos (mediante un bundle) los argumentos del método y devulverlo para cumplir la firma del método
````
public class DialogoConfirmacionDos extends DialogFragment {

    String titulo;
    final static String TAG_ARG1 ="argumento1";
    public static DialogoConfirmacionDos newInstance(String titulo){

        DialogoConfirmacionDos dialogoConfirmacionDos = new DialogoConfirmacionDos();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacionDos.setArguments(b);
        return dialogoConfirmacionDos;
    }

}
````
3. En el método onAttach() recuperar los argumentos e igualarlos a una variable de clase para poder utilizarlos
````
public class DialogoConfirmacionDos extends DialogFragment {

    String titulo;
    final static String TAG_ARG1 ="argumento1";
    public static DialogoConfirmacionDos newInstance(String titulo){

        DialogoConfirmacionDos dialogoConfirmacionDos = new DialogoConfirmacionDos();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacionDos.setArguments(b);
        return dialogoConfirmacionDos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(this.getArguments()!= null)
        {
            Bundle bRecuperado = this.getArguments();
            titulo = bRecuperado.getString(TAG_ARG1);
        }
    }
}

````
4. Sobreescribir el método onCreateDialog para poder crear el builder y rellenar el diálogo
````
public class DialogoConfirmacionDos extends DialogFragment {

    String titulo;
    final static String TAG_ARG1 ="argumento1";
    public static DialogoConfirmacionDos newInstance(String titulo){

        DialogoConfirmacionDos dialogoConfirmacionDos = new DialogoConfirmacionDos();
        Bundle b = new Bundle();
        b.putString(TAG_ARG1,titulo);
        dialogoConfirmacionDos.setArguments(b);
        return dialogoConfirmacionDos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(this.getArguments()!= null)
        {
            Bundle bRecuperado = this.getArguments();
            titulo = bRecuperado.getString(TAG_ARG1);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(titulo);
        builder.setMessage("Diálogo con comunicación");
        builder.setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }
}
````
