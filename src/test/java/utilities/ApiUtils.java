package utilities;

import com.github.javafaker.Faker;
import hooks.api.HooksAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import pojos.GetStudentClassListsPOJO;
import pojos.GetStudentClassPOJO;
import pojos.HomeworkByIdListsPOJ;
import pojos.HomeworkByIdPOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;



public class ApiUtils {

    public static Response response;
    public static JSONObject reqBody;
    public static String fullPath;

    public static HashMap<String, Object> respHP;

    public static int  addId;






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

    public static void patchRequestVisitorsUpdateOgun(int id) {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", id);
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



    public static void postRequestVisitorAdd(){

        JSONObject reqBody=new JSONObject();

        reqBody.put("purpose","Principal Meeting");
        reqBody.put("name","Sumeyra");
        reqBody.put("contact","1237894560");
        reqBody.put("id_proof","312121");
        reqBody.put("no_of_people","40");
        reqBody.put("date","2023-03-30");
        reqBody.put("in_time","06:00 PM");
        reqBody.put("out_time","06:30 PM");
        reqBody.put("note","DBM meeting");

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
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



    public static void reqbodyUS_026() {

        JSONObject reqBody = new JSONObject();

             /*
             {
        "id": 3,
        "student_id": "29",
        "current_email": "cuntahsin.com",
        "current_phone": "123456",
        "occupation": "police"


<<<<<<< HEAD



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

    public static void gultenGetUS13() {


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

    public static void gultenGetUS14() {


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

    public static void gultenPostUS45() {


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

    public static void validateTheListOfTheContentUS007() {
        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(0));


        Assert.assertEquals(listsJA.getJSONObject(1).get("id"), "1097");
        Assert.assertEquals(listsJA.getJSONObject(1).get("title"), "Art Activite");
        Assert.assertEquals(listsJA.getJSONObject(1).get("event_for"), "art");
        Assert.assertEquals(listsJA.getJSONObject(1).get("session_id"), "13");
       // Assert.assertNull(listsJA.getJSONObject(1).get("class_id"));
       // Assert.assertNull(listsJA.getJSONObject(1).get("section"));
        Assert.assertEquals(listsJA.getJSONObject(1).get("from_date"), "2023-11-14 00:00:00");
        Assert.assertEquals(listsJA.getJSONObject(1).get("to_date"), "2023-11-24 23:59:00");
        Assert.assertEquals(listsJA.getJSONObject(1).get("note"), "Paint");
      //  Assert.assertNull(listsJA.getJSONObject(1).get("photo"));
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"), "0");
        Assert.assertEquals(listsJA.getJSONObject(1).get("event_notification_message"), "Art");
        Assert.assertEquals(listsJA.getJSONObject(1).get("show_onwebsite"), "0");
        Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"), "2023-08-14 14:20:34");
    }


    public static void validateTheContentOfTheListUS008() {
        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(0));
        String event_notification_message = "GAVI'S RESPONSE\r\nRespond and protect:" +
                " With COVID-19 now reported in almost all Gavi-eligible countries," +
                " the Vaccine Alliance is providing immediate funding to health systems," +
                " enabling countries to protect health care workers, perform vital surveillance and training," +
                " and purchase diagnostic tests.\r\n\r\nMaintain, restore and strengthen: Gavi will support" +
                " countries to adapt and restart immunisation services, rebuild community trust and catch up" +
                " those who have been missed both before and during the pandemic, while also investing in" +
                " strengthening immunisation systems to be more resilient and responsive to the communities" +
                " they serve.\r\n\r\nEnsure global equitable access: Gavi is co-leading COVAX, the global effort" +
                " to securing a global response to COVID-19 that is effective and fair, using its unique expertise" +
                " to help identify and rapidly accelerate development, production and delivery of COVID-19 vaccines" +
                " so that anyone that needs them, gets them.";

        String note = "COVID-19 is the disease caused by a new coronavirus called SARS-CoV-2." +
                "  WHO first learned of this new virus on 31 December 2019, following a report of a cluster" +
                " of cases of â€˜viral pneumoniaâ€™ in Wuhan, Peopleâ€™s Republic of China.";

        Assert.assertEquals(listsJA.getJSONObject(0).get("id"), "1");
        Assert.assertEquals(listsJA.getJSONObject(0).get("title"), "Covid-19 Seminar");
        Assert.assertEquals(listsJA.getJSONObject(0).get("event_for"), "class");
        Assert.assertEquals(listsJA.getJSONObject(0).get("session_id"), "16");
        Assert.assertEquals(listsJA.getJSONObject(0).get("class_id"), "1");
        Assert.assertEquals(listsJA.getJSONObject(0).get("section"), "[\"1\"]");
        Assert.assertEquals(listsJA.getJSONObject(0).get("from_date"), "2021-03-01 00:00:00");
        Assert.assertEquals(listsJA.getJSONObject(0).get("to_date"), "2021-03-16 00:00:00");
        Assert.assertEquals(listsJA.getJSONObject(0).get("note"), note);
        Assert.assertEquals(listsJA.getJSONObject(0).get("photo"), "");
        Assert.assertEquals(listsJA.getJSONObject(0).get("is_active"), "0");
        Assert.assertEquals(listsJA.getJSONObject(0).get("event_notification_message"), event_notification_message);
        Assert.assertEquals(listsJA.getJSONObject(0).get("show_onwebsite"), "0");
        Assert.assertEquals(listsJA.getJSONObject(0).get("created_at"), "2021-03-23 02:54:29");
    }

    public static void postRequestAlumniEventsIDUS009(int id) {

        JSONObject reqBody = new JSONObject();

        reqBody.put("id", id);

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

    public static void validateContentOfTheResponseUS009() {
        Assert.assertTrue(respHP.get("lists").toString().contains("id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("title"));
        Assert.assertTrue(respHP.get("lists").toString().contains("event_for"));
        Assert.assertTrue(respHP.get("lists").toString().contains("session_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("class_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("section"));
        Assert.assertTrue(respHP.get("lists").toString().contains("from_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("to_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("note"));
        Assert.assertTrue(respHP.get("lists").toString().contains("photo"));
        Assert.assertTrue(respHP.get("lists").toString().contains("is_active"));
        Assert.assertTrue(respHP.get("lists").toString().contains("event_notification_message"));
        Assert.assertTrue(respHP.get("lists").toString().contains("show_onwebsite"));
        Assert.assertTrue(respHP.get("lists").toString().contains("created_at"));
    }

    public static void postVisitorsIdUS036() {
        JSONObject reqBody = new JSONObject();

        reqBody.put("id", 232);

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

    public static void createVisitorUS0037() {
        JSONObject reqBody = new JSONObject();

        reqBody.put("purpose", "Principal Meeting");
        reqBody.put("name", "Timur");
        reqBody.put("contact", "02323 23 23");
        reqBody.put("id_proof", "447932367");
        reqBody.put("no_of_people", "23");
        reqBody.put("date", "2023-10-26");
        reqBody.put("in_time", "06:00 AM");
        reqBody.put("out_time", "06:45 AM");
        reqBody.put("note", "OERD was here");


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
        JsonPath respJp = response.jsonPath();
        addId = respJp.getInt("addId");
    }

    public static void pageRequestus046(int id_number) {

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", id_number);
        reqBody.put("class_id", "1");
        reqBody.put("section_id", "1");
        reqBody.put("session_id", "18");
        reqBody.put("subject_group_subject_id", "21");
        reqBody.put("subject_id", "1");
        reqBody.put("homework_date", "2022-07-05");
        reqBody.put("submit_date", "2022-07-08");
        reqBody.put("marks", 1.00);
        reqBody.put("description", "<p>\r\n\r\nRead carefully\r\n\r\n<br></p>");
        reqBody.put("create_date", "2022-07-01");
        reqBody.put("evaluation_date", "0000-00-00");
        reqBody.put("document", "");
        reqBody.put("created_by", "5");
        reqBody.put("evaluated_by", "5");
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


    public static void postRequestus46() {
        JSONObject reqBody = new JSONObject();

        reqBody.put("id", 423);

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
        //addId = respHP.get("addId");

    }


    public static void deleteVisitorUS0037() {
        JSONObject reqBody = new JSONObject();

        reqBody.put("id", respHP.get("addId"));

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .delete(fullPath);

        response.prettyPrint();
        respHP = response.as(HashMap.class);
    }

    public static void postVisitorIDUS0037() {
        JSONObject reqBody = new JSONObject();

        reqBody.put("id", addId);


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

    public static void postRequestUS044(){
        JSONObject reqBody=new JSONObject();

        reqBody.put("id",423);

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();

         respHP = response.as(HashMap.class);


     }

    public static Response iinvalidpatchRequest (String fullPath, JSONObject reqBody){
        Faker faker = new Faker();
        response = given()
                .spec(spec)
                .headers("Authorization", "Bearer " + faker.internet().password(31, 32, true))
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .patch(fullPath);
        response.prettyPrint();
        return response;
    }


    public static void postRequestus61(){
       JSONObject reqBody=new JSONObject();

       reqBody.put("id",57);


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();
        respHP=response.as(HashMap.class);
    }


    public static void dgpostRequest(){


        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 12);
        reqBody.put("subject_group_subject_id","27");
        reqBody.put("title","deneme");
        reqBody.put("description", "deneme");
        reqBody.put("date","2023-06-15");
        reqBody.put("date", "2023-06-15");

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
    public static void verifyInformationsOfResponseContentUS044(){
        HomeworkByIdListsPOJ homeworkByIdLists = new HomeworkByIdListsPOJ("423","4","3","18","93","47","4",
                "2023-07-25","2023-07-28",null,"<p>verilen testler yapilsin</p>",
                "2023-07-24","2023-08-04",null,"93","117","2023-07-24 15:35:20",
                "Mathematics","7","Class 4th Subject Group","1");


        HomeworkByIdPOJ homeworkByIdPOJ = new HomeworkByIdPOJ(200,"Success",homeworkByIdLists);
        HomeworkByIdPOJ respPojo = response.as(HomeworkByIdPOJ.class);
        Assert.assertEquals(homeworkByIdPOJ.getStatus(),respPojo.getStatus());
        Assert.assertEquals(homeworkByIdPOJ.getMessage(),respPojo.getMessage());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getId(),respPojo.getLists().getId());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getClass_id(),respPojo.getLists().getClass_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSection_id(),respPojo.getLists().getSection_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSession_id(),respPojo.getLists().getSession_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getStaff_id(),respPojo.getLists().getStaff_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSubject_group_subject_id(),respPojo.getLists().getSubject_group_subject_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSubject_id(),respPojo.getLists().getSubject_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getHomework_date(),respPojo.getLists().getHomework_date());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSubmit_date(),respPojo.getLists().getSubmit_date());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getMarks(),respPojo.getLists().getMarks());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getDescription(),respPojo.getLists().getDescription());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getCreate_date(),respPojo.getLists().getCreate_date());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getEvaluation_date(),respPojo.getLists().getEvaluation_date());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getDocument(),respPojo.getLists().getDocument());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getCreated_by(),respPojo.getLists().getCreated_by());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSubject_name(),respPojo.getLists().getSubject_name());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getSubject_groups_id(),respPojo.getLists().getSubject_groups_id());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getName(),respPojo.getLists().getName());
        Assert.assertEquals(homeworkByIdPOJ.getLists().getAssignments(),respPojo.getLists().getAssignments());

    }



        public static void verifyContentOfResponseUS059(){


            GetStudentClassListsPOJO getStudentClassListsPOJO = new GetStudentClassListsPOJO("15998","1014","18",
                    "1","2","108","79","B","ogun.erdogan",
                    "","","2014-03-11","Charles Rodriguez");
            GetStudentClassPOJO expDataPoj = new GetStudentClassPOJO(200,"Success",getStudentClassListsPOJO);
            GetStudentClassPOJO respPOJO = response.as(GetStudentClassPOJO.class);

            Assert.assertEquals(expDataPoj.getStatus(),respPOJO.getStatus());
            Assert.assertEquals(expDataPoj.getMessage(),respPOJO.getMessage());
            Assert.assertEquals(expDataPoj.getLists().getAdmission_no(),respPOJO.getLists().getAdmission_no());
            Assert.assertEquals(expDataPoj.getLists().getRoll_no(),respPOJO.getLists().getRoll_no());
            Assert.assertEquals(expDataPoj.getLists().getSession_id(),respPOJO.getLists().getSession_id());
            Assert.assertEquals(expDataPoj.getLists().getClass_id(),respPOJO.getLists().getClass_id());
            Assert.assertEquals(expDataPoj.getLists().getSection_id(),respPOJO.getLists().getSection_id());
            Assert.assertEquals(expDataPoj.getLists().getId(),respPOJO.getLists().getId());
            Assert.assertEquals(expDataPoj.getLists().getStudent_id(),respPOJO.getLists().getStudent_id());
            Assert.assertEquals(expDataPoj.getLists().getSection(),respPOJO.getLists().getSection());
            Assert.assertEquals(expDataPoj.getLists().getFirstname(),respPOJO.getLists().getFirstname());
            Assert.assertEquals(expDataPoj.getLists().getMiddlename(),respPOJO.getLists().getMiddlename());
            Assert.assertEquals(expDataPoj.getLists().getLastname(),respPOJO.getLists().getLastname());
            Assert.assertEquals(expDataPoj.getLists().getDob(),respPOJO.getLists().getDob());
            Assert.assertEquals(expDataPoj.getLists().getGuardian_name(),respPOJO.getLists().getGuardian_name());

        }













    public static void dgpatchRequest(){


        JSONObject reqBody = new JSONObject();
        reqBody.put("id", 12);
        reqBody.put("subject_group_subject_id","72");
        reqBody.put("title","try");
        reqBody.put("description", "try");
        reqBody.put("date","2023-06-15");
        reqBody.put("date", "2023-06-15");

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

    public static void postRequestAlumniId(){


        JSONObject reqBody = new JSONObject();
        reqBody.put("id",addId);
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

    public static void postRequestUS021(){

        JSONObject reqBody = new JSONObject();

        reqBody.put("book_id","11");
        reqBody.put("member_id","7");
        reqBody.put("duereturn_date","2021-08-04");
        reqBody.put("return_date","2021-09-06");
        reqBody.put("issue_date","2021-08-04");

        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);
        JsonPath respJp = response.jsonPath();
        addId = respJp.getInt("addId");
    }

    public static void postRequestUS047(){

        JSONObject reqBody = new JSONObject();

        reqBody.put("class_id","1");
        reqBody.put("section_id","1");
        reqBody.put("session_id","18");
        reqBody.put("subject_group_subject_id","21");
        reqBody.put("subject_id","1");
        reqBody.put("homework_date","2022-07-05");
        reqBody.put("submit_date","2022-07-08");
        reqBody.put("marks",1);
        reqBody.put("description","<p>\r\n\r\nRead carefully\r\n\r\n<br></p>");
        reqBody.put("create_date","2022-07-01");
        reqBody.put("evaluation_date","0000-00-00");
        reqBody.put("document","");
        reqBody.put("created_by","5");
        reqBody.put("evaluated_by","5");


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);
        JsonPath respJp = response.jsonPath();
        addId = respJp.getInt("addId");
    }

    public static void postrequestUS062(){
        JSONObject reqBody = new JSONObject();

        reqBody.put("subject_group_subject_id","27");
        reqBody.put("title","deneme");
        reqBody.put("description","deneme");
        reqBody.put("date","2023-06-15");
        reqBody.put("remark","");


        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);
        response.prettyPrint();
        respHP = response.as(HashMap.class);
        JsonPath respJp = response.jsonPath();
        addId = respJp.getInt("addId");
    }

    }










