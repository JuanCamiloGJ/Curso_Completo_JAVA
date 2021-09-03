package ficheros_directorios;
import java.io.*;
public class Pruebas_rutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* si no se especifica la ruta, java 
		 * toma como ruta la carpeta donde se esta
		 * guardando todo nuestro proyecto, como carpeta principal.
		 */
		String pathname = "bin";
		File archivo = new File(pathname);
		//imprime la ruta del archivo
		System.out.println(archivo.getAbsolutePath());
		//imprime si el archivo extiste
		System.out.println(archivo.exists());
	}

}
