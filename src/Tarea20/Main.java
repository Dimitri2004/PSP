package Tarea20;

public class Main {

    public static void main(String[] args){
        String mensaje="Hola tienes correo";
        Buzon b=new Buzon();

        Thread l1=new Escritor(mensaje,b);
        Thread l2=new Lector(b);


        l1.start();
        l2.start();
    }
}
