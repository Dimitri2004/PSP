package Tarea25;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        boolean eleccion=true;
        do {
            switch (preguntar()) {
                case 1, 2:

                    Servidor servidor = new Servidor(new Socket(Cliente.getHost(), Cliente.getPort()));
                    servidor.conexion();
                    break;
                case 3:
                    eleccion=false;
                    System.out.println("saliendo.....");
                    break;
            }
        }while(eleccion);
    }
    public static int preguntar(){
        System.out.println("Que quieres hacer: 1.dar host 2.dar puerto  3.salir");
        int eleccion = sc.nextInt();
        return eleccion;
    }
}
