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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterId(int id){
        reqresAPI.getSingleUserValidParamId(id);
    }
    @Given("Get single user with exceed parameter id {int}")
    public void getSingleUserWithInvalidParameterId(int id){
        reqresAPI.getSingleUserValidParamId(id);
    }
    @Given("Get single user with invalid parameter id {string}")
    public void getSingleUserWithInvalidParameterId(String id) {
        reqresAPI.getSingleUserInvalidParamId(id);
    }
    @When("Send get single user")
    public void sendGetSingleUser(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USERS);
    }

    @And("Response body name was id {int}")
    public void responseBodyNameWasId(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID,equalTo(id));
    }

    @And("Validate get single user JSON Schema")
    public void validateGetSingleUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
