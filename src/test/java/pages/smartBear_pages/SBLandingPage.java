package pages.smartBear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SBLandingPage{

    public  SBLandingPage(){
        PageFactory.initElements (Driver.getDriver (), this);
    }

    @FindBy(linkText = "Order")
    public WebElement orderLink;



}
