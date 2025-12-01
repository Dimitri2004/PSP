package TareaCalculadora;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

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
                if (Errores.extracted(msj)) continue; // Error en escribir valor nulo
                if (Errores.extracted1(msj)) break; //Salir de Servidor
                String resultado;
                if (Errores.extracted(msj, func, paquete, socket)) continue; // recoger el valor ans
                resultado = Errores.getResultado(func, msj);
                // Respuesta al cliente
                byte[] bufferEnviar = resultado.getBytes(StandardCharsets.UTF_8);

                DatagramPacket paqueteEnviar = new DatagramPacket(bufferEnviar,bufferEnviar.length,paquete.getAddress(),paquete.getPort());
                socket.send(paqueteEnviar);

            } catch (IOException e) {
                // Si falló la lectura del paquete, NO se muere el servidor
                System.out.println("Error al recibir paquete: " + e.getMessage());
            }
        }
        socket.close();
    }
}
