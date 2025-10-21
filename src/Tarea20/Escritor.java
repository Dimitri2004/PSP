package Tarea20;

public class Escritor extends Thread{

    private String msj;
    private Buzon buzon;

    public Escritor(String mensaje,Buzon buz){
        super();
        msj=mensaje;
        buzon=buz;

    }
    @Override
    public void run(){
        try {
            buzon.EscribirMensage(msj);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
