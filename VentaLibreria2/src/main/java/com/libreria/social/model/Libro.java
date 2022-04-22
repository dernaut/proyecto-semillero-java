package com.libreria.social.model;

public class Libro extends Inventario{
	private static int contadorLibro = 0;
	
	public Libro() {
		super();
	}
	
	public Libro(int id, String tipo, String nombre, String autor, String editorial, int cantidad,
			double precioUnitario, String fechaRegistro, String fechaEliminacion, int descuento) {
		super(id, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento);
		contadorLibro++;
	}
	
	public static int getContadorLibro() {
		return contadorLibro;
	}
	
	
	public int getDescuentoP() {
		return super.getDescuentoP()+15;
	}
	

}
