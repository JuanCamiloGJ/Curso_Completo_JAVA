package ficheros_directorios;

import java.io.File;

public class EnviandoTextos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escribiendo mensaje = new Escribiendo();
		String pathname = "D:"+File.separator+"Usuario"+File.separator+"juank"+File.separator
				+"Escritorio"+File.separator+"certificados"+ File.separator+ "archivo_nuevo.txt";
		mensaje.escribir(pathname, "Hola parcero!");
		
	}

}
