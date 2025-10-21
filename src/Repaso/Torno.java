package Repaso;

import java.util.Random;

public class Torno extends Thread{
    private Espectador af;
    private String nombre;
    public Torno(Espectador exp,String nombre){
        this.af=exp;
        this.nombre=nombre;
    }

    @Override
    public void run(){
        Espectador esc=new Espectador();
        for (int i=0;i<1000;i++){
            af.Numeroespectadores(i);
            System.out.println("Pasaron por el torno "+nombre);
            try {
                Thread.sleep((long) (Math.random()*10+1));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
}
