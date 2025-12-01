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
                System.out.println("Introduce tu operación o número ('salir' para terminar):");
                String entrada = sc.nextLine().trim();

                // Salir del bucle
                if (entrada.equalsIgnoreCase("salir")) {
                    byte[] cerrar = entrada.getBytes();
                    DatagramPacket fin = new DatagramPacket(cerrar, cerrar.length, direccionServidor, 9001);
                    datagramSocket.send(fin);
                    System.out.println("Saliendo del cliente...");
                    break;
                }

                // Validar que NO contenga letras
                if (entrada.matches(".*[a-zA-Z]+.*")) { // si contiene alguna letra
                    if (entrada.contains("ans")){
                        byte[] cerrar = entrada.getBytes();
                        DatagramPacket fin2 = new DatagramPacket(cerrar, cerrar.length, direccionServidor, 9001);
                        datagramSocket.send(fin2);
                    }else{
                        System.out.println("Error no se permiten caracteres distintos de 'ans'");
                        continue;
                    }

                }

                // Enviar mensaje al servidor
                byte[] bufferEnviar = entrada.getBytes();
                DatagramPacket paquete = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionServidor, 9001);
                datagramSocket.send(paquete);

                // Recibir respuesta del servidor
                byte[] bufferRecibido = new byte[8192];
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
                datagramSocket.receive(paqueteRecibido);

                String msjServidor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                System.out.println("Servidor: " + msjServidor);
            }

            datagramSocket.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error vuelve a intentar");
        }
    }
}
