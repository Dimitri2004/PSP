package Tarea14;

public class HilosExtraccion extends Thread{
    public HilosExtraccion(String nombre){
        super(nombre);
    }
    @Override
    public void run(){

        for (int i=1;i<=3000;i++){
            try{
                Thread.sleep(1);
                Caja.Quitado();
            } catch (InterruptedException e) {
                System.out.println("Error salida hilo "+e.getMessage());
            }
        }
    }
}
