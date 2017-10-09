package ex50movieRecommendations;

import java.io.IOException;

public interface MovieDataGetter {

    String getMovieList(String searchWords) throws IOException;

    String getMovieDetails(String id) throws IOException;
}
