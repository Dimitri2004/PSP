package TareaCalculadora;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {

    private static final int port = 9001;

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
                //Cada cliente asignado a un hilo nuevo
                new ControladorClientes(cliente).start();
            }
        } catch (IOException e) {
            System.out.println("Servidor cerrado.");
        }
    }
}
