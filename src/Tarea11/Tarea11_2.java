package Tarea11;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tarea11_2 extends Thread {

        int numero;

        public Tarea11_2(int numero) {
            this.numero = numero;
        }

        @Override
        public void run() {
            int max=600;
            int min=100;
            int numeroAleatorio= new Random().nextInt(max-min+1)+min;//genera un aleatorio entre 600 y 100
            int dominio = 6;
            for (int i = 1; i < dominio; i++) {
                System.out.println("[Hilo " + numero + "] iteración: " + i);

            }
            try {
                Thread.sleep((int) (Math.random() * numeroAleatorio)); // Pequeña pausa aleatoria
                System.out.println("Acabo Hilo-" + numero);//Secuencia del hilo finalizada

            } catch (InterruptedException e) {
                System.out.println("Error " + e);
            }

        }

        public static void main(String[] args) {
            System.out.println("Cuantos hilos quieres crear?");
            Scanner sc=new Scanner(System.in);
            int p=sc.nextInt();
            try {
            if (p>0){
                    for (int i = 1; i <= p; i++) {
                        new Tarea11(i).start(); // Crear e iniciar hilo
                    }
                }else{
                System.out.println("Se restablecio el valor por defecto a 5");
                for (int i = 1; i <= 5; i++) {
                    new Tarea11(i).start(); // Crear e iniciar hilo
                }
            }
            }catch (InputMismatchException e){
                System.out.println("El valor "+e.getMessage()+ "es invalido");
            }

        }





}
