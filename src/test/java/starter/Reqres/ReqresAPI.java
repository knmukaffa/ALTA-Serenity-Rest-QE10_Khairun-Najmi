package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";
    public static String GET_SINGLE_USERS = Constants.BASE_URL + "/api/users/{id}";
    public static String POST_CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String POST_REGISTER_USER = Constants.BASE_URL + "/api/register";
    public static String POST_LOGIN_USER = Constants.BASE_URL + "/api/login";

    public static String PUT_UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";
    @Step("Get list users with valid parameter page")
    public void getListUsersValidParamPage(int page){
        SerenityRest.given().pathParam("page", page);
    }

    // GET
    @Step("Get single user with valid parameter id")
    public void getSingleUserValidParamId(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single user with invalid parameter id")
    public void getSingleUserInvalidParamId(String id){
        SerenityRest.given().pathParam("id", id);
    }

    // POST
    @Step("Post create new user")
    public void postCreateUser(File json){
    SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post Register new user")
    public void postRegisterUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post login user")
    public void postLoginUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    // PUT
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
    SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON);
    }

    // DELETE
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Delete user")
    public void deleteInvalidUser(String id){
        SerenityRest.given().pathParam("id",id);
    }
}
