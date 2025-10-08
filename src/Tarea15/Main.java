package Tarea15;

public class Main {
    public static void main(String[] args){
        Hilo h1=new Hilo("Hilo 1",0);
        Hilo h2=new Hilo("Hilo 2",0);
        Hilo h3=new Hilo("Hilo 3",0);
        try {
            h3.start();
            h3.join();
            h2.start();
            h2.join();
            h1.start();
            h1.join();
        }  catch (InterruptedException e) {
            System.out.println("Error en salida de hilo : "+e.getMessage());
        }
        System.out.println("Programa Terminado");


    }
}
