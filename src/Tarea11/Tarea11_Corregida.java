package Tarea11;

public class Tarea11_Corregida extends Thread {
    private int iteracion;
    private int nHilo;
    private Thread hiloHijo;
    private int limiteCadena;

    public Tarea11_Corregida(int nHilo,int limiteCadena){
        super();
        this.nHilo = nHilo;
        this.iteracion=1;
        setLimiteCadena(limiteCadena);
    }

    public void setLimiteCadena(int limiteCadena) {
        if (limiteCadena>=1){
            this.limiteCadena = limiteCadena;
        }
        else {
            this.limiteCadena = 5;
        }
    }

    @Override
    public void run(){
        if (nHilo<limiteCadena){
            hiloHijo = new Tarea11_Corregida(nHilo+1,limiteCadena);
            hiloHijo.start();
        }
        while (iteracion<=5){
            int dormir = (int)(Math.random()*500+100);
            try {
                Thread.sleep(dormir);
            } catch (InterruptedException e) {
                System.out.println("Interrumpido el sleep en el hilo "+nHilo+" "+e.getMessage());
            }
            System.out.println("Soy [hilo-"+nHilo+"] iteracion: "+iteracion);
            iteracion++;
        }
        try {
            if (hiloHijo!=null){
                hiloHijo.join();
            }
            System.out.println("Acabo hilo-"+nHilo);
        } catch (InterruptedException e) {
            System.out.println("Interrumpido el join en el hilo "+nHilo+" "+e.getMessage());
        }

    }


    public static void main(String[] args){
            long tiempoInicio = System.currentTimeMillis(),tiempoFin,tiempoEjecucion;
            Thread hiloInicio = new Tarea11_Corregida(1,5);
            hiloInicio.start();
            while (hiloInicio.isAlive()){
                System.out.println("[Control Central] Vigilando a Hilo-1... sigue activo.");
                try {
                    Thread.sleep(200);
                }catch (InterruptedException e ){
                    System.out.println("Interrumpida espera de main "+e.getMessage());
                }
            }
            System.out.println("[Control Central] Hilo-1 ha terminado.");
            tiempoFin = System.currentTimeMillis();
            tiempoEjecucion = tiempoFin-tiempoInicio;
            System.out.println("Tiempo total de la caída: "+tiempoEjecucion+" ms");
    }
}
