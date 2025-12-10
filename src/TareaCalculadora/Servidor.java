package TareaCalculadora;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servidor {

    private static final int port = 9001;
    private static final String log = "log.txt";
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Punto de entrada del servidor.
     * @param args
     */
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto " + port + "...");

            while (true) {
                // Espera conexiones de clientes
                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                // Cada cliente se atiende en un hilo aparte
                new Thread(() -> manejarCliente(cliente)).start();
            }

        } catch (IOException e) {
            System.out.println("Servidor cerrado.");
        }
    }

    /**
     * Maneja la comunicación con un cliente específico.
     * @param cliente
     */
    private static void manejarCliente(Socket cliente) {
        Funciones func = new Funciones();
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()))
        ) {
            String msj; // mensaje del cliente
            while ((msj = reader.readLine()) != null) {
                msj = msj.trim();

                if (msj.equalsIgnoreCase("salir")) break;

                if (msj.isEmpty()) {
                    writer.write("ERROR: mensaje vacío");
                    writer.newLine();
                    writer.flush();
                    continue;
                }
                String resultado;
                try {
                    resultado = String.valueOf(func.Operaciones(msj));
                } catch (Exception e) {
                    resultado = "ERROR: operación inválida";
                }// Enviar resultado al cliente

                writer.write(resultado);
                writer.newLine();
                writer.flush();
                log("Cliente " + cliente.getInetAddress().getHostAddress() + " Operación: " + msj + " → " + resultado);
            }// Fin del while de mensajes
        } catch (ConnectException e){
            System.out.println("Error conexion "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error con el cliente: " + e.getMessage());
        } finally {
            try {
                cliente.close();
            } catch (IOException ignored) {}
        }// Fin del manejo del cliente
    }

    /**
     * Escribe un mensaje en el archivo de log con marca de tiempo.
     * @param mensaje
     */

    private static void log(String mensaje) {
        try (FileWriter fw = new FileWriter(log, true)) {
            fw.write("[" + LocalDateTime.now().format(formato) + "] " + mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir log: " + e.getMessage());
        }
    }
}
