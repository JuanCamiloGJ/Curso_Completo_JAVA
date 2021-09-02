package leyendo_escirbiendo_bytes;

import java.io.*;

public class Lectura_Escritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//se establece la ruta del archivo para leerlo
			FileInputStream archivo_lectura= new FileInputStream("D:/Usuario/juank/Escritorio/Leyendo_creando/cerdo.png");
			
			
			boolean final_ar= false;
			
			int contador=0;
			
			int datos_entrada[]= new int[289];
			
			while(!final_ar) {
				//se guarda los bytes en el int al realizar el .read()
				int byte_entrada=archivo_lectura.read();
				/*cuando se deje de cumplir la sentencia se termina el programa
				 * recordando que el .read() alfinalizar devuelve un -1,(los bytes
				 * son numeros enteros positivos.)
				 */
				if (byte_entrada != -1) {
					/*los valores de cada iteracion son los bytes
					 *  del archivo estos se almacenan en el array.
					 */
					datos_entrada[contador]=byte_entrada;
					
				}else {
					
					final_ar=true;
				
				}
				
				
				
				System.out.println(datos_entrada[contador]);
				contador++;
			}
			System.out.println("Cantidad de bytes: "+ contador);
			archivo_lectura.close();
			crea_fichero(datos_entrada);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al acceder a la Imagen");
		}
		
		
		
	}
	//metodo para crear archivos apartir de bytes
	static void crea_fichero(int datos_nuevo_fichero[]) {
	
		try {
			//se crea el objeto que da salida a los archivos, se establece la ruta donde se quiere crear
			FileOutputStream fichero_nuevo = new FileOutputStream("D:/Usuario/juank/Escritorio/Leyendo_creando/cerdo_copia.png"); 
			/* el array que se evio por parametro se recorreen el for
			 * la instruccion write escribe byte por byte, asi creando la copia del elemento
			 */
			for(int i=  0 ; i < datos_nuevo_fichero.length ; i++) {
				
				fichero_nuevo.write(datos_nuevo_fichero[i]);
				
				
			}
			//se cierrra el flujo del objeto para ahorraar recursos
			fichero_nuevo.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al crear el archivo.");
		}
	}
}
