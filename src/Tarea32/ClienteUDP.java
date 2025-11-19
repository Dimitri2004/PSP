package Tarea32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteUDP {

    public static void main(String[] args) {
        try {
            String[] msj ={"Hola","como","estas",""};
            for (String mensaje:msj) {

                // Se crea el DatagramSocket sin especificar un puerto, lo que hace que el sistema asigne un puerto aleatorio.
                // Esto es suficiente para recibir datagramas, ya que el servidor enviará los datos al puerto en el que el cliente está escuchando.
                DatagramSocket datagramSocket = new DatagramSocket();
                InetAddress direccionServidor = InetAddress.getByName("localhost");

                byte[] bufferEnviar=mensaje.getBytes();

                DatagramPacket paquete = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionServidor, 9001);
                datagramSocket.send(paquete);
                datagramSocket.close();
            }

            DatagramSocket socket2=new DatagramSocket(9003);
            byte[] bufferRecibido=new byte[1043];
          while (true) {
              DatagramPacket peticion = new DatagramPacket(bufferRecibido, bufferRecibido.length);

              socket2.receive(peticion);

              String msjServidor = new String(peticion.getData(),0,peticion.getLength());
              System.out.println(msjServidor);
              if (msjServidor.isEmpty()){
                  break;
              }
          }

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClienteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
