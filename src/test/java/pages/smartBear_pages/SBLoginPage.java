package pages.smartBear_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SBLoginPage{


    public SBLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_username\"]")
    public WebElement username;
    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_password\"]")
    public  WebElement password;
    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_login_button\"]")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[1]")
    public WebElement welcomingText;
    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_status\"]")
    public WebElement errorMessage;
}





