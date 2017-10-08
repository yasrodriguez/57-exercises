package ex50movieRecommendations;

import java.io.IOException;

public interface MovieDataGetter {

    String getMovieList(String title) throws IOException;
}
