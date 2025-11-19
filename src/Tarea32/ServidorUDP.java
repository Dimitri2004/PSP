package Tarea32;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;


public class ServidorUDP {

    public static void main(String[] args) {
        String mensajeLargo="";
        int largo=0;

        try {
            DatagramSocket socket = new DatagramSocket(9001);
            byte[] bufferRecibido=new byte[1043];
            while (true) {
                DatagramPacket peticion = new DatagramPacket(bufferRecibido, bufferRecibido.length);
                socket.receive(peticion);

                // Convierte el contenido del buffer recibido en un String para poder procesarlo.
                String msj = new String(peticion.getData(), 0, peticion.getLength());

                if (msj.length() > largo) {
                    largo = msj.length();
                    mensajeLargo = msj;
                }
                if (msj.isEmpty()) {
                    break;
                }
            }
            System.out.println(mensajeLargo + " " + largo);


            String[] msjServidor = {"Hola", "bien", "y", ""};
            for (String mensaje : msjServidor) {
                DatagramSocket socket2 = new DatagramSocket();
                InetAddress ipDestino = InetAddress.getByName("localhost");
                byte[] bufferEnvio = mensaje.getBytes();

                DatagramPacket paquete = new DatagramPacket(
                        bufferEnvio, bufferEnvio.length, ipDestino, 9001
                );
            socket2.send(paquete);
            socket2.close();
        }

            DatagramSocket socket2 = new DatagramSocket();
            InetAddress ipDestino = InetAddress.getByName("localhost");
            byte[] bufferEnvio = mensajeLargo.getBytes();

            DatagramPacket paquete = new DatagramPacket(
                    bufferEnvio, bufferEnvio.length, ipDestino, 9003
            );

            socket2.send(paquete);
            socket2.close();

        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}