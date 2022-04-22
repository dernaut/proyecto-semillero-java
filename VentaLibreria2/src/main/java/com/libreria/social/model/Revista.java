package com.libreria.social.model;

public class Revista extends Inventario{
	private static int contadorRevista = 0;
	
	public Revista() {
		super();
	}
	
	public Revista(int id, String tipo, String nombre, String autor, String editorial, int cantidad,
			double precioUnitario, String fechaRegistro, String fechaEliminacion, int descuento) {
		super(id, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento);
		contadorRevista++;
	}
	
	public static int getContadorRevista() {
		return contadorRevista;
	}
	
	
	public int getDescuentoP() {
		return super.getDescuentoP()+5;
	}

}
