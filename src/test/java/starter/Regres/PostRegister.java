package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

import static org.hamcrest.core.IsEqual.equalTo;


public class PostRegister {
    @Steps
    RegresAPI regresAPI;

    @Given("Post register with valid json")
    public void postRegisterWithValidJson() {
        File jsonRegister = new File(Constant.JSON_REQ_BODY+"/PostRegisterSuccessful.json");
        regresAPI.postRegister(jsonRegister);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(RegresAPI.POST_REGISTER);
    }

    @And("Response body id is should {int} and token is {string}")
    public void responseBodyIsIdShouldAndTokenIs(int id, String token) {
        SerenityRest.then()
                .body("id", equalTo(id))
                .body("token", equalTo(token));
    }

    @And("Validate post register successful json schema")
    public void validatePostRegisterSuccessfulJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA +"/RegisterSuccessfulJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

 // NEGATIVE CASE
 @Given("Post register without valid password")
 public void postRegisterWithoutValidPassword() {
     File jsonRegister = new File(Constant.JSON_REQ_BODY+"/PostRegistrasiWithoutPassword.json");
     regresAPI.postRegister(jsonRegister);
 }

    @When("Send request post register invalid without password")
    public void sendRequestPostRegisterInvalid() {
        SerenityRest.when().post(RegresAPI.POST_REGISTER_INVALID);
    }


    @And("Response body should show message {string}")
    public void responeBodyShouldShowMessage(String error) {
        SerenityRest.then().body("error", equalTo(error));
    }

    @Given("Post register without valid email")
    public void postRegisterWithoutValidEmail() {
        File jsonRegister = new File(Constant.JSON_REQ_BODY+"/PostRegistrasiWithoutPassword.json");
        regresAPI.postRegister(jsonRegister);
    }

    @When("Send request post register invalid without email")
    public void sendRequestPostRegisterInvalidWithoutEmail() {
        SerenityRest.when().post(RegresAPI.POST_REGISTER_INVALID);
    }

    @And("Validate post register invalid json schema")
    public void validatePostRegisterInvalidJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA +"/RegisterErrorJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @Given("Post register without parameter")
    public void postRegisterWithoutParameter() {
        File jsonRegister = new File(Constant.JSON_REQ_BODY+"/PostRegistrasiWithoutPassword.json");
        regresAPI.postRegister(jsonRegister);
    }


    @When("Send request post register without parameter")
    public void sendRequestPostRegisterWithoutParameter() {
        SerenityRest.when().post(RegresAPI.POST_REGISTER_INVALID);
    }
}


