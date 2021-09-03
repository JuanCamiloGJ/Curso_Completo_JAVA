package ficheros_directorios;

import java.io.File;

public class Eliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathname = "D:"+File.separator+"Usuario"+File.separator+"juank"+File.separator
				+"Escritorio"+File.separator+"certificados"+ File.separator+ "archivo_nuevo.txt";
		File ruta = new File(pathname);
		//lo borra
		ruta.delete();
	}

}
