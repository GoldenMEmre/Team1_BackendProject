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
import utilities.ApiUtils;
import utilities.Authentication;
import utilities.ConfigReader;
import java.util.HashMap;
import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;

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

}
