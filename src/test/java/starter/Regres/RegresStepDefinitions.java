package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegresStepDefinitions {
    @Steps
    RegresAPI regresAPI;

    // FIRST SCENARIO
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        regresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(RegresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }


    // SECOND SCENARIO
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(RegresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        regresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(RegresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }


    //THIRD SCHEMA
    @Given("Get single user with valid parameter id {int}")
    public void getSignleUserWithValidParameterId(int id) {
    regresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(RegresAPI.GET_SINGLE_USER);
    }


    // UPDATE SCHEMA
    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(RegresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        regresAPI.putUpdateUser(id, jsonReq);
    }


    //DELETE SCHEMA
    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(RegresAPI.PUT_UPDATE_USER);
    }

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        regresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(RegresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
