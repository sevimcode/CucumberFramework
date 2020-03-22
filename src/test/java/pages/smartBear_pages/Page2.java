package pages.smartBear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page2{


    public  Page2(){
        PageFactory.initElements (Driver.getDriver (), this);
    }


    @FindBy(className =  "article-title")
    public WebElement header2;




}
