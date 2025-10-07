package Tarea12;

public class Tarea12 extends Thread {

    private int nume;
    private int suma;
    private String nombre;

    public Tarea12(int nume) {
        this.nume = nume;
    }

    @Override
    public void run() {
        switch (nume) {
            case 0:
                nombre="Par";
                for (int i = 0; i < 1923; i++) {
                    if (i % 2 == 0) {
                        suma += i;
                    }
                }
                break;
            case 1:
                nombre ="Impar";
                for (int i = 0; i < 1923; i++) {
                    if (i % 2 != 0) {
                        suma += i;
                    }
                }
                break;
            case 2:
                nombre="Terminado 3 o 4";
                for (int i = 0; i < 1923; i++) {
                    int ultimoDigito = i % 10;
                    if (ultimoDigito == 3 || ultimoDigito == 4) {
                        suma += i;
                    }
                }
                break;
        }
    }

    private int getSuma() {
        return suma;
    }

    private String getNombre(){
        return nombre;
    }
    public static void main(String[] args)  {
        Tarea12[] hilos = new Tarea12[3];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Tarea12(i);
            hilos[i].start();
        }
        try {
            for (Tarea12 hilo : hilos) {
                hilo.join();
                System.out.println("Resultado del hilo " + hilo.getNombre() + " " + hilo.getSuma());
            }
        }catch (InterruptedException e){
            System.out.println("Error ejecucion hilo "+e);
        }
    }
}
