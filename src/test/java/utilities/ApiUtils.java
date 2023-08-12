package utilities;

import hooks.api.HooksAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;


public class ApiUtils {

    static Response response;

    public static String fullPath;



    public static void postMethod(String visitors_purpose,String description){

        JSONObject reqBody = new JSONObject();

        reqBody.put("visitors_purpose",visitors_purpose);
        reqBody.put("description",description);


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();

    


    }




    public static Response deleteRequest(){
        Response response = given().headers(
                "Authorization",
                "Bearer " + HooksAPI.token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(fullPath);
        return  response;
    }
}
