package TareaCalculadora;

import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servidor {
    private static final String LOG_FILE = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
                // Log de conexión
                log("CONNECTION from " + paquete.getAddress().getHostAddress() + ":" + paquete.getPort());

                if (Errores.extracted(msj)) continue; // Error en escribir valor nulo
                if (Errores.extracted1(msj)) break; //Salir de Servidor
                String resultado;
                if (Errores.extracted(msj, func, paquete, socket)) continue; // recoger el valor ans
                resultado = Errores.getResultado(func, msj);

                // Log de operación
                log("OPERATION: \"" + msj + "\" → " + resultado);


                // Respuesta al cliente
                byte[] bufferEnviar = resultado.getBytes(StandardCharsets.UTF_8);

                DatagramPacket paqueteEnviar = new DatagramPacket(bufferEnviar,bufferEnviar.length,paquete.getAddress(),paquete.getPort());
                socket.send(paqueteEnviar);

            } catch (IOException e) {
                // Si falló la lectura del paquete, NO se muere el servidor
                System.out.println("Error al recibir paquete: " + e.getMessage());
                log("ERROR: " + e.getMessage());
            }
        }
        socket.close();
    }
    private static void log(String mensaje) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write("[" + LocalDateTime.now().format(FORMATTER) + "] " + mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir en log: " + e.getMessage());
        }
    }
}
