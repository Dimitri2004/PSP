import java.util.Objects;
import java.util.Scanner;

public class Tarea5 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Escribe el tipo de comando que quires:\n" +
                "1.ls \n" +
                "2.gnome-text-editor\n" +
                "3.open");
        String comando= sc.next();
        ProcessBuilder pb=new ProcessBuilder(comando);
        String ruta="/home/dam/Escritorio/PSP/Tarea2/src/css.png";//ruta

        try{
            if (comando.equals("open")) {
                Process pd= new ProcessBuilder(comando,ruta).start();
               int f= pd.waitFor();
                System.out.println("Codigo de ejecuccion: " + f);//Saca el codigo de ejecuccion si sale 0 correcto si sale 1 algo fallo
                System.out.println("Se ejecuto el comando " + comando + " con codigo de ejecuccion " + f);//nombre del comando empleado y su codigo
            }else{
                Process pv=pb.start();
                int exitCode = pv.waitFor();
                System.out.println("Codigo de ejecuccion: " + exitCode);//Saca el codigo de ejecuccion si sale 0 correcto si sale 1 algo fallo
                System.out.println("Se ejecuto el comando " + comando + " con codigo de ejecuccion " + exitCode);//nombre del comando empleado y su codigo
            }
        } catch (Exception e) {
            throw new RuntimeException("Hub un error en el proceso"+e.getMessage());
        }
    }
}
