package Repaso_R2;

public class Pieza {
   
    public synchronized void CogerPieza(){
        System.out.println("Cogiendo pieza");
    }
    public synchronized void PintarPieza(){
        System.out.println("Pintando pieza");
    }
    public synchronized void EmbalandoPieza(){
        System.out.println("Embalando pieza");
    }
}
