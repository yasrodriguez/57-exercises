package ex47peopleInSpace;

import java.io.IOException;

/**
 * Created by Yasmin on 9/6/2017
 */

public class JsonGetterMock implements JsonGetterInterface{
    @Override
    public String getJson() throws IOException {
        return "{\"message\": \"success\", \"people\": [{\"name\": \"Sergey Ryazanskiy\", \"craft\": \"ISS\"}, {\"name\": \"Randy Bresnik\", \"craft\": \"ISS\"}, {\"name\": \"Paolo Nespoli\", \"craft\": \"ISS\"}], \"number\": 3}";
    }
}
