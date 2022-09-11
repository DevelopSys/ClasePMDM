<a name="tema1"></a>
## POO Java 

a.	Sintaxis básica, variables, bucles
- http://www.developandsys.es/estructuras-control-java/
- http://www.developandsys.es/variables-java/
- http://www.developandsys.es/string-java/

#### [Volver al índice](#tema1)
***

b.	Colecciones
- http://www.developandsys.es/arrays-java/
- http://www.developandsys.es/operaciones-con-array/
- http://www.developandsys.es/colecciones-dinamicas-arraylist/
- http://www.developandsys.es/colecciones-dinamicas-hashtable/

#### [Volver al índice](#tema1)
***

c.	Clases y objetos
- http://www.developandsys.es/clases-y-objetos/
- http://www.developandsys.es/clases-abstractas/

#### [Volver al índice](#tema1)
***

d.	Métodos, sobrecarga y sobreescritura

#### [Volver al índice](#tema1)
***

e.	Herencia y Polimorfismo

#### [Volver al índice](#tema1)
***

f.	Tratamiento de ficheros

- http://www.developandsys.es/ficheros-flujo-de-datos/

#### [Volver al índice](#tema1)
***

**Ejercicios clase**

- Mostrar por consola la fecha y hora, personalizando el saludo dependiendo de la hora del día. El mensaje se repetirá hasta que se indique que no se quiere volver a consultar la hora. Para ello se deberá pedir el nombre al usuario nada más arrancar el programa y una vez pulsado Enter se mostrar el mensaje: 

"Por favor introduce tu nombre: "

"Buenos días (tardes o noches) Luis, Son las  10:30 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" S

"Buenos días (tardes o noches) Luis, Son las  10:32 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" S

"Buenos días (tardes o noches) Luis, Son las  10:34 del 12 de Setiembre de 2019"

"¿Quieres volver a comprobar la hora?:" N

"Que tengas buen día"

- Crear un array de elementos de tipo integer con 50 posiciones. Crear un menú que tenga las siguientes opciones:
	- Rellenar: introducirá números de forma aleatoria (estarán comprendidos entre 1 y 200). En caso de que el array esté ya lleno pedirá confirmación.
	- Listar: mostrará por pantalla el contenido del array con la sintaxis: Elemento 1: X
	- Ordenar: ordenará el array con números de menos a mayor.
	- Vaciar: dejará el array vacío
	- Salir: terminará la ejecución del programa

- Crear un juego de adivinación de números. Para ello, nada mas empezar el programa se generará un número aleatorio entre 1 y 100. El programa pedirá al usuario que introduzca números enteros hasta encontrar el correcto. Al finalizar indicará el número de intentos alcanzado. (Opcional: hacerlo iterativo, de forma que al terminar una adivinación pregunte si se quiere volver a intentar. Cada vez que se termina se indica el número de intentos medio, el número mínimo de intentos necesitados y si se ha superado el record)

- Desarrollar un programa que gestione temperaturas máximas y mínimas, y el programa calcule los extremos. Para ello hay que utilizar una coleccion de tipo ArrayList Algunas consideraciones a tener en cuenta son:
a. Para introducir temperaturas el programa me pedirá un dato doublé
b. Cuando me devuelva los extremos y la media, el programa me devolverá un dato double
c. Los datos deberán ser guardados de forma dinámica (con un ArrayList)

El menú mediante el cual se introducen los datos es el siguiente:

1. Introducir temperaturas
2. Mostrar temperaturas
3. Ordenar temperaturas
4. Mostrar extremos
5. Mostrar medias
6. Salir

- Crear una apliación que permita la gestion de usuarios de tipo Alumno. Para ello hay que tener en cuenta que debe existir un Alumno que tenga nombre (string), apellido (string), dni (string) y matrícula (int). Mediante un menú se podrán realizar las siguientes operaciones:

1. Agregar alumno
2. Buscar alumno
3. Borrar alumno
4. Listar alumnos
5. Listar dnis
5. Salir

En cada una de las opciones se pedirán los datos asociados a la opción. Hay que tener en cuenta que no puede haber dados de alta dos alumnos que tengan el mismo dni. Realizar la programación para que la matrícula se genere de forma automática y no esté ya introducida en el sistema 

En todos los casos deben existir mensajes de confirmación tanto si la operación se ha llevado a cabo como si se ha producido algún fallo. Para la realización del problema utilizar una colección de tipo HashTable


