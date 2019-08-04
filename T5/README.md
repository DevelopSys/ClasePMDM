<a name="tema5"></a>
## Elementos adicionales				
***
a.	Menús
- http://www.developandsys.es/menus/

Los menús representan una forma de interactuar con la aplicación casi de forma directa. Existen varios tipos de menús, en este apartado se verán los tipos más sencillos, ya que lo savanzados se veran en el punto d y en el tema 7. 

Para poder crear un menú, lo normal es que este provenga de un xml donde se marquen todas las opciones. De esta forma podrá ser rehutilizado desde cualquier punto de la aplicación. Para ello:

1. En la carpeta src se crea un folder de tipo menu, donde se crea el xml y se incluyen todas las opciones como item.

````
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/opcion_menu1"
        android:icon="@mipmap/ic_launcher"
        android:title="Opcion 1"
        app:showAsAction="always" />
    <item
        android:id="@+id/opcion_menu2"
        android:icon="@mipmap/ic_launcher"
        android:title="Opcion 2"
        app:showAsAction="ifRoom" />
    <item
        android:id="@+id/opcion_menu3"
        android:icon="@mipmap/ic_launcher"
        android:title="Opcion 3"
        app:showAsAction="never" />

    <item android:id="@+id/opcion_menu_sub"
        android:title="Opciones">

        <menu>
            <item
                android:id="@+id/menusub1"
                android:title="Subelemento1" />
            <item
                android:id="@+id/menusub2"
                android:title="Subelemento2" />
        </menu>

    </item>

</menu>
````
Serán obligatorios los campos de id y title. El resto de campos serán optativos

2. Una vez se ha creado el archivo xml se infla dentro de la ActionBar (lugar por defecto de los menús) donde aparecerá con los tipicos puntos (o iconos si así se ha definido en el xml). Para ello se sobreescribe el méeto onCreateOptionMenu()
````
 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
````
En este método se incorpora un parámetro de tipo menú, el cual es utilizado para inflar el recurso xml creado. 

**Evaluar la pulsación del menú**
***

Para poder evaluar la pulsación del menú, se utiliza el atributo id del xml. Para ello se sobreescribe el método onOptionItemSelected()

````
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.opcion_menu1:
                Toast.makeText(getApplicationContext(), "Pulsado elemento 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu2:
                Toast.makeText(getApplicationContext(), "Pulsado elemento 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu3:
                Toast.makeText(getApplicationContext(), "Pulsado elemento 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu_sub:
                Toast.makeText(getApplicationContext(), "Pulsado elemento sub", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusub1:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menusub2:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu1_ctx:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opcion_menu1_ctx_dos:
                Toast.makeText(getApplicationContext(), "Pulsado sub elemento 2", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
````
El parámetro menuItem sirve para evaluar cual es el elemento que ha sido pulsado. 

### Menús contextuales
***

Los menús contextuales son aquellos que se asocian a la pulsación larga de un elemento. Normalmente son utilizados para realizar una acción concreta sobre el elemento que ha provocado la aparición del contextual. Para ello:

1. Se crea un archivo xml de la misma forma que en la creación de los menús convencionales
2. Se ejecuta el método registerForContextMenu() sobre aquel elemento que pueda lanzar menús contextuales con una pulsación larga
````
registerForContextMenu(botonUno);
registerForContextMenu(botonDos);
````
3. Con la ejecución de los métodos anteriores los elementos están prepaados para poder mostrar contextuales. Para sacar los contextuales se sobreescribe el método onCreateContextMenu(). Hay que tener en cuenta que se puede indicar el inlfado de diferentes menús, dependiendo de que elemento haya provocado la llamada
````
@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        switch (v.getId()) {
            case R.id.boton1:
                getMenuInflater().inflate(R.menu.menu_contextual, menu);
                break;
            case R.id.boton2:
                getMenuInflater().inflate(R.menu.menu_contextual_dos, menu);
                break;
        }
    }
````

**Evaluar la pulsación de un menú contextual**

Se realiza de la misma forma que la evaluación de la pulsación de un menú normal

### Menús popup
Los menús popup o emergentes son muy similares a los anteriores, con la diferencia que no necesitan del registro de la acción ni la sobreescritura de ningún metodo. Para poder crearlos se siguen los siguientes pasos:

1. Crear un archivo xml donde se indica los elementos que aparecerán en el menú (igual que los pasos anteriores).
2. Crear un objeto de tipo MenuPopUp y MenuInflater para poder hacer la asignación de elemento - menú. Estos elementos serán llamados cuando se produzca el una acción concreta, definida mediante listener
````
view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        PopupMenu popup = new PopupMenu(getApplicationContext(), view2);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_pop, popup.getMenu());
        popup.show();
    }
});
````
**Evaluar la pulsacion de un menu popup**
Para poder evaluar la pulsación del elemento popup no es necesario sobreescribir ningún método.
1. Sobre el objeto popp se llama al método setOnMenuItemClickListener y se evalúa el menuItem

