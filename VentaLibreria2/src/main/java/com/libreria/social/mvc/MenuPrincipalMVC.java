package com.libreria.social.mvc;


import java.util.Scanner;

import com.libreria.social.interfaces.IMenuPrincipal;


public class MenuPrincipalMVC {

	public static void main(String[] args) {
		IMenuPrincipal operaciones = new MenuPrincipalImpl();
		System.out.println("");
		System.out.println("*****************************************");
		System.out.println("*************Menu Principal**************");
		System.out.println("1. Agregar producto al inventario");
		System.out.println("2. Consultar producto por ID");
		System.out.println("3. Listar productos");
		System.out.println("4. Aumentar cantidad de un producto existente");
		System.out.println("5. Comprar producto");
		System.out.println("6. Eliminar producto de la Base de Datos");
		System.out.println("7. Listar productos eliminados");
		System.out.println("Seleccione opción: ");
		Scanner entrada = new Scanner(System.in);
		String opcion = entrada.nextLine();
		
		switch(opcion) {
		case "1":{
			if(!operaciones.agregarNuevoProducto()) {
				System.out.println("Ha ocurrido un error al agregar producto.");
			}
			break;
			}
		case "2":{
			int id;
			if((id = operaciones.listarProductoID(null)) < 0) {
				System.out.println("Error, no se ha encontrado el producto con ID ["+id*-1+"]");
			}
			break;
		}
		case "3":{
			operaciones.listarProductos();
			break;
		}
		
		case "4":{
			int id;
			if((id = operaciones.listarProductoID(null)) > 0) {
				System.out.println("************Producto a editar***************");
				System.out.println("Digite la cantidad a actualizar: ");
				int cantidad = entrada.nextInt();
				entrada.nextLine();
				cantidad = (cantidad < 0)? cantidad=cantidad*-1: cantidad;
				if(operaciones.aumentarCantidadExistente(id, cantidad)) {
					System.out.println("Se ha actualizado correctamente el producto con ID ["+id+"]");
				}else {
					System.out.println("Se ha producido un error al editar el producto con ID ["+id+"]");
				}
			}
			else {
				System.out.println("Error, no se ha encontrado el producto con ID ["+id*-1+"]");
			}
			break;
		}
		case "5":{
			int id;
			if((id = operaciones.listarProductoID("compra")) > 0) {
				System.out.println("************Producto a comprar***************");
				System.out.println("Digite la cantidad a comprar: ");
				int cantidad = entrada.nextInt();
				entrada.nextLine();
				cantidad = (cantidad < 0)? cantidad=cantidad*-1: cantidad;
				if(operaciones.comprarProducto(id, cantidad)) {
					System.out.println("Se ha comprado correctamente el producto con ID ["+id+"]");
				}else {
					System.out.println("Se ha producido un error al comprar el producto con ID ["+id+"]");
				}
			}
			else {
				System.out.println("Error, no se ha encontrado el producto con ID ["+id*-1+"] o no tiene cantidad disponible para comprarlo");
			}
			break;
		}
		case "6":{
			int id;
			if((id = operaciones.listarProductoID(null)) > 0) {
				System.out.println("************Producto a eliminar***************");
				System.out.println("");
				System.out.println("¿Está seguro de eliminar este producto?");
				System.out.println("s/n");
				String op = entrada.nextLine();
				if (op.equals("s")) {
				if(operaciones.eliminarProducto(id)) {
					System.out.println("Se ha eliminado correctamente el producto con ID ["+id+"]");
				}else {
					System.out.println("Se ha producido un error al eliminar el producto con ID ["+id+"]");
				}
			}else {
				System.out.println("Has cancelado la operación.");
			}
			
			}else {
				System.out.println("Error, no se ha encontrado el producto con ID ["+id*-1+"]");
			}
			break;
		}
		
		case "7":{
			operaciones.listarProductosEliminados();
			break;
		}
		default:{
			System.out.println("Opción incorrecta");
		}
		
		
		}
		
		main(args);
	
	}
	

}
