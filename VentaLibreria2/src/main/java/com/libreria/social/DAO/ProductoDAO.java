package com.libreria.social.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import com.libreria.social.persistencia.PersistenciaConexiones;

public class ProductoDAO {
	

	public List<List<Object>> getProductos() throws SQLException {
		List<List<Object>> productos = new ArrayList<>();
		String consulta = "SELECT productoid, producto.tipo, tipoproducto.tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento FROM producto inner join tipoproducto on producto.tipo = tipoproducto.id ORDER BY productoid";
		Connection conexion = null;
		conexion= PersistenciaConexiones.getConnection();
		
		PreparedStatement ps = PersistenciaConexiones.getPreparedStatement(conexion, consulta);
		ResultSet rs = ps.executeQuery(consulta);
		
		while(rs.next()){
			List<Object> datosConsulta = new ArrayList<>();
			datosConsulta.add(rs.getInt("productoid"));
			datosConsulta.add(rs.getInt("producto.tipo"));
			datosConsulta.add(rs.getString("tipoproducto.tipo"));
			datosConsulta.add(rs.getString("nombre"));
			datosConsulta.add(rs.getString("autor"));
			datosConsulta.add(rs.getString("editorial"));
			datosConsulta.add(rs.getInt("cantidad"));
			datosConsulta.add(rs.getDouble("precioUnitario"));
			datosConsulta.add(rs.getString("fechaRegistro"));
			datosConsulta.add(rs.getInt("descuento"));
			productos.add(datosConsulta);
		}
		conexion.close();
		return productos;
		}
	
	public List<List<Object>> getProductosEliminados() throws SQLException{
		List<List<Object>> productos = new ArrayList<>();
		String consulta = "SELECT productoid, producto_eliminado.tipo, tipoproducto.tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento FROM producto_eliminado inner join tipoproducto on producto_eliminado.tipo = tipoproducto.id ORDER BY productoid";
		Connection conexion = null;
		conexion= PersistenciaConexiones.getConnection();
		
		PreparedStatement ps = PersistenciaConexiones.getPreparedStatement(conexion, consulta);
		ResultSet rs = ps.executeQuery(consulta);
		
		while(rs.next()){
			List<Object> datosConsulta = new ArrayList<>();
			datosConsulta.add(rs.getInt("productoid"));
			datosConsulta.add(rs.getInt("producto_eliminado.tipo"));
			datosConsulta.add(rs.getString("tipoproducto.tipo"));
			datosConsulta.add(rs.getString("nombre"));
			datosConsulta.add(rs.getString("autor"));
			datosConsulta.add(rs.getString("editorial"));
			datosConsulta.add(rs.getInt("cantidad"));
			datosConsulta.add(rs.getDouble("precioUnitario"));
			datosConsulta.add(rs.getString("fechaRegistro"));
			datosConsulta.add(rs.getString("fechaEliminacion"));
			datosConsulta.add(rs.getInt("descuento"));
			productos.add(datosConsulta);
		}
		conexion.close();
		return productos;
		
	}
	
