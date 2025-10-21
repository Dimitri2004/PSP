package Tarea19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Dame una frase para contar sus vocales:");
        String g=sc.nextLine();
        Contador c=new Contador();
        for (char l : g.toCharArray()) {
            Hilo h = new Hilo(c, l);
            h.start();

        }
        try {
            Thread.sleep(1000); // pequeño delay para dar tiempo a que terminen
        } catch (InterruptedException e) {
            System.out.println("Error en hilo "+e.getMessage());
        }

        System.out.println("Total de vocales "+c.contadas());
    }
}
