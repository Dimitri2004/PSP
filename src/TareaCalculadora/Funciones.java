package TareaCalculadora;

public class Funciones {

    private double ans = 0;

    public double getAns() {
        return ans;
    }

    public double Operaciones(String expr) throws Exception {
        if (expr == null || expr.isEmpty()) throw new Exception("Expresión vacía");

        // Reemplaza ans por su valor
        expr = expr.replace("ans", String.valueOf(ans));

        // Quita espacios
        expr = expr.replace(" ", "");

        double resultado;

        // SUMA
        if (expr.contains("+")) {
            String[] p = expr.split("\\+");
            if (p.length != 2) throw new Exception("Formato inválido");
            resultado = Double.parseDouble(p[0]) + Double.parseDouble(p[1]);
            ans = resultado;
            return resultado;
        }

        // RESTA
        if (expr.contains("-")) {
            String[] p = expr.split("-");
            if (p.length != 2) throw new Exception("Formato inválido");
            resultado = Double.parseDouble(p[0]) - Double.parseDouble(p[1]);
            ans = resultado;
            return resultado;
        }

        // MULTIPLICACIÓN
        if (expr.contains("*")) {
            String[] p = expr.split("\\*");
            if (p.length != 2) throw new Exception("Formato inválido");
            resultado = Double.parseDouble(p[0]) * Double.parseDouble(p[1]);
            ans = resultado;
            return resultado;
        }

        // DIVISIÓN
        if (expr.contains("/")) {
            String[] p = expr.split("/");
            if (p.length != 2) throw new Exception("Formato inválido");
            double divisor = Double.parseDouble(p[1]);
            if (divisor == 0) throw new Exception("División por 0");
            resultado = Double.parseDouble(p[0]) / divisor;
            ans = resultado;
            return resultado;
        }

        // Si solo es un número
        resultado = Double.parseDouble(expr);
        ans = resultado;
        return resultado;
    }
}
