import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterMoeda {

    public MostraMoeda conversao(String moedaBase) {
        String apiKey = "e4656d0a92604b8389b8bef1";
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+ apiKey + "/latest/" + moedaBase);

        //HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //conversao
            return new Gson().fromJson(response.body(), MostraMoeda.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao acessar a API: " + e);
        }
    }

}
