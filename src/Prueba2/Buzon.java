package Prueba2;

public class Buzon {
    private String paquete;
    private boolean disponible = false;

    public synchronized String recogerPaquete() {
        while (!disponible) {
            try {
                System.out.println("Cliente espera el paquete...");
                wait(); // espera hasta que el paquete esté disponible
            } catch (InterruptedException e) {
                System.out.println("Interrumpido el proceso por :" + e.getMessage());
            }
        }
        disponible = false;
        System.out.println("Cliente ha recogido el paquete: " + paquete);
        return paquete;
    }

    public synchronized void dejarPaquete(String paquete) {
        this.paquete = paquete;
        disponible = true;
        System.out.println("Repartidor ha dejado el paquete: " + paquete);
        notify(); // avisa al cliente
    }
}