package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson(){
        File json = new File(Constants.REQ_BODY_DIR+"RegisterValidBody.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("Post register user with invalid json without password")
    public void postRegisterUserWithInvalidJson(){
        File json = new File(Constants.REQ_BODY_DIR+"RegisterInvalidBody.json");
        reqresAPI.postRegisterUser(json);
    }
    @When("Send post register user")
    public void sentPostRegisterUser(){
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }
    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
    @And("Validate post register successful user JSON Schema")
    public void validatePostLoginSuccessfulUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserSuccessfulJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post unsuccessful register user JSON Schema")
    public void validatePostUnsuccessfulRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"RegisterUserUnsuccessfulJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body token should be {string} and id {int}")
    public void responseBodyTokenShouldBeAndId(String token, int id) {
        SerenityRest.and().body(ReqresResponses.TOKEN,equalTo(token)).body(ReqresResponses.ID,equalTo(id));
    }
}
