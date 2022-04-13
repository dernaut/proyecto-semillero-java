package com.libreria.social.implementacion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.libreria.social.Articulo;
import com.libreria.social.Inventario;
import com.libreria.social.Libro;
import com.libreria.social.Revista;
import com.libreria.social.diccionario.diccionarioMap;
import com.libreria.social.interfaces.IOperacionesCaja;
import com.libreria.social.reportes.CrearReportes;


public class ImplementacionCaja implements IOperacionesCaja{
	
	static List<Inventario> productos = new ArrayList<Inventario>();
	

	public boolean comprarProducto() {
		System.out.println("///////////////////////////");
		System.out.println("Escriba el ID del producto a comprar: ");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		
		int id = entrada.nextInt();
		productos.get(id).listarProducto();
		if (productos.get(id).getCantidad() > 0) {
			System.out.println("--");
			System.out.println("Usted puede comprar este producto, cantidad disponible: "+productos.get(id).getCantidad());
			System.out.println("--");
			System.out.println("¿Cuantos/as "+(productos.get(id).getTipo())+"s"+" desea comprar?");
			int cant = entrada.nextInt();
			if(cant <= productos.get(id).getCantidad() && (cant > 0)) {
				System.out.println("Total a pagar: "+ cant * productos.get(id).getPrecioUnitario());
				if(productos.get(id).restarCantidad(cant)) {
					System.out.println("--");
					System.out.println("Producto comprado con éxito");
					System.out.println("--");
				}
				else {
					System.out.println("--");
					System.out.println("Ha sucedido un ERROR");
					System.out.println("--");
				}
			}
			else {
				System.out.println("--");
				System.out.println("Error, la cantidad a comprar excede a la cantidad disponible");
				System.out.println("--");
			}
		}
		else if (productos.get(id).getCantidad() == 0) {
			System.out.println("--");
			System.out.println("Error, no hay stock disponible");
			System.out.println("--");
		}
		return true;
	}
	
	
	

	public boolean crearValoresIniciales() {
		//Se definen los productos principales
		Libro libro1=new Libro(diccionarioMap.obtenerDiccionario("1"), "Cien anhos de soledad", "Gabriel GM", "Biblioteca Espanha", 7, 87000);
		Libro libro2=new Libro(diccionarioMap.obtenerDiccionario("1"), "El coronel no tiene quien le", "Gabriel GM", "Biblioteca Espanha", 3, 25000);
		Libro libro3=new Libro(diccionarioMap.obtenerDiccionario("1"), "La odisea", "Eclipse", "Biblioteca Espanha", 5, 35000);
		Revista revista1= new Revista(diccionarioMap.obtenerDiccionario("2"), "National", "Eclipse", "Biblioteca Espanha", 3, 5000);
		Revista revista2= new Revista(diccionarioMap.obtenerDiccionario("2"), "Motor", "RCN", "Biblioteca Colombi", 5, 15000);
		Articulo articulo1 = new Articulo(diccionarioMap.obtenerDiccionario("3"), "Paper sobre Combustión Interna", "UTP", "Biblioteca Colombi", 2, 65000);
		Articulo articulo2 = new Articulo(diccionarioMap.obtenerDiccionario("3"), "Paper Programación orienta a Objetos", "UTP", "Biblioteca Colombi", 2, 100000);					
		productos.add(libro1); productos.add(libro2); productos.add(libro3); productos.add(revista1); productos.add(revista2); 
		productos.add(articulo1); productos.add(articulo2);
		return true;
	}
	
	public boolean agregarProductoExistente() {
		System.out.println("-/////////////////////////////-");
		System.out.println("Escriba el ID del producto a agregar cantidad: ");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int id = entrada.nextInt();
		productos.get(id).listarProducto();
		System.out.println("¿Cuantos/as "+(productos.get(id).getTipo())+"s"+" desea agregar?");
		int cant = entrada.nextInt();
		if (cant > 0) {
		productos.get(id).sumarCantidad(cant);
		}
		else {
			System.out.println("Ha sucedido un error, vuelva a intentarlo por favor.");
			return false;
		}
		return true;
	}


