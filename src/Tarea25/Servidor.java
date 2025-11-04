package Tarea25;

import java.io.IOException;
import java.net.Socket;

public class Servidor{
    private Socket socket;
    public Servidor(Socket socket){
        this.socket=socket;
    }
    public void conexion() {
        try {
            System.out.println("Conectado a : " + socket.getInetAddress());

            if (socket.isConnected()) {
                System.out.println("Servidor abierto");
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
