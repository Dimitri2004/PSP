import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Tarea4 {
    public static void main(String[] args) throws IOException {
        String cmdo="dir";
        String ruta="user.dir";
        ProcessBuilder pb=new ProcessBuilder(cmdo,ruta);
        Properties properties = System.getProperties();

        System.out.println( properties.getProperty(ruta));
        pb.start();

    }
}
