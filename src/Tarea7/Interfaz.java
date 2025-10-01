package Tarea7;

import java.util.Scanner;

public class Interfaz {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String opcion;
        while(true) {
            System.out.println("Introfuce host/ip o ('salir' para terminar)");
            opcion = sc.next().toLowerCase();//PARA LISTILLOS
            if (opcion.equals("salir")) {
                break;//Interrumpe programa si se escribe salir
            }
            Lanzador.Lanzar(opcion);//Envia el dato hacia donde va a ejecutar el proceso
        }
    }
}
