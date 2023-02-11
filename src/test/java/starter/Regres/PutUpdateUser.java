package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class PutUpdateUser {
    @Steps
    RegresAPI regresAPI;

        @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY + "/PutUpdateDataUser.json");
        regresAPI.putUpdateUser(id, jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(RegresAPI.PUT_UPDATE_USER);
    }

    @And("Validate put json schema valid parameter")
    public void validatePutJsonSchemaValidParameter() {
          File jsonSchema = new File(Constant.JSON_SCHEMA + "/PutUpdateValidParameterJSONSchema.json");
          SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Update user with invalid parameter id {string}")
    public void updateUserWithInvalidParameterId(String id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY + "/PutUpdateDataUser.json");
        regresAPI.putUpdateInvalidid(id, jsonReq);
    }

    @When("Send reques invalid paremeter id")
    public void sendRequesInvalidParemeterId() {
            SerenityRest.when().put(RegresAPI.PUT_UPDATE_INVALIDID);
    }

    @Given("Put update user without parameter")
    public void putUpdateUserWithoutParameter() {
        regresAPI.setPutWithoutParameter();
    }

    @When("Send request without parameter")
    public void sendRequestWithoutParameter() {
            SerenityRest.when().put(RegresAPI.PUT_WITHOUT_PARAMETER);
    }

}
