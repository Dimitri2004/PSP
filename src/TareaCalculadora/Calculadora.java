package TareaCalculadora;

import java.nio.charset.CharacterCodingException;

public class Calculadora extends Thread{
    private String msj;
    public Calculadora(String msj){
        this.msj=msj;
    }

    @Override
    public void run(){
        try {
            System.out.println(Funciones.Sumar(msj));
        } catch (Exception e) {
            System.out.println("Error en ecuacion");
        }
    }
}
