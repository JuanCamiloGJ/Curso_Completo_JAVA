package ficheros_directorios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//se le especifica en la ruta donde crear el neuvo directorio con el nombre:
		String pathname = "D:"+File.separator+"Usuario"+File.separator+"juank"+File.separator
				+"Escritorio"+File.separator+"certificados"+ File.separator+ "archivo_nuevo.txt";
		File ruta = new File(pathname);
		
		//aqui se crea la nueva ruta que se establecio en el pathname
		//ruta.mkdir();
		/*para crear un archivo es exactamente lo mismo, pero colocando en el pathname el nombre y tipo de archivo
		 * y obviamente cmabiamos el metodo a: ruta.createNewFile() este metodo nos genera un uso de excepciones ya que
		 * nos puede generar un error
		 */
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Escribiendo accede_es = new Escribiendo();
		accede_es.escribir(pathname, "Hola amigo!");
		
	}

}

class Escribiendo{
	
	public void escribir(String ruta_archivo, String frase_new) {
		
		String frase = frase_new;
		try {
			//recuerda establecer la opción append en el constructor y agregar con apend par ano sobreecribir
			FileWriter escritura = new FileWriter(ruta_archivo, true);
			
			  for(int i=0; i<frase.length(); i++) 
			  { 
				  escritura.append(frase.charAt(i)); 
			  }
			 
			//escritura.write(frase);
			//escritura.append(0);
			escritura.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}