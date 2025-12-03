package TareaCalculadora;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Servidor {

    private static final int PUERTO = 9001;
    private static final int TIMEOUT_MS = 10000; // 10 segundos
    private static final String LOG_FILE = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            serverSocket.setSoTimeout(TIMEOUT_MS);
            System.out.println("Servidor TCP escuchando en puerto " + PUERTO + "...");
            System.out.println("Se cerrará si no hay clientes conectados en " + (TIMEOUT_MS/1000) + " segundos.");

            while (true) {
                try {
                    Socket cliente = serverSocket.accept(); // Espera cliente hasta TIMEOUT_MS
                    System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
                    new Thread(() -> manejarCliente(cliente)).start();

                } catch (SocketTimeoutException e) {
                    System.out.println("No se conectaron clientes en el tiempo límite. Cerrando servidor...");
                    break; // Sale del while y cierra el servidor
                }
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }

    private static void manejarCliente(Socket cliente) {
        Funciones func = new Funciones();

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()))
        ) {
            String msj;
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
                }

                writer.write(resultado);
                writer.newLine();
                writer.flush();
                log("Cliente " + cliente.getInetAddress().getHostAddress() + " Operación: " + msj + " → " + resultado);
            }

        } catch (IOException e) {
            System.out.println("Error con el cliente: " + e.getMessage());
        } finally {
            try {
                cliente.close();
            } catch (IOException ignored) {}
        }
    }

    private static void log(String mensaje) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write("[" + LocalDateTime.now().format(FORMATTER) + "] " + mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir log: " + e.getMessage());
        }
    }
}
