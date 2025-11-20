package TareaCalculadora;

public class ProcesosDeCalculo extends Thread{
    private String msj;

    public ProcesosDeCalculo(String msj){
        this.msj=msj;
    }
    @Override
    public void run(){
        System.out.println(CalcularExponente.derivar(msj));
    }
}
