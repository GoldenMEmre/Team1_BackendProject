package utilities;

import hooks.api.HooksAPI;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import stepDefinitions.APIStepDefinition;

import java.util.Arrays;
import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;


public class ApiUtils {

    public static Response response;
    public static JSONObject reqBody;
    public static String fullPath;

    public static HashMap<String, Object> respHP;
    static int addId;

    public static void getRequestMethod() {

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .get(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);
    }

    public static void emrePostMethod(String visitors_purpose, String description) {

        JSONObject reqBody = new JSONObject();

        reqBody.put("visitors_purpose", visitors_purpose);
        reqBody.put("description", description);


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);
    }

    public static void petParametreSet(String rawPaths) {

        // api/visitorsList

        String[] paths = rawPaths.split("/"); // ["api","visitorsList"]

        System.out.println(Arrays.toString(paths));

       /*
        spec.pathParam("pp1","api");
        spec.pathParam("pp2","visitorsList");
        */

        StringBuilder tempPath = new StringBuilder("/{");


        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            HooksAPI.spec.pathParam(key, value);

            tempPath.append(key + "}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));

        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath);

    }


    public static Response deleteRequest() {
        Response response = given().headers(
                "Authorization",
                "Bearer " + HooksAPI.token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(fullPath);
        return response;
    }


    // alumni Events By Date Range Post Request Method


    public static void postMethodEventsByDateRange(String start, String end) {


        JSONObject reqBody = new JSONObject();

        reqBody.put("start", start);
        reqBody.put("end", end);


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }


    public static void patchRequestGulten(int id) {


         /* {
            "id": 5,
                "title": "Sports Activite 2",
                "event_for": "all",
                "session_id": null,
                "section": "null",
                "from_date": "2023-02-14 00:00:00",
                "to_date": "2023-02-15 23:59:00",
                "note": "Sports",
                "event_notification_message": "Sports",
                "show_onwebsite": "0"


        */


        JSONObject reqBody = new JSONObject();
        reqBody.put("id", id);
        reqBody.put("title", "Sports Activite 2");
        reqBody.put("event_for", "all");
        reqBody.put("session_id", "null");
        reqBody.put("section", "null");
        reqBody.put("from_date", "2023-02-14 00:00:00");
        reqBody.put("to_date", "2023-02-15 23:59:00");
        reqBody.put("note", "Sports");
        reqBody.put("event_notification_message", "Sports");
        reqBody.put("show_onwebsite", "0");
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .patch(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);

    }

    public static void patchRequestVisitorsUpdateOgun() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 232);
        reqBody.put("purpose", "Principal Meeting");
        reqBody.put("name", "Kenan1");
        reqBody.put("contact", "9808678686112");
        reqBody.put("id_proof", "312121");
        reqBody.put("no_of_people", "16");
        reqBody.put("date", "2023-03-16");
        reqBody.put("in_time", "06:00 PM");
        reqBody.put("out_time", "06:30 PM");
        reqBody.put("note", "PTM meeting");
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .patch(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);
    }

    public static void postVisitorsIDOgun() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 232);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .put(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);
    }


    public static void postRequestVisitorId() {

        JSONObject reqBody = new JSONObject();

        reqBody.put("id", 250);


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }


    public static void postRequestVisitorAdd() {
        /*
         "purpose": "Principal Meeting",
        "name": "Sumeyra",
        "contact": "1237894560",
        "id_proof": "312121",
        "no_of_people": "40",
        "date": "2023-03-30",
        "in_time": "06:00 PM",
        "out_time": "06:30 PM",
        "note": "DBM meeting"
         */

        JSONObject reqBody = new JSONObject();

        reqBody.put("purpose", "Principal Meeting");
        reqBody.put("name", "Sumeyra");
        reqBody.put("contact", "1237894560");
        reqBody.put("id_proof", "312121");
        reqBody.put("no_of_people", "40");
        reqBody.put("date", "2023-03-30");
        reqBody.put("in_time", "06:00 PM");
        reqBody.put("out_time", "06:30 PM");
        reqBody.put("note", "DBM meeting");

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);

    }

    public static void postRequestQuestionDetailsById() {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", "3");

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }


    public static void invalidPostRequestVisitorId() {

        JSONObject reqBody = new JSONObject();

        reqBody.put("id", 3250);

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }


    public static void reqbodyUS_026() {

        JSONObject reqBody = new JSONObject();

             /*
             {
        "id": 3,
        "student_id": "29",
        "current_email": "cuntahsin.com",
        "current_phone": "123456",
        "occupation": "police"
=======


>>>>>>> main

}
              */

        reqBody.put("id", 3);
        reqBody.put("current_email", "cuntahsin.com");
        reqBody.put("current_phone", "123456");
        reqBody.put("current_phone", "123456");
        reqBody.put("occupation", "police");


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .put(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }


    public static void responseUS_026() {



             /*
             {
        "id": 3,
        "student_id": "29",
        "current_email": "cuntahsin.com",
        "current_phone": "123456",
        "occupation": "police"

}
              */
        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 3);
        JSONObject responseBody = new JSONObject();
        responseBody.put("updateId", 3);


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .put(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }

    public static void postRequestUS_27() {
        JSONObject reqBody = new JSONObject();

        reqBody.put("student_id", "34");
        reqBody.put("current_email", "yildiz@abc");
        reqBody.put("current_phone", "123456");
        reqBody.put("occupation", "");
        reqBody.put("address", "");
        reqBody.put("photo", "");


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();


        JsonPath respJp = response.jsonPath();
        addId = respJp.getInt("addId");

    }

    public static void deleteMethod1() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("id", addId);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(requestBody.toString())
                .delete(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }

    public static void gultenPostUser11() {
        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 5);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }

    public  static  void gultenGetUS13(){



        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 1);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .get(fullPath);
        response.prettyPrint();


    }
    public  static  void gultenGetUS14(){




        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 7);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }
    public  static  void gultenPostUS45(){




        JSONObject reqBody = new JSONObject();
        reqBody.put("class_id", 1);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);


    }



}











