package Repaso;

public class Espectador {
    private static int contador=0;
    public synchronized void Numeroespectadores(int cont){
        contador=cont;
        contador++;
    }
    public int total(){
        int total = 0;
        for (int i=1;i<=4;i++){
            total +=contador;
        }
        return total;
    }
}
