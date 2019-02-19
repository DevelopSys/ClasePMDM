## 1. Aplicación Fragments

Realizar una aplicación que muestre el siguiente esquema de pantallas

SPLASH SCREEN: Pantalla de carga que mostrará un logo durante 5 segundos y después se cerrará
MAINACTIVITY: Pantalla que cargará dos fragments dependiendo de las pulsaciones:
- Fragment1: Mostrará un recycler view donde se mostrará una lista de versiones de android o la temática elegida. Al seleccionar una versión se cargará el fragment2 con el detalle de la selección. Al pulsar en el botón atrás la aplicación se cerrará
- Fragment2: Mostrará el detalle de la selección realizada en el fragment1. Al pulsar en el botón atras se cargará el fragment1

Entrega Domingo 3 de febrero

## 2. Aplicación Master / Detail: 

Realizar una aplicación que muestre el siguiente esquema de pantallas

SPLASH SCREEN: Pantalla de carga que mostrará un logo durante 5 segundos y después se cerrará
MAINACTIVITY: Pantalla que cargará tres fragments dependiendo de las pulsaciones y la orientación del teléfono:

### Orientación Portraint

- Fragment1: Mostrará un recycler view donde se mostrará una lista de países o la temática elegida. Gráficamente estará compuesto por el escudo del país y el nombre. Al seleccionar el país se cargará el fragment2 con la lista de equipos de la liga seleccionada. Al pulsar en el botón atrás la aplicación se cerrará
- Fragment2: Mostrará la lista de equipos de la selección realizada en el fragment1. El aspecto gráfico será del escudo del equipo y el nombre. Al pulsar en el botón atras se cargará el fragment1. Al pulsar en un equipo aparecerá el fragment3 con el detalle del mismo
- Fragment3: Mostrará el detalle del equipo seleccionado en el fragment3. Al dar en el boton atrás se cargará el fragment anterior

### Orientación Landscape

- Fragment1: Mostrará un recycler view donde se mostrará una lista de países o la temática elegida. Gráficamente estará compuesto por el escudo del país y el nombre. Se mostrará en la parte lateral de la pantalla. Al seleccionar el país se cargará el fragment2 con la lista de equipos de la liga seleccionada en la parte central de la pantalla. Al pulsar en el botón atrás la aplicación se cerrará
- Fragment2: Mostrará la lista de equipos de la selección realizada en el fragment1 en la parte central de la pantalla. El aspecto gráfico será del escudo del equipo y el nombre. Al pulsar en el botón atrás la aplicación se cerrará. Al pulsar en un equipo aparecerá el fragment3 en la parte central con el detalle del mismo
- Fragment3: Mostrará el detalle del equipo seleccionado en el fragment3 en la parte central. Al dar en el botón atrás se cargará el fragment anterior en la parte central de la pantalla

La aplicación deberá controlar los fragments o estados cargados en pila (no cargar aquellos ya cargados, gestionar la pulsación del onBackPressed(), etc...)

Entrega Domingo 3 de febrero

## 3. Navigation - Coordinator - Base datos

Realizar una aplicación que tenga la siguiente funcionalidad
1. Parte central donde se cargarán los fragments: o un recyclerview con la lista de los elementos seleccionados mediante el menú o el detalle del elemento seleccionado. En el caso de hacer scroll la parte del toobar deberá desaparecer

2. Menú lateral con las siguientes opciones:

Header:

Mostrará una imagen y un spinner con las opciones todos, juegos, fútbol y multimedia. Al seleccionar cada una de las opciones cambiará tanto el menú como la imagen de cabecera

Opciones todos:
1a Juegos: Cargará un fragment con un recycler view relleno con juegos de todas las plataformas
1b Multimedia: Cargarña un fragment con un recycler view relleno con elementos multimedia de todos los soportes
1c Fútbol: Cargará un fragment con un recycler view relleno con equipos de fútbol de todas las cometiciones 
1d SearchView: al introducir un nombre cargará el detalle del elemento cuyo nombre coincida con lo introducido. En el caso de haber dos iguales cargará un fragment con un recycler view con los elementos

Opciones juegos:
1a PS4: Cargará un fragment con un recycler view relleno con juegos PS4
1b XBOX: Cargarña un fragment con un recycler view relleno con juegos de XBOX
1c PC: Cargará un fragment con un recycler view relleno con juegos de pc
1d SearchView: al introducir un nombre cargará el detalle del juego cuyo nombre coincida con lo introducido. En el caso de haber dos iguales cargará un fragment con un recycler view con los juegos

Opciones multimedia:
1a Películas: Cargará un fragment con un recycler view relleno con peliculas
1b Series: Cargarña un fragment con un recycler view relleno con series
1c Múscia: Cargará un fragment con un recycler view relleno con discos
1d SearchView: al introducir un nombre cargará el detalle del elemento cuyo nombre coincida con lo introducido. En el caso de haber dos iguales cargará un fragment con un recycler view con los elementos

Opciones futbol:
1a La Liga: Cargará un fragment con un recycler view relleno con equipos de la liga
1b Champion: Cargarña un fragment con un recycler view relleno con equipos de la champion
1c Mundial: Cargará un fragment con un recycler view relleno con selecciones
1d SearchView: al introducir un nombre cargará el detalle del equipo cuyo nombre coincida con lo introducido. En el caso de haber dos iguales cargará un fragment con un recycler view con los equipos

![Práctica colección](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/coleccion1.png "Práctica colección")
![Práctica colección](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/coleccion2.png "Práctica colección")
![Práctica colección](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/coleccion3.png "Práctica colección")
![Práctica colección](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/coleccion4.png "Práctica colección")
![Práctica colección](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/coleccion5.png "Práctica colección")

Para que el proyecto no sea tan pesado las imágenes tendrán que ir cargadas mediante Glide o Picasso

Entrega Domingo 24 de Febrero
