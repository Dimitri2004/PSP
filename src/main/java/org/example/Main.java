package org.example;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.util.Properties;

public class Main {
    public static void main(String[] args){
        Properties prop=new Properties();
        prop.put("mail.smtp.host","sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port","587");

        prop.put("mail.smtp.auth","true");
        prop.put("mail.stmp.starttls.enable","true");

        Session session=Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("89a1249237c5cf","47c6ff69f65a4c");
            }
        });

        //MandarMensaje.mandarMensaje(session);

        //Leer mensajes
        LeerMensajes.leerMensaje(prop,session,-1);
    }
}
