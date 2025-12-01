package TareaCalculadora;

import javax.swing.text.html.parser.Parser;

public class Funciones {

    private int ans=0; // valor persistente

    public int Operaciones(String msj) {
        msj = msj.trim();
        if (msj.contains("+")) {
            return Suma(msj);
        }
        if (msj.contains("-")) {
            return Resta(msj);
        }
        if (msj.contains("*")) {
            return Multi(msj);
        }
        if (msj.contains("/")) {
            return Div(msj);
        }

        System.out.println("[Error]: operación mal formulada");
        return 0;
    }


    private int getValor(String x) {
        if (x.contains("ans")) {
            return ans;
        }
        return Integer.parseInt(x);
    }


    public int Suma(String msj) {
        String[] partes = msj.split("\\+");
        int resultado = getValor(partes[0]) + getValor(partes[1]);
        ans = resultado;
        return resultado;
    }

    public int Resta(String msj) {
        String[] partes = msj.split("-");
        int resultado = getValor(partes[0]) - getValor(partes[1]);
        ans = resultado;
        return resultado;
    }

    public int Multi(String msj) {
        String[] partes = msj.split("\\*");
        int resultado = getValor(partes[0]) * getValor(partes[1]);
        ans = resultado;
        return resultado;
    }

    public int Div(String msj) {
        String[] partes = msj.split("/");
        int resultado = getValor(partes[0]) / getValor(partes[1]);
        ans = resultado;
        return resultado;
    }

    public int getAns() {
        return ans-1;
    }
}
