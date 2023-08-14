package stepDefinitions;


import emreTestData.TestData_US001;
import hooks.api.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.Assert;
import testData.TestData_US_033;
import utilities.ApiUtils;
import utilities.Authentication;

import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.fullPath;
import static utilities.ApiUtils.response;


public class APIStepDefinition {

    JSONObject reqBody;

    Response response1;
    //public static String fullPath;

    //************************** Emre ****************************************
    @Then("VisitorsPurpose icin Post request gonderilir.")
    public void visitorspurposeIcinPostRequestGonderilir() {


        /*
        {
            "visitors_purpose":"Veli Ziyareti",
            "description":"Veli Ziyareti İçin Gelindi"
        }
         */


        ApiUtils.emrePostMethod("Veli Ziyareti","Veli Ziyareti İçin Gelindi");

        reqBody = new JSONObject();

        reqBody.put("visitors_purpose","Veli Ziyareti");
        reqBody.put("description","Veli Ziyareti İçin Gelindi");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer "+ HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response1.prettyPrint();



        ApiUtils.emrePostMethod("Veli Ziyareti","Veli Ziyareti İçin Gelindi");

    }

    @Then("{string}, {string} icin Post request gonderilir.")
    public void icinPostRequestGonderilir(String VisitorPurpose, String Description) {

        ApiUtils.emrePostMethod(VisitorPurpose,Description);
    }
    @And("Validate the First Item of the Visitor Purpose List")
    public void validateTheFirstItemOfTheVisitorPurposeList() {

        TestData_US001 testDataUs001=new TestData_US001();

        JSONObject expData = testDataUs001.expData_US001();

        JSONObject reqBody = new JSONObject();

        reqBody.put("id","1");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .get(fullPath);

        response1.prettyPrint();
        JsonPath resJP = response1.jsonPath();

        Assert.assertEquals(expData.getJSONObject("lists").get("id"),resJP.getJsonObject("lists.id"));
        Assert.assertEquals(expData.getJSONObject("lists").get("visitors_purpose"),resJP.getJsonObject("lists.visitors_purpose"));
        Assert.assertEquals(expData.getJSONObject("lists").get("description"),resJP.getJsonObject("lists.description"));
        Assert.assertEquals(expData.getJSONObject("lists").get("created_at"),resJP.getJsonObject("lists.created_at"));



    }

    //************************** Ogün ****************************************
    @Given("{string} Page User sets {string} parameters")
    public void page_user_sets_parameters(String page, String path) {
        Authentication.generateToken(page);
        ApiUtils.petParametreSet(path);
    }

    @Then("User sends a get request")
    public void user_sends_a_get_request() {
        ApiUtils.getRequestMethod();
    }

