package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with valid json and invalid id {int}")
    public void  putUpdateUserWithValidJsonAndInvalidId(int id){
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with invalid json and valid id {int}")
    public void  putUpdateUserWithInvalidJsonAndValidId(int id){
        File json = new File(Constants.REQ_BODY_DIR+"UpdateInvalidBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Put update user with invalid json and id {int}")
    public void  putUpdateUserWithInvalidJsonAndId(int id){
        File json = new File(Constants.REQ_BODY_DIR+"UpdateInvalidBody.json");
        reqresAPI.putUpdateUser(id, json);
    }
}
