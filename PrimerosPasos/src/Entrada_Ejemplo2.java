import javax.swing.JOptionPane;

public class Entrada_Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre_usuario=JOptionPane.showInputDialog("Introduce tu nombre, por favor");
		int edad=Integer.parseInt(JOptionPane.showInputDialog("introduce la edad, por favor"));
		
		
		System.out.println("probando commit github");
		System.out.println("Hola "+ nombre_usuario+ "el proximo año tendra "+ (edad+1)+ "años");
		

}
}