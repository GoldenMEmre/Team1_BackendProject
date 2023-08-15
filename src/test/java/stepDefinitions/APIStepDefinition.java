package stepDefinitions;


import emreTestData.TestData_US001;


import com.beust.ah.A;
import emreTestData.TestData_US001;

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

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.fullPath;
import static utilities.ApiUtils.response;


import static utilities.ApiUtils.fullPath;

import static utilities.ApiUtils.respHP;


public class APIStepDefinition {

    JSONObject reqBody;

    Response response1;

    //public static String fullPath;


    public static String fullPath;


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


        TestData_US001 testDataUs001 = new TestData_US001();

        JSONObject expData = testDataUs001.expData_US001();

        JSONObject reqBody1 = new JSONObject();

        reqBody1.put("id", "1");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody1.toString())
                .get(fullPath);

        response1.prettyPrint();
        JsonPath resJP = response1.jsonPath();

        Assert.assertEquals(expData.getJSONObject("lists").get("id"), resJP.getJsonObject("lists.id"));
        Assert.assertEquals(expData.getJSONObject("lists").get("visitors_purpose"), resJP.getJsonObject("lists.visitors_purpose"));
        Assert.assertEquals(expData.getJSONObject("lists").get("description"), resJP.getJsonObject("lists.description"));
        Assert.assertEquals(expData.getJSONObject("lists").get("created_at"), resJP.getJsonObject("lists.created_at"));


        TestData_US001 testData = new TestData_US001();

        HashMap<String, Object> reqBody = testData.data_US001();


        Assert.assertEquals(reqBody.get("id"), respHP.get("lists"));
        Assert.assertEquals(reqBody.get("visitors_purpose"), respHP.get("visitors_purpose"));
        Assert.assertEquals(reqBody.get("created_at"), respHP.get("created_at"));

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

        HashMap<String, Object> expData = testDataUs033.expDataUS_033();

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", "250");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .get(fullPath);

        response1.prettyPrint();
        respHP = response1.as(HashMap.class);


        assertEquals(((Map) (expData.get("lists"))).get("id"), ((Map) (respHP.get("lists"))).get("id"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_id"), ((Map) (respHP.get("lists"))).get("staff_id"));
        assertEquals(((Map) (expData.get("lists"))).get("student_session_id"), ((Map) (respHP.get("lists"))).get("student_session_id"));
        assertEquals(((Map) (expData.get("lists"))).get("source"), ((Map) (respHP.get("lists"))).get("source"));
        assertEquals(((Map) (expData.get("lists"))).get("purpose"), ((Map) (respHP.get("lists"))).get("purpose"));
        assertEquals(((Map) (expData.get("lists"))).get("name"), ((Map) (respHP.get("lists"))).get("name"));
        assertEquals(((Map) (expData.get("lists"))).get("email"), ((Map) (respHP.get("lists"))).get("email"));
        assertEquals(((Map) (expData.get("lists"))).get("contact"), ((Map) (respHP.get("lists"))).get("contact"));
        assertEquals(((Map) (expData.get("lists"))).get("id_proof"), ((Map) (respHP.get("lists"))).get("id_proof"));
        assertEquals(((Map) (expData.get("lists"))).get("no_of_people"), ((Map) (respHP.get("lists"))).get("no_of_people"));
        assertEquals(((Map) (expData.get("lists"))).get("date"), ((Map) (respHP.get("lists"))).get("date"));
        assertEquals(((Map) (expData.get("lists"))).get("in_time"), ((Map) (respHP.get("lists"))).get("in_time"));
        assertEquals(((Map) (expData.get("lists"))).get("out_time"), ((Map) (respHP.get("lists"))).get("out_time"));
        assertEquals(((Map) (expData.get("lists"))).get("note"), ((Map) (respHP.get("lists"))).get("note"));
        assertEquals(((Map) (expData.get("lists"))).get("image"), ((Map) (respHP.get("lists"))).get("image"));
        assertEquals(((Map) (expData.get("lists"))).get("meeting_with"), ((Map) (respHP.get("lists"))).get("meeting_with"));
        assertEquals(((Map) (expData.get("lists"))).get("created_at"), ((Map) (respHP.get("lists"))).get("created_at"));
        assertEquals(((Map) (expData.get("lists"))).get("class"), ((Map) (respHP.get("lists"))).get("class"));
        assertEquals(((Map) (expData.get("lists"))).get("section"), ((Map) (respHP.get("lists"))).get("section"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_name"), ((Map) (respHP.get("lists"))).get("staff_name"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_surname"), ((Map) (respHP.get("lists"))).get("staff_surname"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_employee_id"), ((Map) (respHP.get("lists"))).get("staff_employee_id"));
        assertEquals(((Map) (expData.get("lists"))).get("class_id"), ((Map) (respHP.get("lists"))).get("class_id"));
        assertEquals(((Map) (expData.get("lists"))).get("section_id"), ((Map) (respHP.get("lists"))).get("section_id"));
        assertEquals(((Map) (expData.get("lists"))).get("students_id"), ((Map) (respHP.get("lists"))).get("students_id"));
        assertEquals(((Map) (expData.get("lists"))).get("admission_no"), ((Map) (respHP.get("lists"))).get("admission_no"));
        assertEquals(((Map) (expData.get("lists"))).get("student_firstname"), ((Map) (respHP.get("lists"))).get("student_firstname"));
        assertEquals(((Map) (expData.get("lists"))).get("student_middlename"), ((Map) (respHP.get("lists"))).get("student_middlename"));
        assertEquals(((Map) (expData.get("lists"))).get("student_lastname"), ((Map) (respHP.get("lists"))).get("student_lastname"));
        assertEquals(((Map) (expData.get("lists"))).get("role_id"), ((Map) (respHP.get("lists"))).get("role_id"));

    }

    @Given("POST request is sent for visitorId")
    public void post_request_is_sent_for_visitor_ıd() {

        ApiUtils.postRequestVisitorId();


    }

    @Given("Response body content test for visitor Id")
    public void response_body_content_test_for_visitor_ıd() {

        TestDataUS_033 testDataUs033 = new TestDataUS_033();

        HashMap<String, Object> expData = testDataUs033.expDataUS_033();


        assertEquals(((Map) (expData.get("lists"))).get("id"), ((Map) (respHP.get("lists"))).get("id"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_id"), ((Map) (respHP.get("lists"))).get("staff_id"));
        assertEquals(((Map) (expData.get("lists"))).get("student_session_id"), ((Map) (respHP.get("lists"))).get("student_session_id"));
        assertEquals(((Map) (expData.get("lists"))).get("source"), ((Map) (respHP.get("lists"))).get("source"));
        assertEquals(((Map) (expData.get("lists"))).get("purpose"), ((Map) (respHP.get("lists"))).get("purpose"));
        assertEquals(((Map) (expData.get("lists"))).get("name"), ((Map) (respHP.get("lists"))).get("name"));
        assertEquals(((Map) (expData.get("lists"))).get("email"), ((Map) (respHP.get("lists"))).get("email"));
        assertEquals(((Map) (expData.get("lists"))).get("contact"), ((Map) (respHP.get("lists"))).get("contact"));
        assertEquals(((Map) (expData.get("lists"))).get("id_proof"), ((Map) (respHP.get("lists"))).get("id_proof"));
        assertEquals(((Map) (expData.get("lists"))).get("no_of_people"), ((Map) (respHP.get("lists"))).get("no_of_people"));
        assertEquals(((Map) (expData.get("lists"))).get("date"), ((Map) (respHP.get("lists"))).get("date"));
        assertEquals(((Map) (expData.get("lists"))).get("in_time"), ((Map) (respHP.get("lists"))).get("in_time"));
        assertEquals(((Map) (expData.get("lists"))).get("out_time"), ((Map) (respHP.get("lists"))).get("out_time"));
        assertEquals(((Map) (expData.get("lists"))).get("note"), ((Map) (respHP.get("lists"))).get("note"));
        assertEquals(((Map) (expData.get("lists"))).get("image"), ((Map) (respHP.get("lists"))).get("image"));
        assertEquals(((Map) (expData.get("lists"))).get("meeting_with"), ((Map) (respHP.get("lists"))).get("meeting_with"));
        assertEquals(((Map) (expData.get("lists"))).get("created_at"), ((Map) (respHP.get("lists"))).get("created_at"));
        assertEquals(((Map) (expData.get("lists"))).get("class"), ((Map) (respHP.get("lists"))).get("class"));
        assertEquals(((Map) (expData.get("lists"))).get("section"), ((Map) (respHP.get("lists"))).get("section"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_name"), ((Map) (respHP.get("lists"))).get("staff_name"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_surname"), ((Map) (respHP.get("lists"))).get("staff_surname"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_employee_id"), ((Map) (respHP.get("lists"))).get("staff_employee_id"));
        assertEquals(((Map) (expData.get("lists"))).get("class_id"), ((Map) (respHP.get("lists"))).get("class_id"));
        assertEquals(((Map) (expData.get("lists"))).get("section_id"), ((Map) (respHP.get("lists"))).get("section_id"));
        assertEquals(((Map) (expData.get("lists"))).get("students_id"), ((Map) (respHP.get("lists"))).get("students_id"));
        assertEquals(((Map) (expData.get("lists"))).get("admission_no"), ((Map) (respHP.get("lists"))).get("admission_no"));
        assertEquals(((Map) (expData.get("lists"))).get("student_firstname"), ((Map) (respHP.get("lists"))).get("student_firstname"));
        assertEquals(((Map) (expData.get("lists"))).get("student_middlename"), ((Map) (respHP.get("lists"))).get("student_middlename"));
        assertEquals(((Map) (expData.get("lists"))).get("student_lastname"), ((Map) (respHP.get("lists"))).get("student_lastname"));
        assertEquals(((Map) (expData.get("lists"))).get("role_id"), ((Map) (respHP.get("lists"))).get("role_id"));


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


    // *********************** GUlten ***********************Baslangic//


    @Given("User sends a Patch request to end point with id {int}")
    public void user_sends_a_patch_request_to_end_point_with_id(Integer gulten) {

        ApiUtils.patchRequestGulten(gulten);
    }

    @Given("User sends a Patch request to end point with id {int} and compare id with response id")
    public void user_sends_a_patch_request_to_end_point_with_id_and_compare_id_with_response_id(Integer gulten) {
        ApiUtils.patchRequestGulten(gulten);
        Assert.assertEquals(respHP.get("updateId"), gulten);

    }

    @Given("User sends a POST request to alumniEventsId")
    public void user_sends_a_post_request_to_alumni_events_id() {

        ApiUtils.gultenPostUser11();


    }

    @Given("Response body content test for vehicle list")
    public void response_body_content_test_for_vehicle_list() {

        ApiUtils.gultenGetUS13();

        response.then().assertThat()
                .body("lists.id", Matchers.equalTo("1"))
                .body("lists.vehicle_no", equalTo("VH1001"))
                .body("lists.vehicle_model", equalTo("Volvo Bus"))
                .body("lists.vehicle_photo", equalTo("1677502387-149436744063fca7b3a1796!fd.png"))
                .body("lists.manufacture_year", equalTo("2017"))
                .body("lists.registration_number", equalTo("FVFF-08797865"))
                .body("lists.chasis_number", equalTo("45453"))
                .body("lists.max_seating_capacity", equalTo("50"))
                .body("lists.driver_name", equalTo("Michel"))
                .body("lists.driver_licence", equalTo("R534534"))
                .body("lists.driver_contact", equalTo("8667777869"))
                .body("lists.note", equalTo(""))
                .body("lists.created_at", equalTo("2023-02-27 07:53:07"));


    }

    @Given("User sends a POST request to vehicleId")
    public void user_sends_a_post_request_to_vehicle_id() {
        ApiUtils.gultenGetUS14();

    }

    @Given("Response body content test for vehicleId")
    public void response_body_content_test_for_vehicle_id() {
        /*
        "id": "7",
        "vehicle_no": "VH4584",
        "vehicle_model": "Ford CAB",
        "vehicle_photo": null,
        "manufacture_year": "2015",
        "registration_number": "FFG-76575676787",
        "chasis_number": "523422",
        "max_seating_capacity": "50",
        "driver_name": "Jasper",
        "driver_licence": "258714545",
        "driver_contact": "8521479630",
        "note": "",
        "created_at": "2023-08-06 10:31:17"
         */

        response.then().assertThat()
                .body("lists", anything("id"))
                .body("lists", anything("vehicle_no"))
                .body("lists", anything("vehicle_model"))
                .body("lists", anything("vehicle_photo"))
                .body("lists", anything("manufacture_year"))
                .body("lists", anything("registration_number"))
                .body("lists", anything("anything"))
                .body("lists", anything("max_seating_capacity"))
                .body("lists", anything("driver_name"))
                .body("lists", anything("driver_licence"))
                .body("lists", anything("driver_contact"))
                .body("lists", anything("note"))
                .body("lists", anything("created_at"));
    }


    @Given("User sends a POST request for homeworkAdd")
    public void user_sends_a_post_request_for_homework_add() {
        ApiUtils.gultenPostUS45();
    }
    // *********************** GUlten ***********************Baslangic//


    @Then("Execute verification for given informations")
    public void executeVerificationForGivenInformations() {

        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(1));

        Assert.assertEquals(listsJA.getJSONObject(1).get("id"), "11");
        Assert.assertEquals(listsJA.getJSONObject(1).get("session"), "2017-18");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"), "no");
        Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"), "2017-04-20 02:41:37");
        Assert.assertEquals(listsJA.getJSONObject(1).get("updated_at"), "0000-00-00");

    }

    @Then("Validate the First Item of the Book Issue  List")
    public void validate_the_first_ıtem_of_the_book_ıssue_list() {

        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(1));

        Assert.assertEquals(listsJA.getJSONObject(1).get("id"), "7");
        Assert.assertEquals(listsJA.getJSONObject(1).get("book_id"), "3");
        Assert.assertEquals(listsJA.getJSONObject(1).get("member_id"), "9");
        Assert.assertEquals(listsJA.getJSONObject(1).get("duereturn_date"), "2021-05-06");
        Assert.assertEquals(listsJA.getJSONObject(1).get("issue_date"), "2021-05-04");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_returned"), "0");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"), "no");
        Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"), "2021-05-04 02:56:46");


    }


    @Then("User sends a POST request for start date {string} and end date {string}")
    public void userSendsAPOSTRequestForStartDateAndEndDate(String start, String end) {
        ApiUtils.postMethodEventsByDateRange(start, end);
    }


    @Then("User sends a PATCH request to visitorsUpdate endpoint")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpoint() {
        ApiUtils.patchRequestVisitorsUpdateOgun();
    }


    @Then("User sends a PATCH request to  alumniUpdate endpoint")
    public void user_sends_a_patch_request_to_alumni_update_endpoint() {

        ApiUtils.reqbodyUS_026();


    }


    @Then("Expected data is created, and the equality of the ID information is verified.")
    public void expected_data_is_created_and_the_equality_of_the_id_information_is_verified() {
        ApiUtils.responseUS_026();
    }


    @Then("To create a new body that contains the valid authorization information and correct data")
    public void to_create_a_new_body_that_contains_the_valid_authorization_information_and_correct_data() {
        ApiUtils.postRequestUS_27();
        ApiUtils.deleteMethod1();


    }

    @Given("verification of id in delete request body")
    public void verification_of_ıd_ın_delete_request_body() {

        Assert.assertTrue(respHP.containsKey("DeletedId"));


    }

    @Then("Validate the content of the lists in the response")
    public void validateTheContentOfTheListsInTheResponse() {
        ApiUtils.validateTheListOfTheContentUS007();

    }

    @Then("Validate the content of the data in the response body")
    public void validateTheContentOfTheDataInTheResponseBody() {
        ApiUtils.validateTheContentOfTheListUS008();
    }

    @Then("User sends a POST request for id {int}")
    public void userSendsAPOSTRequestForId(int ident) {
        ApiUtils.postRequestAlumniEventsIDUS009(ident);
    }

    @Then("Validate content of the response body")
    public void validateContentOfTheResponseBody() {
        ApiUtils.validateContentOfTheResponseUS009();
    }

    @Then("User sends a POST request to visitorsId endpoint")
    public void userSendsAPOSTRequestToVisitorsIdEndpoint() {
        ApiUtils.postVisitorsIdUS036();
    }

    @Then("User sends a PATCH request to visitorsUpdate endpoint with id {int}")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpointWithId(int ident) {
        ApiUtils.patchRequestVisitorsUpdateOgun(ident);
    }

    @Then("User sends a PATCH request to visitorsUpdate endpoint with id {int} and compare id with response id")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpointWithIdAndCompareIdWithResponseId(int ident) {
        ApiUtils.patchRequestVisitorsUpdateOgun(ident);
        Assert.assertEquals(respHP.get("updatedId"), ident);
    }

    @Then("User sends a POST request to create a visitor")
    public void userSendsAPOSTRequestToCreateAVisitor() {
        ApiUtils.createVisitorUS0037();
    }

    @Then("User sends a DELETE request")
    public void userSendsADELETERequest() {
        ApiUtils.deleteVisitorUS0037();
    }

    @Then("User sends a DELETE request and compare the ids in request and response body")
    public void userSendsADELETERequestAndCompareTheIdsInRequestAndResponseBody() {
        ApiUtils.deleteVisitorUS0037();
        Assert.assertEquals(ApiUtils.addId, respHP.get("deletedId"));
    }

    @Then("User sends a POST request to check the latest created visitor")
    public void userSendsAPOSTRequestToCheckTheLatestCreatedVisitor() {
    }

    @Then("User sends a get POST request to bookIssueId")
    public void userSendsAGetPOSTRequestToBookIssueId() {

    }

    @And("Validate the First Item of the Book Issue Id")
    public void validateTheFirstItemOfTheBookIssueId() {
        Assert.assertTrue(respHP.get("lists").toString().contains("id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("book_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("member_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("duereturn_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("return_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("issue_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("is_active"));
        Assert.assertTrue(respHP.get("lists").toString().contains("created_at"));
    }

    @And("Validate the First Item of the Book Issue Post")
    public void validateTheFirstItemOfTheBookIssuePost() {

    }


    @Then("User send a patch request to homework update  with id {int}")
    public void userSendAPatchRequestToHomeworkUpdateWithId(int id_number) {
        ApiUtils.pageRequestus046(id_number);
    }

    @Then("User send a patch request to homework update  with id {int} and compare id with response id")
    public void userSendAPatchRequestToHomeworkUpdateWithIdAndCompareIdWithResponseId(int id_number) {
        ApiUtils.pageRequestus046(id_number);
        Assert.assertEquals(id_number, respHP.get("updatedId"));
    }

    @Then("User send a post request to homeworkbyId")
    public void userSendAPostRequestToHomeworkbyId() {
        ApiUtils.postRequestus46();
    }
}
















