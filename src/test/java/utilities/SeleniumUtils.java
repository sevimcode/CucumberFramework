package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SeleniumUtils{

    public static List<String> getAllSelectOptions ( WebElement webElement ){

        Select select = new Select (webElement);
        List<String> options = new ArrayList<> ();

        for (WebElement eachOptions: select.getOptions ()){
           options.add (eachOptions.getText ());
        }
        return options;
    }



}