````
popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
 
        String aviso = null;
 
        switch (menuItem.getItemId()) {
            case R.id.menuPopElemento1:
                aviso = "Has pulsado el elemento 1";
                break;
            case R.id.menuPopElemento2:
                aviso = "Has pulsado el elemento 2";
                break;
        }
 
        Toast.makeText(getApplicationContext(), aviso, Toast.LENGTH_SHORT).show();
 
        return true;
    }
});
````

#### [Volver al arriba](#tema5)

b.	Diálogos
- http://www.developandsys.es/dialogos/
- http://www.developandsys.es/comunicacion-dialogos/

Los diálogos son una forma de interactuar con el usuario, bien para dar información a modo información o para pedir algún tipo de dato. Antiguamente se utilizaban diálogos normales, pero desde la aparición de Android 4.0 se utilizan por defecto DialogFragment. Por este motivo el ciclo de vida de un diálogo es idéntico al que se explicará en los fragments. 

Antes de empezar a explicar la creación de diálogos es importante recordar los siguiente elementos:

- getSupportFragmentManager(): elemento que permite manejar los diálogos, mostrarlos y asignatles etiquetas
- DialogFragment: tipo que representa el diálogo como tal. Esta clase tiene sus propios elementos (titulo, contenido, botones) o se le puede inflar una vista propia. 
- AlertDialog.Builder: Tipo que permite la creación del diálogo con todos sus elementos 

Hay que tener en cuenta que los dos primeros elementos tienen que estar en el mismo nivel. Si se declara uno de soporte, el otro deberá ser del mismo tipo **(se recomienda siempre utilizar la librería de soporte por temas de compatibilidad)**

1. Crear una clase que extienda de DialogFragment y sobreescribir el método onCreateDialog()
````
public class DialogoConfirmacion extends DialogFragment {

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
Es reseñable ver que en el método que se implementa, se tiene un parámetro de tipo Bundel el cual guarda el estado (al igual que pasaba en las Activitys)
3. Desde la actividad donde se quiere llamar al diálogo, se construye el objeto y se llama al método show()
````
final static String TAG_DCONFIR = "confirmacion";
DialogoConfirmacion d = new DialogoConfirmacion();
d.show(getSupportFragmentManager(), TAG_DCONFIR);
````
La instancia del objeto de tipo DiálogoConfirmacion arranca la creación del objeto, y por lo tanto la ejecución del método onCreateDialog()

**Partes de un diálogo**
***

En la creacón del diálogo exite la posibilidad de incluir una serie de opciones antes de retornalo en el método onCreateDialog. Las opciones son:
- setPositive/Negative/NeutralButton: se trata de botones que incorporan el listener de la acción directamente dentdo de la definición del método:
````
builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.v("test","Pulsado la opción de si");
            }
        });
 
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.v("test","Pulsado la opción de no");
            }
        });
        
        builder.setNeutralButton("CERRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });
````
- setTitle / setMessage: Incorporación de los textos que tendrá el diálogo, tanto en el título como en el cuerpo del mismo
````
builder.setTitle("Diálogo de mensaje");
builder.setMessage("¿Seguro que deseas continuar?");
````
- setItem: Selección sobre una lista de selección única. Para ellos además de pasarle cual es el array de de elementos que debe representar. La acción se ejecuta de forma directa cuando se realiza la pulsación

````
String[] opciones = {"Opción 1","Opción 2", "Opción 3"};
builder.setItems(opciones, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Log.v("test","seleccionado: "+opciones[i]);
        }
    });
````
- setSingleChoiceItems: Muy parecido al anterior, con la diferencia que al seleccionar el elemento la acción no debería producirse hasta que se pulsa un botón. En el método se indica cual es el elemento que está seleccionado por defecto (-1 no representa ninguno) 
````
String[] opciones = {"Opción 1","Opción 2", "Opción 3","Opción 4"};
builder.setTitle("Diálogo de selección");
builder.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Log.v("test","seleccionado: "+opciones[i]);
        }
});
````
- setMultiChoiceItems: Similar al anterior método, pero con la posibilidad de seleccionar varios elementos al mismo tiempo. En la interfaz de pulscion se inconrpora un booleano que indica si el elemento está o no seleccionado
````
builder.setMultiChoiceItems(opciones, null, new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            if(b){
                Log.v("test","agregado "+opciones[i]);
            }
            else
                Log.v("test","eliminado "+opciones[i]);
        }
    });
