package com.libreria.social;

import com.libreria.social.implementacion.ImplementacionCaja;




public class Main {

	public static void main(String[] args) {
		ImplementacionCaja caja = new ImplementacionCaja (); 
		caja.crearValoresIniciales();
		MenuPrincipal.menu();
}
}