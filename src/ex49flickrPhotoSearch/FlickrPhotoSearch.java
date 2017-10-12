package ex49flickrPhotoSearch;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import static java.nio.file.Files.newBufferedWriter;

/**
 * Take in a search string and display photographs that match the search. Use Flickr's public photo feed as
 * your service: https://www.flickr.com/services/feeds/docs/photos_public/
 * Created by Yasmin on 9/13/2017
 */

public class FlickrPhotoSearch {

    ArrayList<URL> links = new ArrayList<>();

    public int getNumberOfLinks() {
        return links.size();
    }

    public void search(String searchString, PictureFeedGetter p) throws IOException, ParseException{
        if(searchString == null){
            throw new IllegalArgumentException("Search string can't be null.");
        }
        if(p == null){
            throw new IllegalArgumentException("Picture feed can't be null.");
        }

        String pictureData = p.getPictureFeed(searchString);
        parse(pictureData);
        String imagesHtml = generateHtmlForImages();
        display(searchString, imagesHtml);
    }

      private void parse(String data) throws ParseException, IOException{
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(data);
        JSONArray pics = (JSONArray) json.get("items");
        ArrayList<URL> links = new ArrayList<>();

        Iterator i = pics.iterator();
        while(i.hasNext()){
            JSONObject pic = (JSONObject) i.next();
            JSONObject media = (JSONObject) pic.get("media");
            String link = (String) media.get("m");
            links.add(new URL(link));
        }
        this.links = links;
    }

    private void display(String searchString, String imagesHtml)throws IOException {
        try (BufferedWriter writer = newBufferedWriter(Paths.get("src\\ex49flickrPhotoSearch\\index.html"), Charset.forName("UTF-8"), StandardOpenOption.CREATE)) {
            String htmlTemplate =
                    "<!doctype html>\n" +
                            "\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "  <meta charset=\"utf-8\">\n" +
                            "  <title>" + "Flickr Pictures" + "</title>\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "   <p>Search results for " + searchString + "</p>\n" +
                            "<div>\n" +
                            imagesHtml +
                            "</div>\n" +
                            "</body>\n" +
                            "</html>";
            writer.write(htmlTemplate);
        }
    }

    private String generateHtmlForImages(){
        StringBuilder imagesHtml = new StringBuilder();
        for(URL link: links) {
            String line = String.format("<img src=\"%s\">\n", link);
            imagesHtml.append(line);
        }
        return imagesHtml.toString();
    }
}