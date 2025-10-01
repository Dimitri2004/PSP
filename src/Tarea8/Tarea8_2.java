package Tarea8;

public class Tarea8_2 extends Thread {


    private int num;
    public Tarea8_2(int num){
        this.num=num;
    }
    @Override
    public void run(){
        int a=0;
        int b=1;
        if (num<=0){
            System.out.println(a);//Saca 0
        }if (num>=1){
            System.out.println(a);//Saca 1
        }if (num>=2){
            System.out.println(b);//Saca 1
        }
        for (int i=2;i<=num;i++){//operacion fibonaci
           int resultado=a+b;// 0+1 num veces ->1+1->1+2
            System.out.println(resultado);//1
            a=b;//2,3,5,8
            b=resultado;//igualamos
        }

    }

    public static void main(String[] args){
        new Tarea8_2(10).start();
    }
}
