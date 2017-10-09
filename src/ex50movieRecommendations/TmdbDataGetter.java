package ex50movieRecommendations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Yasmin on 10/6/2017
 */

public class TmdbDataGetter implements MovieDataGetter {
    String apiKey;

    public TmdbDataGetter(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getMovieList(String searchString) throws IOException {
        String searchUrl = String.format("http://api.themoviedb.org/3/search/movie?api_key=%s&query=%s", apiKey,
                URLEncoder.encode(searchString, "UTF-8"));
        URL url = new URL(searchUrl);

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.readLine();
        }
    }

    @Override
    public  String getMovieDetails(String id) throws IOException {
        String searchUrl = String.format("http://api.themoviedb.org/3/movie/%s?api_key=%s", id, apiKey);
        URL url = new URL(searchUrl);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
            return reader.readLine();
        }
    }
}
