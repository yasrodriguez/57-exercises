package ex47peopleInSpace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonGetter implements JsonGetterInterface {

    public String getJson() throws IOException {
        URL openNotifyApi = new URL("http://api.open-notify.org/astros.json");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(openNotifyApi.openStream()))) {
            return reader.readLine();
        }

    }
}