````

**Personalizar diálogo**
***

1. Crear el xml que se quiere representar 
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="40dp"
    android:orientation="vertical">

    <TextView
        android:layout_marginTop="30dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Introudce tus datos o crea una cuenta para iniciar sesión"
        android:textAppearance="@style/Base.TextAppearance.AppCompat.Medium"
        android:textAlignment="center"
        android:layout_marginBottom="20dp"
        />

    <Button
        android:id="@+id/b_dialogoperso_cuenta"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Crear Cuenta"
        android:layout_marginBottom="20dp"
        style="@style/Base.Widget.AppCompat.Button.Colored"
        />

    <View
        android:layout_width="match_parent"
        android:layout_height="2dp"
        android:background="@color/colorAccent"
        android:layout_marginBottom="20dp"></View>

    <EditText
        android:layout_marginBottom="5dp"
        android:id="@+id/e_dialogoperso_nombre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Nombre" />

    <EditText
        android:id="@+id/e_dialogoperso_pass"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Contraseña"
        android:layout_marginBottom="20dp"
        />


    <CheckBox
        android:id="@+id/c_dialogoperso_recordar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Recordar contraseña"
        android:layout_marginBottom="20dp"/>

    <Button
        android:id="@+id/b_dialogoperso_recordar"
        style="@style/Base.Widget.AppCompat.Button.Borderless"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Olvidé la contraseña"
        android:gravity="end" />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Entrar"
        style="@style/Base.Widget.AppCompat.Button.Colored"
        android:layout_marginBottom="30dp"
        />

</LinearLayout>
````
2. Inflar la vista el el diálogo. Normalmente suele ser en el método onAttach
````
View v;
 
@Override
public void onAttach(Context context) {
    super.onAttach(context);
    v=LayoutInflater.from(getActivity().getBaseContext()).inflate(R.layout.dialogo_personalizado_layout,null);
}
````
3. Utilizar el método setView para asociar diálogo con vista
````
@NonNull
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {

    builder.setView(v);
    
    return builder.create();
}
````
4. Intanciar los elementos de la vista y utilizarlos normalmente (**ojo a la instancias**)
````
private void instancias() {
    login = v.findViewById(R.id.b_dialogoperso_cuenta);
    nombre = v.findViewById(R.id.e_dialogoperso_nombre);
    pass = v.findViewById(R.id.e_dialogoperso_pass);
}
````
**Comunicar un diálogo con la activity**
***
- http://www.developandsys.es/comunicacion-dialogos/

Lo normal es que un diálogo pida datos o bien una confirmación. Para ello se necesita comunicar de alguna manera. En el caso de ser una comunicación diálogo - activity, la comunicación se produce mediante interfaces de Callback(), del mismo modo que pasaba en el recycleView, con la diferencia que en los diálogos existe un método que es el onAttach() mediante el cual se obtiene de forma directa el contexto desde el que se ha llamado al diálogo, por lo que la interfaz puede ser instanciada en ese método

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

En este caso la comunicación se realiza a la inversa, de forma que no se puede utilizar una interfaz de Callback. Para ello se utiliza un método estatico de creación (típico de los frágments) donde se utilizan los argumentos para poder pasar y recuperar los datos.

1. Crear una clase que extienda de DialogFragment con un método estático que devuelva un objeto de tipo de la clase (el propio diálogo) y que admita como parámetros lo que se le quiere comunicar. 

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
2. Además de devolver el diálogo, este método es utilizado para poner como argumentos en el propio diálogo (objeto de tipo Bundle con par clave - valor) los datos que se han pasado como parámetros.
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
3. En el método onAttach() recuperar los argumentos e igualarlos a una variable de clase para poder utilizarlos como variables globales
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
4. Sobreescribir el método onCreateDialog para poder crear el builder y rellenar el diálogo de la misma forma que se explico en apartados anteriores.
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
5. En la Activity desde la que se quiere llamar al diálogo se llama al método estático con los argumentos, de forma que el diálogo será creado con los parámetros argumentos. Automáticamente estos serán recuperados y situados en el sitio correspondiente.
````
DialogoConfirmacionDos d = DialogoConfirmacionDos.newInstance("parámetro");
d.show(getSupportFragmentManager(), TAG_DCONFIR);
break;
````

