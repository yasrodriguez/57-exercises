package ex49flickrPhotoSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Take in a search string and display photographs that match the search. Use Flickr's public photo feed as
 * your service: https://www.flickr.com/services/feeds/docs/photos_public/
 * Created by Yasmin on 9/13/2017
 */

public class FlickrPhotoSearch {

    public String getPictures(String searchString) throws IOException {
        URL apiUrl = new URL(String.format("https://api.flickr.com/services/feeds/photos_public.gne?tags=%s&format=json"
                , searchString));
        StringBuilder picData = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(apiUrl.openStream()))){
            String line;
            while((line = reader.readLine()) != null){
                picData.append(line);
            }
        }
        return picData.toString();
    }

    public void parse(String data){

    }

    public void displayPics(){

    }
}