	public boolean agregarProducto(int id, String tipo, String nombre, String autor, String editorial, int cantidad, double precioUnitario, String fechaRegistro, int descuento) throws SQLException {
		String sql = "INSERT INTO producto (productoid, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) VALUES (?,?,?,?,?,?,?,?,?)";
		Connection conexion = null;
		conexion= PersistenciaConexiones.getConnection();
		PreparedStatement ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, id);
		ps.setString(2, tipo);
		ps.setString(3, nombre);
		ps.setString(4, autor);
		ps.setString(5, editorial);
		ps.setInt(6, cantidad);
		ps.setDouble(7, precioUnitario);
		ps.setString(8, fechaRegistro);
		ps.setInt(9, descuento);
		ps.execute();
		conexion.close();
		return true;
	}
	
	public List<List<Object>> consultarProductoPorId(int id) throws SQLException{
		List<List<Object>> productos = new ArrayList<>();
		String sql = "SELECT productoid, producto.tipo, tipoproducto.tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento FROM producto inner join tipoproducto on producto.tipo = tipoproducto.id WHERE productoid = ?";
		Connection conexion = null;
		conexion= PersistenciaConexiones.getConnection();
		PreparedStatement ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			List<Object> datosConsulta = new ArrayList<>();
			datosConsulta.add(rs.getInt("productoid"));
			datosConsulta.add(rs.getInt("producto.tipo"));
			datosConsulta.add(rs.getString("tipoproducto.tipo"));
			datosConsulta.add(rs.getString("nombre"));
			datosConsulta.add(rs.getString("autor"));
			datosConsulta.add(rs.getString("editorial"));
			datosConsulta.add(rs.getInt("cantidad"));
			datosConsulta.add(rs.getDouble("precioUnitario"));
			datosConsulta.add(rs.getString("fechaRegistro"));
			datosConsulta.add(rs.getInt("descuento"));
			productos.add(datosConsulta);
		}
		conexion.close();
		return productos;
	}
	
	public boolean editarProducto(int id, int cantidad) throws SQLException {
		String sql;
		int cantidadOriginal=0;
		PreparedStatement ps;
		Connection conexion = null;
		sql = "SELECT productoid, producto.tipo, tipoproducto.tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento FROM producto inner join tipoproducto on producto.tipo = tipoproducto.id WHERE productoid = ?";
		conexion= PersistenciaConexiones.getConnection();
		ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			cantidadOriginal = rs.getInt("cantidad");

		}
		ps.close();
		sql = "UPDATE producto SET cantidad = ? WHERE productoid = ?";
		ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, cantidadOriginal+cantidad);
		ps.setInt(2, id);
		ps.execute();
		conexion.close();
		return true;
		
	}
	
	public boolean comprarProducto(int id, int cantidad) throws SQLException {
		String sql;
		double precio=0;
		int cantidadOriginal=0;
		PreparedStatement ps;
		Connection conexion = null;
		sql = "SELECT productoid, producto.tipo, tipoproducto.tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento FROM producto inner join tipoproducto on producto.tipo = tipoproducto.id WHERE productoid = ?";
		conexion= PersistenciaConexiones.getConnection();
		ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			cantidadOriginal = rs.getInt("cantidad");
			precio = rs.getDouble("precioUnitario");

		}
		if (cantidad > cantidadOriginal) {
			return false;
		}
		ps.close();
		sql = "UPDATE producto SET cantidad = ? WHERE productoid = ?";
		ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, cantidadOriginal-cantidad);
		ps.setInt(2, id);
		ps.execute();
		conexion.close();
		System.out.println("Total a pagar: "+cantidad*precio);
		return true;
	}
	
	public boolean eliminarProducto(int id) throws SQLException {
		String sql;
		Connection conexion = null;
		PreparedStatement ps;
		sql ="SELECT productoid, producto.tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento FROM producto inner join tipoproducto on producto.tipo = tipoproducto.id WHERE productoid = ?";
		conexion= PersistenciaConexiones.getConnection();
		ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			int idProd = rs.getInt("productoid");
			int tipoId = rs.getInt("producto.tipo");
			String nombre = rs.getString("nombre");
			String autor = rs.getString("autor");
			String editorial = rs.getString("editorial");
			int cantidad = rs.getInt("cantidad");
			double precioUnitario = rs.getDouble("precioUnitario");
			String fechaRegistro = rs.getString("fechaRegistro");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a");
			String fechaEliminacion = dtf.format(LocalDateTime.now());
			int descuento = rs.getInt("descuento");
			ps.close();
			sql = "INSERT INTO producto_eliminado (productoid, tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, fechaEliminacion, descuento) VALUES (?,?,?,?,?,?,?,?,?,?)";
			ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
			ps.setInt(1, idProd);
			ps.setInt(2, tipoId);
			ps.setString(3, nombre);
			ps.setString(4, autor);
			ps.setString(5, editorial);
			ps.setInt(6, cantidad);
			ps.setDouble(7, precioUnitario);
			ps.setString(8, fechaRegistro);
			ps.setString(9, fechaEliminacion);
			ps.setInt(10, descuento);
			ps.execute();
			ps.close();
		}
		sql = "DELETE FROM producto WHERE productoid = ?";
		ps = PersistenciaConexiones.getPreparedStatement(conexion, sql);
		ps.setInt(1, id);
		ps.execute();
		conexion.close();
		return true;
	}
	

}

