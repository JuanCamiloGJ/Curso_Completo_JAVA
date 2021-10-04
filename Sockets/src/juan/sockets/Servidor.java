package juan.sockets;



import javax.swing.*;



import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable {
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread mihilo= new Thread(this);
		mihilo.start();
		
		}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//construye un socket de servidor que pone a la escucha a la aplicacion
		
		
		try {
			//poner a la escucha a la aplicación sin esto no puede recibir información.
			ServerSocket misocketServidor= new ServerSocket(9999);
			//un bucle infinito para que siempre este a la escucha
			/*vamos a Almacenar la informaciond el Paquete
			 * en 3 variables a continuación.
			 */
			String nick, ip, mensaje;
			PaqueteEnvio paquete_recibido;
			ArrayList<String> listaIP= new ArrayList<String>();
			while(true) {
			//acepta las conexiones del exterior con el metodo accept()
			Socket miSocket= misocketServidor.accept();
			
			
			
			
			
			
			//flujo de entrada de un Objeto recuerda Utilizar el socket no el serversocket
			ObjectInputStream paquete_datos= new ObjectInputStream(miSocket.getInputStream());
			//lee el objeto se debe hacer el casting  ya que paquete_datos genera un tipo de objeto diferente
			paquete_recibido = (PaqueteEnvio) paquete_datos.readObject();
			//alamacenamos la informacion del poaquet enviado en las variables locales
			nick=paquete_recibido.getNick();
			ip=paquete_recibido.getIp();
			mensaje=paquete_recibido.getMensaje();
			
			if(!mensaje.equals(" online")) {
			
			areatexto.append("\n"+nick+ ": "+ mensaje+ " para "+ ip);
			
			////////////////Ahora enviaremos esta informacion al usuario receptor/////////////
			//toca crear un socket para enviar la informacion
			Socket envioDestinatario = new Socket(ip,9090);
			//se crea el paquete para enviar
			ObjectOutputStream paqueteReenvio = new ObjectOutputStream(envioDestinatario.getOutputStream());
			//establecemos que informacion vamos a enviar, ene ste caso el objeto.
			paqueteReenvio.writeObject(paquete_recibido);
			//cerramos el socket
			envioDestinatario.close();
			paqueteReenvio.close();
			}else {
				//-----------DETECTA ONLINE-----------------
				//alamcena ddentor de la variable la direccion del cliente con el que acabamos de conectar
				InetAddress localizacion= miSocket.getInetAddress();
				//ahora pasamos esa direcciona  string
				String IpRemota= localizacion.getHostAddress();
				
				System.out.println("Online"+ IpRemota);
				
				
				listaIP.add(IpRemota);
				
				paquete_recibido.setIpslista(listaIP);
				for (String ips : listaIP) {
					Socket envioDestinatario = new Socket(ips,9090);
					//se crea el paquete para enviar
					ObjectOutputStream paqueteReenvio = new ObjectOutputStream(envioDestinatario.getOutputStream());
					//establecemos que informacion vamos a enviar, ene ste caso el objeto.
					paqueteReenvio.writeObject(paquete_recibido);
					//cerramos el socket
					envioDestinatario.close();
					paqueteReenvio.close();
					miSocket.close();
				}
			}
			
			miSocket.close();
			
			
			//se estrablece el flujod e entrada mediente el objeto socket y su metodo getInputStream.
			//DataInputStream flujo_entrada= new DataInputStream(miSocket.getInputStream());
			//lee y lo almacena en un string 
			//String mensaje_texto= flujo_entrada.readUTF();
			
			//areatexto.append("\n"+ mensaje_texto);
		
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private	JTextArea areatexto;
}
