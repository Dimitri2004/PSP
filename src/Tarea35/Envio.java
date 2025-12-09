package Tarea35;


import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class Envio {
    public static void main(String[] args){
        Gson gson=new Gson();
        try (HttpClient cliente = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();
        ){
            HttpRequest request=HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coinlore.net/api/tickers/?start=100&limit=100"))
                    .GET().build();

            HttpResponse<String> respuesta = cliente.send(request, BodyHandlers.ofString());
            String jsonString = respuesta.body();

            JsonObject jsonObject= JsonParser.parseString(jsonString).getAsJsonObject();
            JsonArray monedasArray = jsonObject.getAsJsonArray("data");

            Type listType = new TypeToken<List<Moneda>>(){}.getType();
            List<Moneda> monedas = gson.fromJson(monedasArray, listType);

// BUSCAR POR NOMBRE O SYMBOL
            System.out.println("Dime la bitcoin a buscar: ");// <-- aquí colocas el nombre o símbolo
            Scanner sc=new Scanner(System.in);
            String buscado=sc.nextLine();
            Moneda encontrada = monedas.stream()
                    .filter(m -> m.name.equalsIgnoreCase(buscado)
                            || m.symbol.equalsIgnoreCase(buscado))
                    .findFirst()
                    .orElse(null);

            if (encontrada != null) {
                System.out.println(
                        " Nombre: " + encontrada.name +
                        " Symbolo: " + encontrada.symbol +
                        " Precio_USD: " + encontrada.price_usd +
                        " Ranking: " + encontrada.rank +
                        " Variacion 24h: " + encontrada.percent_change_24h
                        );
            } else {
                System.out.println("Moneda no encontrada.");
            }

        } catch (Exception e) {
            System.out.println("Error desconocido : "+e.getMessage());
        }
    }
}
