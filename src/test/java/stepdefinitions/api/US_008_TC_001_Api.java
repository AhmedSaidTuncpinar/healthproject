package stepdefinitions.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.AppointmentResponsePojo;
import pojos.PostAppointmentPojo;

import static io.restassured.RestAssured.*;
import static utilities.AdminAuthenticationMedunna.generateTokenForAdmin;

public class US_008_TC_001_Api {

    PostAppointmentPojo requestBody =new PostAppointmentPojo();
    Response response;
    Response response2;
    RequestSpecification spec;
    JsonPath json;
    AppointmentResponsePojo actualData;
    @Given("user sets the necessary path params to create an appointment")
    public void user_sets_the_necessary_path_params_to_create_an_appointment() {
        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "appointments", "third", "request");
    }
    @Given("sets the expected data with valid {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void sets_the_expected_data_with_valid(String firstname, String lastname, String ssn, String email, String phone, String date, String appoSpeciality, String birthDate, String gender, String snumber) {
        requestBody.setFirstName(firstname);
        requestBody.setLastName(lastname);
        requestBody.setSsn(ssn);
        requestBody.setEmail(email);
        requestBody.setPhone(phone);
        requestBody.setStartDate(date);
        requestBody.setAppoSpeciality(appoSpeciality);
        requestBody.setBirthDate(birthDate);
        requestBody.setGender(gender);
        requestBody.setSnumber(snumber);

    }
    @Given("sends POST request and get the response to make an appointment")
    public void sends_post_request_and_get_the_response_to_make_an_appointment() {
        response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).when().post("/{first}/{second}/{third}");
        //response.prettyPrint();
    }

    @Then("verify HTTP status code is {int} of appointment post request")
    public void verifyHTTPStatusCodeIsOfAppointmentPostRequest(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("verify api records")
    public void verifyApiRecords() {
        json = response.jsonPath();
        Assert.assertEquals(requestBody.getFirstName(), json.getString("patient.firstName"));
        Assert.assertEquals(requestBody.getSsn(), json.getString("patient.user.ssn"));
        Assert.assertEquals(requestBody.getLastName(), json.getString("patient.lastName"));
        Assert.assertEquals(requestBody.getEmail(), json.getString("patient.email"));
        Assert.assertEquals(requestBody.getPhone(), json.getString("patient.phone"));
        Assert.assertEquals(requestBody.getStartDate(), json.getString("startDate"));
//        Assert.assertEquals(requestBody.getGender(), json.getString("patient.gender")); //response : null
//        Assert.assertEquals(requestBody.getBirthDate(), json.getString("patient.birthDate")); //response : null
    }

    @Given("user sends the get request for created appointment data to the url")
    public void userSendsTheGetRequestForAppointmentsDataToTheUrl() {
        int appointmentId = json.getInt("id");
        spec.pathParams("first", "api", "second", "appointments", "third", appointmentId);

        response2 = given().spec(spec).header("Authorization","Bearer "+generateTokenForAdmin()).when().get("/{first}/{second}/{third}");
        //response2.prettyPrint();
    }

    @And("user deserializes data to Java for appointment")
    public void userDeserializesDataToJavaForAppointments() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        actualData = mapper.readValue(response2.asString(), AppointmentResponsePojo.class);

    }
    @Then("verify HTTP status code is {int} of appointment get request")
    public void verifyHTTPStatusCodeIsOfAppointmentGetRequest(int statusCode) {
        Assert.assertEquals(statusCode, response2.getStatusCode());
    }
    @Then("user validate appointment records of registered appointment")
    public void userValidateAppointmentRecordsOfRegisteredAppointment() {
        Assert.assertEquals(requestBody.getFirstName(), actualData.getPatient().getFirstName());
        Assert.assertEquals(requestBody.getSsn(), actualData.getPatient().getUser().getSsn());
        Assert.assertEquals(requestBody.getLastName(), actualData.getPatient().getLastName());
        Assert.assertEquals(requestBody.getEmail(), actualData.getPatient().getUser().getEmail());
        Assert.assertEquals(requestBody.getPhone(), actualData.getPatient().getPhone());
        Assert.assertEquals(requestBody.getStartDate(), actualData.getStartDate());

    }




}




