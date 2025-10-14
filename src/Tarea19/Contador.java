package Tarea19;

public class Contador {
    private int contadorVocales=0;

    public synchronized void incrementarvocales(){
    contadorVocales++;
    }
    public char VocalesaContar(char frase) {
        if (frase=='a'|frase=='e'|frase=='i'|frase=='o'|frase=='u'){
            System.out.println("incrementamos "+ frase);
            incrementarvocales();
        }
        return frase;
    }
    public int contadas(){
        return contadorVocales;
    }
}
