package Tarea24;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Dame un nombre de domino :  ej(google.com)");
        String dominio=sc.next();
        //acepta todas las conexiones si se escribe en ip 0.0.0.0
        try {
            Socket sk=new Socket(dominio,80);
            System.out.println(sk.getInetAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error desconocido "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en entrada/salida en "+e.getMessage());
        }
    }
}
