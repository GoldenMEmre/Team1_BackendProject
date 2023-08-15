package utilities;

import hooks.api.HooksAPI;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import stepDefinitions.APIStepDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;


public class ApiUtils {

    public static Response response;
    public  static JSONObject  reqBody;
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




        public static void postMethodEventsByDateRange (String start, String end){


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


        public static void patchRequestGulten(){


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
            reqBody.put("id", 5);
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

        public static void patchRequestVisitorsUpdateOgun(int id){

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

        public static void postVisitorsIDOgun(){

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


        public static void postRequestVisitorId () {

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
        respHP=response.as(HashMap.class);

    }

    public static void postRequestQuestionDetailsById(){

        JSONObject reqBody = new JSONObject();
        reqBody.put("id","3");

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


    public static void invalidPostRequestVisitorId(){

        JSONObject reqBody=new JSONObject();

        reqBody.put("id",3250);

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






    public static void reqbodyUS_026(){

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

        reqBody.put("id",3);
        reqBody.put("current_email","cuntahsin.com");
        reqBody.put("current_phone","123456");
        reqBody.put("current_phone","123456");
        reqBody.put("occupation","police");



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



    public static void responseUS_026(){



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
        reqBody.put("id",3);
        JSONObject responseBody = new JSONObject();
        responseBody.put("updateId",3);



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

    public static void postRequestUS_27(){
        JSONObject  reqBody =new JSONObject();

        reqBody.put("student_id","34");
        reqBody.put("current_email", "yildiz@abc");
        reqBody.put("current_phone","123456");
        reqBody.put("occupation", "");
        reqBody.put("address","");
        reqBody.put("photo", "");




        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response.prettyPrint();


        JsonPath respJp = response.jsonPath();
           addId = respJp.getInt("addId");

    }
     public static void deleteMethod1(){

      JSONObject requestBody = new JSONObject();
      requestBody.put("id", addId);
        response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept","application/json")
                .headers("Authorization","Bearer " + HooksAPI.token)
                .when()
                .body(requestBody.toString())
                .delete(fullPath);
        response.prettyPrint();
         respHP = response.as(HashMap.class);


     }

     public static void validateTheListOfTheContentUS007(){
         JsonPath resJP = ApiUtils.response.jsonPath();
         ArrayList listsArr = resJP.getJsonObject("lists");
         JSONArray listsJA = new JSONArray(listsArr);
         System.out.println(listsJA.get(0));

         Assert.assertEquals(listsJA.getJSONObject(1).get("id"),"1070");
         Assert.assertEquals(listsJA.getJSONObject(1).get("title"),"Reunion For 2020-21 Batch");
         Assert.assertEquals(listsJA.getJSONObject(1).get("event_for"),"class");
         Assert.assertEquals(listsJA.getJSONObject(1).get("session_id"),"15");
         Assert.assertNull(listsJA.getJSONObject(1).get("class_id"));
         Assert.assertEquals(listsJA.getJSONObject(1).get("section"),"[\"1\",\"2\",\"3\"]");
         Assert.assertEquals(listsJA.getJSONObject(1).get("from_date"),"2021-03-07 00:00:00");
         Assert.assertEquals(listsJA.getJSONObject(1).get("to_date"),"2021-03-10 00:00:00");
         Assert.assertEquals(listsJA.getJSONObject(1).get("note"),"");
         Assert.assertNull(listsJA.getJSONObject(1).get("photo"));
         Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"),"0");
         Assert.assertEquals(listsJA.getJSONObject(1).get("event_notification_message"),"");
         Assert.assertEquals(listsJA.getJSONObject(1).get("show_onwebsite"),"0");
         Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"),"2023-08-14 09:48:43");
     }

     public static void validateTheContentOfTheListUS008(){
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

         Assert.assertEquals(listsJA.getJSONObject(0).get("id"),"1");
         Assert.assertEquals(listsJA.getJSONObject(0).get("title"),"Covid-19 Seminar");
         Assert.assertEquals(listsJA.getJSONObject(0).get("event_for"),"class");
         Assert.assertEquals(listsJA.getJSONObject(0).get("session_id"),"16");
         Assert.assertEquals(listsJA.getJSONObject(0).get("class_id"),"1");
         Assert.assertEquals(listsJA.getJSONObject(0).get("section"),"[\"1\"]");
         Assert.assertEquals(listsJA.getJSONObject(0).get("from_date"),"2021-03-01 00:00:00");
         Assert.assertEquals(listsJA.getJSONObject(0).get("to_date"),"2021-03-16 00:00:00");
         Assert.assertEquals(listsJA.getJSONObject(0).get("note"),note);
         Assert.assertEquals(listsJA.getJSONObject(0).get("photo"),"");
         Assert.assertEquals(listsJA.getJSONObject(0).get("is_active"),"0");
         Assert.assertEquals(listsJA.getJSONObject(0).get("event_notification_message"),event_notification_message);
         Assert.assertEquals(listsJA.getJSONObject(0).get("show_onwebsite"),"0");
         Assert.assertEquals(listsJA.getJSONObject(0).get("created_at"),"2021-03-23 02:54:29");
     }

        public static void postRequestAlumniEventsIDUS009(int id){

            JSONObject reqBody=new JSONObject();

            reqBody.put("id",id);

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
        public static void validateContentOfTheResponseUS009(){
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

        public static void postVisitorsIdUS036(){
            JSONObject reqBody=new JSONObject();

            reqBody.put("id",232);

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

        public static void createVisitorUS0037(){
            JSONObject reqBody=new JSONObject();

            reqBody.put("purpose","Principal Meeting");
            reqBody.put("name","Timur");
            reqBody.put("contact","02323 23 23");
            reqBody.put("id_proof","447932367");
            reqBody.put("no_of_people","23");
            reqBody.put("date","2023-10-26");
            reqBody.put("in_time","06:00 AM");
            reqBody.put("out_time","06:45 AM");
            reqBody.put("note","OERD was here");


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

    public static void postVisitorIDUS0037(){
        JSONObject reqBody=new JSONObject();

        reqBody.put("id",addId);


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

}











