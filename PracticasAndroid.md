## 1. Aplicación Fragments

Realizar una aplicacion que muestre el siguiente esquema de pantallas

SPLASH SCREEN: Pantalla de carga que mostrará un logo durante 5 segundos y después se cerrará
MAINACTIVITY: Pantalla que cargará dos fragments dependiendo de las pulsaciones:
- Fragment1: Mostrará un recycler view donde se mostrará una lista de versiones de android o la temática elegida. Al seleccionar una versión se cargará el fragment2 con el detalle de la seleccion. Al pulsar en el botón atras la aplicación se cerrará
- Fragment2: Mostrará el detalle de la selección realizada en el fragment1. Al pulsar en el botón atras se cargará el fragment1

Entrega Domingo 3 de febrero

## 2. Aplicación Master / Detail: 

Realizar una aplicacion que muestre el siguiente esquema de pantallas

SPLASH SCREEN: Pantalla de carga que mostrará un logo durante 5 segundos y después se cerrará
MAINACTIVITY: Pantalla que cargará tres fragments dependiendo de las pulsaciones y la orientacioón del teléfono:

### Orientacion Portraint

- Fragment1: Mostrará un recycler view donde se mostrará una lista de paises o la temática elegida. Gráficamente estará compuesto por el escudo del pais y el nombre. Al seleccionar el pais se cargará el fragment2 con la lista de equipos de la liga seleccionada. Al pulsar en el botón atras la aplicación se cerrará
- Fragment2: Mostrará la lista de equipos de la selección realizada en el fragment1. El aspecto gráfico será del escudo del equipo y el nombre. Al pulsar en el botón atras se cargará el fragment1. Al pulsar en un equipo aparecerá el fragment3 con el detalle del mismo
- Fragment3: Mostrará el detalle del equipo seleccionado en el fragment3. Al dar en el boton atrás se cargará el fragment anterior

### Orientacion Landscape

- Fragment1: Mostrará un recycler view donde se mostrará una lista de paises o la temática elegida. Gráficamente estará compuesto por el escudo del pais y el nombre. Se mostrará en la parte lateral de la pantalla. Al seleccionar el pais se cargará el fragment2 con la lista de equipos de la liga seleccionada en la parte central de la pantalla. Al pulsar en el botón atras la aplicación se cerrará
- Fragment2: Mostrará la lista de equipos de la selección realizada en el fragment1 en la parte central de la pantalla. El aspecto gráfico será del escudo del equipo y el nombre. Al pulsar en el botón atrás la aplicación se cerrará. Al pulsar en un equipo aparecerá el fragment3 en la parte central con el detalle del mismo
- Fragment3: Mostrará el detalle del equipo seleccionado en el fragment3 en la parte central. Al dar en el boton atrás se cargará el fragment anterior en la parte central de la pantalla

La aplicación deberá controlar los fragments o estados cargados en pila (no cargar aquellos ya cargados, gestionar la pulsación del onBackPressed(), etc...)

Entrega Domingo 3 de febrero