package TareaCalculadora;

public class Calculadora extends Thread{
    private String msj;
    public Calculadora(String msj){
        this.msj=msj;
    }

    @Override
    public void run(){
        if (msj.contains("+")){
            String[] msj2=msj.split("");
            int a= Integer.parseInt(msj2[0]);
            int b=Integer.parseInt(msj2[2]);
            System.out.println(a+b);
        }
    }
}
