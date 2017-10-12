package ex49flickrPhotoSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class FlickrFeedGetter implements PictureFeedGetter {
    public FlickrFeedGetter() {
    }

    public String getPictureFeed(String searchString) throws IOException {

        String apiUrlTemplate = String.format("https://api.flickr.com/services/feeds/photos_public.gne?tags=%s&format=json"
                , URLEncoder.encode(searchString, "UTF-8"));
        URL apiUrl = new URL(apiUrlTemplate);
        StringBuilder picData = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(apiUrl.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                picData.append(line);
            }
        }
        return picData.substring(15, picData.length() - 1);  //removes invalid characters from Json returned by API
    }
}