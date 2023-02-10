package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class GetRecource {
    @Steps
    RegresAPI regresAPI;


    @Given("Get list users with valid parameter unknown")
    public void getListUsersWithValidParameterPage() {
        regresAPI.getRecource();
    }

    @When("Send request get list unknown")
    public void sendRequestGetListUnknow() {
        SerenityRest.when().get(RegresAPI.GET_RECOURCE);
    }

    @And("Validate get list resource json schema")
    public void validateGetListRecourceJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListRecourceJSONSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
