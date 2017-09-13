package ex49flickrPhotoSearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlickrPhotoSearchTest {
    @Test
    public void IntegrationTest_getPictures_ValidUrl_ReturnsPictureData() throws Exception {
        FlickrPhotoSearch fphoto = new FlickrPhotoSearch();
        String pictureData = fphoto.getPictures("dogs");
        System.out.println(pictureData);
    }

}