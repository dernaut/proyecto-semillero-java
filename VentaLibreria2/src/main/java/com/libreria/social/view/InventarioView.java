package com.libreria.social.view;


public class InventarioView {
	
	public void imprimirDatosProducto(int id, String tipo, String nombre, String autor, String editorial, int cantidad,
			double precioUnitario, String fechaRegistro, int descuento) {
		System.out.println("");
		System.out.println("---------------------------------------------------");
		System.out.println("ID: "+id);
		System.out.println("Tipo de producto: "+tipo);
		System.out.println("Nombre: "+nombre);
		System.out.println("Autor: "+autor);
		System.out.println("Editorial: "+editorial);
		System.out.println("Cantidad: "+cantidad);
		System.out.println("Precio: "+precioUnitario);
		System.out.println("Fecha de registro: "+fechaRegistro);
		System.out.println("Descuento: "+descuento);
	}
	
	public void imprimirDatosProductoEliminado(int id, String tipo, String nombre, String autor, String editorial, int cantidad,
			double precioUnitario, String fechaRegistro, String fechaEliminacion, int descuento) {
		System.out.println("");
		System.out.println("---------------------------------------------------");
		System.out.println("ID: "+id);
		System.out.println("Tipo de producto: "+tipo);
		System.out.println("Nombre: "+nombre);
		System.out.println("Autor: "+autor);
		System.out.println("Editorial: "+editorial);
		System.out.println("Cantidad: "+cantidad);
		System.out.println("Precio: "+precioUnitario);
		System.out.println("Fecha de registro: "+fechaRegistro);
		System.out.println("Fecha de eliminacion: "+fechaRegistro);
		System.out.println("Descuento: "+descuento);
	}

}
