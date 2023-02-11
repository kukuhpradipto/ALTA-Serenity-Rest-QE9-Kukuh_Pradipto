package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.Utils.RegresResponses;
import java.io.File;
import static org.hamcrest.Matchers.equalTo; // import manual untuk equalto

public class GetListUser {
    @Steps
    RegresAPI regresAPI;

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
        SerenityRest.then().body(RegresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListUserJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response id should be page {int}")
    public void responseIdShouldBePage(int page) {
        SerenityRest.then().body(RegresResponses.PAGE,equalTo(page));
    }

    @Given("Get list users without parameter page")
    public void getListUsersWithoutParameterPage() {
        regresAPI.getRecource();
    }

    @When("Send request get list with out parameter page")
    public void sendRequestGetListWithOutParameterPage() {
        SerenityRest.when().get(RegresAPI.GET_RECOURCE);
    }

    @And("Validate get list without  json schema")
    public void validateGetListJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListRecourceJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list users with invalid parameter page {string}")
    public void getListUserUsersWithInvalidParameterPage(String page) {
        regresAPI.getListUsersInvalidPage(page);
    }

    @When("Send request with invalid parameter page")
    public void sendRequestWithInvalidParameterPage() {
        SerenityRest.when().get(RegresAPI.GET_LIST_USERS_INVALIDPAGE);
    }
}
