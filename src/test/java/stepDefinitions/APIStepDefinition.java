package stepDefinitions;


import com.beust.ah.A;
import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import testData.TestDataUS_033;
import utilities.ApiUtils;
import utilities.Authentication;

import java.util.HashMap;
import java.util.Map;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.fullPath;
import static utilities.ApiUtils.respHP;


public class APIStepDefinition {

    JSONObject reqBody;
    Response response1;
    //public static String fullPath;


    @Then("VisitorsPurpose icin Post request gonderilir.")
    public void visitorspurposeIcinPostRequestGonderilir() {

        ApiUtils.emrePostMethod("Veli Ziyareti","Veli Ziyareti İçin Gelindi");
    }

    @Then("{string}, {string} icin Post request gonderilir.")
    public void icinPostRequestGonderilir(String VisitorPurpose, String Description) {

        ApiUtils.emrePostMethod(VisitorPurpose,Description);
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

        Assert.assertEquals(expectedData.get("status"), respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), respHP.get("message"));
    }

    @Then("Execute a verification for an invalid authorization")
    public void executeAVerificationForAnInvalidAuthorization() {
        HashMap<String,Object> expectedData = new HashMap<>();
        expectedData.put("status",403);
        expectedData.put("message","failed");

        Assert.assertEquals(expectedData.get("status"), respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), respHP.get("message"));

    }



    @Given("Response body content test for visitor list")
    public void response_body_content_test_for_visitor_list() {

        TestDataUS_033 testDataUs033 = new TestDataUS_033();

        HashMap<String,Object> expData = testDataUs033.expDataUS_033();

        JSONObject reqBody = new JSONObject();
        reqBody.put("id","250");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .get(fullPath);

        response1.prettyPrint();
        respHP=response1.as(HashMap.class);


        assertEquals( ( (Map) (expData.get("lists"))).get("id") , ( (Map) (respHP.get("lists"))).get("id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_id") , ( (Map) (respHP.get("lists"))).get("staff_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_session_id") , ( (Map) (respHP.get("lists"))).get("student_session_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("source") , ( (Map) (respHP.get("lists"))).get("source"));
        assertEquals( ( (Map) (expData.get("lists"))).get("purpose") , ( (Map) (respHP.get("lists"))).get("purpose"));
        assertEquals( ( (Map) (expData.get("lists"))).get("name") , ( (Map) (respHP.get("lists"))).get("name"));
        assertEquals( ( (Map) (expData.get("lists"))).get("email") , ( (Map) (respHP.get("lists"))).get("email"));
        assertEquals( ( (Map) (expData.get("lists"))).get("contact") , ( (Map) (respHP.get("lists"))).get("contact"));
        assertEquals( ( (Map) (expData.get("lists"))).get("id_proof") , ( (Map) (respHP.get("lists"))).get("id_proof"));
        assertEquals( ( (Map) (expData.get("lists"))).get("no_of_people") , ( (Map) (respHP.get("lists"))).get("no_of_people"));
        assertEquals( ( (Map) (expData.get("lists"))).get("date") , ( (Map) (respHP.get("lists"))).get("date"));
        assertEquals( ( (Map) (expData.get("lists"))).get("in_time") , ( (Map) (respHP.get("lists"))).get("in_time"));
        assertEquals( ( (Map) (expData.get("lists"))).get("out_time") , ( (Map) (respHP.get("lists"))).get("out_time"));
        assertEquals( ( (Map) (expData.get("lists"))).get("note") , ( (Map) (respHP.get("lists"))).get("note"));
        assertEquals( ( (Map) (expData.get("lists"))).get("image") , ( (Map) (respHP.get("lists"))).get("image"));
        assertEquals( ( (Map) (expData.get("lists"))).get("meeting_with") , ( (Map) (respHP.get("lists"))).get("meeting_with"));
        assertEquals( ( (Map) (expData.get("lists"))).get("created_at") , ( (Map) (respHP.get("lists"))).get("created_at"));
        assertEquals( ( (Map) (expData.get("lists"))).get("class") , ( (Map) (respHP.get("lists"))).get("class"));
        assertEquals( ( (Map) (expData.get("lists"))).get("section") , ( (Map) (respHP.get("lists"))).get("section"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_name") , ( (Map) (respHP.get("lists"))).get("staff_name"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_surname") , ( (Map) (respHP.get("lists"))).get("staff_surname"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_employee_id") , ( (Map) (respHP.get("lists"))).get("staff_employee_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("class_id") , ( (Map) (respHP.get("lists"))).get("class_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("section_id") , ( (Map) (respHP.get("lists"))).get("section_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("students_id") , ( (Map) (respHP.get("lists"))).get("students_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("admission_no") , ( (Map) (respHP.get("lists"))).get("admission_no"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_firstname") , ( (Map) (respHP.get("lists"))).get("student_firstname"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_middlename") , ( (Map) (respHP.get("lists"))).get("student_middlename"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_lastname") , ( (Map) (respHP.get("lists"))).get("student_lastname"));
        assertEquals( ( (Map) (expData.get("lists"))).get("role_id") , ( (Map) (respHP.get("lists"))).get("role_id"));

    }

    @Given("POST request is sent for visitorId")
    public void post_request_is_sent_for_visitor_ıd() {

        ApiUtils.postRequestVisitorId();


    }

    @Given("Response body content test for visitor Id")
    public void response_body_content_test_for_visitor_ıd() {

        TestDataUS_033 testDataUs033 = new TestDataUS_033();

        HashMap<String,Object> expData = testDataUs033.expDataUS_033();


        assertEquals( ( (Map) (expData.get("lists"))).get("id") , ( (Map) (respHP.get("lists"))).get("id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_id") , ( (Map) (respHP.get("lists"))).get("staff_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_session_id") , ( (Map) (respHP.get("lists"))).get("student_session_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("source") , ( (Map) (respHP.get("lists"))).get("source"));
        assertEquals( ( (Map) (expData.get("lists"))).get("purpose") , ( (Map) (respHP.get("lists"))).get("purpose"));
        assertEquals( ( (Map) (expData.get("lists"))).get("name") , ( (Map) (respHP.get("lists"))).get("name"));
        assertEquals( ( (Map) (expData.get("lists"))).get("email") , ( (Map) (respHP.get("lists"))).get("email"));
        assertEquals( ( (Map) (expData.get("lists"))).get("contact") , ( (Map) (respHP.get("lists"))).get("contact"));
        assertEquals( ( (Map) (expData.get("lists"))).get("id_proof") , ( (Map) (respHP.get("lists"))).get("id_proof"));
        assertEquals( ( (Map) (expData.get("lists"))).get("no_of_people") , ( (Map) (respHP.get("lists"))).get("no_of_people"));
        assertEquals( ( (Map) (expData.get("lists"))).get("date") , ( (Map) (respHP.get("lists"))).get("date"));
        assertEquals( ( (Map) (expData.get("lists"))).get("in_time") , ( (Map) (respHP.get("lists"))).get("in_time"));
        assertEquals( ( (Map) (expData.get("lists"))).get("out_time") , ( (Map) (respHP.get("lists"))).get("out_time"));
        assertEquals( ( (Map) (expData.get("lists"))).get("note") , ( (Map) (respHP.get("lists"))).get("note"));
        assertEquals( ( (Map) (expData.get("lists"))).get("image") , ( (Map) (respHP.get("lists"))).get("image"));
        assertEquals( ( (Map) (expData.get("lists"))).get("meeting_with") , ( (Map) (respHP.get("lists"))).get("meeting_with"));
        assertEquals( ( (Map) (expData.get("lists"))).get("created_at") , ( (Map) (respHP.get("lists"))).get("created_at"));
        assertEquals( ( (Map) (expData.get("lists"))).get("class") , ( (Map) (respHP.get("lists"))).get("class"));
        assertEquals( ( (Map) (expData.get("lists"))).get("section") , ( (Map) (respHP.get("lists"))).get("section"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_name") , ( (Map) (respHP.get("lists"))).get("staff_name"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_surname") , ( (Map) (respHP.get("lists"))).get("staff_surname"));
        assertEquals( ( (Map) (expData.get("lists"))).get("staff_employee_id") , ( (Map) (respHP.get("lists"))).get("staff_employee_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("class_id") , ( (Map) (respHP.get("lists"))).get("class_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("section_id") , ( (Map) (respHP.get("lists"))).get("section_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("students_id") , ( (Map) (respHP.get("lists"))).get("students_id"));
        assertEquals( ( (Map) (expData.get("lists"))).get("admission_no") , ( (Map) (respHP.get("lists"))).get("admission_no"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_firstname") , ( (Map) (respHP.get("lists"))).get("student_firstname"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_middlename") , ( (Map) (respHP.get("lists"))).get("student_middlename"));
        assertEquals( ( (Map) (expData.get("lists"))).get("student_lastname") , ( (Map) (respHP.get("lists"))).get("student_lastname"));
        assertEquals( ( (Map) (expData.get("lists"))).get("role_id") , ( (Map) (respHP.get("lists"))).get("role_id"));


    }

    @Given("POST request is sent for visitorAdd")
    public void post_request_is_sent_for_visitor_add() {

        ApiUtils.postRequestVisitorAdd();


    }

    @Given("Response body content test for visitor Add")
    public void response_body_content_test_for_visitor_add() {

        Assert.assertTrue(respHP.containsKey("addId"));

    }

    @Given("POST request is sent for questionDetailsById")
    public void post_request_is_sent_for_question_details_by_ıd() {

        ApiUtils.postRequestQuestionDetailsById();

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

        Assert.assertEquals(expectedData.get("status"), respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), respHP.get("message"));


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




