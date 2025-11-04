package Tarea23;

import java.util.Arrays;

public class Cajas {
    private int[] nCaja;
    private Cliente cliente;
    //Crear el numero de cajas
    public Cajas(int nCajas,Cliente cliente){
        super();
        this.nCaja=new int[nCajas];
        this.cliente=cliente;
    }
    public int cajaLibre(){
        return buscarCaja(0);
    }
    private int buscarCaja(int cajas){
        for (int i = 0;i<cajas;i++){
            cajas= (int) (Math.random()*nCaja[i]);
            if (nCaja[i]==cajas) {
                return cajas;
            }
            i++;
        }
        return +1;
    }
    //Recrear la cola en caja
    public synchronized void asignarCliente(int clientes){
        int caja = cajaLibre();
        nCaja[caja] = clientes;
        System.out.println("ENTRADA: Cliente  pagando en caja "+clientes+"\n"+ Arrays.toString(nCaja));
        cliente.realizarPago();
    }

}
