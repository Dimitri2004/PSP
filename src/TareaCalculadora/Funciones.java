package TareaCalculadora;

public class Funciones {

    private double ans = 0;

    /**
     * Realiza operaciones básicas entre dos números o devuelve el valor de ans.
     * @param msj La expresión a evaluar.
     * @return El resultado de la operación.
     * @throws Exception Si la expresión es inválida.
     */
    public double Operaciones(String msj) throws Exception {
        if (msj == null || msj.isEmpty()) throw new Exception("Expresión vacía");

        // Reemplaza ans por su valor
        msj = msj.replace("ans", String.valueOf(ans));

        // Quita espacios
        msj = msj.replace(" ", "");

        double resultado;
        // SUMA
        if (msj.contains("+")) {
            String[] p = msj.split("\\+");
            if (p.length != 2) throw new Exception("Formato inválido");
            resultado = Double.parseDouble(p[0]) + Double.parseDouble(p[1]);
            ans = resultado;
            return resultado;
        }
        // RESTA
        if (msj.contains("-")) {
            String[] p = msj.split("-");
            if (p.length != 2) throw new Exception("Formato inválido");
            resultado = Double.parseDouble(p[0]) - Double.parseDouble(p[1]);
            ans = resultado;
            return resultado;
        }
        // MULTIPLICACIÓN
        if (msj.contains("*")) {
            String[] p = msj.split("\\*");
            if (p.length != 2) throw new Exception("Formato inválido");
            resultado = Double.parseDouble(p[0]) * Double.parseDouble(p[1]);
            ans = resultado;
            return resultado;
        }
        // DIVISIÓN
        if (msj.contains("/")) {
            String[] p = msj.split("/");
            if (p.length != 2) throw new Exception("Formato inválido");
            double divisor = Double.parseDouble(p[1]);
            if (divisor == 0) throw new Exception("División por 0");
            resultado = Double.parseDouble(p[0]) / divisor;
            ans = resultado;
            return resultado;
        }
        // Si solo es un número
        resultado = Double.parseDouble(msj);
        ans = resultado;
        return resultado;
    }
}
