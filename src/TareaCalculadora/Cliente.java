package TareaCalculadora;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Cliente {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Dame una ecuacion de segundo grado: (ej:x²+bx+c=2)");

            String msj=sc.nextLine();
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            byte[] bufferEnviar=msj.getBytes();


            // Enviar ecuación
            DatagramPacket paquete = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionServidor, 9001);
            datagramSocket.send(paquete);

            // Recibir confirmación/pregunta del servidor
            byte[] bufferRecibido = new byte[8192];
            DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
            datagramSocket.receive(paqueteRecibido);
            String msjServidor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
            System.out.println(msjServidor);

            // Opcional: recibir mensaje final del servidor
            paqueteRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
            datagramSocket.receive(paqueteRecibido);
            System.out.println(new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength()));

            datagramSocket.close();

        } catch (SocketException ex) {
            System.out.println("Error con socket : "+ex.getMessage());
        } catch (UnknownHostException ex) {
            System.out.println("Error inesperado en host :"+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en conexion de e/s :"+ex.getMessage());
        }
        }
}
