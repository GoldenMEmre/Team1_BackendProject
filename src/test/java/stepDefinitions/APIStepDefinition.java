package stepDefinitions;




import com.google.protobuf.Api;


import emreTestData.TestData_US001;


import emreTestData.TestData_US057;



import hooks.api.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




import org.hamcrest.Matchers;
import org.json.JSONArray;

import org.json.JSONObject;
import org.junit.Assert;
import testData.TestDataUS_033;

import utilities.ApiUtils;
import utilities.Authentication;

import java.util.HashMap;


import java.util.Map;
import java.util.ArrayList;


import static hooks.api.HooksAPI.spec;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;



import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;


import static utilities.ApiUtils.respHP;
import static utilities.ApiUtils.verifyInformationsOfResponseContentUS044;


public class APIStepDefinition {

    JSONObject reqBody;

    Response response1;



    //public static String fullPath;


    public static String fullPath;


    public static String silmeyin = "class";



    //************************** Emre ****************************************
    @Then("VisitorsPurpose icin Post request gonderilir.")
    public void visitorspurposeIcinPostRequestGonderilir() {


        /*
        {
            "visitors_purpose":"Veli Ziyareti",
            "description":"Veli Ziyareti İçin Gelindi"
        }
         */


        ApiUtils.emrePostMethod("Veli Ziyareti", "Veli Ziyareti İçin Gelindi");

        reqBody = new JSONObject();

        reqBody.put("visitors_purpose", "Veli Ziyareti");
        reqBody.put("description", "Veli Ziyareti İçin Gelindi");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response1.prettyPrint();


        ApiUtils.emrePostMethod("Veli Ziyareti", "Veli Ziyareti İçin Gelindi");

    }

    @Then("{string}, {string} icin Post request gonderilir.")
    public void icinPostRequestGonderilir(String VisitorPurpose, String Description) {

        ApiUtils.emrePostMethod(VisitorPurpose, Description);
    }

    @And("Validate the First Item of the Visitor Purpose List")
    public void validateTheFirstItemOfTheVisitorPurposeList() {

       // TestData_US001 testDataUs001=new TestData_US001();


        //JSONObject expData = testDataUs001.expData_US001();

        JSONObject reqBody1 = new JSONObject();

        reqBody1.put("id","2");

        TestData_US001 testDataUs001 = new TestData_US001();

        JSONObject expData = testDataUs001.expData_US001();

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody1.toString())
                .get(fullPath);

