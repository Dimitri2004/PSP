package TareaCalculadora;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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

            // Obtener datos del paquete
            byte[] datos = Arrays.copyOfRange(paquete.getData(), 0, paquete.getLength());
            String msj = new String(datos, StandardCharsets.UTF_8).trim();

            // Salida del servidor si recibe "Salir"
            if (msj.equalsIgnoreCase("Salir")) {
                System.out.println("Servidor detenido.");
                break;
            }

            // Procesar la operación usando tu Calculadora
            Calculadora c = new Calculadora(msj);
            c.start();

            String resultado= String.valueOf(Funciones.Operaciones(msj));

            // Enviar resultado de vuelta al cliente
            byte[] bufferEnviar = resultado.getBytes(StandardCharsets.UTF_8);
            InetAddress direccionCliente = paquete.getAddress(); // dirección del cliente que envió el mensaje
            int puertoCliente = paquete.getPort();              // puerto del cliente que envió el mensaje

            DatagramPacket paqueteEnviar = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionCliente, puertoCliente);
            socket.send(paqueteEnviar);
        }
        socket.close();
    }
}
