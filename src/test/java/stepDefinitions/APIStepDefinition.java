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
import utilities.ApiUtils;
import utilities.ConfigReader;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.fullPath;

public class APIStepDefinition {

    JSONObject reqBody;

    Response response;

    @Given("Api kullanicisi {string} path parametreleri set eder.")
    public void api_kullanicisi_path_parametreleri_set_eder(String Paths) {

        ApiUtils.petParametreSet(Paths);
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


}
