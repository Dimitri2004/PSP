package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;

import java.util.Properties;

public class LeerMensajes {
    public static void leerMensaje(Properties prop, Session session,int msg){
        //1.Configuracion
        prop.put("mail.pop3.host","pop3.mailtrap.io");
        prop.put("mail.pop3.port","1100");
        prop.put("mail.pop3.starttls.enable","true");

        //2.Conectar Store
        try {
            Store store = session.getStore("pop3");
            store.connect("89a1249237c5cf","47c6ff69f65a4c");

            //3.Abrir Inbox y Leer
            Folder inbox=store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages;//Obtenemos mails
            int cantidadMsgs = inbox.getMessageCount();
            if (cantidadMsgs<=msg || msg<0){
                messages = inbox.getMessages();
            }
            else {
                messages = inbox.getMessages(1,msg);
            }
            for (Message m:messages){
                System.out.println("Remitente : "+ InternetAddress.toString(m.getFrom()));
                System.out.println("Asunto : "+m.getSubject());
            }
        } catch (NoSuchProviderException e) {
            System.out.println("No provisto de : "+e.getLocalizedMessage());
        } catch (MessagingException e) {
            System.out.println("No hay mensages :"+e.getLocalizedMessage());
        }
    }
}
