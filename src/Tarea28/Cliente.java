package Tarea28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

            System.out.println("Cliente conectado");
            PrintWriter escritor = new PrintWriter(cliente.getOutputStream(),true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            while (true) {
                System.out.println("Escribe mensaje: ");
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