    @Then("Execute a verification for a valid authorization")
    public void executeAVerificationForAValidAuthorization() {
        HashMap<String,Object> expectedData = new HashMap<>();
        expectedData.put("status",200);
        expectedData.put("message","Success");

        Assert.assertEquals(expectedData.get("status"),ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"),ApiUtils.respHP.get("message"));
    }

    @Then("Execute a verification for an invalid authorization")
    public void executeAVerificationForAnInvalidAuthorization() {
        HashMap<String,Object> expectedData = new HashMap<>();
        expectedData.put("status",403);
        expectedData.put("message","failed");

        Assert.assertEquals(expectedData.get("status"),ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"),ApiUtils.respHP.get("message"));

    }



    @Given("Response body content test for visitor list")
    public void response_body_content_test_for_visitor_list() {

        TestData_US_033 testDataUs033 = new TestData_US_033();

        JSONObject expData = testDataUs033.expDataUS_033();

        JsonPath resJP = response1.jsonPath();

        Assert.assertEquals(expData.getJSONObject("data").get("id"),resJP.getJsonObject("lists.id"));
        Assert.assertEquals(expData.getJSONObject("data").get("staff_id"),resJP.getJsonObject("lists.staff_id"));
        Assert.assertEquals(expData.getJSONObject("data").get("student_session_id"),resJP.getJsonObject("lists.student_session_id"));
        Assert.assertEquals(expData.getJSONObject("data").get("source"),resJP.getJsonObject("lists.source"));
        Assert.assertEquals(expData.getJSONObject("data").get("purpose"),resJP.getJsonObject("lists.purpose"));
        Assert.assertEquals(expData.getJSONObject("data").get("name"),resJP.getJsonObject("lists.name"));
        Assert.assertEquals(expData.getJSONObject("data").get("email"),resJP.getJsonObject("lists.email"));
        Assert.assertEquals(expData.getJSONObject("data").get("contact"),resJP.getJsonObject("lists.contact"));
        Assert.assertEquals(expData.getJSONObject("data").get("id_proof"),resJP.getJsonObject("lists.id_proof"));
        Assert.assertEquals(expData.getJSONObject("data").get("no_of_people"),resJP.getJsonObject("lists.no_of_people"));
        Assert.assertEquals(expData.getJSONObject("data").get("date"),resJP.getJsonObject("lists.date"));
        Assert.assertEquals(expData.getJSONObject("data").get("in_time"),resJP.getJsonObject("lists.in_time"));
        Assert.assertEquals(expData.getJSONObject("data").get("out_time"),resJP.getJsonObject("lists.out_time"));
        Assert.assertEquals(expData.getJSONObject("data").get("note"),resJP.getJsonObject("lists.note"));
        Assert.assertEquals(expData.getJSONObject("data").get("image"),resJP.getJsonObject("lists.image"));
        Assert.assertEquals(expData.getJSONObject("data").get("meeting_with"),resJP.getJsonObject("lists.meeting_with"));
        Assert.assertEquals(expData.getJSONObject("data").get("created_at"),resJP.getJsonObject("lists.created_at"));
        Assert.assertEquals(expData.getJSONObject("data").get("class"),resJP.getJsonObject("lists.class"));
        Assert.assertEquals(expData.getJSONObject("data").get("section"),resJP.getJsonObject("lists.section"));
        Assert.assertEquals(expData.getJSONObject("data").get("staff_name"),resJP.getJsonObject("lists.staff_name"));
        Assert.assertEquals(expData.getJSONObject("data").get("staff_surname"),resJP.getJsonObject("lists.staff_surname"));
        Assert.assertEquals(expData.getJSONObject("data").get("staff_employee_id"),resJP.getJsonObject("lists.staff_employee_id"));
        Assert.assertEquals(expData.getJSONObject("data").get("class_id"),resJP.getJsonObject("lists.class_id"));
        Assert.assertEquals(expData.getJSONObject("data").get("section_id"),resJP.getJsonObject("lists.section_id"));
        Assert.assertEquals(expData.getJSONObject("data").get("students_id"),resJP.getJsonObject("lists.students_id"));
        Assert.assertEquals(expData.getJSONObject("data").get("admission_no"),resJP.getJsonObject("lists.admission_no"));
        Assert.assertEquals(expData.getJSONObject("data").get("student_firstname"),resJP.getJsonObject("lists.student_firstname"));
        Assert.assertEquals(expData.getJSONObject("data").get("student_middlename"),resJP.getJsonObject("lists.student_middlename"));
        Assert.assertEquals(expData.getJSONObject("data").get("student_lastname"),resJP.getJsonObject("lists.student_lastname"));
        Assert.assertEquals(expData.getJSONObject("data").get("role_id"),resJP.getJsonObject("lists.role_id"));

    }

    @Given("POST request is sent for visitorId")
    public void post_request_is_sent_for_visitor_ıd() {

        ApiUtils.postRequestVisitorId();


    }

    @Given("Response body content test for visitor Id")
    public void response_body_content_test_for_visitor_ıd() {

    }



    // *********************** GUlten ***********************//
    @Given("User sends a Patch request to end point")
    public void user_sends_a_patch_request_to_end_point() {
     // ApiUtils.patchRequestGulten();

    }


    @Then("Execute verification for given informations")
    public void executeVerificationForGivenInformations() {

        HashMap<String,Object> expectedData = new HashMap<>();
        expectedData.put("status",200);
        expectedData.put("message","Success");
        expectedData.put("id",11);
        expectedData.put("session","2017-18");
        expectedData.put("is_active","no");
        expectedData.put("created_at","2017-04-20 02:41:37");

        Assert.assertEquals(expectedData.get("status"),ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"),ApiUtils.respHP.get("message"));


    }

    @Then("User sends a POST request for start date {string} and end date {string}")
    public void userSendsAPOSTRequestForStartDateAndEndDate(String start, String end) {
        ApiUtils.postMethodEventsByDateRange(start,end);
    }

    @Given("User verifies that the information in the response body  is the same as in the PATCH request body sent to the api alumniEventsUpdate endpoint")
    public void user_verifies_that_the_information_in_the_response_body_is_the_same_as_in_the_patch_request_body_sent_to_the_api_alumni_events_update_endpoint() {

        JSONObject  reqBody =new JSONObject();
        reqBody.put("id", 5);
        reqBody.put("title","Sports Activite 2");
        reqBody.put("event_for","all");
        reqBody.put("session_id", "null");
        reqBody.put("section","null");
        reqBody.put("from_date","2023-02-14 00:00:00");
        reqBody.put("to_date","2023-02-15 23:59:00");
        reqBody.put("note","Sports");
        reqBody.put("event_notification_message","Sports");
        reqBody.put("show_onwebsite","0");
        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer "+ HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .patch(fullPath);
        response1.prettyPrint();

    JSONObject jsonResponseBody =new JSONObject();

    }



    @Then("User sends a PATCH request to visitorsUpdate endpoint")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpoint() {
        ApiUtils.patchRequestVisitorsUpdateOgun();
    }


}












