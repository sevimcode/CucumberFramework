package pages.etsy_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EtsyHomePage{


    public EtsyHomePage(){


        PageFactory.initElements (Driver.getDriver (), this);

    }
    //1- locate the input box

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBox;

    @FindBy (xpath = "//button[@value = 'Search']")
    public WebElement searchButton;


}
