package juan.sockets;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.*;




public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);
		
		setVisible(true);
		//agregamos el evento de ventana
		addWindowListener(new EnvioOnline());
		}	
	
}
//windowadapter es una clase adaptadora, implementa todos los metodos de windowlistener
class EnvioOnline extends WindowAdapter{
	//overwrite metodo
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket miSocket= new Socket("192.168.1.1", 9999);
			PaqueteEnvio datos= new PaqueteEnvio();
			datos.setMensaje(" online");
			//flujo de datos establecido
			ObjectOutputStream paquetedatos= new ObjectOutputStream(miSocket.getOutputStream());
			
			paquetedatos.writeObject(datos);
			
			miSocket.close();
			paquetedatos.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}

class LaminaMarcoCliente extends JPanel implements Runnable{
	
	public LaminaMarcoCliente(){
		
		String nick_usuario= JOptionPane.showInputDialog("Nick: ");
		JLabel n_nick= new JLabel("Nick: ");
		add(n_nick);
		
		JLabel texto=new JLabel(" | Online: ");
		nick= new JLabel(nick_usuario);
		add(nick);
		add(texto);
		ip= new JComboBox();
		
		add(ip);
		campoChatArea= new JTextArea(12,20);
		
		add(campoChatArea);
		
		
		campo1=new JTextField(20);
	
		add(campo1);		
	
		miboton=new JButton("Enviar");
		
		add(miboton);	
		miboton.addActionListener(new EnviaTexto());
		//el metodo run esta dentro de la misma clase por eso el this
		Thread miThread = new Thread(this);
		miThread.start();
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//crearemos el socket en el actionPerformed para que funcione apenas se toque el boton
			//la primera IP se supone que es la del servidor ene ste caso
			//es un IP local de la maquina, pero se debe tener en cuenta
			//que se debe usar la IP del servidor a la cual se quiere conectar.
			try {
				//puente virtual
				Socket miSocket= new Socket("192.168.1.1", 9999);
				
				//empaquetamos los datos de información para transferir el mensaje en la clase que creamos.
				PaqueteEnvio datos= new PaqueteEnvio();
				
				datos.setNick(nick.getText());
				datos.setIp((String)ip.getSelectedItem());
				datos.setMensaje(campo1.getText());
				//flujo de dsalida de un Objeto.
				ObjectOutputStream paquete_datos= new ObjectOutputStream(miSocket.getOutputStream());
				//se establece que objeto se enviará
				paquete_datos.writeObject(datos);
				miSocket.close();
				paquete_datos.close();
				// Clase Data output stream
				/*en el constructor se le define un objeto de tipo OutputStream mediante
				 * el socket creado.
				 */
				//DataOutputStream flujo_salida= new DataOutputStream(miSocket.getOutputStream());
				/* esto escribe en el flujo lo que hay en el campo1, el metodo writeUTF
				 * Escribe una cadena en el flujo de salida subyacente mediante la 
				 * codificación UTF-8 modificada de forma independiente del equipo.
				 */
				///flujo_salida.writeUTF(campo1.getText());
				campoChatArea.append("\n"+"Yo: "+campo1.getText());
				campo1.setText("");
				//los flujos siempre se deben cerrar
				//flujo_salida.close();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Este es el error: "+ e1.getMessage());
				
			}
		}
		
		
	}
	
		
		
		
	private JTextField campo1;
	private JLabel nick;
	private JComboBox ip;
	private JButton miboton;
	
	private JTextArea campoChatArea;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//ponemos el lciente a la escucha por el puerto 9090
			ServerSocket servidorcliente= new ServerSocket(9090);
			//se crea el socket
			Socket cliente;
			//una variable de este tipo
			PaqueteEnvio paqueteRecibido;
			//bucle infinito para siempre estar a la escuha
			while (true) {
				//aceptamos la información del servidor
				cliente= servidorcliente.accept();
				//recibimos el objeto por el socket
				ObjectInputStream flujoentrada= new ObjectInputStream(cliente.getInputStream());
				//transformamos el objeto en un Objeto de tipo PAqueteEnvio
				paqueteRecibido= (PaqueteEnvio) flujoentrada.readObject();
				//Todo en una sola linea
				//paqueteRecibido=(PaqueteEnvio) new ObjectInputStream(cliente.getInputStream()).readObject();
				
				if(!paqueteRecibido.getMensaje().equals(" online")) {
					campoChatArea.append("\n"+paqueteRecibido.getNick()+": "+ paqueteRecibido.getMensaje());
					
				}else {
					//campoChatArea.append(" \n"+ paqueteRecibido.getIpslista());
					ArrayList<String> ipsmenu= paqueteRecibido.getIpslista();
					//remueve lo que habia en el combobox ya que se crea duplicidad.
					ip.removeAllItems();
					for (String string : ipsmenu) {
						ip.addItem(string);
					}
				}
				
				
				
				
				
				
				
				
				
				cliente.close();
				flujoentrada.close();
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}
	
	
}



class PaqueteEnvio implements Serializable{
	private String nick, ip, mensaje;
	
	private ArrayList<String> ipslista;
	public ArrayList<String> getIpslista() {
		return ipslista;
	}



	public void setIpslista(ArrayList<String> ipslista) {
		this.ipslista = ipslista;
	}



	public PaqueteEnvio() {
		// TODO Auto-generated constructor stub
	
	
	
	}
	
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
