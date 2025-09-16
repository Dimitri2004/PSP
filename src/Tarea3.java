import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Tarea3 {
    public static void main(String[] arg) throws IOException {
        Scanner sc=new Scanner(System.in);        System.out.println("Quieres crear nuevo archivo:Si/No");
        String r=sc.next();

        if (Objects.equals(r, "Si")){
            Editor();
        }
    }
    public static void Editor() throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Cual es el nombre del nuevo archivo :");
        String name=sc.next();
        ProcessBuilder pb=new ProcessBuilder("gnome-text-editor");
        File log=new File(name);
        pb.redirectErrorStream(true);
        Process p= pb.start();
        assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
        assert Objects.equals(pb.redirectOutput().file(), log);
        if (p.getInputStream().read() != -1) throw new AssertionError();
    }


}
