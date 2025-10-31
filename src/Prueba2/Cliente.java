package Prueba2;

public class Cliente extends Thread{
    private Buzon buzon;

    public Cliente(Buzon buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {
        String paquete = buzon.recogerPaquete();
    }

}
