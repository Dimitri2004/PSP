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


                // Enviar mensaje al servidor
                byte[] bufferEnviar = entrada.getBytes();
                DatagramPacket paquete = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccionServidor, 9001);
                datagramSocket.send(paquete);

                // Recibir respuesta del servidor
                byte[] bufferRecibido = new byte[8192];
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecibido, bufferRecibido.length);
                datagramSocket.receive(paqueteRecibido);


                // Salir del bucle
                if (entrada.equalsIgnoreCase("salir")) {
                    byte[] cerrar = entrada.getBytes();
                    DatagramPacket fin = new DatagramPacket(cerrar, cerrar.length, direccionServidor, 9001);
                    datagramSocket.send(fin);
                    System.out.println("[Cliente] Saliendo del cliente...");
                    break;
                }


                String msjAns=new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());

                // Validar que NO contenga letras distintas de las permitidas
                if (entrada.matches(".*[a-zA-Z]+.*")) {
                    if (entrada.contains("ans")){
                        System.out.println("[Servidor] El valor actual de ans es : "+msjAns);
                    }else{
                        System.out.println("[Cliente] Error no se permiten caracteres distintos de 'ans'");
                        continue;
                    }
                }
                if (entrada.isEmpty()){
                    System.out.println("[Cliente] No hay valores");
                    continue;
                }

                String msjServidor = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());
                System.out.println("[Servidor] Respuesta:  " + msjServidor);
            }

            datagramSocket.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error vuelve a intentar");
        }
    }
}
