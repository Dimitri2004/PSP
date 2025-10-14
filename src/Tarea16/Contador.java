package Tarea16;

public class Contador {
    private int valor=0;

    public synchronized void incrementar(){
        valor++;
    }
    public int obtenerValor(){
        return valor;
    }
}
