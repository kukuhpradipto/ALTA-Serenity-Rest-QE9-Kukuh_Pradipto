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

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUser {

    @Steps
    RegresAPI regresAPI;

    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterId(int id) {
        regresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(RegresAPI.GET_SINGLE_USER);
    }

    @Given("Get single without parameter")
    public void getSingleWithoutParameter() {
        regresAPI.getSingleUserWithoutParameter();
    }

    @When("Send request get single user without parameter")
    public void sendRequestGetSingleUserWithoutParameter() {
        SerenityRest.when().get(RegresAPI.GET_SINGLE_USER_WITHOUT_PARAMETER);
    }

    @Given("Get list user with number id parameter unregistered {int}")
    public void getListUserWithNumberIdParameterUnregisteredId(int id) {
        regresAPI.getSingleUser(id);
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidIdId( String id) {
        regresAPI.setGetSingletUsersInvalidId(id);
    }

    @When("Send request get single user invalid")
    public void sendRequestGetSingleUserInvalid() {
        SerenityRest.when().get(RegresAPI.GET_SINGLE_USER);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Response id should be {int}")
    public void responseIdShoulbeBeId(int id) {
        SerenityRest.then().body(RegresResponses.DATA_ID, equalTo(id));
    }

    @And("Validate get single user json schema")
    public void validateGetSingleUserJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/SingleUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate get single without parameter json schema")
    public void validateGetSingleWithoutParameterJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/SingleUserInvalidWithOutParameterJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate get single invalid id parameter json schema")
    public void validateGetSingleInvalidIdParameterJsonSchema() {
    File jsonSchema = new File(Constant.JSON_SCHEMA + "/SingleUserInvalidIDJSONSchema.json");
    SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate get single unregistered id parameter json schema")
    public void validateGetSingleUnregisteredIdParameterJsonSchema() {
    File jsonSchema = new File(Constant.JSON_SCHEMA + "/SingleUserInvalidIDJSONSchema.json");
    SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}

