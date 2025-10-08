package Tarea16;

public class Hilo extends Thread{
    @Override
    public void run(){
        for (int i=1;i<50;i++){
            try {
                Contador.cont +=1;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Error salida hilo "+e.getMessage());
            }
            System.out.println(Contador.cont);
        }
    }
}
