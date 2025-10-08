package Tarea15;

public class Hilo extends Thread{

    private int interaccion=0;
    public Hilo(String nombre,int interaccion){
        super(nombre);
        this.interaccion=interaccion;
    }

    @Override
    public void run(){
        for (int i=1;i<=8;i++){
            interaccion +=1;
            try {
                Thread.sleep(20);
                System.out.println("Soy el "+getName()+ "- interacción : "+interaccion);
            } catch (InterruptedException e) {
                System.out.println("Error salida hilo "+e.getMessage());
            }
        }
    }
}
