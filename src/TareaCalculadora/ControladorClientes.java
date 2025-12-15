package TareaCalculadora;

import java.net.Socket;

import static TareaCalculadora.ManejarCliente.manejarCliente;

public class ControladorClientes extends Thread{
    private Socket cliente;

    public ControladorClientes(Socket cliente) {
        this.cliente = cliente;
    }
    @Override
    public void run() {
        manejarCliente(cliente);
    }
}
