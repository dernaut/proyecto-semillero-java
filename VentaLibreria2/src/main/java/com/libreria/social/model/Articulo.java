package com.libreria.social.model;

public class Articulo extends Inventario{
	private static int contadorArticulo = 0;
	
	public Articulo() {
		super();
	}
	
	public Articulo(int id, String tipo, String nombre, String autor, String editorial, int cantidad,
			double precioUnitario, String fechaRegistro, String fechaEliminacion, int descuento) {
		super(id, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento);
		contadorArticulo++;
	}
	
	public static int getContadorRevista() {
		return contadorArticulo;
	}
	
	
	public int getDescuentoP() {
		return super.getDescuentoP()+20;
	}

}
