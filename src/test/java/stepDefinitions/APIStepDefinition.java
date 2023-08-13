package stepDefinitions;


import hooks.api.HooksAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import testData.TestData_US_033;
import utilities.ApiUtils;
import utilities.Authentication;
import utilities.ConfigReader;

import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class APIStepDefinition {

    JSONObject reqBody;
    Response response;
    public static String fullPath;

    @Then("VisitorsPurpose icin Post request gonderilir.")
    public void visitorspurposeIcinPostRequestGonderilir() {

        /*
        {
            "visitors_purpose":"Veli Ziyareti",
            "description":"Veli Ziyareti İçin Gelindi"
        }
         */

        reqBody = new JSONObject();

        reqBody.put("visitors_purpose","Veli Ziyareti");
        reqBody.put("description","Veli Ziyareti İçin Gelindi");

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer "+ HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
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


    @Given("Response body content test for visitor list")
    public void response_body_content_test_for_visitor_list() {

        TestData_US_033 testDataUs033 = new TestData_US_033();

        JSONObject expData = testDataUs033.expDataUS_033();

        JsonPath resJP = response.jsonPath();

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
}
