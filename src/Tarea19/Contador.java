package Tarea19;

public class Contador {
    static int contadorVocales=0;
    public synchronized void incrementarvocales(){
    contadorVocales++;
    }
    public int contadas(){
        return contadorVocales;
    }
}
