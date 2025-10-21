package Repaso;

public class Main {
    public static void main(String[] args) {

        Espectador espectador = new Espectador();

        Thread t1 = new Torno(espectador,"Torno 1");
        Thread t2 = new Torno(espectador,"Torno 2");
        Thread t3 = new Torno(espectador,"Torno 3");
        Thread t4 = new Torno(espectador,"Torno 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();

            System.out.println("pasaron un total de : "+espectador.total()+" espectadores");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
