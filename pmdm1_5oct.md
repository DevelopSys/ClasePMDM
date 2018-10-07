# Cuarta semana

##TEMA 2 INTRODUCCION ANDROID STUDIO

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

** Trabajo con estado: guardado y recupreación** - http://www.developandsys.es/uso-recursos-recuperacion-estado/
****
Por cada cambio en configuración o pausado de aplicaciones, se pueden eliminar dato que estén presentes en elementos de la interfaz. Para ello se debe guardar el estado sobreescribiendo el método onSaveInstanceState y utilizando el objeto de tipo bundle. Para recuperarlo se utiliza el objeto de tipo bundle dado en el método onCreate
1. Guardar el estado:
````
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("clave_dato1", "dato a guardar");
        outState.putString("clave_dato2", "dato a guardar");
        outState.putString("clave_dato3", "dato a guardar");
    }
````
2. Recuperar estado
```
@Override
protected void onRestoreInstanceState(Bundle inState){
    super.onSaveInstanceState(outState);
    inState.putString("clave_dato1", "dato1");
    inState.putString("clave_dato2", "dato2");
}
```
ó utilizar el propio onCreate para hacer los mismo
````
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); // Always call the superclass first

    // Check whether we're recreating a previously destroyed instance
    if (savedInstanceState != null) {
        String dato1 = savedInstanceState.getString("clave_dato1");
        String dato2 = savedInstanceState.getString("clave_dato2");
    } else {
      
    }
}
````

**Gestión de recursos: internazionalización y orientación del dispositivo** - http://www.developandsys.es/uso-recursos-recuperacion-estado/
****
Para poder otorgar al dispositivo la capacidad de gestionar los recursos a utilizar se utilizan los cualificados. Para ello hay que duplicar el fichero del recurso que se quiera gestionar (layout, strings, etc...) con el mismo nombre acompañado de su calificador (_land, _port, _en_Us, etc...)

### PRÁCTICAS A ENTREGAR

Números aleatorios
***
Realizar una aplicación para el cálculo de números aleatorios. Para ellos se podrá introducir mediante interfaz los siguientes datos:
1. Número minimo y número máximo: rango entre los que quiero calcular los aleatorios
2. Números: cantidad de aleatorios que quiero calcular

En el momento de dar botón aparecerá la lista de números aleatorios separados por comas justo encima del botón. La apliacación tendrá que soportar internacionalización y representacion land / portraint
![Práctica aleatorios](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/aleatorios.png "Práctica aleatorios")
