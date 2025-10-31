package Prueba2;

public class Main {
    public static void main(String[] args) {
        Buzon buzon = new Buzon();

        Cliente cliente = new Cliente(buzon);
        Repartidor repartidor = new Repartidor(buzon);

        cliente.start();      // Cliente intenta recoger el paquete

        repartidor.start();   // Repartidor lo deja después de un tiempo
    }
}
