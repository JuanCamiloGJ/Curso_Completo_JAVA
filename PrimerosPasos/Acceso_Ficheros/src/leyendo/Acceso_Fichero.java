package leyendo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Acceso_Fichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer_Fichero accediendo = new Leer_Fichero();
		accediendo.lee();
	}

}
class Leer_Fichero {
	
	
	public void lee() {
		
		try {
			FileReader entrada= new FileReader("D:/Usuario/juank/Escritorio/Cursos doing/Streams.txt");
			/*se crea la instancia del buffer y se le pasa por variable
			 * el objeto FileReader, que especifica la ruta del documento. 
			 */
			BufferedReader mibuffer= new BufferedReader(entrada);
			
			String linea="";
			
			while(linea!=null) {
				//esto lee linea a linea
				linea= mibuffer.readLine();
				if(linea!=null) {
					System.out.println(linea);	
				}
				
				
			}
			entrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha encontrado el archivo");
		}
	
	
	
	}
	
	
}
