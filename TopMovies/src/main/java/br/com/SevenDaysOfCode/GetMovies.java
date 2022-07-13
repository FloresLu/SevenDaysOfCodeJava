package br.com.SevenDaysOfCode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetMovies {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// Faz a requisição HTTP e pega o resultado passando o corpo para string
		String api_key = "k_g021z74v";

		OkHttpClient client = new OkHttpClient().newBuilder().build();

		Request request = new Request.Builder().url("https://imdb-api.com/en/API/Top250Movies/" + api_key)
				.method("GET", null).build();

		Response response = client.newCall(request).execute();
		// Transforma a resposta do HTTP em um objeto JSON
		JSONObject json = new JSONObject(response.body().string());
		// Tira os objetos JSON de dentro do Array JSON.
		JSONArray items = json.getJSONArray("items");
		// Cria uma lista de filmes.
		List<Filme> filmes = new ArrayList<Filme>();
		// Um for que que converte cada elemento dentro do array em um objeto.
		for (int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);

			Filme filme = new Filme(item.getString("title"), item.getString("image"), item.getInt("year"),
					item.getDouble("imDbRating"));
			// Adiciona esse objeto a lista de array.
			filmes.add(filme);
		}

		HTMLGenerator paginaFilme = new HTMLGenerator(filmes, 99);
		paginaFilme.pw.write(paginaFilme.html);
		paginaFilme.pw.close();

	}

}
