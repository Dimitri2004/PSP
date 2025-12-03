package TareaCalculadora;

import java.io.BufferedWriter;
import java.io.IOException;

public class Errores {

    // --- Para detectar comando "ans" y responder ---
    static boolean extracted(String msj, Funciones func, BufferedWriter writer) throws IOException {
        if (msj.equals("ans")) {
            writer.write(String.valueOf(func.getAns()));
            writer.newLine();
            writer.flush();
            return true;
        }
        return false;
    }

    // --- Para comando "Salir" ---
    static boolean extracted1(String msj) {
        if (msj.equalsIgnoreCase("Salir")) {
            System.out.println("[Servidor] Servidor detenido por el cliente.");
            return true;
        }
        return false;
    }

    // --- Mensaje vacío ---
    static boolean extracted(String msj) {
        if (msj == null || msj.isEmpty()) {
            System.out.println("Servidor: mensaje vacío recibido");
            return true;
        }
        return false;
    }

    // --- Evaluar operación ---
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