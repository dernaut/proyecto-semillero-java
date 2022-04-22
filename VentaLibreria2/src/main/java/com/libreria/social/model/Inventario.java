package com.libreria.social.model;

public abstract class Inventario {
	private int id;
	private String tipo;
	private String nombre;
	private String autor;
	private String editorial;
	private int cantidad;
	private double precioUnitario;
	private String fechaRegistro;
	private int descuento;
	private String fechaEliminacion;
	
	
	
	public Inventario() {
		super();
	}


	public Inventario(int id, String tipo, String nombre, String autor, String editorial, int cantidad,
			double precioUnitario, String fechaRegistro, String fechaEliminacion, int descuento) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.fechaRegistro = fechaRegistro;
		this.setFechaEliminacion(fechaEliminacion);
		this.descuento = descuento;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getDescuentoP() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public int getDescuento() {
		return descuento;
	}


	public String getFechaEliminacion() {
		return fechaEliminacion;
	}


	public void setFechaEliminacion(String fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}

	
	
}
