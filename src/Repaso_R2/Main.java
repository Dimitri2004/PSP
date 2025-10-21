package Repaso_R2;


public class Main {
    private static final Object miLockPieza =new Object();
    private static final Object miLockPintura =new Object();
    private static final Object miLockEmbalaje =new Object();
    static class T {
        void Tarea1() {
            synchronized (miLockPieza) {
                Pieza p = new Pieza();
                p.CogerPieza();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        void Tarea2() {
            synchronized (miLockPintura) {
                Pieza p = new Pieza();
                p.PintarPieza();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        void Tarea3() {
            synchronized (miLockEmbalaje) {
                Pieza p = new Pieza();
                p.EmbalandoPieza();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
     static T t=new T();

    static Thread h1=new Thread(()->t.Tarea1(),"operador 1");
    static Thread h2=new Thread(()->t.Tarea2(),"operador 2");
    static Thread h3=new Thread(()->t.Tarea3(),"operador 3");
    public static void main(String[] args) throws InterruptedException {
        System.out.println(h1.getName());
        h1.start();
        h1.join();
        System.out.println(h2.getName());
        h2.start();
        h2.join();
        System.out.println(h3.getName());
        h3.start();
        h3.join();
    }
}
