package starter.Regres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class DeleteUser {
    @Steps
    RegresAPI regresAPI;

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

    @Given("Delete user with invalid id {string}")
    public void deleteUserWithInvalidIdId(String id) {
        regresAPI.deleteUserInvalid(id);
    }

    @When("Send request delete user invalid id")
    public void sendRequestDeleteUserInvalidId() {
        SerenityRest.when().delete(RegresAPI.DELETE_USER_INVALIDID);
    }

    @Given("Delete user without ID")
    public void deleteUserWithoutID() {
        regresAPI.deleteUserWithoutId();
    }

    @When("Send request delete user without id")
    public void sendRequestDeleteUserWithoutId() {
        SerenityRest.when().delete(RegresAPI.DELETE_WITHOUTID);
    }
}
