package stepDefinitions;


import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ApiUtils;
import utilities.Authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APIStepDefinition {

    JSONObject reqBody;
    Response response1;
    public static String fullPath;


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



