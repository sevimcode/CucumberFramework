package step_definitions.wiki_pages_tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.wiki_pages.WikiPage;
import utilities.Driver;

public class Wiki_Page_Tests{

    WikiPage wikiPage = new WikiPage ();

    @Given("User is on Wikipedia homepage")
    public void user_is_on_Wikipedia_homepage() {
        Driver.getDriver ().get ("https://www.wikipedia.com");
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchQuery) {
       wikiPage.searchBox.sendKeys (searchQuery);


    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiPage.searchButton.click ();


    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String searchQuery) {
        String actualtitle = Driver.getDriver ().getTitle ();
        String expectedtitle = searchQuery + " - Wikipedia";
            Assert.assertTrue(actualtitle.equals (expectedtitle));
        }


    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String searchQuery) {

        Assert.assertTrue(wikiPage.header.getText ().equals (searchQuery));

    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String searchQuery) {
        Assert.assertTrue(wikiPage.imageHeader.getText ().contains(searchQuery));
    }





}