        response1.prettyPrint();
        response1.then().assertThat().body("lists.visitors_purpose",equalTo("Parent Teacher Meeting"))
                                      .body("lists.created_at",equalTo("2023-01-18 01:07:12"));


    }
    @And("Validate the content of the student information details lists")
    public void validateTheContentOfTheStudentInformationDetailsLists() {

        TestData_US057 testDataUs057 = new TestData_US057();

        JSONObject expData = testDataUs057.expData_US057();

        JSONObject reqBody1= new JSONObject();

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody1.toString())
                .get(fullPath);

        response1.prettyPrint();
        respHP=response1.as(HashMap.class);
        Assert.assertTrue(respHP.get("lists").toString().contains("pickup_point_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("route_pickup_point_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("transport_fees"));
        Assert.assertTrue(respHP.get("lists").toString().contains("app_key"));
        Assert.assertTrue(respHP.get("lists").toString().contains("parent_app_key"));
        Assert.assertTrue(respHP.get("lists").toString().contains("vehroute_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("route_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("vehicle_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("route_title"));
        Assert.assertTrue(respHP.get("lists").toString().contains("vehicle_no"));
        Assert.assertTrue(respHP.get("lists").toString().contains("room_no"));
        Assert.assertTrue(respHP.get("lists").toString().contains("driver_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("driver_contact"));
        Assert.assertTrue(respHP.get("lists").toString().contains("vehicle_model"));
        Assert.assertTrue(respHP.get("lists").toString().contains("manufacture_year"));
        Assert.assertTrue(respHP.get("lists").toString().contains("driver_licence"));
        Assert.assertTrue(respHP.get("lists").toString().contains("vehicle_photo"));
        Assert.assertTrue(respHP.get("lists").toString().contains("hostel_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("hostel_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("room_type_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("room_type"));
        Assert.assertTrue(respHP.get("lists").toString().contains("hostel_room_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("student_session_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("fees_discount"));
        Assert.assertTrue(respHP.get("lists").toString().contains("class_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("class"));
        Assert.assertTrue(respHP.get("lists").toString().contains("section_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("section"));
        Assert.assertTrue(respHP.get("lists").toString().contains("id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("admission_no"));
        Assert.assertTrue(respHP.get("lists").toString().contains("roll_no"));
        Assert.assertTrue(respHP.get("lists").toString().contains("admission_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("firstname"));
        Assert.assertTrue(respHP.get("lists").toString().contains("middlename"));
        Assert.assertTrue(respHP.get("lists").toString().contains("lastname"));
        Assert.assertTrue(respHP.get("lists").toString().contains("image"));
        Assert.assertTrue(respHP.get("lists").toString().contains("mobileno"));
        Assert.assertTrue(respHP.get("lists").toString().contains("email"));
        Assert.assertTrue(respHP.get("lists").toString().contains("state"));
        Assert.assertTrue(respHP.get("lists").toString().contains("city"));
        Assert.assertTrue(respHP.get("lists").toString().contains("pincode"));
        Assert.assertTrue(respHP.get("lists").toString().contains("note"));
        Assert.assertTrue(respHP.get("lists").toString().contains("religion"));
        Assert.assertTrue(respHP.get("lists").toString().contains("cast"));
        Assert.assertTrue(respHP.get("lists").toString().contains("house_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("dob"));
        Assert.assertTrue(respHP.get("lists").toString().contains("current_address"));
        Assert.assertTrue(respHP.get("lists").toString().contains("previous_school"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_is"));
        Assert.assertTrue(respHP.get("lists").toString().contains("parent_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("permanent_address"));
        Assert.assertTrue(respHP.get("lists").toString().contains("category_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("adhar_no"));
        Assert.assertTrue(respHP.get("lists").toString().contains("samagra_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("bank_account_no"));
        Assert.assertTrue(respHP.get("lists").toString().contains("bank_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("ifsc_code"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("father_pic"));
        Assert.assertTrue(respHP.get("lists").toString().contains("height"));
        Assert.assertTrue(respHP.get("lists").toString().contains("weight"));
        Assert.assertTrue(respHP.get("lists").toString().contains("measurement_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("mother_pic"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_pic"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_relation"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_phone"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_address"));
        Assert.assertTrue(respHP.get("lists").toString().contains("is_active"));
        Assert.assertTrue(respHP.get("lists").toString().contains("created_at"));
        Assert.assertTrue(respHP.get("lists").toString().contains("updated_at"));
        Assert.assertTrue(respHP.get("lists").toString().contains("father_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("father_phone"));
        Assert.assertTrue(respHP.get("lists").toString().contains("blood_group"));
        Assert.assertTrue(respHP.get("lists").toString().contains("school_house_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("father_occupation"));
        Assert.assertTrue(respHP.get("lists").toString().contains("mother_name"));
        Assert.assertTrue(respHP.get("lists").toString().contains("mother_phone"));
        Assert.assertTrue(respHP.get("lists").toString().contains("mother_occupation"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_occupation"));
        Assert.assertTrue(respHP.get("lists").toString().contains("gender"));
        Assert.assertTrue(respHP.get("lists").toString().contains("rte"));
        Assert.assertTrue(respHP.get("lists").toString().contains("guardian_email"));
        Assert.assertTrue(respHP.get("lists").toString().contains("username"));
        Assert.assertTrue(respHP.get("lists").toString().contains("user_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("dis_reason"));
        Assert.assertTrue(respHP.get("lists").toString().contains("dis_note"));
        Assert.assertTrue(respHP.get("lists").toString().contains("disable_at"));

    }

    @And("Validate the content of the homework lists")
    public void validateTheContentOfTheHomeworkLists() {

        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(0));

        Assert.assertEquals(listsJA.getJSONObject(0).get("id"),"423");
        Assert.assertEquals(listsJA.getJSONObject(0).get("class_id"),"4");
        Assert.assertEquals(listsJA.getJSONObject(0).get("section_id"),"3");
        Assert.assertEquals(listsJA.getJSONObject(0).get("session_id"),"18");
        Assert.assertEquals(listsJA.getJSONObject(0).get("staff_id"),"93");
        Assert.assertEquals(listsJA.getJSONObject(0).get("subject_group_subject_id"),"47");
        Assert.assertEquals(listsJA.getJSONObject(0).get("subject_id"),"4");
        Assert.assertEquals(listsJA.getJSONObject(0).get("homework_date"),"2023-07-25");
        Assert.assertEquals(listsJA.getJSONObject(0).get("submit_date"),"2023-07-28");
        //Assert.assertNull(listsJA.getJSONObject(0).get("marks"));
        Assert.assertEquals(listsJA.getJSONObject(0).get("description"),"<p>verilen testler yapilsin</p>");
        Assert.assertEquals(listsJA.getJSONObject(0).get("create_date"),"2023-07-24");
        Assert.assertEquals(listsJA.getJSONObject(0).get("evaluation_date"),"2023-08-04");
        //Assert.assertNull(listsJA.getJSONObject(0).get("document"));
        Assert.assertEquals(listsJA.getJSONObject(0).get("created_by"),"93");
        Assert.assertEquals(listsJA.getJSONObject(0).get("evaluated_by"),"117");
        Assert.assertEquals(listsJA.getJSONObject(0).get("created_at"),"2023-07-24 15:35:20");
        Assert.assertEquals(listsJA.getJSONObject(0).get("class"),"Class 4");
        Assert.assertEquals(listsJA.getJSONObject(0).get("section"),"C");
        Assert.assertEquals(listsJA.getJSONObject(0).get("subject_name"),"Mathematics");
        Assert.assertEquals(listsJA.getJSONObject(0).get("subject_groups_id"),"7");
        Assert.assertEquals(listsJA.getJSONObject(0).get("name"),"Class 4th Subject Group");
        Assert.assertEquals(listsJA.getJSONObject(0).get("assignments"),"1");

/*
        JSONObject reqBody = new JSONObject();

        reqBody.put("id", 798);

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response1.prettyPrint();
        response1.then().assertThat().body("lists.id",equalTo("798"))
                                    .body("lists.class_id",equalTo("1"))
                                    .body("lists.section_id",equalTo("1"))
                                    .body("lists.session_id",equalTo("18"))
                                    .body("lists.staff_id",equalTo("5"))
                                    .body("lists.subject_group_subject_id",equalTo("21"))
                                    .body("lists.subject_id",equalTo("1"))
                                    .body("lists.homework_date",equalTo("2022-07-05"))
                                    .body("lists.submit_date",equalTo("2022-07-08"))
                                    .body("lists.marks",equalTo(null))
                                    .body("lists.description",equalTo("<p>\\r\\n\\r\\nRead carefully\\r\\n\\r\\n<br></p>"))
                                    .body("lists.create_date",equalTo("2022-07-01"))
                                    .body("lists.evaluation_date",equalTo("0000-00-00"))
                                    .body("lists.document",equalTo(""))
                                    .body("lists.created_by",equalTo("95"))
                                    .body("lists.evaluated_by",equalTo("95"))
                                    .body("lists.created_at",equalTo("2023-08-16 05:35:57"))
                                    .body("lists.class",equalTo("Class 1"))
                                    .body("lists.section",equalTo("A"))
                                    .body("lists.subject_name",equalTo("English"))
                                    .body("lists.subject_groups_id",equalTo("4"))
                                    .body("lists.name",equalTo("Class 1st Subject Group"))
                                    .body("lists.assignments",equalTo("0"));

*/

    }

    @And("Send a post request for visitor purposeID")
    public void sendAPostRequestForVisitorPurposeID() {

        JSONObject reqBody = new JSONObject();

        reqBody.put("id", 9);

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .post(fullPath);

        response1.prettyPrint();
        respHP = response1.as(HashMap.class);
    }
    @And("Validate the content of the visitors purposeID")
    public void validateTheContentOfTheVisitorsPurposeID() {

        Assert.assertTrue(respHP.get("lists").toString().contains("id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("visitors_purpose"));
        Assert.assertTrue(respHP.get("lists").toString().contains("description"));
        Assert.assertTrue(respHP.get("lists").toString().contains("created_at"));
    }
    @And("Validate the new visitors purposeId")
    public void validateTheNewVisitorsPurposeId() {
        Assert.assertTrue(respHP.containsKey("addId"));
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
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("status", 200);
        expectedData.put("message", "Success");

        Assert.assertEquals(expectedData.get("status"), ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), ApiUtils.respHP.get("message"));








    }

    @Then("Execute a verification for an invalid authorization")
    public void executeAVerificationForAnInvalidAuthorization() {
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("status", 403);
        expectedData.put("message", "failed");

        Assert.assertEquals(expectedData.get("status"), ApiUtils.respHP.get("status"));
        Assert.assertEquals(expectedData.get("message"), ApiUtils.respHP.get("message"));


    }


    @Given("Response body content test for visitor list")
    public void response_body_content_test_for_visitor_list() {

        TestDataUS_033 testDataUs033 = new TestDataUS_033();

        HashMap<String, Object> expData = testDataUs033.expDataUS_033();

        JSONObject reqBody = new JSONObject();
        reqBody.put("id", "250");

        response1 = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .headers("Authorization", "Bearer " + HooksAPI.token)
                .when()
                .body(reqBody.toString())
                .get(fullPath);

        response1.prettyPrint();
        respHP = response1.as(HashMap.class);


        assertEquals(((Map) (expData.get("lists"))).get("id"), ((Map) (respHP.get("lists"))).get("id"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_id"), ((Map) (respHP.get("lists"))).get("staff_id"));
        assertEquals(((Map) (expData.get("lists"))).get("student_session_id"), ((Map) (respHP.get("lists"))).get("student_session_id"));
        assertEquals(((Map) (expData.get("lists"))).get("source"), ((Map) (respHP.get("lists"))).get("source"));
        assertEquals(((Map) (expData.get("lists"))).get("purpose"), ((Map) (respHP.get("lists"))).get("purpose"));
        assertEquals(((Map) (expData.get("lists"))).get("name"), ((Map) (respHP.get("lists"))).get("name"));
        assertEquals(((Map) (expData.get("lists"))).get("email"), ((Map) (respHP.get("lists"))).get("email"));
        assertEquals(((Map) (expData.get("lists"))).get("contact"), ((Map) (respHP.get("lists"))).get("contact"));
        assertEquals(((Map) (expData.get("lists"))).get("id_proof"), ((Map) (respHP.get("lists"))).get("id_proof"));
        assertEquals(((Map) (expData.get("lists"))).get("no_of_people"), ((Map) (respHP.get("lists"))).get("no_of_people"));
        assertEquals(((Map) (expData.get("lists"))).get("date"), ((Map) (respHP.get("lists"))).get("date"));
        assertEquals(((Map) (expData.get("lists"))).get("in_time"), ((Map) (respHP.get("lists"))).get("in_time"));
        assertEquals(((Map) (expData.get("lists"))).get("out_time"), ((Map) (respHP.get("lists"))).get("out_time"));
        assertEquals(((Map) (expData.get("lists"))).get("note"), ((Map) (respHP.get("lists"))).get("note"));
        assertEquals(((Map) (expData.get("lists"))).get("image"), ((Map) (respHP.get("lists"))).get("image"));
        assertEquals(((Map) (expData.get("lists"))).get("meeting_with"), ((Map) (respHP.get("lists"))).get("meeting_with"));
        assertEquals(((Map) (expData.get("lists"))).get("created_at"), ((Map) (respHP.get("lists"))).get("created_at"));
        assertEquals(((Map) (expData.get("lists"))).get("class"), ((Map) (respHP.get("lists"))).get("class"));
        assertEquals(((Map) (expData.get("lists"))).get("section"), ((Map) (respHP.get("lists"))).get("section"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_name"), ((Map) (respHP.get("lists"))).get("staff_name"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_surname"), ((Map) (respHP.get("lists"))).get("staff_surname"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_employee_id"), ((Map) (respHP.get("lists"))).get("staff_employee_id"));
        assertEquals(((Map) (expData.get("lists"))).get("class_id"), ((Map) (respHP.get("lists"))).get("class_id"));
        assertEquals(((Map) (expData.get("lists"))).get("section_id"), ((Map) (respHP.get("lists"))).get("section_id"));
        assertEquals(((Map) (expData.get("lists"))).get("students_id"), ((Map) (respHP.get("lists"))).get("students_id"));
        assertEquals(((Map) (expData.get("lists"))).get("admission_no"), ((Map) (respHP.get("lists"))).get("admission_no"));
        assertEquals(((Map) (expData.get("lists"))).get("student_firstname"), ((Map) (respHP.get("lists"))).get("student_firstname"));
        assertEquals(((Map) (expData.get("lists"))).get("student_middlename"), ((Map) (respHP.get("lists"))).get("student_middlename"));
        assertEquals(((Map) (expData.get("lists"))).get("student_lastname"), ((Map) (respHP.get("lists"))).get("student_lastname"));
        assertEquals(((Map) (expData.get("lists"))).get("role_id"), ((Map) (respHP.get("lists"))).get("role_id"));

    }

    @Given("POST request is sent for visitorId")
    public void post_request_is_sent_for_visitor_ıd() {

        ApiUtils.postRequestVisitorId();


    }

    @Given("Response body content test for visitor Id")
    public void response_body_content_test_for_visitor_ıd() {

        TestDataUS_033 testDataUs033 = new TestDataUS_033();

        HashMap<String, Object> expData = testDataUs033.expDataUS_033();


        assertEquals(((Map) (expData.get("lists"))).get("id"), ((Map) (respHP.get("lists"))).get("id"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_id"), ((Map) (respHP.get("lists"))).get("staff_id"));
        assertEquals(((Map) (expData.get("lists"))).get("student_session_id"), ((Map) (respHP.get("lists"))).get("student_session_id"));
        assertEquals(((Map) (expData.get("lists"))).get("source"), ((Map) (respHP.get("lists"))).get("source"));
        assertEquals(((Map) (expData.get("lists"))).get("purpose"), ((Map) (respHP.get("lists"))).get("purpose"));
        assertEquals(((Map) (expData.get("lists"))).get("name"), ((Map) (respHP.get("lists"))).get("name"));
        assertEquals(((Map) (expData.get("lists"))).get("email"), ((Map) (respHP.get("lists"))).get("email"));
        assertEquals(((Map) (expData.get("lists"))).get("contact"), ((Map) (respHP.get("lists"))).get("contact"));
        assertEquals(((Map) (expData.get("lists"))).get("id_proof"), ((Map) (respHP.get("lists"))).get("id_proof"));
        assertEquals(((Map) (expData.get("lists"))).get("no_of_people"), ((Map) (respHP.get("lists"))).get("no_of_people"));
        assertEquals(((Map) (expData.get("lists"))).get("date"), ((Map) (respHP.get("lists"))).get("date"));
        assertEquals(((Map) (expData.get("lists"))).get("in_time"), ((Map) (respHP.get("lists"))).get("in_time"));
        assertEquals(((Map) (expData.get("lists"))).get("out_time"), ((Map) (respHP.get("lists"))).get("out_time"));
        assertEquals(((Map) (expData.get("lists"))).get("note"), ((Map) (respHP.get("lists"))).get("note"));
        assertEquals(((Map) (expData.get("lists"))).get("image"), ((Map) (respHP.get("lists"))).get("image"));
        assertEquals(((Map) (expData.get("lists"))).get("meeting_with"), ((Map) (respHP.get("lists"))).get("meeting_with"));
        assertEquals(((Map) (expData.get("lists"))).get("created_at"), ((Map) (respHP.get("lists"))).get("created_at"));
        assertEquals(((Map) (expData.get("lists"))).get("class"), ((Map) (respHP.get("lists"))).get("class"));
        assertEquals(((Map) (expData.get("lists"))).get("section"), ((Map) (respHP.get("lists"))).get("section"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_name"), ((Map) (respHP.get("lists"))).get("staff_name"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_surname"), ((Map) (respHP.get("lists"))).get("staff_surname"));
        assertEquals(((Map) (expData.get("lists"))).get("staff_employee_id"), ((Map) (respHP.get("lists"))).get("staff_employee_id"));
        assertEquals(((Map) (expData.get("lists"))).get("class_id"), ((Map) (respHP.get("lists"))).get("class_id"));
        assertEquals(((Map) (expData.get("lists"))).get("section_id"), ((Map) (respHP.get("lists"))).get("section_id"));
        assertEquals(((Map) (expData.get("lists"))).get("students_id"), ((Map) (respHP.get("lists"))).get("students_id"));
        assertEquals(((Map) (expData.get("lists"))).get("admission_no"), ((Map) (respHP.get("lists"))).get("admission_no"));
        assertEquals(((Map) (expData.get("lists"))).get("student_firstname"), ((Map) (respHP.get("lists"))).get("student_firstname"));
        assertEquals(((Map) (expData.get("lists"))).get("student_middlename"), ((Map) (respHP.get("lists"))).get("student_middlename"));
        assertEquals(((Map) (expData.get("lists"))).get("student_lastname"), ((Map) (respHP.get("lists"))).get("student_lastname"));
        assertEquals(((Map) (expData.get("lists"))).get("role_id"), ((Map) (respHP.get("lists"))).get("role_id"));


    }

    @Given("POST request is sent for visitorAdd")
    public void post_request_is_sent_for_visitor_add() {

        ApiUtils.postRequestVisitorAdd();


    }

    @Given("Response body content test for visitor Add")
    public void response_body_content_test_for_visitor_add() {

        Assert.assertTrue(respHP.containsKey("addId"));

    }


    @Given("POST request is sent for questionDetailsById")
    public void post_request_is_sent_for_question_details_by_ıd() {

        ApiUtils.postRequestQuestionDetailsById();

    }


    // *********************** GUlten ***********************Baslangic//


    @Given("User sends a Patch request to end point with id {int}")
    public void user_sends_a_patch_request_to_end_point_with_id(Integer gulten) {

        ApiUtils.patchRequestGulten(gulten);
    }

    @Given("User sends a Patch request to end point with id {int} and compare id with response id")
    public void user_sends_a_patch_request_to_end_point_with_id_and_compare_id_with_response_id(Integer gulten) {
        ApiUtils.patchRequestGulten(gulten);
        Assert.assertEquals(respHP.get("updateId"), gulten);

    }

    @Given("User sends a POST request to alumniEventsId")
    public void user_sends_a_post_request_to_alumni_events_id() {

        ApiUtils.gultenPostUser11();


    }

    @Given("Response body content test for vehicle list")
    public void response_body_content_test_for_vehicle_list() {

        ApiUtils.gultenGetUS13();

        ApiUtils.response.then().assertThat()
                .body("lists.id", Matchers.equalTo("1"))
                .body("lists.vehicle_no", equalTo("VH1001"))
                .body("lists.vehicle_model", equalTo("Volvo Bus"))
                .body("lists.vehicle_photo", equalTo("1677502387-149436744063fca7b3a1796!fd.png"))
                .body("lists.manufacture_year", equalTo("2017"))
                .body("lists.registration_number", equalTo("FVFF-08797865"))
                .body("lists.chasis_number", equalTo("45453"))
                .body("lists.max_seating_capacity", equalTo("50"))
                .body("lists.driver_name", equalTo("Michel"))
                .body("lists.driver_licence", equalTo("R534534"))
                .body("lists.driver_contact", equalTo("8667777869"))
                .body("lists.note", equalTo(""))
                .body("lists.created_at", equalTo("2023-02-27 07:53:07"));


    }

    @Given("User sends a POST request to vehicleId")
    public void user_sends_a_post_request_to_vehicle_id() {
        ApiUtils.gultenGetUS14();

    }

    @Given("Response body content test for vehicleId")
    public void response_body_content_test_for_vehicle_id() {
        /*
        "id": "7",
        "vehicle_no": "VH4584",
        "vehicle_model": "Ford CAB",
        "vehicle_photo": null,
        "manufacture_year": "2015",
        "registration_number": "FFG-76575676787",
        "chasis_number": "523422",
        "max_seating_capacity": "50",
        "driver_name": "Jasper",
        "driver_licence": "258714545",
        "driver_contact": "8521479630",
        "note": "",
        "created_at": "2023-08-06 10:31:17"
         */

        ApiUtils.response.then().assertThat()
                .body("lists", anything("id"))
                .body("lists", anything("vehicle_no"))
                .body("lists", anything("vehicle_model"))
                .body("lists", anything("vehicle_photo"))
                .body("lists", anything("manufacture_year"))
                .body("lists", anything("registration_number"))
                .body("lists", anything("anything"))
                .body("lists", anything("max_seating_capacity"))
                .body("lists", anything("driver_name"))
                .body("lists", anything("driver_licence"))
                .body("lists", anything("driver_contact"))
                .body("lists", anything("note"))
                .body("lists", anything("created_at"));
    }


    @Given("User sends a POST request for homeworkAdd")
    public void user_sends_a_post_request_for_homework_add() {
        ApiUtils.gultenPostUS45();
    }
    // *********************** GUlten ***********************Baslangic//


    @Then("Execute verification for given informations")
    public void executeVerificationForGivenInformations() {

        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(1));

        Assert.assertEquals(listsJA.getJSONObject(1).get("id"), "11");
        Assert.assertEquals(listsJA.getJSONObject(1).get("session"), "2017-18");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"), "no");
        Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"), "2017-04-20 02:41:37");
        Assert.assertEquals(listsJA.getJSONObject(1).get("updated_at"), "0000-00-00");

    }

    @Then("Validate the First Item of the Book Issue  List")
    public void validate_the_first_ıtem_of_the_book_ıssue_list() {

        JsonPath resJP = ApiUtils.response.jsonPath();
        ArrayList listsArr = resJP.getJsonObject("lists");
        JSONArray listsJA = new JSONArray(listsArr);
        System.out.println(listsJA.get(1));

        Assert.assertEquals(listsJA.getJSONObject(1).get("id"), "7");
        Assert.assertEquals(listsJA.getJSONObject(1).get("book_id"), "3");
        Assert.assertEquals(listsJA.getJSONObject(1).get("member_id"), "9");
        Assert.assertEquals(listsJA.getJSONObject(1).get("duereturn_date"), "2021-05-06");
        Assert.assertEquals(listsJA.getJSONObject(1).get("issue_date"), "2021-05-04");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_returned"), "0");
        Assert.assertEquals(listsJA.getJSONObject(1).get("is_active"), "no");
        Assert.assertEquals(listsJA.getJSONObject(1).get("created_at"), "2021-05-04 02:56:46");


    }


    @Then("User sends a POST request for start date {string} and end date {string}")
    public void userSendsAPOSTRequestForStartDateAndEndDate(String start, String end) {
        ApiUtils.postMethodEventsByDateRange(start, end);
    }


    @Then("User sends a PATCH request to visitorsUpdate endpoint")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpoint() {
        ApiUtils.patchRequestVisitorsUpdateOgun();
    }


    @Then("User sends a PATCH request to  alumniUpdate endpoint")
    public void user_sends_a_patch_request_to_alumni_update_endpoint() {

        ApiUtils.reqbodyUS_026();


    }


    @Then("Expected data is created, and the equality of the ID information is verified.")
    public void expected_data_is_created_and_the_equality_of_the_id_information_is_verified() {
        ApiUtils.responseUS_026();
    }


    @Then("To create a new body that contains the valid authorization information and correct data")
    public void to_create_a_new_body_that_contains_the_valid_authorization_information_and_correct_data() {
        ApiUtils.postRequestUS_27();
        ApiUtils.deleteMethod1();


    }

    @Given("verification of id in delete request body")
    public void verification_of_ıd_ın_delete_request_body() {

        Assert.assertTrue(respHP.containsKey("DeletedId"));


    }

    @Then("Validate the content of the lists in the response")
    public void validateTheContentOfTheListsInTheResponse() {
        ApiUtils.validateTheListOfTheContentUS007();

    }

    @Then("Validate the content of the data in the response body")
    public void validateTheContentOfTheDataInTheResponseBody() {
        ApiUtils.validateTheContentOfTheListUS008();
    }

    @Then("User sends a POST request for id {int}")
    public void userSendsAPOSTRequestForId(int ident) {
        ApiUtils.postRequestAlumniEventsIDUS009(ident);
    }

    @Then("Validate content of the response body")
    public void validateContentOfTheResponseBody() {
        ApiUtils.validateContentOfTheResponseUS009();
    }

    @Then("User sends a POST request to visitorsId endpoint")
    public void userSendsAPOSTRequestToVisitorsIdEndpoint() {
        ApiUtils.postVisitorsIdUS036();
    }

    @Then("User sends a PATCH request to visitorsUpdate endpoint with id {int}")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpointWithId(int ident) {
        ApiUtils.patchRequestVisitorsUpdateOgun(ident);
    }

    @Then("User sends a PATCH request to visitorsUpdate endpoint with id {int} and compare id with response id")
    public void userSendsAPATCHRequestToVisitorsUpdateEndpointWithIdAndCompareIdWithResponseId(int ident) {
        ApiUtils.patchRequestVisitorsUpdateOgun(ident);
        Assert.assertEquals(respHP.get("updatedId"), ident);
    }

    @Then("User sends a POST request to create a visitor")
    public void userSendsAPOSTRequestToCreateAVisitor() {
        ApiUtils.createVisitorUS0037();
    }

    @Then("User sends a DELETE request")
    public void userSendsADELETERequest() {
        ApiUtils.deleteVisitorUS0037();
    }

    @Then("User sends a DELETE request and compare the ids in request and response body")
    public void userSendsADELETERequestAndCompareTheIdsInRequestAndResponseBody() {
        ApiUtils.deleteVisitorUS0037();
        Assert.assertEquals(ApiUtils.addId, respHP.get("deletedId"));
    }

    @Then("User sends a POST request to check the latest created visitor")
    public void userSendsAPOSTRequestToCheckTheLatestCreatedVisitor() {

        ApiUtils.postVisitorIDUS0037();
    }

    @Then("User sends a POST request to homeworkById page")
    public void userSendsAPOSTRequestToHomeworkByIdPage() {
        ApiUtils.postRequestUS044();
    }

    @Then("Validate the informations in response body")
    public void validateTheInformationsInResponseBody() {
        verifyInformationsOfResponseContentUS044();
    }

    @Then("Validate the content of the getStudentClass Response Body")
    public void validateTheContentOfTheGetStudentClassResponseBody() {
        ApiUtils.verifyContentOfResponseUS059();
    }







    @Then("User sends a get POST request to bookIssueId")
    public void userSendsAGetPOSTRequestToBookIssueId() {

    }

    @And("Validate the First Item of the Book Issue Id")
    public void validateTheFirstItemOfTheBookIssueId() {
        Assert.assertTrue(respHP.get("lists").toString().contains("id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("book_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("member_id"));
        Assert.assertTrue(respHP.get("lists").toString().contains("duereturn_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("return_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("issue_date"));
        Assert.assertTrue(respHP.get("lists").toString().contains("is_active"));
        Assert.assertTrue(respHP.get("lists").toString().contains("created_at"));
    }

    @And("Validate the First Item of the Book Issue Post")
    public void validateTheFirstItemOfTheBookIssuePost() {

    }


    @Then("User send a patch request to homework update  with id {int}")
    public void userSendAPatchRequestToHomeworkUpdateWithId(int id_number) {
        ApiUtils.pageRequestus046(id_number);
    }

    @Then("User send a patch request to homework update  with id {int} and compare id with response id")
    public void userSendAPatchRequestToHomeworkUpdateWithIdAndCompareIdWithResponseId(int id_number) {
        ApiUtils.pageRequestus046(id_number);
        Assert.assertEquals(id_number, respHP.get("updatedId"));
    }

    @Then("User send a post request to homeworkbyId")
    public void userSendAPostRequestToHomeworkbyId() {
        ApiUtils.postRequestus46();
    }


}
















