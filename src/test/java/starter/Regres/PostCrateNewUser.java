package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.Utils.RegresResponses;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;

public class PostCrateNewUser {
    @Steps
    RegresAPI regresAPI;

    // POST VALID USER
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY + "PostCreateValid.json");
        regresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(RegresAPI.POST_CREATE_USER);
    }
    @When("Send request post create user valid json")
    public void sendRequestPostCreateUserValidJson() {
        SerenityRest.when().post(RegresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body(RegresResponses.NAME,equalTo(name))
                .body(RegresResponses.JOB, equalTo(job));
    }


    // POST INVALID USER
    @Given("Create new user with invalid json")
    public void createNewUserWithInvalidJson() {
        File invalidReq = new File(Constant.JSON_REQ_BODY + "/PostCreateInvalid.json");
        regresAPI.postCreateUser(invalidReq);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }


    @Given("Create new user with name is blank")
    public void createNewUserWithNameIsBlank() {
        File nameBlankReq = new File(Constant.JSON_REQ_BODY +"/PostCreateNameBlank.json");
        regresAPI.postCreateUser(nameBlankReq);
    }

    @Given("Create new user with job is blank")
    public void createNewUserWithJobIsBlank() {
            File nameBlankReq = new File(Constant.JSON_REQ_BODY + "/PostCreateJobBlank.json");
            regresAPI.postCreateUser(nameBlankReq);
    }
}
