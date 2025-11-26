package TareaCalculadora;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Servidor {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9001);
        byte[] buffer = new byte[8192]; // tamaño razonable

        System.out.println("Servidor UDP escuchando en puerto 9001...");

        while (true) {
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete);

            byte[] datos = Arrays.copyOfRange(paquete.getData(), 0, paquete.getLength());
            String msj = new String(datos, StandardCharsets.UTF_8).trim();

            if (msj.equalsIgnoreCase("FIN")) { // mensaje de cierre
                System.out.println("Servidor detenido.");
                break;
            }

            Calculadora c=new Calculadora(msj);
            c.start();
        }
        socket.close();
    }
}
