package utilities;

import hooks.api.HooksAPI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import hooks.enumToken;

import static io.restassured.RestAssured.given;

public class Authentication {

    private static RequestSpecification spec;

    public static String generateToken(String page){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        spec.pathParams("pp1","api","pp2","getToken");

        JSONObject reqBody = new JSONObject();

        switch (page){
            case "ADMIN" :
                reqBody.put("email",enumToken.TOKEN.getAdminEmail());
                break;
            case "TEACHER" :
                reqBody.put("email",enumToken.TOKEN.getTeacherEmail());
                break;
            case "STUDENT" :
                reqBody.put("email",enumToken.TOKEN.getStudentUserName());
                break;
            default:
                System.err.println("Please enter a valid Page direction!!");
                break;
        }

        reqBody.put("password", enumToken.TOKEN.getPassword());

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                //.header("Accept","application/json")
                .when()
                .body(reqBody.toString())
                .post("/{pp1}/{pp2}");

        JsonPath resJP = response.jsonPath();

        String token=resJP.getString("token");
        System.out.println(token);
        HooksAPI.token = token;
        System.out.println(HooksAPI.token);
        return token;
    }






}
