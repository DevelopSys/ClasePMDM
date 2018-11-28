## Practica de cuatrimestre
****

Realizar una aplicación de memory que simule el juego de parejas de cartas. El contenido de la aplicación será el siguiente:

1. Pantalla Splash que se muestre durante 5 segundos el Logo de la aplicación
2. Pantalla principal de la aplicación que tenga los siguientes componentes:
- Botón que inicia el juego.
Al pulsar este boton aparecerá un cuadro de diálogo con un spinner para seleccionar la dificultad
- Botón que inicia la lista de puntuaciones
3. Pantalla de juego que mostrará una serie de cartas (8, 12, 16, ó 20) junto con una barra de progreso, el tiempo restante y la puntuación
4. Diálogos que aparecerán tras completar el juego (dependerán del éxito del juego)

### Funcionalidad

Se seleccionarán dos cartas una tras otra. 
En el caso que tengan el mismo logo se quedarán descubiertas y se sumarán puntos al marcador. En el caso de que sean distintas se darán la vuelta ambas y se retarán puntos al marcador. Para finalizar el juego se pueden dar 3 situaciones:

1. Todas las cartas han quedado descubiertas antes de terminar el tiempo y la puntuación es mayor que 0: aparecerá un cuadro de diálogo dando la enhorabuena y pidiendo el nombre del jugador para poder registrarlo en las puntuaciones
2. Todas las cartas han quedado descubiertas antes de terminar el tiempo y puntuación sea 0 o negativa: aparecerá un cuadro de diálogo avisando que el juego se ha superado sin puntuación
3. El tiempo se ha terminado antes de descubrir todas las cartas: aparecerá un cuadro de diálogo avisando que se ha perdido

Records La pantalla de récords mostrará el nombre de usuario con la puntuación obtenida dificultad y un logo aleatorio de todos aquellos que hayan superado el juego

### Reglas

Tanto el número de cartas que aparecerán como las puntuaciones dependen de la dificultad

1. Aficionado: 8 cartas (4 pares), cada acierto +3 cada fallo -1, tiempo de juego 0:20
2. Proncipiante: 12 cartas (6 pares), cada acierto +3 cada fallo -2, tiempo de juego 0:30
3. Cinefilo: 16 cartas (8 pares), cada acierto +3 cada fallo -3, tiempo de juego 0:40
4. Director: 20 cartas (10 pares), cada acierto +3 cada fallo -4, tiempo de juego 1:00

Al terminar se sumará el tiempo restante a la puntuación

### Programación

La práctica deberá tener los siguientes requisitos:

1. Reyclerview con adaptador personalizado
2. Spinner con adaptador personalizado
3. Tratamiento de imágenes
4. Dataset para la gestión de arraylist de cartas
5. Interfaces de callback para la comunicación de diálogos

### Entrega

13 de diciembre compartiendo el código mediante la carpeta de prácticas y enseñarme la app en clase. Aquel que no entrege **nada** de la aplicación estará suspenso

### Imágenes

![Práctica final](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/memory1.png "Práctica versiones") ![Práctica final](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/memory2.png "Práctica versiones") ![Práctica final](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/memory3.png "Práctica versiones") ![Práctica final](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/memory4.png "Práctica versiones")