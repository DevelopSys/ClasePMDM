# Índice



# Objetivos

- Conocer el concepto de fragments y los diferentes tipos
- Entender el ciclo de vida de un fragments
- Utilizar fragments, creación, modificación y remplazo
- Comunicar fragments entre activity y otros fragments
- Conocer como funcionan las notificaciones

# Contenidos
[Volver arriba](#índice)
HAsta este punto se ha visto como poder manejar pantallas dentro de una aplicación mediante Activitys comunicadas con Intents. Sin embargo este tipo de diseño imposibilita la modularidad, ya que cada elemento es individual y no tiene mucha relación con el resto más allá de los intents que puedan compartir. Desde la versión 3.0 se introduce el concepto de fragments, los cuales favorecen dicha modularidad. Podemos definir un fragment como una parte de la pantalla que puede ser reutilizada en varias sitios, teniendo un ciclo de vida propio. Una de las grandes capacidades de los fragments es el de permitir que para dispositivos grandes se puedan visualizar elementos de diferente que para dispositivos pequeños. El ejemplo más claro de esto es que una aplicación no debería verse igual en un móvil de 5 pulgadas que en una tablet de 11 pulgadas. Con los fragmentes tendremos la posibilidad de modular la pantalla y decidir que partes se muestran dependiendo del tamaño de la pantalla, siempre mostrando la misma activity pero con diferentes contenido (fragments)


# Tipos de fragments 
[Volver arriba](#índice)

Como se ha comentado antes, los fragments son elementos que permiten la modulación dentro de la pantalla. A grandes rasgos, un fragment es un elemento individual (con xml propio) que se incorpora dentro de una activity. Esta incorporación puede ser de dos tipos: estática (se declara el elemento en el xml de la pantalla) o dinámica (no se declara el elemento, sino que puede ser cambiante). Dependiendo de cual sea el uso que se quiera dar, utilizaremos uno u otro. Por ejemplo si todas las pantallas de nuestra aplicación tienen la misma cabecera, podremos crear un fragment estático para agregarlo en cada una de las pantallas

## Ciclo de vida de los fragments

Como se verá más adelante, los fragments son partes de la interfaz que tienen la capacidad de aparecer / desaparecer dependiendo de multitud de factores como pueden ser interacción con el usuario, configuraciones de la pantalla, etc... Muchos de los métodos son compartidos con las activitys, existiendo diferencia con los elementos que asocian / eliminan el fragment con la pantalla. El ciclo de vida comparado con el de las pantallas es el siguiente: 


<img src="../images/t7_ciclovida_fragments.png" alt="drawing" width="200"/>


## Creación de fragments

Los fragments, al igual que las activitys están representados por una clase separada, la cual extiende de Fragments. Al ser un elemento lógico, no es necesario declararlo en el AndroidManifest.xml, pero si es necesario que tenga una parte gráfica por lo que los elementos que forman un Fragment son:

- fragment_layout.xml: fichero que representa la parte lógica del fragment 
- MainFragment.kt: fichero que representa la parte lógica del fragment

Para poder crear uno, teniendo en cuenta las dependecias de archivos que acabamos de comentar quedaría de la siguiente forma:

```java
class BlankFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }
    
}
```
Como se puede ver en el código anterior, la clase extiende de Fragment y trae por defecto un método (el único obligatorio) que es el onCreateView (muy similar al método onCreate de las activitys). Esté método se encarga de asocias la parte lógica con la parte gráfica. Además de este método, se pueden utilizar métodos del ciclo de vida del fragment al igual que pasaba en las activtys, poniendo especial interés en el método onAttach() y onDetach(). Ambos métodos se ejecutan cuando el fragment se asocia a la parte de la pantalla que se quiere y cuando se desasocia (recordad que los fragments son partes de la pantalla que pueden aparecer y desaparecer)
