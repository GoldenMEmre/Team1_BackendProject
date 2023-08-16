package stepDefinitions;



import com.beust.ah.A;
import emreTestData.TestData;
import hooks.api.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hamcrest.Matchers;
import org.json.JSONArray;

import org.json.JSONObject;
import org.junit.Assert;
import testData.TestDataUS_033;
import pojos.SessionListListsPOJO;
import pojos.SessionListPOJO;

import utilities.ApiUtils;
import utilities.Authentication;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;

import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.*;


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


        ApiUtils.emrePostMethod("Veli Ziyareti", "Veli Ziyareti İçin Gelindi");

        reqBody = new JSONObject();

        reqBody.put("visitors_purpose", "Veli Ziyareti");
        reqBody.put("description", "Veli Ziyareti İçin Gelindi");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response1.prettyPrint();


        ApiUtils.emrePostMethod("Veli Ziyareti", "Veli Ziyareti İçin Gelindi");

    }

    @Then("{string}, {string} icin Post request gonderilir.")
    public void icinPostRequestGonderilir(String VisitorPurpose, String Description) {

        ApiUtils.emrePostMethod(VisitorPurpose, Description);
    }

    @And("Validate the First Item of the Visitor Purpose List")
    public void validateTheFirstItemOfTheVisitorPurposeList() {

        TestData testData = new TestData();

        HashMap<String, Object> reqBody = testData.dataBodyOlusturMap();

        Assert.assertEquals(reqBody.get("id"), ApiUtils.respHP.get("lists"));
        Assert.assertEquals(reqBody.get("visitors_purpose"), ApiUtils.respHP.get("visitors_purpose"));
        Assert.assertEquals(reqBody.get("created_at"), ApiUtils.respHP.get("created_at"));

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
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("status", 200);
        expectedData.put("message", "Success");

        Assert.assertEquals(expectedData.get("status"), ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), ApiUtils.respHP.get("message"));

    }

    @Then("Execute a verification for an invalid authorization")
    public void executeAVerificationForAnInvalidAuthorization() {
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("status", 403);
        expectedData.put("message", "failed");

        Assert.assertEquals(expectedData.get("status"), ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), ApiUtils.respHP.get("message"));


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

    @Given("Response body content test for Apply Leave List")
    public void response_body_content_test_for_apply_leave_list() {

        response.then().assertThat().body("lists",anything("id"))
                                    .body("lists",anything("student_session_id"))
                                    .body("lists",anything("from_date"))
                                    .body("lists",anything("to_date"))
                                    .body("lists",anything("apply_date"))
                                    .body("lists",anything("status"))
                                    .body("lists",anything("docs"))
                                    .body("lists",anything("reason"))
                                    .body("lists",anything("approve_by"))
                                    .body("lists",anything("approve_date"))
                                    .body("lists",anything("request_type"))
                                    .body("lists",anything("created_at"))
                                    .body("lists",anything("firstname"))
                                    .body("lists",anything("middlename"))
                                    .body("lists",anything("lastname"))
                                    .body("lists",anything("staff_name"))
                                    .body("lists",anything("surname"))
                                    .body("lists",anything("class_id"))
                                    .body("lists",anything("section_id"))
                                    .body("lists",anything("class"))
                                    .body("lists",anything("section"));
    }




    // *********************** GUlten ***********************//
    @Given("User sends a Patch request to end point")
    public void user_sends_a_patch_request_to_end_point() {
        // ApiUtils.patchRequestGulten();

    }





    @Given("User verifies that the information in the response body  is the same as in the PATCH request body sent to the api alumniEventsUpdate endpoint")
    public void user_verifies_that_the_information_in_the_response_body_is_the_same_as_in_the_patch_request_body_sent_to_the_api_alumni_events_update_endpoint() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 5);
        reqBody.put("title", "Sports Activite 2");
        reqBody.put("event_for", "all");
        reqBody.put("session_id", "null");
        reqBody.put("section", "null");
        reqBody.put("from_date", "2023-02-14 00:00:00");
        reqBody.put("to_date", "2023-02-15 23:59:00");
        reqBody.put("note", "Sports");
        reqBody.put("event_notification_message", "Sports");
        reqBody.put("show_onwebsite", "0");
        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .patch(fullPath);
        response1.prettyPrint();

        JsonPath resJP = response1.jsonPath();
        Assert.assertEquals(reqBody.get("id"), resJP.get("updateId"));
        /*{
            "status": 200,
                "message": "Success",
                "Token_remaining_time": 813,
                "updateId": 5
        }

         */
    }

    // *********************** GUlten ***********************//


    @Then("Execute verification for given informations")
    public void executeVerificationForGivenInformations() {

        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(0));

        Assert.assertEquals(listsJA.getJSONObject(1).get("id"),"11");
        Assert.assertEquals(listsJA.getJSONObject(1).get("session"),"2017-18");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"),"no");
        Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"),"2017-04-20 02:41:37");
        Assert.assertEquals(listsJA.getJSONObject(1).get("updated_at"),"0000-00-00");

    }

    @Then("User sends a POST request for start date {string} and end date {string}")
    public void userSendsAPOSTRequestForStartDateAndEndDate(String start, String end) {
        ApiUtils.postMethodEventsByDateRange(start, end);
    }


    @Then("User sends a PATCH request to visitorsUpdate endpoint")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpoint() {
        ApiUtils.patchRequestVisitorsUpdateOgun();
    }


}













