package Tarea21;

import java.util.Arrays;

public class Parking {
        private int[] plazas;

        public Parking(int nPlazas) {
            this.plazas = new int[nPlazas];
        }
        private int plazaLibre(){
            return buscarCoche(0); // Los coches no deben entrar en 0 por lo q tienen q buscar otra plaza
        }
        private int buscarCoche(int coche) {
            for (int i = 0;i<plazas.length;i++){
                if (plazas[i] == coche){
                    return i;
                }
            }
            return -1;
        }
        public synchronized void aparcar(int coche){
            while (plazaLibre()==-1){
                System.out.println("Coche "+coche+" esperando");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interrumpido al aparcar: "+e.getMessage());
                }
            }
            int plaza = plazaLibre();
            plazas[plaza] = coche;
            System.out.println("ENTRADA: Coche "+coche+" aparcando en "+plaza+"\n"+Arrays.toString(plazas));
        }
        public synchronized void salir(int coche){
            int plaza = buscarCoche(coche);
            if (plaza != -1){
                plazas[plaza] = 0;
                System.out.println("SALIDA: Coche "+coche+" saliendo de "+plaza+"\n"+ Arrays.toString(plazas));
                notifyAll();
            }

        }
}
