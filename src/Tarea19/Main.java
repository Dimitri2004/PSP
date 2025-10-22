package Tarea19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Dame una frase para contar sus vocales:");
        String g=sc.nextLine().toLowerCase();
        Contador contador=new Contador();

        Thread c1=new Thread(new Hilo(g.toCharArray(),'a'));
        Thread c2=new Thread(new Hilo(g.toCharArray(),'e'));
        Thread c3=new Thread(new Hilo(g.toCharArray(),'i'));
        Thread c4=new Thread(new Hilo(g.toCharArray(),'o'));
        Thread c5=new Thread(new Hilo(g.toCharArray(),'u'));

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        try {
            c1.join();
            c2.join();
            c3.join();
            c4.join();
            c5.join();
        } catch (InterruptedException e) {
            System.out.println("Error en hilo "+e.getMessage());
        }
        System.out.println("Total de vocales "+contador.contadas());
    }
}
