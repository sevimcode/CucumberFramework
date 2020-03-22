package pages.smartBear_pages;
//Compare titles at "https://dzone.com/articles/gradle-vs-maven"
//        and "https://dzone.com/articles/api-security-weekly-issue-71"

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page1{


 public  Page1(){
            PageFactory.initElements (Driver.getDriver (), this);
        }

     @FindBy (className =  "article-title")
   public  WebElement header1;


    }


