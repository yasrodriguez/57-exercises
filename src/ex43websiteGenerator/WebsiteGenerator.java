package ex43websiteGenerator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.newBufferedWriter;

/**
 * Prompt for the name of the site, author, and whether they want a folder for JavaScript files and a folder for CSS
 * files. Generate an index.html file that contains the name of the site inside the <title> tag and the author in a
 * <meta> tag.
 * Reference for website template: https://www.sitepoint.com/a-basic-html5-template/
 * Created by Yasmin on 8/23/2017
 */

public class WebsiteGenerator {

    private String siteName;
    private String author;
    private boolean createJavascriptFolder;
    private boolean createCssFolder;
    private Path mainFolder;


    public WebsiteGenerator(String siteName, String author, String pathName, boolean javascriptFolder, boolean cssFolder){
        this.siteName = siteName;
        this.author = author;
        this.mainFolder = Paths.get(pathName +  "\\" + siteName.replace(" ", ""));
        this.createJavascriptFolder = javascriptFolder;
        this.createCssFolder = cssFolder;
    }

    public void createFolders() throws IOException{

        if(!Files.exists(mainFolder)){
            Files.createDirectories(mainFolder);
        }

        Path jsFolder = mainFolder.resolve("javascript");

        if (createJavascriptFolder && !Files.exists(jsFolder)){
            Files.createDirectories(jsFolder);
            }

        Path cssFolder = mainFolder.resolve("css");

        if(createCssFolder && !Files.exists(cssFolder)){
            Files.createDirectories(cssFolder);

    }
}

    public void generateHTMLIndexFile() throws IOException{
        try(BufferedWriter writer = newBufferedWriter(mainFolder.resolve("index.html"), Charset.forName("US-ASCII"),
                StandardOpenOption.CREATE)){

            String htmlTemplate =
                    "<!doctype html>\n" +
                            "\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "  <meta charset=\"utf-8\">\n" +
                            "  <title>" + siteName + "</title>\n" +
                            "  <meta name=\"" + author + "\">\n" +
                            "</head>\n" +
                            "<body>\n" +
                            "   <p>This is an auto-generated website!</p>\n" +
                            "</body>\n" +
                            "</html>";
            writer.write(htmlTemplate);
        }
    }
}
