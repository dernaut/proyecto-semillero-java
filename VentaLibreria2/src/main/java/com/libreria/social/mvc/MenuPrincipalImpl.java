package com.libreria.social.mvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.libreria.social.DAO.ProductoDAO;
import com.libreria.social.controller.ArticuloController;
import com.libreria.social.controller.InventarioController;
import com.libreria.social.controller.LibroController;
import com.libreria.social.controller.RevistaController;
import com.libreria.social.interfaces.IMenuPrincipal;
import com.libreria.social.model.Articulo;
import com.libreria.social.model.Inventario;
import com.libreria.social.model.Libro;
import com.libreria.social.model.Revista;
import com.libreria.social.view.InventarioView;
import com.libreria.social.view.MenuPrincipalView;

public class MenuPrincipalImpl implements IMenuPrincipal {


	public boolean agregarNuevoProducto() {
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		
		List<Object> datos = new ArrayList<>();
		datos = MenuPrincipalView.inicializarDatos();
		if (datos.size() == 0) {
			return false;
		}
		Libro lib = new Libro();
		Revista rev = new Revista();
		Articulo art = new Articulo();
		if ((int) datos.get(0) == 1) {
			int descuento = (((String)datos.get(7)).equals("s"))? lib.getDescuentoP() : 0;
			System.out.println("Agregando Libro");
			Libro libro = new Libro(0, String.valueOf(datos.get(0)), (String)datos.get(1), (String)datos.get(2), (String)datos.get(3), (int)datos.get(4), (double)datos.get(5), (String)datos.get(6), null, descuento);
			LibroController controladorLibro = new LibroController(libro, vista, persistencia);
			try {
				controladorLibro.insertarLibro();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if((int) datos.get(0) == 2) {
			int descuento = (((String)datos.get(7)).equals("s"))? rev.getDescuentoP() : 0;
			System.out.println("Agregando Revista");
			Revista revista = new Revista(0, String.valueOf(datos.get(0)), (String)datos.get(1), (String)datos.get(2), (String)datos.get(3), (int)datos.get(4), (double)datos.get(5), (String)datos.get(6), null, descuento);
			RevistaController controladorRevista = new RevistaController(revista, vista, persistencia);
			try {
				controladorRevista.insertarRevista();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if((int) datos.get(0) == 3) {
			int descuento = (((String)datos.get(7)).equals("s"))? art.getDescuentoP() : 0;
			System.out.println("Agregando Articulo");
			Articulo articulo = new Articulo(0, String.valueOf(datos.get(0)), (String)datos.get(1), (String)datos.get(2), (String)datos.get(3), (int)datos.get(4), (double)datos.get(5), (String)datos.get(6), null, descuento);
			ArticuloController controladorArticulo = new ArticuloController(articulo, vista, persistencia);
			try {
				controladorArticulo.insertarArticulo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}


	public boolean aumentarCantidadExistente(int id, int cantidad) {
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		Inventario inventario = null;
		InventarioController controladorInventario = new InventarioController(inventario, vista, persistencia);
		try {
			controladorInventario.editarProducto(id, cantidad);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean comprarProducto(int id, int cantidad) {
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		Inventario inventario = null;
		InventarioController controladorInventario = new InventarioController(inventario, vista, persistencia);
		try {
			if(controladorInventario.comprarProducto(id, cantidad)) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminarProducto(int id) {
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		Inventario inventario = null;
		InventarioController controladorInventario = new InventarioController(inventario, vista, persistencia);
		try {
			if(controladorInventario.eliminarProductoPorID(id)) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


	public void listarProductos() {
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		Inventario inventario = null;
		List<List<Object>> productos = new ArrayList<>();
		InventarioController controladorInventario = new InventarioController(inventario, vista, persistencia);
		try {
			productos = controladorInventario.obtenerProductos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (productos.size() > 0) {
			
			for (int i=0; i < productos.size(); i++) {
					int idProducto = (int) productos.get(i).get(0);
					int tipoProducto = (int) productos.get(i).get(1);
					String tipo = (String) productos.get(i).get(2);
					String nombre = (String) productos.get(i).get(3);
					String autor = (String) productos.get(i).get(4);
					String editorial = (String) productos.get(i).get(5);
					int cantidad = (int) productos.get(i).get(6);
					double precioUnitario = (double) productos.get(i).get(7);
					String fechaRegistro = (String) productos.get(i).get(8);
					int descuento = (int) productos.get(i).get(9);
					
					if (tipoProducto == 1) {
						Libro libro = new Libro(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, null, descuento);
						LibroController controladorLibro = new LibroController(libro, vista, null);
						controladorLibro.actualizarVista();
					}
					if (tipoProducto == 2) {
						Revista revista = new Revista(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, null, descuento);
						RevistaController controladorRevista = new RevistaController(revista, vista, null);
						controladorRevista.actualizarVista();
					}
					if (tipoProducto == 3) {
						Articulo articulo = new Articulo(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, null, descuento);
						ArticuloController controladorArticulo = new ArticuloController(articulo, vista, null);
						controladorArticulo.actualizarVista();
					}
				}
			}
			else {
				System.out.println("Se ha producido un error en la consulta");
			}
		
		
	}
	
	public void listarProductosEliminados() {
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		Inventario inventario = null;
		List<List<Object>> productos = new ArrayList<>();
		InventarioController controladorInventario = new InventarioController(inventario, vista, persistencia);
		try {
			productos = controladorInventario.obtenerProductosEliminados();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (productos.size() > 0) {
			
			for (int i=0; i < productos.size(); i++) {
					int idProducto = (int) productos.get(i).get(0);
					int tipoProducto = (int) productos.get(i).get(1);
					String tipo = (String) productos.get(i).get(2);
					String nombre = (String) productos.get(i).get(3);
					String autor = (String) productos.get(i).get(4);
					String editorial = (String) productos.get(i).get(5);
					int cantidad = (int) productos.get(i).get(6);
					double precioUnitario = (double) productos.get(i).get(7);
					String fechaRegistro = (String) productos.get(i).get(8);
					String fechaEliminacion = (String) productos.get(i).get(9);
					int descuento = (int) productos.get(i).get(10);
					
					if (tipoProducto == 1) {
						Libro libro = new Libro(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento);
						LibroController controladorLibro = new LibroController(libro, vista, null);
						controladorLibro.actualizarVistaEliminado();
					}
					if (tipoProducto == 2) {
						Revista revista = new Revista(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento);
						RevistaController controladorRevista = new RevistaController(revista, vista, null);
						controladorRevista.actualizarVistaEliminado();
					}
					if (tipoProducto == 3) {
						Articulo articulo = new Articulo(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento);
						ArticuloController controladorArticulo = new ArticuloController(articulo, vista, null);
						controladorArticulo.actualizarVistaEliminado();
					}
				}
			}
			else {
				System.out.println("Se ha producido un error en la consulta");
			}
	}


	public int listarProductoID(String indicador) {	
		List<List<Object>> productos = new ArrayList<>();
		int id = MenuPrincipalView.buscarProducto();
		InventarioView vista = new InventarioView();
		ProductoDAO persistencia = new ProductoDAO();
		Inventario inventario = null;
		InventarioController controladorInventario = new InventarioController(inventario, vista, persistencia);
		try {
			productos = controladorInventario.consultarPorID(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		if (productos.size() > 0) {
		
		for (int i=0; i < productos.size(); i++) {
				int idProducto = (int) productos.get(i).get(0);
				int tipoProducto = (int) productos.get(i).get(1);
				String tipo = (String) productos.get(i).get(2);
				String nombre = (String) productos.get(i).get(3);
				String autor = (String) productos.get(i).get(4);
				String editorial = (String) productos.get(i).get(5);
				int cantidad = (int) productos.get(i).get(6);
				double precioUnitario = (double) productos.get(i).get(7);
				String fechaRegistro = (String) productos.get(i).get(8);
				int descuento = (int) productos.get(i).get(9);
				
				if(cantidad <= 0 && indicador == "compra") {
					return -id;
				}
				
				if (tipoProducto == 1) {
					Libro libro = new Libro(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, null, descuento);
					LibroController controladorLibro = new LibroController(libro, vista, null);
					controladorLibro.actualizarVista();
				}
				if (tipoProducto == 2) {
					Revista revista = new Revista(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, null, descuento);
					RevistaController controladorRevista = new RevistaController(revista, vista, null);
					controladorRevista.actualizarVista();
				}
				if (tipoProducto == 3) {
					Articulo articulo = new Articulo(idProducto, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, null, descuento);
					ArticuloController controladorArticulo = new ArticuloController(articulo, vista, null);
					controladorArticulo.actualizarVista();
				}
			}
		}
		else {
			return -id;
		}
		return id;
		
			
		
		
		
		
		
		
	}

	

}
