package TareaCalculadora;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress direccionServidor = InetAddress.getByName("localhost");

        try {
            while (true) {
                System.out.println("[Cliente] Introduce tu operación o número ('salir' para terminar):");
                String entrada = sc.nextLine().trim();

                // Salir del cliente si escribe "salir"
                if (entrada.equalsIgnoreCase("salir")) {
                    byte[] cerrar = entrada.getBytes();
                    DatagramPacket fin = new DatagramPacket(cerrar, cerrar.length, direccionServidor, 9001);
                    datagramSocket.send(fin);

                    System.out.println("[Cliente] Saliendo del cliente...");
                    break; // rompe el bucle y cierra socket y scanner
                }

                // Enviar mensaje al servidor
                byte[] bufferEnviar = entrada.getBytes();
                DatagramPacket paquete = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionServidor, 9001);
                datagramSocket.send(paquete);

                // Recibir respuesta del servidor
                byte[] bufferRecibido = new byte[8192];
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
                datagramSocket.receive(paqueteRecibido);

                String msjServidor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength()).trim();

                // Validar que NO contenga letras distintas de las permitidas
                if (entrada.matches(".*[a-zA-Z]+.*")) {
                    if (entrada.contains("ans")) {
                        System.out.println("[Servidor] Respuesta: " + msjServidor);
                        continue; // no imprimimos otra vez
                    } else {
                        System.out.println("[Cliente] Error: solo se permite 'ans'");
                        continue;
                    }
                }
                System.out.println("[Servidor] Respuesta: " + msjServidor);
            }
        } catch (Exception e) {
            System.out.println("[Cliente] Error en la comunicación. Vuelve a intentar.");
        } finally {
            datagramSocket.close();
            sc.close();
        }
    }
}
