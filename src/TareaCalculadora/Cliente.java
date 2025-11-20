package TareaCalculadora;

import Tarea32.ClienteUDP;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Dame una ecuacion de segundo grado: (ej:x²+bx+c=2)");

            String msj=sc.nextLine();
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress direccionServidor = InetAddress.getByName("localhost");

            byte[] bufferEnviar=msj.getBytes();

            DatagramPacket paquete = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionServidor, 9001);
            datagramSocket.send(paquete);
            datagramSocket.close();

            DatagramSocket socket2=new DatagramSocket(9003);
            byte[] bufferRecibido=new byte[700000000];
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
            System.out.println("Error con socket : "+ex.getMessage());
        } catch (UnknownHostException ex) {
            System.out.println("Error inesperado en host :"+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error en conexion de e/s :"+ex.getMessage());
        }
        }
}
