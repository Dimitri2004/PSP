import java.io.File;

import java.io.IOException;
import java.util.Properties;

public class Tarea4 {
    public static void main(String[] args) throws IOException {
        String cmdo="dir";
        String ruta="user.dir";
        String dir="/home/dam/Escritorio/PSP/Tarea2";
        String dir2="/home/dam/Escritorio/PSP/Tarea1";
        ProcessBuilder pb=new ProcessBuilder(cmdo);
        Properties properties = System.getProperties();
        pb.inheritIO();

        System.out.println( properties.getProperty(ruta));

        properties.setProperty(ruta,dir2);
        System.out.println( properties.getProperty(ruta));



        pb.start();

    }
}
