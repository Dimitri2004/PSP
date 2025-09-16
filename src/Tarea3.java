import java.io.File;
import java.io.IOException;

public class Tarea3 {
    public static void main(String[] arg) throws IOException {
        ProcessBuilder pb=new ProcessBuilder("gnome-text-editor");
        File log=new File("log");
        pb.redirectErrorStream(true);
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process p= pb.start();
        assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
        assert pb.redirectOutput().file() == log;
        if (p.getInputStream().read() != -1) throw new AssertionError();
    }
}
