package TareaCalculadora;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    /**
     * Punto de entrada del cliente.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Socket socket = null;// punto de acceso al servidor
        try {
            socket = new Socket("localhost", 9001);
        } catch (IOException e) {
            System.out.println("Error e/s "+e.getMessage());
        }
        // Conexión al servidor

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));// bufferedReader para leer del servidor
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"))// bufferedWriter para escribir al servidor
        ) {
            System.out.println("[Cliente TCP] Conectado al servidor.");

            // Bucle principal para enviar operaciones al servidor
            while (true) {
                System.out.println("[Cliente] Introduce tu operación (ej: 4+4 , 9*2000 , 4/5000) ('salir' para terminar):");
                String entrada = sc.nextLine().trim();

                // Comprobar si el usuario quiere salir
                if (entrada.equalsIgnoreCase("salir")) {
                    writer.write("salir");
                    writer.newLine();
                    writer.flush();
                    System.out.println("[Cliente] Saliendo...");
                    break;
                }
                //Enviar la entrada al servidor
                writer.write(entrada);
                writer.newLine();
                writer.flush();

                // Leer la respuesta del servidor
                String respuesta = reader.readLine();

                // Validación de letras no permitidas
                if (entrada.matches(".*[a-zA-Z]+.*")) {
                    if (entrada.contains("ans")) {
                        System.out.println("[Servidor] Respuesta: " + respuesta);
                        continue;
                    } else {
                        System.out.println("[Cliente] Error: solo se permite 'ans'");
                        continue;
                    }
                }
                // Mostrar la respuesta del servidor
                System.out.println("[Servidor] Respuesta: " + respuesta);
            }
            //Recogida de errores
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error de codificación : " + e.getMessage());
        } catch (UnknownHostException e) {
            System.out.println("Error desconocido : " + e.getMessage());
        } catch (ConnectException e){
            System.out.println("Error conexion "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error e/s:" + e.getMessage());
        }catch (NullPointerException e){
            System.out.println("Error en soket "+e.getMessage());
        }
        sc.close();
    }
}
