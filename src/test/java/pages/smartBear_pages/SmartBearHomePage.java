package pages.smartBear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SmartBearHomePage{

    public SmartBearHomePage(){


        PageFactory.initElements (Driver.getDriver (), this);

    }
    //1- locate the input box

    @FindBy(name = "ctl00$MainContent$username")
    public WebElement username;

    @FindBy (name = "ctl00$MainContent$password")
    public WebElement password;

    @FindBy (name = "ctl00$MainContent$login_button")
    public WebElement loginButton;


    @FindBy (id = "ctl00_MainContent_status")
    public WebElement message;



}
