package com.libreria.social.interfaces;

public interface IOperacionesCaja {
	public boolean comprarProducto();
	public boolean agregarProductoExistente();
	public boolean crearValoresIniciales();
	public boolean agregarProducto();
	public void listarProductos(String tipo);
	public void totalProductos();
	public void descuentoProductos();
	public void generarReporte();
}
