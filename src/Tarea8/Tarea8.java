package Tarea8;

public class Tarea8 extends Thread {
    //Nombre y valor de paciancia
    private int paciencia=5;
    public Tarea8(String nombre,int paciencia){
        super(nombre);
        this.paciencia=paciencia;
    }
    @Override
    public void run() {
        int i;
        for (i = 0; i <= paciencia; i++) {
            System.out.println("["+getName()+"] Nivel de enfado:"+i);
            if (i == 4) {
                System.out.println("[" +getName() + "] Paciencia agotada:" + i);
            }
        }
    }

    //Empezamos las tareas con start() y llamamos run()
    public static class Thread {
        public static void main(String[] args) {
            System.out.println("empezando");
            new Tarea8("Diego",4).start();
            new Tarea8("Iago",4).start();
            new Tarea8("Manuel",4).start();
            new Tarea8("Damian",4).start();

        }

    }
}
