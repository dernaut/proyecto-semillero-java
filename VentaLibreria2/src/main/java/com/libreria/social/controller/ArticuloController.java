package com.libreria.social.controller;

import java.sql.SQLException;

import com.libreria.social.DAO.ProductoDAO;
import com.libreria.social.model.Articulo;
import com.libreria.social.view.InventarioView;

public class ArticuloController {
	private InventarioView vista;
	private Articulo modelo;
	private ProductoDAO persistencia;
	
	public ArticuloController(Articulo modelo, InventarioView vista, ProductoDAO persistencia) {
		this.modelo = modelo;
		this.vista = vista;
		this.persistencia = persistencia;
	}
	
	public int getId() {
		return modelo.getId();
	}
	public void setId(int id) {
		this.modelo.setId(id);
	}
	public String getTipo() {
		return modelo.getTipo();
	}
	public void setTipo(String tipo) {
		this.modelo.setTipo(tipo);
	}
	public String getNombre() {
		return modelo.getNombre();
	}
	public void setNombre(String nombre) {
		this.modelo.setNombre(nombre);
	}
	public String getAutor() {
		return modelo.getAutor();
	}
	public void setAutor(String autor) {
		this.modelo.setAutor(autor);
	}
	public String getEditorial() {
		return modelo.getEditorial();
	}
	public void setEditorial(String editorial) {
		this.modelo.setEditorial(editorial);
	}
	public int getCantidad() {
		return modelo.getCantidad();
	}
	public void setCantidad(int cantidad) {
		this.modelo.setCantidad(cantidad);
	}
	public double getPrecioUnitario() {
		return modelo.getPrecioUnitario();
	}
	public void setPrecioUnitario(float precioUnitario) {
		this.modelo.setPrecioUnitario(precioUnitario);
	}
	public String getFechaRegistro() {
		return modelo.getFechaRegistro();
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.modelo.setFechaRegistro(fechaRegistro);
	}
	public int getDescuento() {
		return modelo.getDescuentoP();
	}
	public void setDescuento(int descuento) {
		this.modelo.setDescuento(descuento);
	}
	
	
	public void actualizarVista() {
		vista.imprimirDatosProducto(modelo.getId(), modelo.getTipo(), modelo.getNombre(), modelo.getAutor(), modelo.getEditorial(), modelo.getCantidad(), modelo.getPrecioUnitario(), modelo.getFechaRegistro(), modelo.getDescuento());
	}
	
	public void actualizarVistaEliminado() {
		vista.imprimirDatosProductoEliminado(modelo.getId(), modelo.getTipo(), modelo.getNombre(), modelo.getAutor(), modelo.getEditorial(), modelo.getCantidad(), modelo.getPrecioUnitario(), modelo.getFechaRegistro(), modelo.getFechaEliminacion(), modelo.getDescuento());
	}
	
	public void insertarArticulo() throws SQLException {
		if(persistencia.agregarProducto(modelo.getId(), modelo.getTipo(), modelo.getNombre(), modelo.getAutor(), modelo.getEditorial(), modelo.getCantidad(), modelo.getPrecioUnitario(), modelo.getFechaRegistro(), modelo.getDescuento())){
			System.out.println("Se ha insertado el producto correctamente.");
		}else {
			System.out.println("Ha ocurrido un error al inserter el producto.");
		}
	}
	
	
}
