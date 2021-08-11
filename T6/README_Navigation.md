# Navigation component	
Además de la forma tradicional de navegación entre fragments mediante los elementos vistos FramentManager y FragmentTransaction, Android saco un conjunto de librerias llamadas Jetpack que ofrecen la posibilidad de utilizar componentes adicionales que reducen código y mejoran la funcionalidad en algunos aspectos. 

En lo que a manejo de fragment se supone, el componente en cuestion es el Navigation, libreria que permite manejar la redireccion de fragments si necesidad de utilizar el fragment manager ni el fragment transaction. En este caso los elementos básicos que permiten toda la funcionalidad son: 

- Gráfico de navegación: Definido mendiante un archivo xml que permite indicar los fragment existentes y cuales son cada una de las acciones que llevan a otro fragment. Se puede hacer también con activitys, dialogFragment, etc...
- Host: Se trata del elemento gráfico donde se ubicarán los fragmnets que estén definidos en el grafico de navegacion. Este host se define como etiqueta fragment dentro del xml de la activity donde se quiere se aparezcan los fragments
- Controller: Se trata del elemento que posibilita la navegación entre los fragments definidos. Es importante tener en cuenta que la navegación se realiza mediante acciones, no llamando a los fragments como se verá más adelante. 

## Configuraciones iniciales

Antes de empezar con la implementación de la solución propuesta, es necesario traer todas las librerias necesarias para poder funcionar. Por ello se implementarán las siguientes

````
    implementation 'androidx.navigation:navigation-fragment:2.3.5'
    implementation 'androidx.navigation:navigation-ui:2.3.5'
````

Ambas librerias permiten tener disponible todos los elementos que son necesarios para realizar la navegación. 

Para este ejemplo se realizará una aplicación simple de navegacion entre 3 fragments y un cuadre de diálogo. Para ello se cuenta con:

- MainActivity que servirá de base para mostrar los fragments declarados en el gráfico
- HomeFragment: fragment que se mostrará al inicio de la aplicación
- LogInFragmnet: fragment que se mostrará si el usuario pulsa la opcion de LogIn en el fragment de Home
- RegisterFragment: fragment que se mostrará si el usuario pulsa la opcion de SignIn en el fragment de Home
- MainFragment: fragment que se mostrará si el usuario ha metido bien las credenciales en el fragment de LogIn
- DialogUser: dialogFragment que será lanzado solo desde si el usuario ha accedido a la aplicación

Para poder empezar, es necesario plantear cual es la navegación que se quiere dentro de la aplicación. En este caso será la siguiente:

![navigation flow](./images/navigation.png)

