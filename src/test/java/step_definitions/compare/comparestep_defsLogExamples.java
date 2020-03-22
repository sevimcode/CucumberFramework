package step_definitions.compare;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.smartBear_pages.Page1;
import pages.smartBear_pages.Page2;
import utilities.Driver;
import utilities.Log;
import utilities.TemporaryStorage;

public class comparestep_defsLogExamples{

    Page1 page1 = new Page1 ();
    Page2 page2 = new Page2 ();


    @When("User is on {string}")
    public void userIsOn( String url1 ) {
        Driver.getDriver ().get (url1);
        Log.info ("user go to " + url1);
    }

    @And("User on {string}")
    public void userOn( String url2 )
    {
        Driver.getDriver ().get (url2);
        Log.info ("user go to " + url2);
    }

    @Then("Compare")
    public void compare() {
        System.out.println (page1.header1.getText ()); // page 1 loosing it is point get second title
        System.out.println (page2.header2.getText ()); //output should be not equal but prints
//        API Security Weekly: Issue #71
//        API Security Weekly: Issue #71
//        equals
// that's why you can not compare them without temporary data   Temporary map method helps

        Driver.getDriver ().get ("https://dzone.com/articles/gradle-vs-maven");
        String s1= page1.header1.getText ();
        Log.info ("header 1 is taken " +  s1);

        Driver.getDriver ().get ("https://dzone.com/articles/api-security-weekly-issue-71");
        String s2 =page2.header2.getText ();
        Log.info ("header 2 is taken " +  s2);
        if (s1.equals (s2)){
            System.out.println ("equals");
        }else{
            System.out.println ("not equal!");
        }
    }

    @And("User get the header")
    public void userGetTheHeader() {
        String s1 = Driver.getDriver ().findElement (By.xpath ("//h1")).getText ();
        TemporaryStorage.addData ("test", s1);


    }

    @And("User get the header of other page")
    public void userGetTheHeaderOfOtherPage() {
        String s2 = Driver.getDriver ().findElement (By.xpath ("//h1")).getText ();
        TemporaryStorage.addData ("test2", s2);


    }

    @Then("Compare with tempstroge")
    public void compareWithTempstroge() {
        Assert.assertEquals (TemporaryStorage.getData ("test"), TemporaryStorage.getData("test2"));
     // temporary storage is a util method it is storing data temporarily in Map it clears data in hooks
        Log.info ("Heders compared " );
    }
}
