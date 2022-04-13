/**
 * 
 */
package com.libreria.social.reportes;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.libreria.social.Inventario;

/**
 * @author Indra
 *
 */
public class CrearReportes {
	
	public static void generarReporteEXCEL(List<Inventario> productos) {
		 HSSFWorkbook workbook = new HSSFWorkbook();
	        
	     // Creamos una hoja de calculo llama "Reporte" en dicho libro de excel
	     HSSFSheet sheet = workbook.createSheet("Reporte");
	     
	     String[] atributos = {"ID", "Tipo", "Nombre", "Autor", "Editorial", "Cantidad", "Precio Unitario"};
	     
	        
	     // Creamos un formato para las celdas
	     HSSFCellStyle style = workbook.createCellStyle();        
	     // Especificamente que *siempre* muestre dos digitos enteros y dos decimales
	     style.setDataFormat(workbook.createDataFormat().getFormat("00,00"));
	        

	     Row encabezado = sheet.createRow(0);

	     
	     
	     HSSFCellStyle style2 = workbook.createCellStyle(); 
	     HSSFFont font = workbook.createFont();
	     font.setBold(true);
	     style2.setFont(font);
	     
	     for (int i = 0; i < atributos.length; i++) {
	        Cell celda = encabezado.createCell(i);
	        celda.setCellValue(atributos[i]);
	        celda.setCellStyle(style2);
	       }

	          
	     for (int i = 1; i <= productos.size()-1; i++) {
	    	 Row fila = sheet.createRow(i);
    		 Cell productoInfo = fila.createCell(0);
    		 productoInfo.setCellValue(i);
    		 productoInfo.setCellStyle(style2);
    		 
    		for (int j = 0; j < productos.get(i).retornarListaProducto().size(); j++) {
    			 Cell celda = fila.createCell(j+1);
    			 celda.setCellStyle(style);
    			 celda.setCellValue(productos.get(i).retornarListaProducto().get(j));    			 
    			 
    		 }
	     }

	        
	     // Ahora almacenaremos el archivo en disco
	     String ruta="./src/resources/reportesExcel/reporteProductosInventario.xls";
	     File archivo = new File(ruta);
	     try {
	         FileOutputStream out = new FileOutputStream(archivo);
	         workbook.write(out);
	         out.close();
	         System.out.println("REPORTE GENERADO DE MANERA CORRECTA");
	     } catch (IOException e) {
	         System.err.println("ERROR AL CREAR EL ARCHIVO, CIERRE EL ARCHIVO EXCEL!");
	     }
	     try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     Desktop desktop = Desktop.getDesktop();
	     
	     if(archivo.exists()) {       
	     try {
			desktop.open(archivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}              
	     }  
		
		
	}
}


