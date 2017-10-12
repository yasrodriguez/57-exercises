package ex49flickrPhotoSearch;

import java.io.IOException;

public interface PictureFeedGetter {
    String getPictureFeed(String searchString) throws IOException;
}
