# Rama SinBD

Esta rama implementa el proyecto de la libreria sin conexión a base de datos, todo se realiza con listas de objetos (Inventario, Libro, Revista, Articulo). También se implementó la libreria POI para generar un reporte Excel.

- Proyecto con Maven ✅
- Herencia ✅
- Polimorfismo ✅
- Manejo de Listas Array ✅
- Encapsulamiento ✅
- Abstracción ✅

## Proceso de desarrollo
Antes de comenzar a desarrollar, se creó un diagrama básico para ver cómo funcionaba la herencia en este caso. Primero definimos una clase Abstracta llamada Inventario (Esta clase será la que contendrá los métodos que se van a utilizar).

El diagrama tiene 2 Clases de tipo Interface para así establecer los servicios que contendrá el proyecto.

## Diagrama
![diagram](https://user-images.githubusercontent.com/80859223/163813306-2f3a6c0f-4233-4db7-b6d5-791c272a84e0.png)

### Estructura del proyecto en Eclipse

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164770654-706af5a4-9201-4a05-b900-8f006c289209.png" />
</p>
El proyecto se dividió en paquetes, algunos paquetes se encargan de contener la información de cada Clase (Modelo). Otro paquete se encarga de contener las Clases que interactuar con el usario (Vista). Y por último, hay unos paquetes que se encargan de la gestión de listas y la transferencia de información entre instancias de Objetos.

### Dependencias utilizadas

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164771134-a0a2ac04-9b2e-45fa-be59-38d890a8f9f2.png" />
</p>

### Proyecto desglosado

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164771451-24f44bfe-8631-45e6-933a-26b9665004ca.png" />
</p>

> Para ver el proyecto completo, pueden hacer un git clone https://github.com/dernaut/proyecto-semillero-java/tree/SinBD


