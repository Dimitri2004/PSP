package Tarea21;

import java.util.ArrayList;
import java.util.Random;

public class Coche extends Thread{
    private Parking parking;
    private int nplazas;

    public Coche(Parking parking,int nplazas){
        this.parking=parking;
        setNplazas(nplazas);
    }
    public void setNplazas(int nplazas){
        if (nplazas>0){
           this.nplazas=nplazas;
        }else this.nplazas=nplazas;
    }
    @Override
    public void run(){
        for (int i = 0; i<20; i++){
            parking.aparcar(nplazas);
            try {
                Thread.sleep(numeroAleatorio());
            } catch (InterruptedException e) {
                System.out.println("Hilo coche "+nplazas+" interrumpido: "+e.getMessage());
            }
            parking.salir(nplazas);
            try {
                Thread.sleep(numeroAleatorio());
            } catch (InterruptedException e) {
                System.out.println("Hilo coche "+nplazas+" interrumpido: "+e.getMessage());
            }
        }
    }
    private long numeroAleatorio(){
           long tiempo = (long) (Math.random()*100+100);
        return tiempo;
    }
}
