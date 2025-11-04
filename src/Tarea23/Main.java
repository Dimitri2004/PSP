package Tarea23;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cliente clientes = new Cliente(200);
        Cajas c = new Cajas(5, clientes);

        SuperMercado sm = new SuperMercado(c, clientes);

        sm.start();

        System.out.println(sm.ResultadoImporteTotal(clientes));

    }
}
