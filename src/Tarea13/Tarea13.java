package Tarea13;

public class Tarea13 extends Thread{

    public Tarea13(String nombre){
        super(nombre);
    }

    @Override
    public void run(){
        long duracion;
        for (int i=1;i<11;i++){
            System.out.println("Iteracion: "+i+ " para "+getName()+" con prioridad "+getPriority());
            duracion=(long) (Math.random()*9000+1000);
            try{
                Thread.sleep(duracion);
            } catch (InterruptedException e) {
                System.out.println("Error en salida de hilo "+e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        Thread primero = new Tarea13("Primer hilo");
        primero.start();
        primero.setPriority(Thread.MIN_PRIORITY);
        Thread segundo = new Tarea13("Segundo hilo");
        segundo.start();
        segundo.setPriority(Thread.NORM_PRIORITY);
        Thread tercero = new Tarea13("Tercero hilo");
        tercero.start();
        tercero.setPriority(Thread.MAX_PRIORITY);
        Thread cuarto = new Tarea13("Cuarto hilo");
        cuarto.start();
        cuarto.setPriority(Thread.NORM_PRIORITY);


    }
}
