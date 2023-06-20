# Instalación de las librerías de Dart y Flutter

Para poder empezar a trabajar con Flutter es ncesario tener descargado tanto el sdk de Dart como el de Flutter. Ámbos van unidos y se pueden descargar desde el siguiente link https://docs.flutter.dev/get-started/install. Dependiendo de cual sea el sistema operativo tendrá unos pasos u otros.

## Instalación en windows

Para la instalación en windows es necesario seguir los pasos:

1. descargar el .zip con el contenido de todas las librerías requeridas para el desarrollo.
2. Una vez descargado, se descomprime en una ruta (importante ubicarla bien)
3. Modificar las rutas de las variables de entorno, agregando la nueva de flutter.

## Instalación en mac

Los pasos de la instalación son muy parecidos a los de windows

1. Descargar el .zip
2. Descomprimirlo en una ruta conocida
3. Añadir fluter a la variable de entorno, ejecutando el siguiente comando en la terminal:

```shell
export PATH="$PATH:`pwd`/flutter/bin"
```

Es imporatante que este comando se ejecute estando en la ruta de la carpeta bin (ubicada dentro del zip que se ha descargado)

Una vez seguidos estos pasos, lo último que quedá es (tanto en windows como en mac) ejecutar el comando

```shell
flutter doctor
```

Este comando saltará un aviso de todas las instalaciones necesarias que tendremos que tener para poder desarrollar en flutter. Entre estos requisitos esta:

- Visual Studio Code con extensiones de Dart y Flutter
- Android Studio con licencias de android aceptadas y plataformas instaladas
- Vistual devices desplegados
- Chrome
- Cocoa y XCode en el caso de MacOS

Ademas de instalaciones locales, las licencias de android se aceptan mediante la ejecución del siguiente comando

```shell
flutter doctor --android-license
```

## IDEs

Los IDEs que se pueden utilizar para el desarrollo flutter son tanto VSCode como AndroidStudio. En el caso de VSCode tendemos que instalar las extensiones de Flutter y Dart (van juntas), mientras que en el caso de Android Studio tendremos que instalar el plugin rde Flutter (incluye el de Dart por defecto)

## Creación del primer proyecto

Una vez realizados todos los pasos anteriores, podremos empezar a crear nuestros proyectos. En el caso de querer hacerlos desde Antroid Studio, se puede hacer directamente sin necesidad de entrar en la línea de comandos ya que mediante el wizard se puede crear de forma sencilla, indicando cual es el alcance del proyecto y cual es la ubicación del sdk para el desarrollo (carpeta que descomprimimos en los puntos anteriores)

En el caso de querer querar un proyecto para realizar el desarrollo desde VSCode, podremos crear el proyecto desde la línea de comando introduciendo lo siguiente:

```shell
flutter create my_app
```

Esto creará toda la estructura de carpetas que se verá más adelante
