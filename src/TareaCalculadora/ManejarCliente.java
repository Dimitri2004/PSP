package TareaCalculadora;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ManejarCliente {
    private static final String log = "log.txt";
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Maneja la comunicación con un cliente específico.
     * @param cliente
     */
    public static void manejarCliente(Socket cliente) {
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
                log("Cliente " + cliente.getInetAddress().getHostAddress() + " Operación: " + msj + " --- Solucion " + resultado);
            }// Fin del while de mensajes
        } catch (ConnectException e) {
            System.out.println("Error conexion " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error con el cliente: " + e.getMessage());
        } finally {
            try {
                cliente.close();
                System.out.println("Cliente desconectado");
            } catch (IOException e) {
                System.out.println("Desconexion  " + e.getMessage());
            }
        }// Fin del manejo del cliente

    }


    private static void log(String mensaje) {
        try (FileWriter fw = new FileWriter(log, true)) {
            fw.write("[" + LocalDateTime.now().format(formato) + "] " + mensaje + "\n");
        } catch (IOException e) {
            System.out.println("Error al escribir log: " + e.getMessage());
        }
    }
}
