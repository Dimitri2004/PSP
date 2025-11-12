package Tarea27;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;


public class Cliente {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        InetSocketAddress isa=new InetSocketAddress("localhost",8080);
        String mensaje,contenido;
        try{
            Socket cliente= new Socket();
            cliente.connect(isa);

            System.out.println("Cliente conectado al servidor");
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));


            while (true) {
                System.out.println("Escribe un mensaje");
                mensaje = sc.nextLine();

                escritor.println(mensaje);
                contenido = lector.readLine();
                System.out.println(contenido);
                if (mensaje.equalsIgnoreCase("adios")) break;
            }
            cliente.close();
        } catch (IOException e) {
            System.out.println("Error en es/sa "+e.getMessage());
        }

    }
}
