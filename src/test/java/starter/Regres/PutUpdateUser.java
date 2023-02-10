package starter.Regres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class PutUpdateUser {
    @Steps
    RegresAPI regresAPI;

        @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_SCHEMA + "/PostCreateValid.json");
        regresAPI.putUpdateUser(id, jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(RegresAPI.PUT_UPDATE_USER);
    }

}
