package pages.wiki_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WikiPage{

    public WikiPage() {

        PageFactory.initElements (Driver.getDriver () , this);
    }

    @FindBy (id= "searchInput")
    public WebElement searchBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy ( xpath = "//h1")
    public WebElement header;

    @FindBy( css = "div.fn")
    public WebElement imageHeader;






}
