# Proyecto Semillero Java Indra ☕

## Conceptos vistos
- Herencia
- Polimorfismo
- Encapsulamiento
- Arrays
- Sobrecarga de métodos
- Archivos EAR, JAR y WAR
- Clase Object
- Clase Abstract
- Proyecto Maven
- Manejo de dependencias
- Manejo del archivo pom.xml

### Requerimientos del proyecto

La librería maneja 3 productos, Libros, Revistas y Artículos Científicos. Cada uno de estos productos maneja un inventario, es decir, para poder vender se debe tener una cantidad mayor a cero.

El sistema debe realizar lo siguiente: 

1. Permitir la creación de los artículos, es decir, sea que ingresen los datos de los artículos por consola, interfaz grafica (en swing) o por archivo texto. Para simplificar, los productos solo tienen un autor, una edición o un editorial, etc. 

2. Cada articulo creado se le debe poder ingresar un inventario, que básicamente es colocar una cantidad para poder vender. 

3. El proceso de venta debe ser sencillo, cuando el usuario consulta el articulo, se debe retornar el nombre, el precio unitario y la cantidad disponible; en caso que exista cantidad, el usuario puede realizar la venta digitando la cantidad a vender, luego el sistema debe restar del inventario la cantidad vendida y por pantalla debe presentar el valor total a pagar. No se debe generar facturas, ni nada por el estilo, es muy básico. Nota: en la venta se debe indicar la cantidad a vender y los datos necesarios para identificar el articulo. 

**Nota:** Se agregaron algunas funcionalidades adicionales para aplicar los conceptos vistos.

## Proceso de desarollo
En este desarollo, se establecieron 2 diferentes ramas, la rama **SinBD** y la rama **conBD**.
El proyecto se desarrolló con Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components).
> La librería de Java utilizada fue:  
![image](https://user-images.githubusercontent.com/80859223/164769120-d2f95cfd-6869-448b-afbd-96246c817a85.png)


#### SinBD
Esta rama implementa el proyecto de la libreria sin conexión a base de datos, todo se realiza con listas de objetos (Inventario, Libro, Revista, Articulo). También se implementó la libreria POI para generar un reporte Excel.
- Proyecto con Maven ✅
- Herencia ✅
- Polimorfismo ✅
- Manejo de Listas Array ✅
- Encapsulamiento ✅
- Abstracción ✅

#### conBD
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

# Tecnologías utilizadas

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164781711-93cfe3a4-f7a4-416d-946e-d6e57e22a3e0.png" />
</p>


<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164781878-b0c6ab6a-4142-4e8b-909b-0959718306e3.png" />
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164782052-634f10a7-4765-415c-b983-51d36dd22c22.png" />
</p>


<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164782178-c55c61cc-8023-40bf-87f3-5f9775ef2d64.png" />
</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164782428-ff6709c5-feeb-4cd8-8f5a-120075c5ec33.png" />
</p>


<p align="center">
  <img src="https://user-images.githubusercontent.com/80859223/164782539-b9854400-b7bb-402d-a959-e514dc574e30.png" />
</p>