	public boolean agregarProducto(){
		String nombre;
		String autor;
		String editorial;
		int cantidad;
		double precioUnitario;
		String registrado="no";
		System.out.println("-------------------------------------------");
		System.out.println("Agregar producto");
		System.out.println("-------------------------------------------");
		System.out.println("1.Libro | 2.Revista | 3.Articulo");
		System.out.println("Escribe el producto (Número): ");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		String tipo = entrada.nextLine();
		if(diccionarioMap.obtenerDiccionario(tipo) != "-1") {
			System.out.println("-------------------------------------------");
			System.out.println("Agregando "+diccionarioMap.obtenerDiccionario(tipo));
			System.out.println("...");
			System.out.println("Digite nombre: ");
			nombre = entrada.nextLine();
			System.out.println("Digite autor: ");
			autor = entrada.nextLine();
			System.out.println("Digite editorial: ");
			editorial = entrada.nextLine();
			System.out.println("Digite cantidad: ");
			while(true) {
			try {
			cantidad = entrada.nextInt();
			break;
			}
			catch (Exception e) {
				 System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			     System.out.println("Error, escriba un numero entero");
			     System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			     entrada.nextLine();
			     System.out.println("Vuelva a digitar la cantidad: ");
			}
			}
			
			while(true) {
			try {
				precioUnitario=agregarNumerosEntrada();
				break;
				}
			catch (Exception e) {
				System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
				System.out.println(e.getMessage());
				System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
				}
			}
		switch(tipo) {
		case "1":{
			
			for (int i=0; i < productos.size(); i++) {
				if((diccionarioMap.obtenerDiccionario(tipo).equals(productos.get(i).getTipo())) && 
				   (nombre.equals(productos.get(i).getNombre())) &&
				   (autor.equals(productos.get(i).getAutor())) &&
				   (editorial.equals(productos.get(i).getEditorial())) &&
				   (precioUnitario == productos.get(i).getPrecioUnitario())) {
					System.out.println("--");
					System.out.println("Producto ya registrado, actualizando cantidad...");
					System.out.println("--");
					registrado= "si";
					productos.get(i).sumarCantidad(cantidad);
				}
			}
			if (registrado == "no") {
				Libro libro1=new Libro(diccionarioMap.obtenerDiccionario(tipo), nombre, autor, editorial, cantidad, precioUnitario);
				productos.add(libro1);
			}
			break;
		}
		case "2":{
			for (int i=0; i < productos.size(); i++) {
				if((tipo.equals(productos.get(i).getTipo())) && 
				   (nombre.equals(productos.get(i).getNombre())) &&
				   (autor.equals(productos.get(i).getAutor())) &&
				   (editorial.equals(productos.get(i).getEditorial())) &&
				   (precioUnitario == productos.get(i).getPrecioUnitario())) {
					System.out.println("--");
					System.out.println("Producto ya registrado, actualizando cantidad...");
					System.out.println("--");
					registrado= "si";
					productos.get(i).sumarCantidad(cantidad);
				}
			}
			if (registrado == "no") {
				Revista revista1= new Revista(diccionarioMap.obtenerDiccionario(tipo), nombre, autor, editorial, cantidad, precioUnitario);
				productos.add(revista1);
			}
			break;
		}
		case "3":{
			for (int i=0; i < productos.size(); i++) {
				if((tipo.equals(productos.get(i).getTipo())) && 
				   (nombre.equals(productos.get(i).getNombre())) &&
				   (autor.equals(productos.get(i).getAutor())) &&
				   (editorial.equals(productos.get(i).getEditorial())) &&
				   (precioUnitario == productos.get(i).getPrecioUnitario())) {
					System.out.println("--");
					System.out.println("Producto ya registrado, actualizando cantidad...");
					System.out.println("--");
					registrado= "si";
					productos.get(i).sumarCantidad(cantidad);
				}
			}
			if (registrado == "no") {
				Articulo articulo1 = new Articulo(diccionarioMap.obtenerDiccionario(tipo), nombre, autor, editorial, cantidad, precioUnitario);
				productos.add(articulo1);
			}
			break;
		}
	}
	return true;
		}
		else {
			return false;
		}
	}
	
	public static Double agregarNumerosEntrada() throws InputMismatchException{
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite precio: ");
		try {
			Double precioUnitario = entrada.nextDouble();
			return precioUnitario;
		}
		catch(InputMismatchException e){
			throw new InputMismatchException( "Error, no se admiten caracteres" );
		}
		
	}
	
	public void listarProductos(String tipo) {
		if (tipo == "consulta") {
			for (int i=0; i < productos.size(); i++) {
				productos.get(i).listarProducto();
		}
		}
		else if (tipo == "compra") {
			for (int i=0; i < productos.size(); i++) {
				if(productos.get(i).getCantidad() > 0) {
				productos.get(i).listarProducto();
				System.out.println("ID: "+i);
			}}
		}
		else if (tipo == "agregar") {
			for (int i=0; i < productos.size(); i++) {
				productos.get(i).listarProducto();
				System.out.println("ID: "+i);
			}
		}
	}
	
	public void totalProductos() {
		System.out.println("============Cantidades Productos=============");
		System.out.println("Libros: "+Libro.getContadorLibro());
		System.out.println("Revistas: "+Revista.getContadorRevista());
		System.out.println("Articulos: "+Articulo.getContadorArticulo());
		System.out.println("=============================================");
	}
	
	public void descuentoProductos() {
		Libro libro = new Libro();
		Revista revista = new Revista();
		Articulo articulo = new Articulo();
		
		System.out.println("=================Descuentos==================");
		System.out.println("Libros: "+libro.getDescuento()+"%");
		System.out.println("Revistas: "+revista.getDescuento()+"%");
		System.out.println("Articulos: "+articulo.getDescuento()+"%");
		System.out.println("=============================================");
	}
	
	public void generarReporte() {
		CrearReportes.generarReporteEXCEL(productos);
	}

}
