# Rama conBD

Esta rama implementa el proyecto de la libreria con conexión a base de datos, todo se realiza con instancias de objetos para visualizar la información. Se implementó HikariCP para el majeo de las conexiones.

- Proyecto con Maven ✅
- Herencia ✅
- Polimorfismo ✅
- Manejo de Listas Array ✅
- Encapsulamiento ✅
- Abstracción ✅
- Conexión a BD ✅
- Implementación de CRUD ✅
- Implementación de Pool ✅

## Proceso de desarrollo

Antes de comenzar a desarrollar, se creó un diagrama básico para ver cómo funcionaba el proyecto. Primero definimos los modelos de las Clases que se van a usar, cada Clase tiene un controlador que se encarga de comunicarse entre el menú principal y la base de datos. La conexión a la BD se hace por medio de una Clase adicional llamada ProductoDAO.

## Diagrama

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164778926-8aeb9740-1f0e-44b4-bd00-c870c809a86e.png" />
</p>

### Estructura del proyecto en Eclipse

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164779497-1a05ecae-411d-4068-8213-d6bc14a62f73.png" />
</p>

Se implementó el patrón de diseño MVC junto con el patrón DAO para la transferencia de información a la BD. 
- En el paquete model se definieron las clases principales para instanciar los Objetos. 
- En el paquete controller se definieron los controladores de cada una de las clases modelo, esto con el fin de realizar toda la logica del proyecto sin afectar las otras clases.
- En el paquete interface se encuentra la interface implementada desde el MenuPrincipal (Agregar, Editar, Eliminar, Listar).
- En el paquete diccionario se definió un simple método para saber si el producto es Libro, Revista o Artículo.
- En el paquete persistenca se encuentra la conexión con el Pool a la base de datos (static).
- En el paquete view se definieron algunos métodos para obtener información por consola y para listar los diferentes objetos recibidos de la base de datos.
- En el paquete mvc se implementó el menú principal para permitirle al usuario acceder a las diferentes operaciones.

### Dependencias utilizadas

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164780905-c4737110-f6ea-4aec-8226-237fff699191.png" />
</p>


### Proyecto desglosado

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164781010-50bc84eb-732a-4be2-8db1-4bea41629d08.png" />
</p>

> Para ver el proyecto completo, pueden hacer un git clone https://github.com/dernaut/proyecto-semillero-java/tree/conBD




