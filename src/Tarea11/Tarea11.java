package Tarea11;

public class Tarea11 extends Thread {
    int numero;

    public Tarea11(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        int dominio = 6;
        for (int i = 1; i < dominio; i++) {
            System.out.println("[Hilo " + numero + "] iteración: " + i);

        }
        try {
            Thread.sleep((int) (Math.random() * 100)); // Pequeña pausa aleatoria
            System.out.println("Acabo Hilo-" + numero);

        } catch (InterruptedException e) {
            System.out.println("Error " + e);
        }

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Tarea11(i).start(); // Crear e iniciar hilo

        }
    }

}


