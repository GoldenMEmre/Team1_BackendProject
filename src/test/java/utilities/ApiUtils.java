package utilities;

import hooks.api.HooksAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static stepDefinitions.APIStepDefinition.fullPath;

public class ApiUtils {

    static Response response;
    public static HashMap<String,Object> respHP;

    public static void getRequestMethod(){

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .get(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);
    }

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


    public static void petParametreSet(String rawPaths){

        // api/visitorsList

        String [] paths = rawPaths.split("/"); // ["api","visitorsList"]

        System.out.println(Arrays.toString(paths));

       /*
        spec.pathParam("pp1","api");
        spec.pathParam("pp2","visitorsList");
        */

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
