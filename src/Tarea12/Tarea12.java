package Tarea12;

public class Tarea12 extends Thread {

    private int nume;
    private int suma;
    private String nombre;

    public Tarea12(int nume) {// 0 par, 1 impar, 2 terminado en 3 o 4
        this.nume = nume;// tipo de suma
    }

    @Override
    public void run() { //realiza la suma segun el tipo
        switch (nume) {// 0 par, 1 impar, 2 terminado en 3 o 4
            case 0:// par
                nombre="Par";
                for (int i = 0; i < 1923; i++) {
                    if (i % 2 == 0) { // Si el número es par
                        suma += i;
                    }
                }
                break;
            case 1: // impar
                nombre ="Impar";
                for (int i = 0; i < 1923; i++) {
                    if (i % 2 != 0) { // Si el número es impar
                        suma += i;
                    }
                }
                break;
            case 2: // terminado en 3 o 4
                nombre="Terminado 3 o 4";
                for (int i = 0; i < 1923; i++) {
                    int ultimoDigito = i % 10; // Obtener el último dígito
                    if (ultimoDigito == 3 || ultimoDigito == 4) {
                        suma += i;
                    }
                }
                break;
        }
    }

    private int getSuma() { // devuelve la suma realizada
        return suma;
    }

    private String getNombre(){ // devuelve el nombre del tipo de suma
        return nombre;
    }
    public static void main(String[] args)  {
        Tarea12[] hilos = new Tarea12[3]; // Creamos un array de hilos
        for (int i = 0; i < hilos.length; i++) { // Creamos e iniciamos los hilos
            hilos[i] = new Tarea12(i); // 0 par, 1 impar, 2 terminado en 3 o 4
            hilos[i].start(); // Iniciamos el hilo
        }
        try { // Esperamos a que terminen los hilos y mostramos el resultado
            for (Tarea12 hilo : hilos) {
                hilo.join(); // Esperamos a que termine el hilo
                System.out.println("Resultado del hilo " + hilo.getNombre() + " " + hilo.getSuma()); // Mostramos el resultado
            }
        }catch (InterruptedException e){ // Capturamos la excepción
            System.out.println("Error ejecucion hilo "+e);
        }
    }
}
