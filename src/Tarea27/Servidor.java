package Tarea27;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {


    public static void main(String[] args){
        try {
            InetSocketAddress isa=new InetSocketAddress("localhost",8080);
            String lectura,contenido;
            ServerSocket servidor=new ServerSocket();
            servidor.bind(isa);
            Socket cliente=servidor.accept();
            BufferedReader leer=new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            PrintWriter escribir=new PrintWriter(cliente.getOutputStream(),true);
            while (true){
                lectura= leer.readLine();
                contenido="ECO "+lectura;
                escribir.println(contenido);
                if (lectura == null || lectura.equalsIgnoreCase("adios")) break;
            }
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            System.out.println("Error archivo no encontrado : " + e.getMessage());
        }
    }
}
