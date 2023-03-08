package stepdefinitions.api;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.JdbcUtils;
import java.util.*;
import static io.restassured.RestAssured.given;


public class US_031_TC_001_Api {

    static Response response;
    static String token = "";
    static JsonPath json;
    static List<Integer> physicianList;
    static List<Object> databaseList;

    @When("user send post request {string} for get token with username {string} and password {string}")
    public void userSendPostRequestForGetTokenWithUsernameAndPassword(String url, String username, String password) {
        Map<String, Object> body = new HashMap<>();
        body.put("password", password);
        body.put("rememberMe", true);
        body.put("username", username);

        response = given().contentType(ContentType.JSON).body(body).post(url);
        token = response.jsonPath().get("id_token");
    }

    @When("user sends GET request to {string} with token")
    public void user_sends_get_request_to_with_token(String url) throws JsonProcessingException {
        response = given().headers("Authorization","Bearer "+token).contentType(ContentType.JSON).get(url);

        json = response.jsonPath();
        physicianList = json.getList("id");
//        System.out.println(physicianList);
    }

    @Then("HTTP status code {int}")
    public void httpStatusCode(int arg0) {
        Assert.assertEquals(200, response.getStatusCode());
    }


    @Then("verify physicians ids in database")
    public void verifyPhysiciansIdsInDatabase() {
        JdbcUtils.connectToDatabase("157.230.48.97","medunna_db_v2","select_user","Medunna_pass_@6");
        JdbcUtils.createStatement();

        databaseList= JdbcUtils.getColumnList("id","public.physician");

        System.out.println(databaseList);
        List<Integer> newDBList= new ArrayList<>();
        for (Object w: databaseList){
            String t = String.valueOf(w);
            newDBList.add(Integer.valueOf(t));
        }

        for (int i = 0; i< physicianList.size();i++){
            System.out.println("ids in API --> "+physicianList.get(i));
            System.out.println("ids in DB --> "+ newDBList.get(i));
            Assert.assertTrue(newDBList.contains(physicianList.get(i)));
        }


    }
}

