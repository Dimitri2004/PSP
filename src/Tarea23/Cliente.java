package Tarea23;


public class Cliente {
    private int importe;
    public Cliente(int importe){
        this.importe=importe;
        setImporte(importe);
    }

    public void setImporte(int importe) {
        this.importe=importe;
    }

    //hace compra y cuando termine se añadira a cola de caja en Cajas
    public synchronized void  haciendoCompra(Cajas cajas) throws InterruptedException {
        System.out.println("Haciendo compra....");
        int tiempo= (int) (Math.random()*10+5);
        Thread.sleep(tiempo);
        for (int i=0;i< Math.random()*6+1;i++) {
            cajas.asignarCliente(i);
        }
    }

    //importe por producto
    public synchronized int realizarPago(){
        notify();
        return importe;
    }
}
