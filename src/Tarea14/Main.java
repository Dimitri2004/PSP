package Tarea14;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Capital actual :" +Caja.capital);
        HilosIngreso hI=new HilosIngreso("Ingresos");
        hI.start();
        HilosExtraccion hE=new HilosExtraccion("Extraccion");
        hE.start();

        try {
            hE.join();
            hI.join();
        } catch (InterruptedException e) {
            System.out.println("Error en hilo salida "+e.getMessage());
        }
        System.out.println("Capital final: "+Caja.capital);
    }



}
