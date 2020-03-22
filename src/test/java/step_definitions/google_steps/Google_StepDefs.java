package step_definitions.google_steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.google_pages.GoogleLandingPage;
import utilities.Driver;

public class Google_StepDefs{


   GoogleLandingPage googleLandingPage = new GoogleLandingPage();

    @When("User is on google homepage")
    public void user_is_on_google_homepage() {

        Driver.getDriver ().get ("https://www.google.com");
    }

    @Then("User should see title contains Google")
    public void user_should_see_title_contains_Google() {
       String actualTitle = Driver.getDriver ().getTitle ();
       String expectedTitle = "Google";

        Assert.assertTrue (actualTitle.contains (expectedTitle));

    }
    @When("User types wooden spoon into the search box")
    public void user_types_wooden_spoon_into_the_search_box() {

        googleLandingPage.searchBox.sendKeys ("wooden spoon");
    }

    @When("User clicks to search button")
    public void user_clicks_to_search_button() {
        googleLandingPage.searchButton.click ();

    }

    @Then("User should see wooden spoon in the title")
    public void user_should_see_wooden_spoon_in_the_title() {
    String actualtitle = Driver.getDriver ().getTitle ();
    String expectedtitle = "wooden spoon - Google Search";
    Assert.assertTrue ("title is not matching with the expected title",actualtitle.equals (expectedtitle));


    }



}
