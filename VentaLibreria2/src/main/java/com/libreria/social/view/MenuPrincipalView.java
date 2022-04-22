package com.libreria.social.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipalView {
	
	public static List<Object> inicializarDatos() {
		int cantidad;
		List<Object> datos = new ArrayList<>();
		double precioUnitario;
		System.out.println("***************Agregando Producto**************");
		System.out.println("¿Qué tipo de producto quiere agregar?");
		System.out.println("1. Libro");
		System.out.println("2. Revista");
		System.out.println("3. Articulo");
		System.out.println("Seleccione opción: ");
		Scanner entrada = new Scanner(System.in);
		int opcion = entrada.nextInt();
		entrada.nextLine();
		if (opcion != 1 && opcion !=2 && opcion !=3) {
			return datos;
		}
		
		System.out.println("Digite nombre: ");
		String nombre = entrada.nextLine();
		System.out.println("Digite autor: ");
		String autor = entrada.nextLine();
		System.out.println("Digite editorial: ");
		String editorial = entrada.nextLine();
		System.out.println("Digite cantidad: ");
		
		while(true) {
			try {
			cantidad = entrada.nextInt();
			break;
			}
			catch (Exception e) {
				 System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			     System.out.println("ERROR");
			     System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			     entrada.nextLine();
			     System.out.println("Vuelva a digitar la cantidad: ");
			}
			}
		cantidad = (cantidad < 0)? cantidad=cantidad*-1: cantidad;
		System.out.println("Digite precio: ");
		while(true) {
			try {
			precioUnitario = entrada.nextDouble();
			break;
			}
			catch (Exception e) {
				 System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			     System.out.println("ERROR");
			     System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
			     entrada.nextLine();
			     System.out.println("Vuelva a digitar el precio: ");
			}
			}
		precioUnitario = (precioUnitario < 0)? precioUnitario=precioUnitario*-1: precioUnitario;
		entrada.nextLine();
		System.out.println("¿Desea incluir descuento? s/n");
		String descuento = entrada.nextLine();
		switch(descuento) {
			case "s":{
				System.out.println("Se aplicará descuento");
				break;
			}
			case "n":{
				System.out.println("No se aplicará descuento");
				break;
			}
			default:{
				System.out.println("No se aplicará descuento");
			}
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
		String fechaRegistro = dtf.format(LocalDateTime.now());
		
		datos.add(opcion);
		datos.add(nombre); 
		datos.add(autor); 
		datos.add(editorial); 
		datos.add(cantidad); 
		datos.add(precioUnitario); 
		datos.add(fechaRegistro); 
		datos.add(descuento);
		
		return datos;
		
		
	}
	
	public static int buscarProducto() {
		System.out.println("**************Buscar Producto por ID**************");
		System.out.println("Digite el ID del producto a buscar en la Base de Datos");
		Scanner entrada = new Scanner(System.in);
		int id = entrada.nextInt();
		entrada.nextLine();
		return id;
		
	}
	


}
