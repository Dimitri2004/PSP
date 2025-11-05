package Tarea27;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import static Tarea27.Cliente.sk;

public class Servidor {
    static ServerSocket sek;

    static {
        try {
            sek = new ServerSocket();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static InetSocketAddress isa=new InetSocketAddress(8000);

    public static String leer() throws IOException {
        String lectura="";

        try {
            BufferedReader file=new BufferedReader(new FileReader("Linea.txt"));
            lectura = file.readLine();
            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo no encontrado : "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error en entrada/salida "+e.getMessage());
        }
        return "ECO: "+lectura;

    }
}