**Diálogos precargados**
***
Del mismo modo que existe la posibilidad de crear diálogos y utilizarlos como se ha explicado, Android incorpora algunos diálogos ya construidos que permiten el manejo de calendarios y selectores de fecha de forma muy sencilla. Al igual que se definen todos los elementos gráficos de los diálogos comentados, también se incluyen las interfaces de CallBack que producen la comunicación entre diálogo y activity. Los diálogos son:

**Diálogo de hora**

1. Crear una clase que extienda de dialogfragment y retornar un objeto de tipo TimePicker
````
public class DialogoHora extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

            return new TimePickerDialog(getActivity(), (TimePickerDialog.OnTimeSetListener) getActivity(),
                    Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                    Calendar.getInstance().get(Calendar.MINUTE),
                    true);

    }
}
````
3. En el destino de los datos implementar la interfaz TimePickerDialog.OnTimeListener
````
public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    Button bDialgoHora;
    TextView textDialogoHora;
    final static String TAG_DHORA = "confirmacion_hora";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {

        bDialgoHora.setOnClickListener(this);
    }

    private void instancias() {
        
        textDialogoHora = findViewById(R.id.respuestaHora);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogoHora:
                DialogoHora dialogoHora = new DialogoHora();
                dialogoHora.show(getSupportFragmentManager(), TAG_DHORA);
                break;
        }
    }

    
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        textDialogoHora.setText(String.format("%2d:%2d", hourOfDay, minute));
    }

}
````

El método implementado tendrá toda la información del diálogo. Este método será ejecutado cuando se pulse el boton aceptar del diálogo

**Diálogo de fecha**

La misma funcionamidad que el caso anterior, pero con clases e interfaz diferente

1. Crear una clase que extienda de dialog fragment y retornar un objeto de tipo DatePicker
````
import java.util.Calendar;

public class DialogoFecha extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(),
                Calendar.getInstance().get(java.util.Calendar.YEAR),
                Calendar.getInstance().get(java.util.Calendar.MONTH),
                Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH));

    }
}

````
2. En el destino de los datos implementar la interfaz DatePickerDialog.OnDateListener
````
public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button bDialgoHora, bDialogoFecha;
    TextView textoDialgoFecha;
    final static String TAG_DFECHA = "confirmacion_fecha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {

        bDialogoFecha.setOnClickListener(this);
    }

    private void instancias() {
        
        textoDialgoFecha = findViewById(R.id.respuestaFecha);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogoFecha:
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getSupportFragmentManager(), TAG_DFECHA);
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        textoDialgoFecha.setText(String.format("%2d/%2d/%4d", dayOfMonth, month+1, year));

    }
}
````
El método implementado tendrá toda la información del diálogo. Este método será ejecutado cuando se pulse el boton aceptar del diálogo


#### [Volver al arriba](#tema5)

c.	Action Bar / Toolbar
- http://www.developandsys.es/toolbar/

Por defecto toda activity tiene una barra superior, llamada ActioBar. Esta barra es configurable desde el arichivo de estilos
````
<resources>
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar"></style>
</resources>
````

Desde Antroid 5.0 se introduce el concepto de Toolbar, el cual es una barra muy similar al ActionBar pero mucho más personalizable (necesaria para algunos elementos como el menú lateral). Para poder utilizarla lo primero es elinimar la ActionBar mediante el archivo de estilos.

````
<resources>
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar"></style>
</resources>
````

Del mismo modo es necesario la importación de la librería de soporte que permite utilizar el elemento Toolbar

````
compile 'com.android.support:appcompat-v7:26.+'
````

Una vez hechos estos dos pasos, para poder utilizar la Toolbar ser realiza lo siguiente:

1. En el xml del layout utiliza el elemento Toolbar. Como altura se define un atibuto que representa la altura del ActionBar original. 

````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.developandsystem.toolbarexplicacion.MainActivity">
 
    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        android:elevation="4dp"
        android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light">
 
    </android.support.v7.widget.Toolbar>
    
</LinearLayout>
````

2. Si se quieren incorporar elementos dentro de la Toolbar es posible mediante xml, como puede ser un botón por ejemplo. Estos elementos podrán ser implementados como un view más

````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.developandsystem.toolbarexplicacion.MainActivity">
 
    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        android:elevation="4dp"
        android:theme="@style/ThemeOverlay.AppCompat.ActionBar"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light">
 
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/buttonToolbar"
            android:text="Pulsar"
            style="@style/Base.Widget.AppCompat.Button.Borderless"
            android:textColor="@android:color/white"></Button>
 
    </android.support.v7.widget.Toolbar>
 
