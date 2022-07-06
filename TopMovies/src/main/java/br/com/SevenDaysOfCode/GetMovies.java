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

		String api_key = "";

		OkHttpClient client = new OkHttpClient().newBuilder().build();

		Request request = new Request.Builder().url("https://imdb-api.com/en/API/Top250Movies/" + api_key)
				.method("GET", null).build();

		Response response = client.newCall(request).execute();

		JSONObject json = new JSONObject(response.body().string());

		JSONArray items = json.getJSONArray("items");

		List<Filme> filmes = new ArrayList<Filme>();

		for (int i = 0; i < items.length(); i++) {
			JSONObject item = items.getJSONObject(i);

			Filme filme = new Filme(item.getString("title"), item.getString("image"), item.getInt("year"),
					item.getDouble("imDbRating"));

			filmes.add(filme);
		}

		System.out.println(filmes.get(1).titulo());
	}

}
