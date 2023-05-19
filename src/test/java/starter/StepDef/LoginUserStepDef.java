package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.File;

public class LoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson(){
        File json = new File(Constants.REQ_BODY_DIR+"LoginValidBody.json");
        reqresAPI.postLoginUser(json);
    }
    @Given("Post login user with invalid json without password")
    public void postLoginUserWithInvalidJson(){
        File json = new File(Constants.REQ_BODY_DIR+"LoginInvalidBody.json");
        reqresAPI.postLoginUser(json);
    }
    @When("Send post login user")
    public void sentPostLoginUser(){
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Validate post login user JSON Schema")
    public void validatePostLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Response body page should be error {string}")
    public void responseBodyPageShouldBeError(String massage) {
        SerenityRest.and().body(ReqresResponses.ERROR_MASSAGE,equalTo(massage));
    }

    @And("Validate post unsuccessful login user JSON Schema")
    public void validatePostUnsuccessfulLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"LoginUserUnsuccessfulJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
