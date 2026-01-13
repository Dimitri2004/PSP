package Tarea38;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Scanner;

public class Registro {
    private String hex;
    public void InicioSesion(){
        try{
            Scanner sc=new Scanner(System.in);
        MessageDigest md = MessageDigest.getInstance("SHA-256");


            System.out.println("Dame una contraseña :");
            String password=sc.nextLine();

            md.update(password.getBytes());

            byte[] resumen= md.digest();

           hex= HexFormat.of().formatHex(resumen);



        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error en algoritmo de Registro " + e.getMessage());
        }
        System.out.println("Usuario registrado, Inicie sesion para probar");
    }

    public void Inicio(){
        Scanner sc=new Scanner(System.in);

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            System.out.println("Iniciando sesion,contraseña:");
            String miPass=sc.nextLine();

            md.update(miPass.getBytes());

            byte[] resumen= md.digest();

           String hex2= HexFormat.of().formatHex(resumen);

            String passwordGuardada=hex;

            if (hex2.equals(passwordGuardada)){
                System.out.println("Contraseña Correcta:ACCESO CONCEDIDO");
            }else {
                System.out.println("[ERROR:Credenciales inválidas] Fallo al iniciar sesión");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error en algoritmo de Inicio "+e.getMessage());
        }
    }
    public void main(String[] args){
        InicioSesion();
        Inicio();
    }

}

