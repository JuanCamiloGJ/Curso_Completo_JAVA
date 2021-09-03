package ficheros_directorios;

import java.io.File;


public class Acceso_Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Tener en cuenta que las rutas cambian en cada S.O por lo tanto
		 * es importante que los separadores sean los indicados, para no 
		 * tener este problema se debe cambiar cada separador por la constante
		 * de clase llamada File.separator para que asi sea compatible quedando así:
		 * 
		 * String pathname= "D:"+File.separator+"Usuario"+File.separator+"juank"+File.separator+"Escritorio"+File.separator+"certificados";
		 * 
		 * pero esto es tedioso, por ello haremos lo siguiente:
		 * Para que el código esté más limpio se podría hacer así:
			String s = File.separator;
			String ruta = "C:/Java/PruebaFile/";
  			una función de la clase string para remplazar el caracter.
			ruta.replace("/", s);
			File fCarpeta = new File(ruta);
		 */
		String pathname= "D:\\Usuario\\juank\\Escritorio\\certificados";
		/*
		 * File ruta = new File(pathname); System.out.println(ruta.getAbsolutePath());
		 * //almacena todos los nombre de archivos de la ruta puesta String []
		 * nombres_archivos= ruta.list(); //lista en consola el nombre de los archivos
		 * encontrados en la ruta especificada for(String e: nombres_archivos) {
		 * System.out.println(e); File f = new File(ruta.getAbsolutePath(), e);
		 * 
		 * if (f.isDirectory()) { System.out.println(f.getAbsolutePath()); String []
		 * archivos_subcarpeta = f.list();
		 * 
		 * } }
		 */
		
		
		listarArchivos(pathname);
	}
	
	public static void listarArchivos(String rutaof) {
		String pathname= rutaof;
		File ruta = new File(pathname);
		String [] nombres_archivos= ruta.list();
		//lista en consola el nombre de los archivos encontrados en la ruta especificada
		for(String e: nombres_archivos) {
			
			File f = new File(ruta.getAbsolutePath(), e);
			if (f.isDirectory()) {
				
				System.out.println("----------------------------------------------------");
				listarArchivos(f.getAbsolutePath());
				System.out.println("----------------------------------------------------");
				//String [] archivos_subcarpeta = f.list();
				
			}else {
				System.out.println(" $$ "+ruta.getPath()+"\\ "+e);
			}
		}
	}

}
