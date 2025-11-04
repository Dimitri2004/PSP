package Tarea23;

public class SuperMercado extends Thread{
    private Cajas cajas;
    private Cliente cliente;
    private int resultadoFinal;
    public SuperMercado(Cajas cajas,Cliente cliente){
        this.cajas=cajas;
        this.cliente=cliente;
    }

    public int ResultadoImporteTotal(Cliente cliente){
        for (int i=0;i<cliente.realizarPago();i++) {
            resultadoFinal += cliente.realizarPago();
            resultadoFinal++;
        }
        return resultadoFinal;
    }

    @Override
    public void run(){
        try {
            cliente.haciendoCompra(cajas);
        } catch (InterruptedException e) {
            System.out.println("Error en :"+e.getMessage());
        }
    }



}
