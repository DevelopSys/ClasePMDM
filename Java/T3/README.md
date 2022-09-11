<a name="tema3"></a>
## Tema 3. Manejo de Activitys				
***

a.	Ciclo de vida

- http://www.developandsys.es/conceptos-basicos-primera-aplicacion/
- http://www.developandsys.es/manejo-de-activitys/
- http://www.developandsys.es/uso-recursos-recuperacion-estado/

***

### Conceptos básicos

Una activity básica (pantalla) consta de:

- .xml parte gráfica, definido por Views (layouts, botones, listas, fragments, etc.): Cada elemento tiene sus propiedades (width y heigth son básicas, id muy recomendable) y se organizan mediante layouts.

```
<Button  
  android:layout_width="wrap_content"  
  android:layout_height="wrap_content"  
  android:id="@+id/botonArrancar"/>
```

- .java parte lógica de la aplicación (operaciones, gestión de datos, etc.): Una clase normal que extiende de Activity (ahora AppCompactActivity). Por herencia obtiene numerosos métodos. Deben estar declaradas en el androidmanifest.xml

- Adicionamiente podrá contener más elementos como menús, popups, servicios, tareas asíncronas, etc.

****

Asociación parte gráfica y parte lógica: método setContentView (ojo, solo sobre una activity)

```
@Override  
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_main);  
  }  
}
```

Asociación elemento declarado en el xml con elemento declarado en el .java: método findViewById (sobre la vista asociada en el primer paso) o mediante binding con librerias externas como butterknife

```
Button boton = findViewById(R.id.botonArrancar);;
```

****

### Ciclo de vida
Respetar el ciclo de vida: cada elemento en su sitio para no sobre cargar

****

### Internacionalización y acceso a recursos

¿Elementos declarados en xml o hardcode?. Archivos involucrados: string.xml, dimen.xml, menus.xml, colors.xml, style.xml

Las declaraciones mediante archivos xml mejoran la reutilización y la internazionalización. El acceso se realiza: 
- En en el archivo xml mediante @string/nombre
- En código mediante getResource().getString(R.id.nombre)

Para poder otorgar al dispositivo la capacidad de gestionar los recursos a utilizar se utilizan los cualificados. Para ello hay que duplicar el fichero del recurso que se quiera gestionar (layout, strings, etc...) con el mismo nombre acompañado de su calificador (_land, _port, _en_Us, etc...), archivo que será seleccionado automáticamente por el dispositivo teniendo en cuenta las configuraciones.

[Volver arriba](#tema1)

b.	Comunicación entre activitys 

- http://www.developandsys.es/programacion-intents-acciones/
- https://developer.android.com/guide/components/intents-common

### Los intents marcan acciones a realizar dentro de una aplicación. 

Para pasar de una activity a otra:

1. Declaración de todas las activitys en el manifest
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


***

### Para pasar datos entre actividades se sigue el mismo contepto, añadiendo todos los datos a pasar mediante par clave-valor:


1. Declaración del intent y añadir los datos

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
String recueprar = getIntent().getStringExtra("clave_asociada");
```
 o bien:

```
Bundle b = getIntent().getExtras()
String recueprar = b.getString("clave_asociada");

``` 

***

### Pasar de una actividad a otra esperando resultado

Mismo concepto que el anterior pero la actividad que arranca no finaliza y espera que se le comunique un dato

1. Arrancar la segunda actividad desde la primera (igual que el punto anterior), añadiendo un código en el método startActivityForResult() (normalmente debe ser una constante).

``` 
//arrancar la segunda actividad  
Intent intent = new Intent(getApplicationContext(),SecondActivity.class);  
//pasarle un dato concreto  
intent.putExtra("clave_asociada","dato a pasar");  
startActivityForResult(intent,1);

```

 2. Una vez abierta la segunda actividad, poner el resultado en la segunda actividad y cerrarla. Utilizando el método setResult, con un código de respuesta y los datos que se quieren pasar 
  
``` 
Bundle b = getIntent().getExtras()
String recueprar = b.getString("clave_asociada");

Intent intentRespuesta = new Intent();  
intentRespuesta.putExtra("clave_respuesta","dato a pasar");  
setResult(2,intentRespuesta);  
finish()
```

 3. Procesar el resultado en la primera actividad, donde requestCode es el código lanzado en la primera actividad y requestCode el código obtenido con el resultado

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
***

### Guardar y recuperar el estado

Por cada cambio en configuración o pausado de aplicaciones, se pueden eliminar dato que estén presentes en elementos de la interfaz gráfica. Para ello se debe guardar el estado sobreescribiendo el método onSaveInstanceState() y utilizando el objeto de tipo bundle. Para recuperarlo se utiliza el objeto de tipo bundle dado en el método onCreate()

1. Guardar el estado mediante par clave valor. Método llamado automáticamente cuando la aplicación vaya a pausa:
````
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("clave_dato1", "dato a guardar");
        outState.putString("clave_dato2", "dato a guardar");
        outState.putString("clave_dato3", "dato a guardar");
    }
````

2. Recuperar estado con el método onRestoreInstanceState() llamado automáticamente cuando la activity vuelve
```
@Override
protected void onRestoreInstanceState(Bundle inState){
    super.onSaveInstanceState(outState);
    inState.putString("clave_dato1", "dato1");
    inState.putString("clave_dato2", "dato2");
}
```
ó utilizar el propio onCreate para hacer los mismo directamente

```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState); 
    if (savedInstanceState != null) {
        String dato1 = savedInstanceState.getString("clave_dato1");
        String dato2 = savedInstanceState.getString("clave_dato2");
    } else {
      
    }
}
```