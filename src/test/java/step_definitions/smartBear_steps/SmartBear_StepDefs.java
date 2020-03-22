package step_definitions.smartBear_steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.smartBear_pages.SmartBearHomePage;
import utilities.Config;
import utilities.Driver;

public class SmartBear_StepDefs{

    SmartBearHomePage smartBearHomePage = new SmartBearHomePage ();

    @When("User is on Smart Bear homepage")
    public void userIsOnSmartBearHomepage() {

        Driver.getDriver ().get ("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");


    }

    @And("User input username in username box")
    public void userInputUsernameInUsernameBox() {

        smartBearHomePage.username.sendKeys (Config.getProperty ("Username"));
    }

    @And("User input password in password box")
    public void userInputPasswordInPasswordBox() {
        smartBearHomePage.password.sendKeys (Config.getProperty ("Password"));

    }
    @And("User should be click login button")
    public void userShouldBeClickLoginButton() {

        smartBearHomePage.loginButton.click ();
    }

    @Then("User should be able to login")
    public void userShouldBeAbleToLogin() {


        Assert.assertEquals (Driver.getDriver ().getTitle (),"Web Orders Login");
    }


    @And("User input wrong password in password box")
    public void userInputWrongPasswordInPasswordBox() {
        smartBearHomePage.password.sendKeys (Config.getProperty ("WrongPassword"));

    }

    @Then("User should be able to see message")
    public void userShouldBeAbleToSeeMessage() {
        Assert.assertTrue ("jff",smartBearHomePage.message.isDisplayed());


    }



}
