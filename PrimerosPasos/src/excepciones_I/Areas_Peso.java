package excepciones_I;

import java.util.Scanner;
import javax.swing.*;
public class Areas_Peso {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Elige una opci?n :\n1:Cuadrado \n2:Rectangulo \n3:Triangulo \n4: Circulo");
		try {
			figura= entrada.nextInt();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ha ocurrido un error");
		}finally {
			entrada.close();
		}
		
		 switch(figura){
	case 1: 
        
        int lado = Integer.parseInt(JOptionPane.showInputDialog("In"
                + "troduce el lado:"));
        System.out.println(Math.pow(lado, 2));
        
        break;
        
    case 2:
        
        int base = Integer.parseInt(JOptionPane.showInputDialog("In"
                + "troduce la base:"));
        int altura = Integer.parseInt(JOptionPane.showInputDialog("In"
                + "troduce la altura: "));
        
        System.out.println("El ?rea del rect?ngulo es: " + base*altura);
        
        break;
        
    case 3:
        
        base = Integer.parseInt(JOptionPane.showInputDialog("In"
                + "troduce la base:"));
        altura = Integer.parseInt(JOptionPane.showInputDialog("In"
                + "troduce la altura: "));
        
        System.out.println("El ?rea del tri?ngulo es: " + 
                (base*altura)/2);
        
        break;
        
    case 4:
        
        int radio = Integer.parseInt(JOptionPane.showInputDialog("In"
                + "troduce el radio: "));
        System.out.println("El ?rea del c?rculo es: ");
        System.out.println(Math.PI*(Math.pow(radio, 2)));
        
        break;
        
    default:
        System.out.println("La opci?n no es correcta.");
		 }
	

	       int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce "
	                + "tu altura en cm: "));
	        
	        System.out.printf("Si eres hombre tu peso ideal es: %d kg.", altura-110);
	        System.out.printf("Si eres mujer tu peso ideal es: %d kg.", altura-120);
		
	}
	static int figura;

}
