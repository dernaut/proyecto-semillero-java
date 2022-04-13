package com.libreria.social;

/**
 * Clase Articulo hija de Inventario, tiene un atributo adicional contadorArticulo para llevar un registro
 * de las Revistas agregadas.
 *  
 * @author Indra
 * @category Herencia
 * 
 */

public class Articulo extends Inventario {
	private static int contadorArticulo = 0;
	
	/**
	 * Constructor simple, en este proyecto se usa para obtener la información de los descuentos sin afectar
	 * la variable contadorRevista
	 * 
	 */	
	
	public Articulo() {
		super();
	}
	
	/**
	 * Constructor para cada articulo que se agrega, cada vez el contadorArticulo va aumentando.
	 * 
	 * @param  tipo
	 * 		   Recibe el tipo de producto que se está ingresando al inventario (Libro, Revista, Articulo).
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
	
	public Articulo(String tipo, String nombre, String autor, String editorial, int cantidad, double precioUnitario) {
		super(tipo, nombre, autor, editorial, cantidad, precioUnitario);
		contadorArticulo++;
	}
	
	/**
	 * Método que retorna un entero, se realiza de manera estática para no tener que inicializar el objeto Revista.
	 * 
	 * 
	 */
	
	
	public static int getContadorArticulo() {
		return contadorArticulo;
	}
	
	/**
	 * Método que retorna un entero, en esta clase se aumenta por un valor de 5 para aplicar el polimorfismo.
	 * 
	 * @category Polimorfismo
	 */
	
	public int getDescuento() {
		return super.descuento+5;
	}
	
}