</LinearLayout>
````
3. En la activity asociada, se debe setear la Toolbar como barra superior mediante el método setSupportActionBar. 

````
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tb = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(tb);   
}
````

4. Una vez seteada la Toolbar se puede utiliza por ejemplo para un menú lateral, o simplemente modificar elementos. Es importante que para todas estas acciones se utilice el método getSupportActionBar() y lo el objeto Toolbar directamente

````
getSupportActionBar().setTitle("Nombre de la activity");
getSupportActionBar().setIcon(android.R.drawable.btn_star_big_on);
getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_menu_manage);
````

5. Si se quiere poner un menú normal, tan solo se tienen que sobreescribir el método explicado en el punto de los menús. 

````
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_principal, menu);
    return true;
}

````

**Evaluar la pulsación de un menú puesto en un toolbar**

1. Se realiza de la misma forma que un menú normal
````
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.elemento1:
            Log.v("test","pulsado elemento 1");
            break;
        case R.id.elemento2:
            Log.v("test","pulsado elemento 2");
            break;
        case android.R.id.home:
            Log.v("test","elemento pulsado");
    }
 
    return true;
}
````
2. O bién llamando setOnMenuItemClickListener() al método diréctamente sobre el toolbar
````
tb = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(tb);
getSupportActionBar().setTitle("Nombre de la activity");
tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.elemento1:
                Log.v("test","pulsado elemento 1");
                break;
            case R.id.elemento2:
                Log.v("test","pulsado elemento 2");
                break;
        }
        return true;
    }
});
````

**Definir botón home en el Toolbar**

En algunas ocasiones es necesario definir un icono detro del Toolbar (parte uperior izquierda) que actúe como home. Para ello se ejecuta el método

````
barraToolbar.setNavigationIcon(android.R.drawable.btn_star);
````

Una vez está definido el elemento se podría evaluar su pulsación como un case más dentro del switch de evaluación del menú

````
case android.R.id.home:
    Log.v("test","elemento pulsado");
````


#### [Volver al arriba](#tema5)


d.	Bottom navigation
- http://www.developandsys.es/bottom-navigation-view/

Una barra de menu inferior agrega fundionalidad a todos los menús anteriores. Son complementarios pero hay que tener cuidado con sobrecargar la aplicación. En concreto esta opción solo debería ser urilizada para las 3 - 5 opciones más importantes, nunca superando este número. Para poder utilizarlo:

1. Asegurarse de la implmentación de la librería de diseño:

````
implementation 'com.android.support:design:28.0.0'
````

2. Declar un archivo xml donde se incluyen las opciones del menú a mostrar. Este paso es el mismo que se describió en el punto de los menús normales

3. En el xml de la activity, declar el elemento 

````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="+@id/"
    tools:context=".MainActivity">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.9" />

    <android.support.design.widget.BottomNavigationView
        android:id="@+id/bottom_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        app:itemBackground="@color/colorPrimary"
        app:menu="@menu/menu_bottom" />
    
</LinearLayout>
````
Dentro de las opciones declaradas, destacar:
- layout_alignParentBottom:coloca al elemento en la parte inferior
- itemBackground: representa el color que aparecerá en el fondo de cada uno de los elementos
- itemIconTint: reperenta el color que tendrá el icono
- itemTextColor: representa el color del texto que tendrá el icono

Los dos últimos atributos son muy interesantes en el caso de personalizarlos. Por ejemplo en el caso de querer un color diferente cuando esté seleccionado 

````
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:color="@android:color/white" android:state_checked="true" />
    <item android:color="@color/colorPrimaryDark" android:state_checked="false" />
</selector>
````

````
<android.support.design.widget.BottomNavigationView
android:id="@+id/bottom_bar"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:layout_alignParentBottom="true"
app:itemBackground="@color/colorPrimary"
app:itemIconTint="@drawable/state_color_bottom"
app:itemTextColor="@drawable/state_color_bottom"
app:menu="@menu/menu_bottom" />
````

4. Al ser un elemento propio del xml no hay que sobreescribir ningún método para que aparezca no para gestionar la pulsación. Tan solo utilizar un método propio para gestionar el evento:
````

bottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
@Override
public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.opcion1:
                        mostrarToast("Pulsada opción 1");
                        break;
                    case R.id.opcion2:
                        mostrarToast("Pulsada opción 2");
                        break;
                    case R.id.opcion3:
                        mostrarToast("Pulsada opción 3");
                        break;
                    case R.id.opcion4:
                        mostrarToast("Pulsada opción 4");
                        break;
                }
                return true;
            }
        });
    }
 
````

#### [Volver al arriba](#tema5)

