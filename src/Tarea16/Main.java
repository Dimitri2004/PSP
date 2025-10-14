package Tarea16;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Contador contadorCompartido= new Contador();
       Thread h1=new Hilo(contadorCompartido);
       Thread h2=new Hilo(contadorCompartido);
       Thread h3=new Hilo(contadorCompartido);
       Thread h4=new Hilo(contadorCompartido);
       Thread h5=new Hilo(contadorCompartido);
       h1.start();
       h2.start();
       h3.start();
       h4.start();
       h5.start();
       h1.join();
       h2.join();
       h3.join();
       h4.join();
       h5.join();

        System.out.println("Valor contador: "+contadorCompartido.obtenerValor());

    }
}
