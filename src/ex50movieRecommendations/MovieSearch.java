package ex50movieRecommendations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;

/**
 * Take in a movie title and use the The Movie Database API https://www.themoviedb.org/documentation/api
 * to display movie details like the year, rating, running time, and synopsis. If the audience score is 7.5 or more
 * recommend watching the movie, otherwise recommend avoiding this movie.
 *
 * Created by Yasmin on 10/6/2017
 */

public class MovieSearch {

    /**
     * Parses movie data (in JSON) for all the movies matching the user search and displays selected values to the user
     * in a nice format.
     *
     * @param m List of movies returned by the search, in JSON format
     * @param searchTerms Search terms
     * @return List of movies that match the user search
     * @throws IOException If an I/O error occurs
     * @throws ParseException If a JSON parsing error occurs
     */
    public String parseMovieList(MovieDataGetter m, String searchTerms) throws IOException, ParseException {
        if (m == null) {
            throw new IllegalArgumentException("You can't have null movie data.");
        }

        if (searchTerms == null || searchTerms.isEmpty()){
            throw new IllegalArgumentException("You can't have null or empty search criteria.");
        }


        String movieData = m.getMovieList(searchTerms);
        StringBuilder results = new StringBuilder();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(movieData);

        long totalMovies = (long) json.get("total_results");
        results.append("Total Movies Found: ");
        results.append(totalMovies);
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
            results.append("Release Date: ");
            results.append(releaseDate);
            results.append("\n");
            results.append("\n");
        }
        return results.toString();
    }

    /**
     * Parses movie details (in JSON format) for the movie ID provided by the user and displays selected values to the
     * user in a nice format.
     *
     * @param m Movie details returned by the search, in JSON format
     * @param id Movie ID
     * @return Details for the movie that match the movie ID
     * @throws IOException If an I/O error occurs
     * @throws ParseException If a JSON parsing error occurs
     */
    public String parseMovieDetails(MovieDataGetter m, String id) throws IOException, ParseException {
        if (m == null) {
            throw new IllegalArgumentException("You can't have null movie data.");
        }

        if (id == null || id.isEmpty()){
            throw new IllegalArgumentException("You can't have null or empty movie ID.");
        }

        String movieData = m.getMovieDetails(id);
        StringBuilder results = new StringBuilder();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(movieData);

        String title = (String) json.get("original_title");
        String overview = (String) json.get("overview");
        String releaseDate = (String) json.get("release_date");

        long runtime = (long) json.get("runtime");
        String formattedRunTime = formatTime(runtime);

        double popularity = (double) json.get("popularity");
        double voteAverage = (double) json.get("vote_average");
        long voteCount = (long) json.get("vote_count");

        JSONArray genres = (JSONArray) json.get("genres");
        StringBuilder genreNames = new StringBuilder();
        for (int i = 0; i < genres.size(); i++){
            JSONObject genre = (JSONObject) genres.get(i);
            String genreName = (String) genre.get("name");
            if( i > 0) {
                genreNames.append(", ");
            }
            genreNames.append(genreName);
        }

        String recommendation = getRecommendation(voteAverage);

        results.append("Title: ");
        results.append(title);
        results.append("\n");
        results.append("Overview: ");
        results.append(overview);
        results.append("\n");
        results.append("Release Date: ");
        results.append(releaseDate);
        results.append("\n");
        results.append("Runtime: ");
        results.append(formattedRunTime);
        results.append("\n");
        results.append("Genre: ");
        results.append(genreNames);
        results.append("\n");
        results.append("Popularity: ");
        results.append(popularity);
        results.append("\n");
        results.append("Vote Average: ");
        results.append(voteAverage);
        results.append("\n");
        results.append("Vote Count: ");
        results.append(voteCount);
        results.append("\n");
        results.append("Recommendation: ");
        results.append(recommendation);
        results.append("\n");
        results.append("\n");

        return results.toString();
    }

    /**
     * Takes the movie vote average and recommends to watch or not watch the movie.
     *
     * @param voteAverage the movie's vote average
     * @return recommendation
     */
    private String getRecommendation(double voteAverage) {
        final double MINIMUM_GOOD_RATING = 7.5;
        final double EPSILON = .0001;

        if (voteAverage >= MINIMUM_GOOD_RATING - EPSILON) {
            return "Watch this movie!";
        }
        else {
            return "Don't watch this movie!";
        }
    }

    /**
     * Takes the movie run time and converts it from minutes to hours and minutes.
     * @param runtime total runtime in minutes
     * @return runtime in hours and minutes
     */
    private String formatTime(long runtime) {
        int hours = (int) runtime / 60;
        int minutes = (int) runtime % 60;

        return hours + "h " + minutes + " mins";
    }
}
