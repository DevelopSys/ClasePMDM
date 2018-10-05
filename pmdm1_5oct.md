# Cuarta semana

TEMA 2 INTRODUCCION ANDROID STUDIO
***

### MARTES 
Gestión de la parte gráfica con la parte lógica y adecuación de elementos gráficos en el xml - http://www.developandsys.es/conceptos-basicos-primera-aplicacion/


1. Asociar vista declarada en el xml con elemento declarado en el .java
```
@Override  
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_main);  
  }  
}
```
2. Asociar elemento declarado en el xml con elemento declarado en el java
```
Button boton = findViewById(R.id.botonArrancar);;
```
y el botón en el xml asociado con nombre activity_main.xml
```
<Button  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:text="Pulsa para arrancar la segunda actividad"  
  android:id="@+id/botonArrancar"/>
```
3. Configurar elemento TextView , Button , EditText en el xml

```
<TextView  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:text="Primera actividad"  
  android:textSize="30dp"  
  android:layout_marginBottom="40dp"/>
```
```
<Button  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:text="Pulsa para arrancar la segunda actividad"  
  android:id="@+id/botonArrancar"/>
```
```
<EditText  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:hint="Introduce numero" 
  android:inputType="number" 
  android:id="@+id/editNumero"  
  />
```
4. Asociar acciones a botones desde el java

```
boton = findViewById(R.id.botonArrancar);  
boton.setOnClickListener(new View.OnClickListener() {  
    @Override  
  public void onClick(View v) {  
        //accion a realizar
  }  
});
```
### MIÉRCOLES
**Paso de una actividad a otra** - http://www.developandsys.es/manejo-de-activitys/
****
Manejo de actividades para el paso entre ellas. Uso básico de los intents para pasar de una pantalla a otra:

1. Ambas pantallas declaradas en el AndroidManifest.xml
```
<activity android:name=".MainActivity">  
 <intent-filter> <action android:name="android.intent.action.MAIN" />  
   <category android:name="android.intent.category.LAUNCHER" />  
 </intent-filter></activity>  
<activity android:name=".SecondActivity"></activity>
```
2. Creacións de un objeto de tipo intent en la pantalla origen donde se pasa como parámetro el contexto y la clase de la pantalla que se quiere abrir
```
//arrancar la segunda actividad  
Intent intent = new Intent(getApplicationContext(),SecondActivity.class);  
```
3. Arrancar el intent creado
``` 
startActivity(intent);  
```
**Paso de datos entre actividades** - http://www.developandsys.es/manejo-de-activitys/
***
Para pasar datos entre actividades se añaden los datos al intent creado en el punto anterior con método putExtra() con clave asociada y dato a pasar. Para recuperarlos en la actividad destino se utiliza el método getIntent().getExtra()

1. Añadir los datos al intent creado
```
Intent intent = new Intent(getApplicationContext(),SecondActivity.class);  
//pasarle un dato concreto  
intent.putExtra("clave_asociada","dato a pasar");  
```
2. Arrancar la actividad
 ``` 
startActivity(intent);  
```
3. Recoger los datos en la actividad destino
 ``` 
String recueprar = getIntent().getStringExtra("clave_asociada");```
  ``` 
### JUEVES

**Paso de una actividad a otra esperando resultados** http://www.developandsys.es/manejo-de-activitys/
****
Se utiliza el método startActivityForResult() con un intent como el visto el día anterior y un código de arranque. En la actividad destino para configurar el resultado se utiliza el método setResult() con los datos a pasar y un código de devolución 

 1. Arrancar la segunda actividad desde la primera
 ``` 
//arrancar la segunda actividad  
Intent intent = new Intent(getApplicationContext(),SecondActivity.class);  
//pasarle un dato concreto  
intent.putExtra("clave_asociada","dato a pasar");  
startActivityForResult(intent,1);
```
 2. Poner el resultado en la segunda actividad y cerrarla
  ``` 
Intent intentRespuesta = new Intent();  
intentRespuesta.putExtra("clave_respuesta",3);  
setResult(1,intentRespuesta);  
finish();
```
 3. Procesar el resultado en la primera actividad
   ``` 
@Override  
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  
    super.onActivityResult(requestCode, resultCode, data);  
 if (requestCode == 1){  
        if (resultCode == 1){  
            data.getStringExtra("clave_respuesta");  
        }  
    }  
}
```
 
### VIERNES
