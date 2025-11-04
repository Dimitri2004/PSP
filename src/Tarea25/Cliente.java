package Tarea25;


import java.util.Scanner;

public class Cliente {

    private static Scanner sc=new Scanner(System.in);

    public static String getHost() {
        System.out.println("Dame la ruta a connectar:  ej(127.0.0.1 o localhost)");
        String host1 = sc.next();
        return host1;
    }
    public static int getPort() {
        System.out.println("Dame el dominio : ej(80,21,28)");
        int port1=sc.nextInt();
        return port1;
    }

}
