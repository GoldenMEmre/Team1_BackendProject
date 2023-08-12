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
import utilities.ConfigReader;

import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIStepDefinition {

    public static String fullPath;

    JSONObject reqBody;

    Response response;

    @Given("Api kullanicisi {string} path parametreleri set eder.")
    public void api_kullanicisi_path_parametreleri_set_eder(String Paths) {

        ApiUtils.petParametreSet(Paths);

/*
        String [] paths = rawPaths.split("/"); // ["api","profile","allCountries"]

        System.out.println(Arrays.toString(paths));


        StringBuilder tempPath = new StringBuilder("/{");


        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            HooksAPI.spec.pathParam(key,value);

            tempPath.append(key + "}/{");
        }
            tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
            tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

            fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath);

 */

    }


    @Then("VisitorsList icin Get request gonderilir.")
    public void visitors_list_icin_get_request_gonderilir() {

        ApiUtils.getRequestMethod();

        /*
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .get(fullPath);

        response.prettyPrint();

         */


    }



    @Then("Login icin {string} ve {string} girilir.")
    public void loginIcinVeGirilir(String emreemail, String password) {

        /*
        {
          "email": "test@test.com",
          "password": "123123123"
        }
         */

        reqBody = new JSONObject();

        reqBody.put("email", ConfigReader.getProperty(emreemail));
        reqBody.put("password", ConfigReader.getProperty(password));

    }

    @Then("Login icin Post request gonderilir.")
    public void loginIcinPostRequestGonderilir() {

        Response response = given()
                                .spec(spec)
                                .contentType(ContentType.JSON)
                                .header("Accept","application/json")
                            .when()
                                .body(reqBody.toString())
                                .post(fullPath);

        response.prettyPrint();


    }

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

        response =      given()
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

        ApiUtils.postMethod(VisitorPurpose,Description);
    }

    @Then("It is validated that the status code is {int} and the response message is Success")
    public void ıtIsValidatedThatTheStatusCodeIsAndTheResponseMessageIsSuccess(int arg0) {

        Response response =given().get(fullPath);

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("message", equalTo("Success"));



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
}
