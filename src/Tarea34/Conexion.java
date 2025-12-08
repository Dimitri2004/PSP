
package Tarea34;
import java.util.Scanner;

public class Conexion {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String url,url1,urlVel,urlGran;
            long urlV,url1V,urlT,url1T,VelMax,TamMax;

            System.out.println("Primera URL a comparar?");
            url = sc.nextLine();
            System.out.println("Segunda URL a comparar?");
            url1 = sc.nextLine();

            hilosConexion h1 = new hilosConexion(url);
            hilosConexion h2 = new hilosConexion(url1);

            h1.start();
            h2.start();

            h1.join();
            h2.join();

            urlV = h1.getVelocidad();
            urlT = h1.getTamaño();
            url1V = h2.getVelocidad();
            url1T = h2.getTamaño();

            if (urlT == url1T){
                System.out.println("Ambas webs tiene el mismo tamaño");
            }
            else{
                if (urlT>url1T){
                    urlGran = url;
                    TamMax = urlT;
                }
                else {
                    urlGran = url1;
                    TamMax = url1T;
                }
                System.out.println("La web con más contenido ha sido: ["+urlGran+"] con ["+TamMax+"] caracteres.");
            }

            if (urlV == url1V){
                System.out.println("Ambas webs tardaron los mismo");
            }
            else {
                if (urlV>url1V){
                    urlVel = url;
                    VelMax = urlV;
                }
                else {
                    urlVel = url1;
                    VelMax = url1V;
                }
                System.out.println("La web más rápida ha sido: ["+urlVel+"] con ["+VelMax+"] ms.");
            }
        } catch (InterruptedException e){
            System.out.println("Error con los hilos. "+e.getMessage());
        }
    }
}
