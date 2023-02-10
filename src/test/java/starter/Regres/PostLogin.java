package starter.Regres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import static org.hamcrest.core.IsEqual.equalTo;
import java.io.File;

public class PostLogin {
    @Steps
    RegresAPI regresAPI;

    @Given("Post login with valid json")
    public void postLoginWithValidJson() {
        File jsonLogin = new File(Constant.JSON_REQ_BODY + "/PostLogin.json");
        regresAPI.postLogin(jsonLogin);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(RegresAPI.POST_LOGIN);

    }

    @And("Response body token is {string}")
    public void responseBodyTokenIs(String token) {
        SerenityRest.then().body("token", equalTo(token));
    }

    @And("Validate post login successful json schema")
    public void validatePostLoginSuccessfulJsonSchema() {
        File jsonLoginSchema = new File(Constant.JSON_SCHEMA + "/LoginSuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonLoginSchema));
    }


    @Given("Post login without email")
    public void postLoginWithoutEmail() {
        File jsonLoginInvalid = new File(Constant.JSON_REQ_BODY + "/PostLoginWithoutEmail.json");
        regresAPI.postLoginInvalid(jsonLoginInvalid);
    }

    @When("Send request invalid json")
    public void sendRequestInvalidJson() {
        SerenityRest.when().post(RegresAPI.POST_LOGIN_INVALID);
    }

    @Given("Post login without password")
    public void postLoginWithoutPassword() {
        File jsonLoginInvalid = new File(Constant.JSON_REQ_BODY + "/PostLoginWithoutPassword.json");
        regresAPI.postLoginInvalid(jsonLoginInvalid);
    }
}