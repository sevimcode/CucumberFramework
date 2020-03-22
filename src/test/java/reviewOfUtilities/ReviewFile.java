package reviewOfUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReviewFile{

    public static void main( String[] args ) throws IOException {
        // this code can read the information from review.properties file
        Properties properties = new Properties ();
        FileInputStream file = new FileInputStream ("review.properties");
        properties.load (file); //all data copied to the properties object here
        String s = properties.getProperty ("day"); // getting property from review. properties file
        System.out.println (s);

        // automating google search and takes the title gets the data from review.properties
        WebDriverManager.chromedriver ().setup ();
        WebDriver driver = new ChromeDriver ();
        driver.get ("http://www.google.com");
        driver.findElement (By.name ("q")).sendKeys (properties.getProperty ("searchitem"));
        String title = driver.getTitle ();
        System.out.println (title);
        driver.quit ();

    }
}
