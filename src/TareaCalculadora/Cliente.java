package TareaCalculadora;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 9001);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"))
        ) {
            System.out.println("[Cliente TCP] Conectado al servidor.");

            while (true) {
                System.out.println("[Cliente] Introduce tu operación o número ('salir' para terminar):");
                String entrada = sc.nextLine().trim();

                // --- Salir del cliente ---
                if (entrada.equalsIgnoreCase("salir")) {
                    writer.write("salir");
                    writer.newLine();
                    writer.flush();
                    System.out.println("[Cliente] Saliendo...");
                    break;
                }

                // --- Enviar la operación al servidor ---
                writer.write(entrada);
                writer.newLine();
                writer.flush();

                // --- Recibir respuesta ---
                String respuesta = reader.readLine();

                // --- Validación como en tu cliente UDP ---
                if (entrada.matches(".*[a-zA-Z]+.*")) {
                    if (entrada.contains("ans")) {
                        System.out.println("[Servidor] Respuesta: " + respuesta);
                        continue;
                    } else {
                        System.out.println("[Cliente] Error: solo se permite 'ans'");
                        continue;
                    }
                }

                System.out.println("[Servidor] Respuesta: " + respuesta);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            System.out.println("Error desconocido : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error :"+e.getMessage());
        }
        sc.close();
    }
}
