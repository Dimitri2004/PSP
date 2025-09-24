import java.io.*;

public class Lanzador {
    public static void Lanzar(String opcion){
        String comando="ping";
        String distancia="-c";
        String cantidad="4";
        InputStream consola;
        String estado;
                try {
                    ProcessBuilder pb = new ProcessBuilder(comando, distancia, cantidad, opcion);//Creamos el builder con la opcion de host o ip enviada desde interfaz
                    Process pv = pb.start();
                    int f=pv.waitFor();//Codigo de salida 1 o 0
                    if (f==0){
                        consola=pv.getInputStream();//Realiza una asignacion de datos del processBuiter inicializado anteriormente
                        estado="[OK]";

                    }else {
                        consola=pv.getErrorStream();//Asigna un estado de fallo en caso de que una linea sea incorrecta
                        estado="[Fallo]";
                    }
                    BufferedReader lectura = new BufferedReader(new InputStreamReader(consola));//Realiza la lectura de los ping de consola al que le asignamos el estado ok y los reproduce añadiendo el mismo
                    if (f==0){
                        BufferedInputStream p=new BufferedInputStream(consola);
                        OutputStream t=new FileOutputStream("/home/dam/Escritorio/PSP/Tarea2/src/pin_output.log");

                    }
                    while (true) {
                        String linea = lectura.readLine();
                        if (linea==null){
                            break;//En caso de que termine pues pare el proceso
                        }
                        System.out.println(estado+linea);
                    }
                    System.out.println("Operacion terminada "+f);
                } catch (Exception e) {
                    throw new RuntimeException(e);//Error de e/s
                } catch (Throwable e) {
                    throw new RuntimeException("No funciona" + e.getMessage());//Error en ejecuccion
                }
        }
    }
