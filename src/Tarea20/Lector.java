package Tarea20;

public class Lector extends Thread {
    private Buzon buzon;

    public Lector(Buzon bz){
        super();
        buzon=bz;
    }
    @Override
    public void run(){
        String mensaje;
        try {
            mensaje=buzon.LeerMensaje();
            System.out.println(mensaje+" leido");
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
