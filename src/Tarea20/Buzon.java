package Tarea20;

public class Buzon {
    private String mensaje;
    public synchronized void EscribirMensage(String msj){
        while (mensaje!=null){
            System.out.println("Buzon lleno, lea para vaciar");
            try{
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mensaje=msj;
        System.out.println("Mensaje escrito : "+msj);
        notifyAll();
    }

    public synchronized String LeerMensaje(){
        while (mensaje==null){
            System.out.println("Buzon vacio, esperando");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String msj=mensaje;
        mensaje=null;
        notifyAll();
        return msj;
    }
}
