package starter.Regres;

import com.sun.corba.se.pept.transport.ContactInfo;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class RegresAPI {

    //GET LIST USER
    public static String GET_LIST_USERS = Constant.BASE_URL + "/users?page={page}";
    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }

    public static String GET_LIST_USERS_INVALIDPAGE = Constant.BASE_URL + "/users?page={page}";
    @Step("Get list users with invalid page")
    public void getListUsersInvalidPage (String page){
        SerenityRest.given().pathParam("page", page);
    }


    //GET SINGLE USER
    public static String GET_SINGLE_USER = Constant.BASE_URL + "/users/{id}";
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Get single user with invalid id")
    public void setGetSingletUsersInvalidId(String id){
        SerenityRest.given().pathParam("id", id);
    }


    public static String GET_SINGLE_USER_WITHOUT_PARAMETER = Constant.BASE_URL + "/users";
    @Step("Get single user without parameter")
    public void getSingleUserWithoutParameter(){
        SerenityRest.given();
    }


    //GET RECOURSE
    public static String GET_RECOURCE = Constant.BASE_URL + "/unknown";
    public void getRecource(){
        SerenityRest.given();
    }


    //POST CREATE
    public static String POST_CREATE_USER = Constant.BASE_URL + "/users";
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    //POST REGSITER
    public static String POST_REGISTER = Constant.BASE_URL + "/register";
    @Step("Post register successful")
    public void postRegister(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    public static String POST_REGISTER_INVALID = Constant.BASE_URL + "/register";
    @Step("Post register invalid")
    public void postRegisterInvalid(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    //POST LOGIN
    public static String POST_LOGIN = Constant.BASE_URL + "/login";
    @Step("Post login")
    public void postLogin ( File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    public static String POST_LOGIN_INVALID = Constant.BASE_URL + "/login";
    @Step("Logon with invalid json")
    public void postLoginInvalid (File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }


    //PUT UPDATE
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/users/{id}";
    @Step("PuT update user")
    public void putUpdateUser(int id, File json ){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    public static String PUT_UPDATE_INVALIDID = Constant.BASE_URL + "/users/{id}";
    @Step("Put update user invalid id")
    public void putUpdateInvalidid(String id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    public static String PUT_WITHOUT_PARAMETER = Constant.BASE_URL + "/users";
    @Step("Put without parameter")
    public void setPutWithoutParameter (){
        SerenityRest.given();
    }


    //DELETE
    public static String DELETE_USER = Constant.BASE_URL+"/users/{id}";
    @Step("Delete user")
    public void deleteUser (int id){
        SerenityRest.given().pathParam("id", id);
    }

    public static String DELETE_USER_INVALIDID = Constant.BASE_URL + "/users/{id}";
    @Step("Delete user with invalid id")
    public void deleteUserInvalid (String id){
        SerenityRest.given().pathParam("id", id);
    }

    public static String DELETE_WITHOUTID = Constant.BASE_URL + "/users";
    @Step("Delete user without parameter")
    public void deleteUserWithoutId (){
        SerenityRest.given();
    }

}
