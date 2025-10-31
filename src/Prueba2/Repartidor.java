package Prueba2;

import java.util.Random;

public class Repartidor extends Thread{
    private Buzon buzon;

    public Repartidor(Buzon buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {
        try {
            int espera = new Random().nextInt(3000) + 1000; // entre 1 y 4 segundos
            Thread.sleep(espera);
        } catch (InterruptedException e) {
            System.out.println("Servicio interrumpido por :"+e.getMessage());

        }
        buzon.dejarPaquete("Documentacion Necesaria para aprovar");
    }
}
