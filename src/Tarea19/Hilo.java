package Tarea19;

public class Hilo extends Thread{
    private char[] texto;
    private char vocal;
    public Hilo(char[] texto,char vocal){
        this.texto=texto;
        this.vocal=vocal;
    }
    @Override
    public void run(){
        Contador c=new Contador();
        for (char a:texto) {
            if(a==vocal) {
                c.incrementarvocales();
            }
        }
        }
}
