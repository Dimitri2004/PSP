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
        Funciones func=new Funciones();
        while (true) {
            try {
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                // Obtener texto
                String msj = new String(
                        paquete.getData(),
                        0,
                        paquete.getLength(),
                        StandardCharsets.UTF_8
                ).trim();

                // Paquete vacío → NO detenemos servidor
                if (msj.isEmpty()) {
                    System.out.println("Servidor: paquete vacío recibido");
                    continue;
                }


                // Comando para detener servidor
                if (msj.equalsIgnoreCase("Salir")) {
                    System.out.println("[Servidor] Servidor detenido por el cliente.");
                    break;
                }

                String resultado;

                if (msj.equals("ans")) {
                    String respuestaAns = String.valueOf(func.getAns());

                    byte[] enviar = respuestaAns.getBytes(StandardCharsets.UTF_8);
                    DatagramPacket packetEnviar = new DatagramPacket(enviar, enviar.length,
                            paquete.getAddress(), paquete.getPort());

                    socket.send(packetEnviar);
                    continue;
                }
                try {
                    // Procesar operación
                    resultado = String.valueOf(func.Operaciones(msj));

                } catch (Exception e) {
                    // Error del cálculo → pero NO se cierra el servidor
                    resultado = "ERROR: operación inválida.";
                    System.out.println("Error procesando mensaje: " + e.getMessage());
                }

                // Respuesta al cliente
                byte[] bufferEnviar = resultado.getBytes(StandardCharsets.UTF_8);

                DatagramPacket paqueteEnviar = new DatagramPacket(
                        bufferEnviar,
                        bufferEnviar.length,
                        paquete.getAddress(),
                        paquete.getPort()
                );

                socket.send(paqueteEnviar);

            } catch (IOException e) {
                // Si falló la lectura del paquete, NO se muere el servidor
                System.out.println("Error al recibir paquete: " + e.getMessage());
            }
        }
        socket.close();
    }
}
