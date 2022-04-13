package com.libreria.social;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.libreria.social.interfaces.Tienda;


/**
 * Esta clase abstracta Inventario nos permite globalizar las 3 clases hijas, así mismo, el Inventario implementa
 * los servicios de la interface Tienda para manejar un control de las operaciones.
 * @author Indra
 * @category Super clase
 * 
 */
public abstract class Inventario implements Tienda{
	private String tipo;
	private String nombre;
	private String autor;
	private String editorial;
	private int cantidad;
	private double precioUnitario;
	private String fechaRegistro;
	protected int descuento=0;
	
	
	/**
	 * Constructor simple
	 * 
	 * 
	 */	
	public Inventario() {
		super();
	}
	
	
	/**
	 * Constructor para cada producto que se agrega, la fecha de registro se pone automáticamente
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
	public Inventario(String tipo, String nombre, String autor, String editorial, int cantidad, double precioUnitario) {
		super();
		
		this.tipo = tipo;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
		this.fechaRegistro = dtf.format(LocalDateTime.now());
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	
	/**
	 * Este método nos permite restar la cantidad de un determinado producto, retorna false si la cantidad
	 * es menor o igual que cero.
	 * 
	 * @param  cantidad
	 *         Recibe la cantidad de productos para así restarlo con la cantidad actual.
	 * 
	 */
	public boolean restarCantidad(int cantidad) {
		this.cantidad = this.cantidad - cantidad;
		return (cantidad <= 0)? false : true;
	}
	
	/**
	 * Este método nos permite aumentar la cantidad de un determinado producto, retorna verdadero al completar la tarea.
	 * 
	 * @param  cantidad
	 *         Recibe la cantidad de productos para así sumarlo con la cantidad actual.
	 * 
	 */
	public boolean sumarCantidad(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
		return true;
		}
	
	public int getDescuento() {
		return descuento;
	}
	
	/**
	 * Este método nos permite listar la informacion completa de un producto.
	 * 
	 */
	public void listarProducto() {
		System.out.println("");
		System.out.println("---------------------------------------------------");
		System.out.println("Tipo de producto: "+this.tipo);
		System.out.println("Nombre: "+this.nombre);
		System.out.println("Autor: "+this.autor);
		System.out.println("Editorial: "+this.editorial);
		System.out.println("Cantidad: "+this.cantidad);
		System.out.println("Precio: "+this.precioUnitario);
		System.out.println("Fecha de registro: "+this.fechaRegistro);
	}
	
	public List<String> retornarListaProducto() {
		List<String> list = new ArrayList<>();
		list.add(this.tipo);
		list.add(this.nombre);
		list.add(this.autor);
		list.add(this.editorial);
		list.add(String.valueOf(this.cantidad));
		list.add(String.valueOf(this.precioUnitario));
		return list;
		
	}
	
}
