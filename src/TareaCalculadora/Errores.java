package TareaCalculadora;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Errores {
    static boolean extracted(String msj, Funciones func, DatagramPacket paquete, DatagramSocket socket) throws IOException {
        if (msj.equals("ans")) {
            String respuestaAns = String.valueOf(func.getAns());

            byte[] enviar = respuestaAns.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packetEnviar = new DatagramPacket(enviar, enviar.length,
                    paquete.getAddress(), paquete.getPort());

            socket.send(packetEnviar);
            return true;
        }
        return false;
    }
    static boolean extracted1(String msj) {
        if (msj.equalsIgnoreCase("Salir")) {
            System.out.println("[Servidor] Servidor detenido por el cliente.");
            return true;
        }
        return false;
    }
    static boolean extracted(String msj) {
        if (msj.isEmpty()) {
            System.out.println("Servidor: paquete vacío recibido");
            return true;
        }
        return false;
    }
    static String getResultado(Funciones func, String msj) {
        String resultado;
        try {
            resultado = String.valueOf(func.Operaciones(msj));

        } catch (Exception e) {
            resultado = "ERROR: operación inválida.";
            System.out.println("Error procesando mensaje: " + e.getMessage());
        }
        return resultado;
    }
}