package Tarea34;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
public class hilosConexion extends Thread {
        private String url;
        private long v = 0;
        private long tamaño = 0;
        public hilosConexion(String url){
            super();
            this.url = url;
        }
        @Override
        public void run(){
            try(HttpClient cliente = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build()){
                HttpRequest envio = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
                long tiempoInicio = System.currentTimeMillis();
                HttpResponse<String> response = cliente.send(envio,HttpResponse.BodyHandlers.ofString());
                long tiempoFin = System.currentTimeMillis();
                v = tiempoFin-tiempoInicio;
                int cantidad = response.statusCode();
                if (cantidad==200){
                    tamaño = response.body().length();
                }

            } catch (IOException e) {
                System.out.println("Error con el envio. "+e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Error con el envio . "+e.getMessage());;
            } catch (Exception e) {
                System.out.println("Error con el link. "+e);
            }
        }

        public long getVelocidad() {
            return v;
        }

        public long getTamaño() {
            return tamaño;
        }
    }
