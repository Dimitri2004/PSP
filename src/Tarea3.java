import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Tarea3 {
    public static void main(String[] arg) throws IOException {
        Scanner sc=new Scanner(System.in);
        ProcessBuilder pb=new ProcessBuilder("gnome-text-editor");
        File log=new File("log");
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process p= pb.start();
        assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
        assert pb.redirectOutput().file() == log;
        if (p.getInputStream().read() != -1) throw new AssertionError();

        System.out.println("Quieres crear nuevo archivo:Si/No");
        String r=sc.next();

        if (Objects.equals(r, "Si")){
            Editor();
        }
    }
    public static void Editor(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Cual es el nombre del nuevo archivo :");
        String name=sc.next();
    }


}
