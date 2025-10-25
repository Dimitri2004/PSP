import java.util.concurrent.CountDownLatch;

public class Repaso{
private static final Object miLockPieza = new Object();
private static final Object miLockPintura = new Object();
private static final Object miLockEmbalaje = new Object();

    static CountDownLatch latch1 = new CountDownLatch(1); // Espera a que Tarea1 termine
    static CountDownLatch latch2 = new CountDownLatch(1); // Espera a que Tarea1 termine



    static class T {
        void Tarea1() {
            synchronized (miLockPieza) { // Asegura acceso exclusivo al recurso de pieza
                Pieza p = new Pieza(); // Crea una nueva pieza
                System.out.println(h1.getName()); // Imprime el nombre del hilo actual (operador 1)
                p.CogerPieza(); // Ejecuta la acción de coger la pieza
                try {
                    Thread.sleep(2000); // Simula tiempo de trabajo (2 segundos)
                } catch (InterruptedException e) {
                    throw new RuntimeException(e); // Manejo de interrupciones
                }
                latch1.countDown(); // Libera Tarea2 para que pueda continuar
            }
        }

        void Tarea2() {
            try {
                latch1.await(); // Espera a que Tarea1 termine
                synchronized (miLockPintura) { // Asegura acceso exclusivo al recurso de pintura
                    Pieza p = new Pieza(); // Crea una nueva pieza (puedes modificar para reutilizar la misma si lo deseas)
                    System.out.println(h2.getName()); // Imprime el nombre del hilo actual (operador 2)
                    p.PintarPieza(); // Ejecuta la acción de pintar la pieza
                    latch2.countDown(); // Libera Tarea3 para que pueda continuar
                    try {
                        Thread.sleep(1000); // Simula tiempo de trabajo (1 segundo)
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e); // Manejo de interrupciones
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Error " + e.getMessage()); // Imprime error si ocurre interrupción
            }
        }

        void Tarea3() {
            try {
                latch2.await(); // Espera a que Tarea2 termine
                synchronized (miLockEmbalaje) { // Asegura acceso exclusivo al recurso de embalaje
                    Pieza p = new Pieza(); // Crea una nueva pieza (puedes modificar para reutilizar la misma si lo deseas)
                    System.out.println(h3.getName()); // Imprime el nombre del hilo actual (operador 3)
                    p.EmbalandoPieza(); // Ejecuta la acción de embalar la pieza
                    try {
                        Thread.sleep(1000); // Simula tiempo de trabajo (1 segundo)
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e); // Manejo de interrupciones
                    }
                }
                System.out.println("Pieza lista para lanzar"); // Mensaje final indicando que el proceso ha terminado
            } catch (RuntimeException | InterruptedException e) {
                System.out.println("Error " + e.getMessage()); // Imprime error si ocurre interrupción o excepción
            }
        }
}

static T t = new T();

static Thread h1 = new Thread(() -> t.Tarea1(), "operador 1");
static Thread h2 = new Thread(() -> t.Tarea2(), "operador 2");
static Thread h3 = new Thread(() -> t.Tarea3(), "operador 3");

public static void main(String[] args) {
        // Lanzamiento simultáneo de los tres hilos
        h1.start(); // Inicia Tarea1
        h2.start(); // Inicia Tarea2 (esperará a que Tarea1 termine)
        h3.start(); // Inicia Tarea3 (esperará a que Tarea2 termine)
    }
}
