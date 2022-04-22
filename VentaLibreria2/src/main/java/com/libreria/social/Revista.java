package com.libreria.social;

/**
 * Clase Revista hija de Inventario, tiene un atributo adicional contadorRevista para llevar un registro
 * de las Revistas agregadas.
 *  
 * @author Indra
 * @category Herencia
 * 
 */

public class Revista extends Inventario {
	private static int contadorRevista = 0;
	
	
	/**
	 * Constructor simple, en este proyecto se usa para obtener la informaci�n de los descuentos sin afectar
	 * la variable contadorRevista
	 * 
	 */	
	
	public Revista() {
		super();
	}
	
	/**
	 * Constructor para cada revista que se agrega, cada vez el contadorRevista va aumentando.
	 * 
	 * @param  tipo
	 * 		   Recibe el tipo de producto que se est� ingresando al inventario (Libro, Revista, Articulo).
	 * 
	 * @param  nombre
	 *         Recibe el nombre del producto.
	 *         
	 * @param  autor
	 *         Recibe autor del procuto.
	 *         
	 * @param  editorial
	 *         Recibe el editorial.
	 *         
	 * @param  cantidad
	 * 		   Recibe la cantidad de libros a agregar.
	 * 
	 * @param  precioUnitario
	 * 		   Recibe el precio unitario, con o sin decimales.
	 * 
	 */
	
	public Revista(String tipo, String nombre, String autor, String editorial, int cantidad, double precioUnitario) {
		super(tipo, nombre, autor, editorial, cantidad, precioUnitario);
		contadorRevista++;
	}
	
	/**
	 * M�todo que retorna un entero, se realiza de manera est�tica para no tener que inicializar el objeto Revista.
	 * 
	 * 
	 */
	
	public static int getContadorRevista() {
		return contadorRevista;
	}
	
	/**
	 * M�todo que retorna un entero, en esta clase se aumenta por un valor de 10 para aplicar el polimorfismo.
	 * 
	 * @category Polimorfismo
	 */
	
	public int getDescuento() {
		return super.descuento+10;
	}
}
