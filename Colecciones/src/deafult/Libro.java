package deafult;

import java.util.Objects;

public class Libro {

	public Libro(String titulo, String autor, int ISBN) {
		// TODO Auto-generated constructor stub
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
	
	}
	public String getDatos() {
		return "El titulo es: "+ titulo + ". El autor es: "+autor
				+ ". Y el ISBN es: "+ISBN;
	}
	
	/*public boolean equals(Object obj) {
		
		boolean condicion;
		if(obj  instanceof Libro) {
			//para que el obejto de tipo object tenga acceso a las variables
			//de la clase Libro se debe realizar un casting
			 Libro otro=(Libro)obj;
			 
			 if(this.ISBN==otro.ISBN) {
				 
				condicion= true;
				
			 }else {
				 
				condicion= false;
				
			 }
			 
		}else {
			condicion= false;
		}
		
		
		return condicion;
		
	}*/
	
	
	private String titulo;
	@Override
	public int hashCode() {
		return Objects.hash(ISBN);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return ISBN == other.ISBN;
	}

	private String autor;
	private int ISBN;
}
