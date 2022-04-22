package com.libreria.social;


/**
 * Clase Libro hija de Inventario, tiene un atributo adicional contadorLibro para llevar un registro
 * de los libros agregados.
 *  
 * @author Indra
 * @category Herencia
 * 
 */
public class Libro extends Inventario{
	private static int contadorLibro = 0;
	
	/**
	 * Constructor simple, en este proyecto se usa para obtener la información de los descuentos sin afectar
	 * la variable contadorLibro
	 * 
	 */	
	public Libro() {
		super();
	}
	
	/**
	 * Constructor para cada libro que se agrega, cada vez el contadorLibro va aumentando.
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
	
	public Libro(String tipo, String nombre, String autor, String editorial, int cantidad, double precioUnitario) {
		super(tipo, nombre, autor, editorial, cantidad, precioUnitario);
		contadorLibro++;
	}
	
	/**
	 * Método que retorna un entero, se realiza de manera estática para no tener que inicializar el objeto libro.
	 * 
	 * 
	 */
	
	public static int getContadorLibro() {
		return contadorLibro;
	}
	
	/**
	 * Método que retorna un entero, en esta clase se aumenta por un valor de 20 para aplicar el polimorfismo.
	 * 
	 * @category Polimorfismo
	 */
	public int getDescuento() {
		return super.descuento+20;
	}
	
}
