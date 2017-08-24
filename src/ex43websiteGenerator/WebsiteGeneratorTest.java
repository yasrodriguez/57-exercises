package ex43websiteGenerator;

import org.junit.Test;
import org.junit.Before;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.*;
import junitx.framework.FileAssert;

/**
 * Unit tests for Website Generator.
 */

public class WebsiteGeneratorTest {

    private String mainFolderPath = "C:\\example\\";
    private String websiteFolder = "BestPRCoffee";
    private String websiteName = "Best PR Coffee";
    private String author = "Jas Nice";

    @Test
    public void test_that_folders_are_created() throws Exception{
        //arrange

        WebsiteGenerator wg = new WebsiteGenerator(websiteName, author, mainFolderPath, true,true);
        Path expectedJsFolder = Paths.get("C:\\example\\BestPRCoffee\\javascript");
        Path expectedCssFolder = Paths.get("C:\\example\\BestPRCoffee\\css");

        //act
        wg.createFolders();

        //assert
        assertTrue(Files.exists(expectedJsFolder));
        assertTrue(Files.exists(expectedCssFolder));
    }

    @Test
    public void test_that_html_file_is_created() throws Exception{
        //arrange
        WebsiteGenerator wg = new WebsiteGenerator(websiteName, author, mainFolderPath, true,true);
        Path expectedHtmlFile = Paths.get("C:\\example\\BestPRCoffee\\index.html");
        wg.createFolders();

        //act
        wg.generateHTMLIndexFile();

        //assert
        assertTrue(Files.exists(expectedHtmlFile));
    }

    @Test
    public void test_that_html_file_is_correctly_populated() throws Exception{
        //arrange
        WebsiteGenerator wg = new WebsiteGenerator(websiteName, author, mainFolderPath, true,true);
        File expectedHtmlFile = new File("src/ex43websiteGenerator/expectedWebsite.txt");
        File actualHtmlFile = new File("C:/example/BestPRCoffee/index.html");
        wg.createFolders();

        //act
        wg.generateHTMLIndexFile();

        //assert
        FileAssert.assertEquals(expectedHtmlFile,actualHtmlFile);
    }

    @Before
    public void cleanup() throws Exception{
        Files.deleteIfExists(Paths.get(mainFolderPath).resolve(websiteFolder).resolve("javascript"));
        Files.deleteIfExists(Paths.get(mainFolderPath).resolve(websiteFolder).resolve("css"));
        Files.deleteIfExists(Paths.get(mainFolderPath).resolve(websiteFolder).resolve("index.html"));
        Files.deleteIfExists(Paths.get(mainFolderPath).resolve(websiteFolder));
        Files.deleteIfExists(Paths.get(mainFolderPath));
    }
}