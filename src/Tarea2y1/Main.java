package Tarea2y1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args){
    Runtime r= Runtime.getRuntime();

        System.out.println("Espacio libre :"+r.freeMemory()/1024);
        System.out.println("Espacio total :"+r.totalMemory()/1024);
        System.out.println("Espacio máximo :"+r.maxMemory()/1024);


        System.out.println("Numero de procesadores :"+r.availableProcessors());

        String a=System.getProperties().toString();
        String[] b=a.split(",");
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
}