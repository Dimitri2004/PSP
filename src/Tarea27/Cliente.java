package Tarea27;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static Tarea27.Servidor.isa;
import static Tarea27.Servidor.sek;

public class Cliente {

    static Socket sk=new Socket();
    public static void escribir(){
        Scanner sc=new Scanner(System.in);
        try{
            sk.bind(isa);
            sk = sek.accept();
            BufferedWriter buff=new BufferedWriter(new FileWriter("Linea.txt"));
            System.out.println("Dame un mensaje de despedida");
            String mensaje=sc.next();
            for (int i = 0; i < 4; i++){
            buff.write(mensaje);
            sk.close();
            }
            buff.close();
        } catch (IOException e) {
            System.out.println("Error en entrada/salida "+e.getMessage());
        }

    }
}
