package Tarea16;

public class Hilo extends Thread{
    private Contador contador;
    public Hilo(Contador c){
        this.contador=c;
    }
    @Override
    public void run(){
        for (int i=1;i<50;i++){
            try {
                contador.incrementar();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Error salida hilo "+e.getMessage());
            }
        }
    }
}
