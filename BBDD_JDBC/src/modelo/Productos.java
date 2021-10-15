package modelo;

public class Productos {

	public Productos() {
		// TODO Auto-generated constructor stub
		n_articulo="";
		seccion="";
		precio="";
		paisorigen="";
	}
	
	public String getN_articulo() {
		return n_articulo;
	}
	public void setN_articulo(String n_articulo) {
		this.n_articulo = n_articulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getPaisorigen() {
		return paisorigen;
	}
	public void setPaisorigen(String paisorigen) {
		this.paisorigen = paisorigen;
	}

	private String n_articulo;
	private String seccion;
	private String precio;
	private String paisorigen;
	
}
