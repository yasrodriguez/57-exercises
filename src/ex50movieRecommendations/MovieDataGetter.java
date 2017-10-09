package ex50movieRecommendations;

import java.io.IOException;

/**
 * Interface for the movie data.
 */
public interface MovieDataGetter {

    String getMovieList(String searchWords) throws IOException;

    String getMovieDetails(String id) throws IOException;
}
