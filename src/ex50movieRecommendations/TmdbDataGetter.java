package ex50movieRecommendations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Gets movie information from The Movie Database (TMDb).
 * Created by Yasmin on 10/6/2017
 */

public class TmdbDataGetter implements MovieDataGetter {
    String apiKey;

    public TmdbDataGetter(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Takes in a search string and returns in JSON format a list of all movies matching the search.
     * @param searchString Search terms
     * @return Movie list in JSON format
     * @throws IOException If an I/O error occurs
     */
    @Override
    public String getMovieList(String searchString) throws IOException {
        String searchUrl = String.format("http://api.themoviedb.org/3/search/movie?api_key=%s&query=%s", apiKey,
                URLEncoder.encode(searchString, "UTF-8"));
        URL url = new URL(searchUrl);

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.readLine();
        }
    }

    /**
     * Takes in a movie ID and returns in JSON format all the movie details.
     * @param id Movie ID in The Movie Database
     * @return Movie details in JSON format
     * @throws IOException If an I/O error occurs
     */
    @Override
    public  String getMovieDetails(String id) throws IOException {
        String searchUrl = String.format("http://api.themoviedb.org/3/movie/%s?api_key=%s", id, apiKey);
        URL url = new URL(searchUrl);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
            return reader.readLine();
        }
    }
}
