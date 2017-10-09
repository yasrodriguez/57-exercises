package ex50movieRecommendations;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class MovieSearchTest {

    String apiKey;

    @Before
    public void initialize() throws IOException{
        Path file = Paths.get("C:\\Users\\Yasmin\\Documents\\api_keys\\TMDb.txt");
        apiKey =  Files.readAllLines(file).get(0).toString();
    }



    @Test
    public void parseMovieList_validMovieData_ReturnsParsedMovieList() throws Exception{
        //arrange
        MovieSearch ms = new MovieSearch();
        String search = "Jack Reacher";
        String expectedResults =
                "Total Movies Found: 2\n" +
                        "\n" +
                        "ID: 75780\n" +
                        "Title: Jack Reacher\n" +
                        "Overview: In an innocent heartland city, five are shot dead by an expert sniper. The police quickly identify and arrest the culprit, and build a slam-dunk case. But the accused man claims he's innocent and says \"Get Jack Reacher.\" Reacher himself sees the news report and turns up in the city. The defense is immensely relieved, but Reacher has come to bury the guy. Shocked at the accused's request, Reacher sets out to confirm for himself the absolute certainty of the man's guilt, but comes up with more than he bargained for.\n" +
                        "Release Date: 2012-12-20\n" +
                        "\n" +
                        "ID: 343611\n" +
                        "Title: Jack Reacher: Never Go Back\n" +
                        "Overview: Jack Reacher must uncover the truth behind a major government conspiracy in order to clear his name. On the run as a fugitive from the law, Reacher uncovers a potential secret from his past that could change his life forever.\n" +
                        "Release Date: 2016-10-19\n" +
                         "\n";

        MovieDataGetter movieDataMock = Mockito.mock(MovieDataGetter.class);
        Mockito.when(movieDataMock.getMovieList(search)).thenReturn("{\"page\":1,\"total_results\":2,\"total_pages\":1,\"results\":[{\"vote_count\":3028,\"id\":75780,\"video\":false,\"vote_average\":6.3,\"title\":\"Jack Reacher\",\"popularity\":33.424269,\"poster_path\":\"\\/38bmEXmuJuInLs9dwfgOGCHmZ7l.jpg\",\"original_language\":\"en\",\"original_title\":\"Jack Reacher\",\"genre_ids\":[80,18,53],\"backdrop_path\":\"\\/ezXodpP429qK0Av89pVNlaXWJkQ.jpg\",\"adult\":false,\"overview\":\"In an innocent heartland city, five are shot dead by an expert sniper. The police quickly identify and arrest the culprit, and build a slam-dunk case. But the accused man claims he's innocent and says \\\"Get Jack Reacher.\\\" Reacher himself sees the news report and turns up in the city. The defense is immensely relieved, but Reacher has come to bury the guy. Shocked at the accused's request, Reacher sets out to confirm for himself the absolute certainty of the man's guilt, but comes up with more than he bargained for.\",\"release_date\":\"2012-12-20\"},{\"vote_count\":1836,\"id\":343611,\"video\":false,\"vote_average\":5.3,\"title\":\"Jack Reacher: Never Go Back\",\"popularity\":32.589739,\"poster_path\":\"\\/IfB9hy4JH1eH6HEfIgIGORXi5h.jpg\",\"original_language\":\"en\",\"original_title\":\"Jack Reacher: Never Go Back\",\"genre_ids\":[28],\"backdrop_path\":\"\\/nDS8rddEK74HfAwCC5CoT6Cwzlt.jpg\",\"adult\":false,\"overview\":\"Jack Reacher must uncover the truth behind a major government conspiracy in order to clear his name. On the run as a fugitive from the law, Reacher uncovers a potential secret from his past that could change his life forever.\",\"release_date\":\"2016-10-19\"}]}");

        //act
        String actualResults = ms.parseMovieList(movieDataMock,search);

        //assert
        System.out.println(actualResults); //TOFIX
        assertEquals(expectedResults, actualResults);

    }

    @Test
    public void parseMovieDetail_validMovieDetails_ReturnsParsedMovieDetails() throws Exception {
        //arrange
        MovieSearch ms = new MovieSearch();
        String id = "343611";
        MovieDataGetter movieDetailsMock = Mockito.mock(MovieDataGetter.class);
        Mockito.when(movieDetailsMock.getMovieDetails(id)).thenReturn("{\"adult\":false,\"backdrop_path\":\"/nDS8rddEK74HfAwCC5CoT6Cwzlt.jpg\",\"belongs_to_collection\":{\"id\":403374,\"name\":\"Jack Reacher Collection\",\"poster_path\":\"/7baSUtFKi8PQ9SLo6ECYBfAW2K8.jpg\",\"backdrop_path\":\"/3FHrAeYMogXd6K1e5tUzQAiS7GE.jpg\"},\"budget\":60000000,\"genres\":[{\"id\":28,\"name\":\"Action\"}],\"homepage\":\"http://www.jackreachermovie.com/\",\"id\":343611,\"imdb_id\":\"tt3393786\",\"original_language\":\"en\",\"original_title\":\"Jack Reacher: Never Go Back\",\"overview\":\"Jack Reacher must uncover the truth behind a major government conspiracy in order to clear his name. On the run as a fugitive from the law, Reacher uncovers a potential secret from his past that could change his life forever.\",\"popularity\":31.589739,\"poster_path\":\"/IfB9hy4JH1eH6HEfIgIGORXi5h.jpg\",\"production_companies\":[{\"name\":\"Paramount Pictures\",\"id\":4},{\"name\":\"Shanghai Film Group\",\"id\":3407},{\"name\":\"TC Productions\",\"id\":21777},{\"name\":\"Skydance Media\",\"id\":82819},{\"name\":\"Huahua Media\",\"id\":83645}],\"production_countries\":[{\"iso_3166_1\":\"CN\",\"name\":\"China\"},{\"iso_3166_1\":\"US\",\"name\":\"United States of America\"}],\"release_date\":\"2016-10-19\",\"revenue\":162146076,\"runtime\":118,\"spoken_languages\":[{\"iso_639_1\":\"en\",\"name\":\"English\"}],\"status\":\"Released\",\"tagline\":\"Justice is Coming.\",\"title\":\"Jack Reacher: Never Go Back\",\"video\":false,\"vote_average\":5.3,\"vote_count\":1837}");
        String expectedResults = "Title: Jack Reacher: Never Go Back\n" +
                "Overview: Jack Reacher must uncover the truth behind a major government conspiracy in order to clear his name. On the run as a fugitive from the law, Reacher uncovers a potential secret from his past that could change his life forever.\n" +
                "Release Date: 2016-10-19\n" +
                "Runtime: 1h 58 mins\n" +
                "Genre: Action\n" +
                "Popularity: 31.589739\n" +
                "Vote Average: 5.3\n" +
                "Vote Count: 1837\n" +
                "Recommendation: Don't watch this movie!\n" +
                "\n";

        //act
        String actualResults = ms.parseMovieDetails(movieDetailsMock, id);

        //assert
        assertEquals(expectedResults, actualResults);
    }

//        @Test
//    public void IntegrationTest_getMovieList_validMovieName_ReturnsMovieList() throws Exception {
//        //arrange
//        TmdbDataGetter tmdb = new TmdbDataGetter(apiKey);
//        String search = "Terminator";
//
//
//        //act
//        String results = tmdb.getMovieList(search);
//        System.out.println(results);
//
//    }
//
//    @Test
//    public void IntegrationTest_getMovieDetails_validMovieId_ReturnsMovieDetails() throws Exception {
//        //arrange
//        TmdbDataGetter tmdb = new TmdbDataGetter(apiKey);
//        String id = "87101";
//
//        //act
//        String results = tmdb.getMovieDetails(id);
//        System.out.println(results);
//    }

}