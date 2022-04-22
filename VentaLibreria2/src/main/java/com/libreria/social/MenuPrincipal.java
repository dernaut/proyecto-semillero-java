package com.libreria.social;

import com.libreria.social.implementacion.ImplementacionCaja;
import com.libreria.social.interfaces.IOperacionesCaja;

import java.util.Scanner;

public class MenuPrincipal {
	static IOperacionesCaja caja = new ImplementacionCaja ();
	// ArrayList para guardar todos los productos en el inventario	
	public static void menu() {
		System.out.println("*********************************************");
		System.out.println("jgiraldoc@indracompany.com");
		System.out.println("*********************************************");
		System.out.println("1. Agregar producto al inventario");
		System.out.println("2. Agregar producto existente al inventario");
		System.out.println("3. Comprar producto");
		System.out.println("4. Listar inventario");
		System.out.println("5. Total productos agregados de cada tipo");
		System.out.println("6. Ver los descuentos para el día de hoy");
		System.out.println("7. Generar reporte Excel");
		System.out.println("Seleccione opción (Número): ");
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		String opcion = entrada.nextLine();
		
		switch(opcion) {
		case "1":{
			if(caja.agregarProducto()) {
				System.out.println("Se ha agregado el producto correctamente");
			}
			else {
				System.out.println("Error, no se ha podido agregar el producto");
			}
			break;
		}
		
		case "2":{
			caja.listarProductos("agregar");
			caja.agregarProductoExistente();
			break;
		}
		
		case "3":{
			caja.listarProductos("compra");
			caja.comprarProducto();
			break;
		}
		case "4":{
			caja.listarProductos("consulta");
			System.out.println("-");
			System.out.println("-");
			break;
		}
		case "5":{
			caja.totalProductos();
			break;
		}
		case "6":{
			caja.descuentoProductos();
			break;
		}
		case "7":{
			caja.generarReporte();
			break;
			}
		default: {
		    System.out.println("Opción incorrecta");
		}
	}
		menu();
	}	
}
