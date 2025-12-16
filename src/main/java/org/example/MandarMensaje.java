package org.example;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MandarMensaje {
    public static void mandarMensaje(Session session){
        try{
            MimeMessage masg=new MimeMessage(session);
            masg.setFrom(new InternetAddress("prueba@java.com"));
            masg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(("destino@cualquiera.com")));
            masg.setSubject("Prueba Mailtrap-Dima Aparicio");
            masg.setText("Hola! Si ves esto, como te sientes bien?");

            //2.Enviar
            Transport.send(masg);
            System.out.println("Enviar.Revisa tu bandeja de entrda en Mailtrap");
        } catch (AddressException e) {
            System.out.println("Error en direccion: "+e.getRef());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
