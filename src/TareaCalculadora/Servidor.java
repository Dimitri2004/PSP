package TareaCalculadora;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Servidor {
    public static void main(String[] args) {
        String mensajeOperacion="";
        try {
            DatagramSocket socket = new DatagramSocket(9001);
            byte[] bufferRecibido=new byte[700000000];

            while (true) {
                DatagramPacket peticion = new DatagramPacket(bufferRecibido, bufferRecibido.length);
                socket.receive(peticion);

                byte[] datos = Arrays.copyOfRange(peticion.getData(), 0, peticion.getLength());

                String msj = new String(datos, StandardCharsets.UTF_8);
                if (msj.isEmpty()) {
                    break;
                }
                ProcesosDeCalculo p=new ProcesosDeCalculo(msj);
                p.start();
            }


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
            byte[] bufferEnvio = mensajeOperacion.getBytes();

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
