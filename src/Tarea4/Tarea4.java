package Tarea4;

import java.io.IOException;
import java.util.Properties;

public class Tarea4 {
    public static void main(String[] args) throws IOException {
        String cmdo="dir";
        String ruta="user.dir";
        String ruta2="user.home";
        String dir="/home/dam/Escritorio/PSP/Tarea3.Tarea3";
        String dir2="/home/dam/Escritorio/PSP/Tarea2";
        ProcessBuilder pb=new ProcessBuilder(cmdo,dir2);
        pb.start();
        Properties properties = System.getProperties();
        pb.inheritIO();

        properties.setProperty(ruta2,dir2);
        properties.getProperty(ruta);

        //Cambia la propiedad de la ruta e trabajo
        properties.setProperty(ruta,dir);
        properties.getProperty(ruta);

        properties.setProperty(ruta,"/temp");
        properties.getProperty(ruta);



    }
}
