# Objetivos

- Conocer el concepto de menus y sus posibilidades
- Entender la diferencia entre Toolbar y ActionBar
- Conocer como funcionan las notificaciones

# Contenidos

Una de la parte dentro del desarrollo movil es la de los menús ya que ofrecen la posibilidad de crear y gestionar acciones desde un mismo sitio colocado en la barra superior (de forma general) o de forma contextual desde cualquier elemento de la interfaz. Estos menús desde la version de android 3.0 se sitúan en la parte superior también llamada ActioBar, pero se pueden cambiar a un elemento llamado ToolBar la cual nos otorgará un control mucho mayor de los elementos que se pueden ejecutar. Por último, en este tema veremos las notificaciones emergentes, que aunque tienen mucho sentido cuando trabajamos con una aplicación con conexión en red, pueden ser útiles en alguno de los escenarios locales.

# Menús

Como ya se ha dicho los menus son las herramientas por defecto que permiten añadir funcionalidad extra en un solo sitio, siendo de primeras invisibles. Es importante saber que cada pantalla puede tener asignado un menú diferente

## Creación de un menu de opciones

Para poder trabajar con un menu de opciones, lo primero necesario es crearlos. Se puede crear programaticamente o como recurso. En este caso lo vamos a ver como recurso, ya que de esta forma el menu puede estar disponible para diferentes sitios. Para ello lo primero necesario es crear una carpeta dentro de res donde se vayan a alojar los recurso, por lo que con el botón derecho ya pulsado seleccionamos new --> android resource directory indicando como nombre menu y como tipo menu. Una vez hecho esto se crea una carpeta dentro de res con el nombre indicado. Es aquí donde se van a ubicar todos los recursos de tipo menu. Para poder crear un recurso de tipo menu, seleccionaremos con botón derecho crear un nuevo recurso de menu al cual se indicaremos el nombre, en este caso menu_principal. Esta acción crea un xml con el recurso del menu y si lo abrimos podemos tratarlo tanto gráficamente como por código. Mediante código nos encontraremos con los siguiente:

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
</menu>
```
Dentro de la etiquete menu tendremos que indicar todas las opciones que queramos que tenga nuestro menu, creando un elemento de tipo item para cada una de ellas

```xml
    <item android:title="Información"
        android:id="@+id/menu_informacion"
        />
```

El atributo title es el único obligatorio y es el que recoge el string que aparecerá asociado al elemento (puede estar declarado dentro de string.xml). Ek id es muy recomendable ya que será la forma de asociarlo a la pulsación desde la parte lógica. Además de estas opciones se pueden poner algunas adicionales: 

```xml
    <item android:title="Agregar dato"
        android:id="@+id/menu_agregar"
        android:icon="@android:drawable/ic_dialog_info"
        app:showAsAction="always"
        android:checkable="false"
        />
```

De estas opciones destacar showAsAction que permite poder indicar que la opción aparecerá como icono en la barra superior (las posibles configuraciones son always (siempre) ifRoom (solo si hay espacio) never (nunca)) y la de checkable la cual indica si la opción aparecerá como una opción con estilo RadioButton. Además de esto podemos tener submenus, para lo cual es necesario no autocerrar el item sino dejarlo abierto y meter un elemento de tipo menu dentro. Un ejemplo completo podría ser el siguiente

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item
        android:id="@+id/menu_agregar"
        android:checkable="false"
        android:icon="@android:drawable/ic_dialog_info"
        android:title="Agregar dato"
        app:showAsAction="always" />
    <item android:title="Navegación">
        <menu>
            <item
                android:id="@+id/menu_navegacion_1"
                android:title="Ir a la pantalla 1"
                />
            <item
                android:id="@+id/menu_navegacion_2"
                android:title="Ir a la pantalla 2"
                />
        </menu>
    </item>
    <item
        android:id="@+id/menu_salir"
        android:title="Salir" />


</menu>
```

## Configurar menu en la activity

Con el recurso creado el siguiente paso sería la configuración dentro de la aplicación del mismo. Para ello existen varias posibilidades, siempre dependiendo del tipo de barra superior con el que cuente la activity. Como se ha dicho el principio, por defecto la barra con la que se cuenta es una barra de ActioBar, la cual tienen una configuración muy sencilla pero tiene una personalización muy baja. Para poder poner un menú dentro de este tipo de barras basta con sobreescribir el método onCreateOptionMenu

```java
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
```

Este método tiene como parámetro un objeto de tipo menu, el cual es el menu que toda barra tiene, pero que solo es visible cuando se le pone algo. En el momento en el que se le pone el recurso que creamos en el punto anterior directamente aparecerá como menu de la aplicación. Para poder ponerlo, lo primero que se debe hacer es acceder al recurso mediante un objeto de tipo MenuInflater (muy similar al layout inflater que utilizamos constantemente en con binding) e indicar mediante el método inflate lo que queremos inflar (nuestro xml) y donde lo queremos poner (el menu que nos dan como parámetro)

```java
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return true
    }
```
Como se pude ver en la firma del método el método debe devolver true si se quiere mostrar el menu

Más delante veremos como poder configurar los menus y sus funcionalidades dentro de un Toolbar

## Configurar las pulsaciones dentro de un menu

Para poder configurar las pulsaciones tendremos que sobreescribir el método onOptionsItemSelected

```java
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
```

Dicho método tiene como parámetro un objeto de tipo menuItem, que será el elemento seleccionado dentro del menu que previamente hemos rellenado con el método el punto anterior. Al igual que hacemos con la evaluación de la pulsación de un menu, en este caso evaluaremos el id del menuItem pulsado, para así poder decidir que acción es la que queremos ejecutar

```java
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        
        when(item.itemId){
            R.id.menu_salir->{
                // accion para el menu salir
            }
            R.id.menu_navegacion_1->{
                // accion para el menu nav1
            }
            R.id.menu_navegacion_2->{
                // accion para el menu nav2
            }
            R.id.menu_salir->{
                // accion para el menu salir
            }
        }
        
        return true
    }
```
En cada una de las acciones podemos configurar diferentes acciones