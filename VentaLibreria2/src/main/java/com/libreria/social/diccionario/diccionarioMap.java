package com.libreria.social.diccionario;

import java.util.HashMap;
import java.util.Map;

public class diccionarioMap {
	public static String obtenerDiccionario(Integer key) {
		Map<Integer, String> tipoProducto = new HashMap<Integer, String>();
		tipoProducto.put(1, "Libro");
		tipoProducto.put(2, "Revista");
		tipoProducto.put(3, "Articulo");
		return (tipoProducto.get(key) != null)? tipoProducto.get(key) : "-1";
	}
}
