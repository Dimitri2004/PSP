package Tarea19;

public class Hilo extends Thread{
    private Contador ContadorHilos;
    private char f;
    public Hilo(Contador h,char letra){
        this.f=letra;
        this.ContadorHilos=h;
    }
    @Override
    public void run(){
       ContadorHilos.VocalesaContar(f);
        }
}
