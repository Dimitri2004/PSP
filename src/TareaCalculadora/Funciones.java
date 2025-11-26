package TareaCalculadora;

public class Funciones {
    public static int Sumar(String msj){

        msj = msj.trim();

        if (msj.contains("+")) {
            String[] partes = msj.split("\\+");
            return Integer.parseInt(partes[0]) + Integer.parseInt(partes[1]);
        }

        if (msj.contains("-")) {
            String[] partes = msj.split("-");
            return Integer.parseInt(partes[0]) - Integer.parseInt(partes[1]);
        }

        if (msj.contains("*")) {
            String[] partes = msj.split("\\*");
            return Integer.parseInt(partes[0]) * Integer.parseInt(partes[1]);
        }

        if (msj.contains("/")) {
            String[] partes = msj.split("/");
            return Integer.parseInt(partes[0]) / Integer.parseInt(partes[1]);
        }

        System.out.println("Error en simbología, haber estudiao bobo");
        return 0;
    }
}
