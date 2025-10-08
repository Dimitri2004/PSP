package Tarea14;

public class Caja {
    public static double capital=1000.0;
    public synchronized static void Añadido(){
        capital +=10;
    }
    public synchronized static void Quitado(){
        capital -=10;
    }
}
