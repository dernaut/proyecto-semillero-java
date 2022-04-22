package com.libreria.social.interfaces;

public interface IMenuPrincipal {
	public boolean agregarNuevoProducto();
	public boolean aumentarCantidadExistente(int id, int cantidad);
	public void listarProductos();
	public int listarProductoID(String indicador);
	public boolean comprarProducto(int id, int cantidad);
	public boolean eliminarProducto(int id);
	public void listarProductosEliminados();
	
	
}
