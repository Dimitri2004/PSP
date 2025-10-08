package Tarea14;

public class HilosIngreso extends Thread{

    public HilosIngreso(String nombre){
        super(nombre);
    }
    @Override
    public void run(){

        for (int i=1;i<=5000;i++){
            try{
                Thread.sleep(1);
                Caja.Añadido();
            } catch (InterruptedException e) {
                System.out.println("Error salida hilo "+e.getMessage());
            }
        }


    }
}
