package Repaso_R2;


import java.util.concurrent.CountDownLatch;

public class Main {
    private static final Object miLockPieza = new Object();
    private static final Object miLockPintura = new Object();
    private static final Object miLockEmbalaje = new Object();

    static CountDownLatch latch1= new CountDownLatch(1);
    static CountDownLatch latch2=new CountDownLatch(1);

    static class T {
        void Tarea1() {
            System.out.println(h1.getName());
            synchronized (miLockPieza) {
                Pieza p = new Pieza();
                p.CogerPieza();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                latch1.countDown();
            }
        }

        void Tarea2() {
            try {
                latch1.await();
                System.out.println(h2.getName());
                synchronized (miLockPintura) {
                    Pieza p = new Pieza();
                    p.PintarPieza();
                    latch2.countDown();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Error "+e.getMessage());
            }
        }

        void Tarea3() {
            try {
                latch2.await();
                System.out.println(h3.getName());
                synchronized (miLockEmbalaje) {
                    Pieza p = new Pieza();
                    p.EmbalandoPieza();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Pieza lista para lanzar");
            } catch (InterruptedException e) {
                System.out.println("Error "+e.getMessage());
            }
        }
    }

    static T t = new T();

    static Thread h1 = new Thread(() -> t.Tarea1(), "operador 1");
    static Thread h2 = new Thread(() -> t.Tarea2(), "operador 2");
    static Thread h3 = new Thread(() -> t.Tarea3(), "operador 3");

    public static void main(String[] args) throws InterruptedException {
        h1.start();
        h2.start();
        h3.start();
    }
}
