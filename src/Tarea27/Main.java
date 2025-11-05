package Tarea27;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Cliente.escribir();
        System.out.println(Servidor.leer());
    }
}
