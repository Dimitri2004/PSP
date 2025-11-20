package TareaCalculadora;

import java.util.Map;

public class CalcularExponente {
    static Map<Character, Integer> superIndices = Map.of(
            '¹', 1,
            '²', 2
    );
    public static int getExponente(String s) {
        char ultimo = s.charAt(s.length() - 1);
        if (superIndices.containsKey(ultimo)) {
            return superIndices.get(ultimo);
        }

        // Si es solo "x" → grado 1
        if (s.equals("x"))
            return 1;

        return -1;
    }

    public static String derivar(String s) {
        s = s.trim(); // quitar espacios

        int coef = 1;
        String variable = "x";

        // Si empieza con número
        int i = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) i++;
        if (i > 0) {
            coef = Integer.parseInt(s.substring(0, i));
        }

        // Extraemos el exponente
        int grado = getExponente(s.substring(i));

        if (grado == 1) {
            return String.valueOf(coef);
        } else if (grado == 2) {
            return (coef * 2) + "x";
        } else {
            return "No soportado";
        }
    }
}
