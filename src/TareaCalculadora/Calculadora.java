package TareaCalculadora;



public class Calculadora extends Thread{
    private String msj;


    public Calculadora(String msj){
        this.msj=msj;
    }

    @Override
    public void run(){
        Funciones func=new Funciones();
        try {
            System.out.println(func.Operaciones(msj));
        } catch (Exception e) {
            System.out.println("Error en ecuacion");
        }
    }
}
