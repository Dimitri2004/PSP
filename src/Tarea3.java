
import java.io.IOException;

import java.util.Scanner;

public class Tarea3 {
    public static void main(String[] arg) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Cual es el nombre del nuevo archivo a crear o buscar:");
        String name=sc.next();

        String comando="gnome-text-editor";

        ProcessBuilder pb=new ProcessBuilder(comando,name);
        pb.start();

    }
}
