package step_definitions.api_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import utilities.APIUtil;

public class TeacherDeleting_stepDefs{


    @Given("user deletes teacher at {string}")
    public void user_deletes_teacher_at(String resource) {
        APIUtil.hitDELETE (resource);
    }

    @Then("user gets teacher at {string}")
    public void user_gets_teacher_at(String resource) {
        APIUtil.hitGET (resource);
      //  Assert.fail ("on purpose"); if your scenario fails it will take screen shot

    }

    @Then("user verifies response message {string}")
    public void user_verifies_response_message(String message) {
        Assert.assertEquals ("Delete teacher failed" ,APIUtil.getResponseBody ().getMessage (),message);

    }





}
