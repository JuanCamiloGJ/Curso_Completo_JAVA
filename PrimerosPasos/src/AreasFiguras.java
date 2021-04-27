import java.util.Scanner;

import javax.swing.JOptionPane;

public class AreasFiguras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectangulo \n3: Triangulo \n4: Circulo");
		Scanner opseleccion=new Scanner(System.in);
		
		int figura=opseleccion.nextInt();
		switch(figura) {
		
		case 1://Calculo área Cuadrado
			int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
			System.out.println("El área del cuadrado es: "+ Math.pow(lado, 2));
		
			break;
		
		case 2://Calculo área rectangulo
			int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base "));
			int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			
			System.out.println("El área del rectangulo es: "+ (base*altura));
		
			break;
		case 3://Calculo área rectangulo
			base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base "));
			altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
			
			System.out.println("El área del Triangulo es: "+ ((base*altura)/2));
		
			break;
		case 4://Calculo área rectangulo
			int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio "));
			
			System.out.println("El área del circulo es: ");
			System.out.printf("%.2f", Math.PI*(Math.pow(radio, 2)));
		
			break;
			
		default:
			System.out.print("la opción seleccionada no es correcta");
		
		}
		
		
		
	}

}
