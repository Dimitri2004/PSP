package Tarea28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {


    public static void main(String[] args){
        try (ServerSocket server = new ServerSocket()){
            InetSocketAddress dir = new InetSocketAddress("localhost",8080);
            server.bind(dir);

            while (true){
                Socket cliente = server.accept();
                GestorClientes h1 = new GestorClientes(cliente);
                h1.start();
            }
        } catch (IOException e ) {
            System.out.println("Error archivo no encontrado : " + e.getMessage());
        }
    }
}
