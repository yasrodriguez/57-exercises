package ex50movieRecommendations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

/**
 * Take in a movie title and use the The Movie Database API https://www.themoviedb.org/documentation/api
 * to display the year, rating, running time, and synopsis. If the audience score is 75% or more recommend watching
 * the movie, otherwise recommend avoiding this movie.
 *
 * Created by Yasmin on 10/6/2017
 */

public class MovieSearch {

    public String parseMovieList(MovieDataGetter m, String search) throws IOException, ParseException {
        String movieData = m.getMovieList(search);
        StringBuilder results = new StringBuilder();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(movieData);

        long totalMovies = (long) json.get("total_results");
        results.append("Total Movies Found: " + totalMovies);
        results.append("\n");
        results.append("\n");

        JSONArray movies = (JSONArray) json.get("results");

        for(int i = 0; i < movies.size(); i++){
            JSONObject movie = (JSONObject) movies.get(i);
            long id = (long) movie.get("id");
            String title = (String) movie.get("title");
            String overview = (String) movie.get("overview");
            String releaseDate = (String) movie.get("release_date");

            results.append("ID: ");
            results.append(id);
            results.append("\n");
            results.append("Title: ");
            results.append(title);
            results.append("\n");
            results.append("Overview: ");
            results.append(overview);
            results.append("\n");
            results.append("Release Date ");
            results.append(releaseDate);
            results.append("\n");
            results.append("\n");
        }
        return results.toString();
    }
}
