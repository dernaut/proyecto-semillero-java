package com.libreria.social.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libreria.social.DAO.ProductoDAO;
import com.libreria.social.model.Inventario;
import com.libreria.social.view.InventarioView;

public class InventarioController {
	private InventarioView vista;
	private Inventario modelo;
	private ProductoDAO persistencia;
	
	public InventarioController(Inventario modelo, InventarioView vista, ProductoDAO persistencia) {
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
		vista.imprimirDatosProducto(modelo.getId(), modelo.getTipo(), modelo.getNombre(), modelo.getAutor(), modelo.getEditorial(), modelo.getCantidad(), modelo.getPrecioUnitario(), modelo.getFechaRegistro(), modelo.getDescuentoP());
	}
	
	public List<List<Object>> consultarPorID(int id) throws SQLException {
		List<List<Object>> datos = new ArrayList<>();
		datos = persistencia.consultarProductoPorId(id);
		return datos;
	}
	
	public List<List<Object>> obtenerProductos() throws SQLException{
		List<List<Object>> datos = new ArrayList<>();
		datos = persistencia.getProductos();
		return datos;
	}
	
	public List<List<Object>> obtenerProductosEliminados() throws SQLException{
		List<List<Object>> datos = new ArrayList<>();
		datos = persistencia.getProductosEliminados();
		return datos;
	}
	
	public boolean editarProducto(int id, int cantidad) throws SQLException {
		persistencia.editarProducto(id, cantidad);
		return true;
	}
	
	public boolean comprarProducto(int id, int cantidad) throws SQLException {
		if(persistencia.comprarProducto(id, cantidad)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean eliminarProductoPorID(int id) throws SQLException {
		if(persistencia.eliminarProducto(id)) {
			return true;
		}else {
			return false;
		}
	}
	

	
}
