package javasockets_v1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {
    public SocketCliente() {        
        try {
            // Se crea un socket cliente.
            Socket socket = new Socket("localhost", 35557);
            System.out.println("Conectado");
            
            // Se prepara un flujo de salida de objetos y se le envía el objeto
            // al servidor.
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            
            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce un número: ");
            int num = entrada.nextInt();
            DatoSocket objCliente = new DatoSocket();
            objCliente.setAcierto(false);
            objCliente.setNombre("Biel");
            objCliente.setNumero(num);
            oos.writeObject(objCliente);
            

//oos.writeObject(new DatoSocket("Biel", 7));
            
            // Se obtiene un flujo de lectura de objetos.
            ObjectInputStream bufferObjetos = new ObjectInputStream(socket.getInputStream());
            // Se lee un DatoSocket enviado por el servidor y se muestra por pantalla.
            DatoSocket dato = (DatoSocket) bufferObjetos.readObject();
            System.out.println(dato);            
            
        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }
    
    public static void main(String [] args) {
        new SocketCliente();
    }
}


// Se obtiene un flujo de lectura de objetos.
// ObjectInputStream bufferObjetos = new ObjectInputStream(socket.getInputStream());

// Se lee un DatoSocket enviado por el servidor y se muestra por pantalla.
// DatoSocket dato = (DatoSocket) bufferObjetos.readObject();
// System.out.println("Datos Recibidos: " + dato);


// Se prepara un flujo de entrada de datos simples y se muestra el
// mensaje devuelto por el servidor
// DataInputStream buffer = new DataInputStream(socket.getInputStream());
// System.out.println(buffer.readUTF());
