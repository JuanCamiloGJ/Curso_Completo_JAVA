package escribiendo;

import java.io.FileWriter;
import java.io.IOException;

public class Escribir_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escribiendo accede_es= new Escribiendo();
		
		accede_es.escirbir();
	}

}
 class Escribiendo{
	 
	 public void escirbir() {
		 String frase= "Esto es una prueba de escritura";
		 
		 try {
			 /*el constructor varia despendiendo si queremos que cree 
			  * un archivo nuevo, o escriba en un archivo existente
			  */
			 FileWriter escritura= new FileWriter("D:/Usuario/juank/Escritorio/texto_nuevo.txt", true);
			 
			 for(int i=0; i<frase.length();i++) {
				 //escribe caracter a caracter en el archivo
				 escritura.write(frase.charAt(i));
			 }
			 
			 escritura.close();
			 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }
