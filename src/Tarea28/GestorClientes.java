package Tarea28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class GestorClientes extends Thread {
    private Socket socket;

    public GestorClientes(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true)
        ){
            String mensaje, respuesta;

            while (true) {
                mensaje = lector.readLine();
                if (mensaje == null || mensaje.equalsIgnoreCase("adios")) break;
                respuesta = "ECO: " + mensaje;
                escritor.println(respuesta);

            }
        } catch (IOException e) {
            System.out.println("Error en conexion: "+e.getMessage());
        }finally {
            try {
                socket.close();
                System.out.println("Cliente desconectado");
            } catch (IOException e) {
                System.out.println("Error en e/s: "+e.getMessage());
            }
        }

    }
}
