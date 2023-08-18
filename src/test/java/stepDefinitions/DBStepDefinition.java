package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DB_Utils;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.DB_Utils.*;

public class DBStepDefinition {
    int flag;
    String query16;
    String query04;
    String query05;
    String query06;
    String query17;
    String query18;
    String query10;
    String query11;
    String query12;


    String query01;
    String query02;
    String query03;
    ResultSet rs01;
    ResultSet rs02;
    ResultSet rs03;


    List<Object> UserEmailList = new ArrayList<>();
    Manage manage = new Manage();

    ResultSet rs16;
    ResultSet rs04;
    ResultSet rs17;
    int rs10;
    int rs11;
    ResultSet rs12;
    ResultSet rs18;
    ResultSet rs13;
    ResultSet rs14;
    ResultSet rs15;
    ResultSet rs;
    Statement st;
    String query7;
    ResultSet rs7;
    String query8;
    int rs8;
    String query9;
    int rs9;


    ResultSet rs05;
    ResultSet rs06;

    String query19;
    String query20;
    String query21;

    ResultSet rs19;
    ResultSet rs20;
    int rs21;


    @Given("Database connection established")
    public void database_connection_established() {
        createConnection();
    }

    @Given("From the Users table,{string} data of the user whose {string} and {string} information is entered are retrieved")
    public void from_the_users_table_data_of_the_user_whose_and_information_is_entered_are_retrieved(String email, String firstName, String lastName) {
        String query = "SELECT email FROM u480337000_tlb_training.users where first_name='" + firstName + "' and last_name= '" + lastName + "';";
        UserEmailList = getColumnData(query, email);
    }

    @Then("User's {string} data is verified")
    public void user_s_data_is_verified(String email) {
        assertTrue(UserEmailList.get(0).equals(email));

    }

    @Then("Database connection is closed")
    public void database_connection_is_closed() {
        DB_Utils.closeConnection();
    }


    //--------------------------------------------------------------------------------------

    @Given("Dataabase connection established.")
    public void dataabase_connection_established() {
        DB_Utils.createConnection();
    }

    @Given("Query16  is being prepared")
    public void query16_is_being_prepared() {
        query16 = "SELECT * FROM u168183796_qawonder.online_admissions ORDER BY admission_date DESC LIMIT 10;";
    }

    @Given("The query is sent to online_admissions table and results are validated")
    public void the_query_is_sent_to_online_admissions_table_and_results_are_validated() throws SQLException {
        rs16 = DB_Utils.getStatement().executeQuery(manage.getQuery16());
        while (rs16.next()) {
            int id = rs16.getInt("id");
            String name = rs16.getNString("firstname");
            System.out.println(id + " " + name);
        }

    }


    //---------------------------------------------------------


    @Given("Query17  is being prepared")
    public void query17_is_being_prepared() {
        query17 = "SELECT AVG(passing_percentage) FROM u168183796_qawonder.onlineexam;";
    }

    @Given("The query is sent to onlineexam and results are valıidated")
    public void the_query_is_sent_to_onlineexam_and_results_are_valıidated() throws SQLException {
        rs17 = DB_Utils.getStatement().executeQuery(manage.getQuery17());
        int expeceted17 = 34;
        rs17.next();
        int actualRS17 = rs17.getInt(1);
        assertEquals(expeceted17, actualRS17);
        System.out.println(actualRS17);

    }
    //---------------------------------------------------------------------------------------------------


    @Given("Query18 is being prepared")
    public void query18_is_being_prepared() {
        query18 = "SELECT COUNT(DISTINCT student_session_id) FROM u168183796_qawonder.onlineexam_students;";
    }

    @Given("The query is sent to onlineexam_students and results are validated.")
    public void the_query_is_sent_to_onlineexam_students_and_results_are_validated() throws SQLException {

        rs18 = DB_Utils.getStatement().executeQuery(manage.getQuery18());
        int expeceted18 = 266;
        rs18.next();
        int actualRS18 = rs18.getInt(1);
        assertEquals(expeceted18, actualRS18);

        System.out.println(actualRS18);

    }

    //***************************************************************************************************************
    @Given("Query01 is being prepared")
    public void query01_is_being_prepared() {
        query01 = "SELECT COUNT(*) AS user_count FROM u168183796_qawonder.chat_users WHERE create_staff_id = 1;";
    }


    @Given("The query is sent to chat_users table and results are validated")
    public void the_query_is_sent_to_chat_users_table_and_results_are_validated() throws SQLException {

        rs01 = DB_Utils.getStatement().executeQuery(query01);
        int expected01 = 11;
        rs01.next();
        int actualRS01 = rs01.getInt(1);
        assertEquals(expected01, actualRS01);

        System.out.println(actualRS01);
    }

    @Given("Query02 is being prepared")
    public void query02_is_being_prepared() {

        query02 = "SELECT id FROM u168183796_qawonder.class_sections WHERE class_id = section_id;";
    }

    @Given("The query is sent to class_sections table and results are validated")
    public void the_query_is_sent_to_class_sections_table_and_results_are_validated() throws SQLException {

        rs02 = DB_Utils.getStatement().executeQuery(query02);
        while (rs02.next()) {
            int id = rs02.getInt("id");
            System.out.println("ID: " + id);
        }
    }

    @Given("Query03 is being prepared")
    public void query03_is_being_prepared() {

        query03 = "SELECT email FROM u168183796_qawonder.students WHERE firstname = 'Brian' AND lastname = 'Kohlar';";
    }

    @Given("The query is sent to students table and results are validated")
    public void the_query_is_sent_to_students_table_and_results_are_validated() throws SQLException {

        rs03 = DB_Utils.getStatement().executeQuery(query03);
        String expected03 = "brain@gmail.com";
        rs03.next();
        String actualRS03 = rs03.getString(1);
        assertEquals(expected03, actualRS03);
        System.out.println(actualRS03);


    }
//*******************************************************************************************************************

    @Given("Query07  is being prepared")
    public void query07_is_being_prepared() {
        query7 = "SELECT * FROM u168183796_qawonder.users WHERE role = 'parent' ORDER BY user_id ASC";


    }

    @Given("The query is sent to parent validated")
    public void the_query_is_sent_to_parent_validated() throws SQLException {
        rs7 = DB_Utils.getStatement().executeQuery(manage.getQuery7());

    }

    @Given("Query08  is being prepared")
    public void query08_is_being_prepared() {
        query8 = "UPDATE u168183796_qawonder.topic SET name ='Gulten' WHERE id = 25;";


    }

    @Given("Query09  is being prepared")
    public void query09_is_being_prepared() {
        query9 = "INSERT INTO u168183796_qawonder.transport_route VALUES (800,'Ankara','5','successed test','yes','2023-08-15','2023-08-17');";

    }

    @Given("The query is sent to the transport_route table.")
    public void the_query_is_sent_to_the_transport_route_table() throws SQLException {

        rs9 = DB_Utils.getStatement().executeUpdate(query9);
    }

    //**************************** Ogün *****************************
    @Given("Query04  is being prepared")
    public void query04_is_being_prepared() {
        query04 = "SELECT firstname AND lastname FROM u168183796_qawonder.students WHERE admission_no BETWEEN 18001 AND 18010;";
    }


    //---------------------------------------------------------------------------------------------------


    @Given("Query10  is being prepared")
    public void query10_is_being_prepared() {
        query10 = "DELETE FROM u168183796_qawonder.visitors_book WHERE id=115;";
    }

    @Given("The query is sent to visitor books table and results are validated")
    public void the_query_is_sent_to_visitor_books_table_and_results_are_validated() throws SQLException {

        rs10 = DB_Utils.getStatement().executeUpdate(query10);

    }

    @Given("Query11  is being prepared")
    public void query11_is_being_prepared() {
        query11 = "UPDATE u168183796_qawonder.transport_feemaster SET fine_amount = '200.00' WHERE month = 'October';";

    }

    @Given("The query is sent to transport_feemaster table and results are validated")
    public void the_query_is_sent_to_transport_feemaster_table_and_results_are_validated() throws SQLException {
        rs11 = DB_Utils.getStatement().executeUpdate(query11);
    }

    @Given("Query12  is being prepared")
    public void query12_is_being_prepared() {
        query12 = "SELECT * FROM u168183796_qawonder.staff ORDER BY work_exp ASC LIMIT 5;";


    }

    @Given("The query is sent to staff work_exp table and results are validated")
    public void the_query_is_sent_to_staff_work_exp_table_and_results_are_validated() throws SQLException {
        rs12 = DB_Utils.getStatement().executeQuery(manage.getQuery12());
    }

    @Given("Query19  is prepared")
    public void query19_is_prepared() {

        query19 = "SELECT email FROM u168183796_qawonder.students ORDER BY LENGTH(email) DESC LIMIT 5;";

    }

    @Given("The query is sent to the Student table and the results are validated")
    public void the_query_is_sent_to_the_student_table_and_the_results_are_validated() throws SQLException {

        rs19 = DB_Utils.getStatement().executeQuery(manage.getQuery19());

        while (rs19.next()) {

            String email = rs19.getNString("email");
            System.out.println(email);
        }

    }

    //---------------------------------------------------------------------------------------------------

    @Given("Query20  is prepared")
    public void query20_is_prepared() {

        query20 = "SELECT name FROM u168183796_qawonder.expenses ORDER BY amount DESC LIMIT 1;";

    }

    @Given("The query is sent to the Expenses table and the results are validated")
    public void the_query_is_sent_to_the_expenses_table_and_the_results_are_validated() throws SQLException {

        rs20 = DB_Utils.getStatement().executeQuery(manage.getQuery20());

        String expectedName = "Jio-Network";
        rs20.next();

        String actualName = rs20.getNString("name");
        System.out.println(actualName);

        assertEquals(expectedName, actualName);

    }

    //---------------------------------------------------------------------------------------------------

    @Given("Query21  is prepared")
    public void query21_is_prepared() {

        query21 = "INSERT INTO u168183796_qawonder.general_calls VALUES (150,'team1sumeyra','21234512','2023-08-16','successed test','2023-08-15','50','olsun artik','the coming','2023-08-15');";

    }

    @Given("The query is sent to the general_calls table and the results are validated")
    public void the_query_is_sent_to_the_general_calls_table_and_the_results_are_validated() throws SQLException {

        rs21 = DB_Utils.getStatement().executeUpdate(manage.getQuery21());

        int verify = 0;
        if (rs21 > 0) {
            verify++;
        }
        assertEquals(verify, 1);
    }

    @Given("The query is sent to student table and results are validated")
    public void the_query_is_sent_to_student_table_and_results_are_validated() throws SQLException {
        rs04 = DB_Utils.getStatement().executeQuery(manage.getQuery04());

    }

    @Given("Query05  is being prepared")
    public void query05_is_being_prepared() {
        query05 = "SELECT mother_name, mother_occupation\n" +
                "FROM u168183796_qawonder.students\n" +
                "WHERE lastname LIKE 'T%'";
    }

    @Given("The query is sent to students mother_name mother_occupation table and results are validated")
    public void the_query_is_sent_to_students_mother_name_mother_occupation_table_and_results_are_validated() throws SQLException {
        rs05 = DB_Utils.getStatement().executeQuery(manage.getQuery05());
    }

    @Given("Query06  is being prepared")
    public void query06_is_being_prepared() {
        query06 = "SELECT roll_no\n" +
                "FROM u168183796_qawonder.students\n" +
                "WHERE father_occupation IN ('Doctor', 'Police')\n" +
                "ORDER BY roll_no DESC;";
    }

    @Given("The query is sent to father_occupation students table and results are validated")
    public void the_query_is_sent_to_father_occupation_students_table_and_results_are_validated() throws SQLException {
        rs06 = DB_Utils.getStatement().executeQuery(manage.getQuery06());
    }


    //13
    @Given("Online admission table query is prepared")
    public void online_admission_table_query_is_prepared() {
        manage.getEmailFirstNameQuery();
    }

    @Given("A query is sent to the admission table table and  tehe results are validated.")
    public void a_query_is_sent_to_the_admission_table_table_and_tehe_results_are_validated() throws SQLException {
        rs13 = DB_Utils.getStatement().executeQuery(manage.getEmailFirstNameQuery());
        while (rs13.next()) {
            System.out.println(rs13.getString("email"));
        }
    }


    ////////////////////////////////////////////14

    @Given("Author data query is prepared")
    public void author_data_query_is_prepared() {

        manage.getBookTitleQuery();
    }

    @Given("A query  is sent from  the  book table  to the  author data and the result are validated")
    public void a_query_is_sent_from_the_book_table_to_the_author_data_and_the_result_are_validated() throws SQLException {
        rs14 = DB_Utils.getStatement().executeQuery(manage.getBookTitleQuery());
        while (rs14.next()) {
            System.out.println(rs14.getString("book_title"));
        }







    }
    /////////////////////

    @Given("{string} being prepared.")
    public void being_prepared(String string) {

    }

    @Given("Query is executed and results are obtained.")
    public void query_is_executed_and_results_are_obtained() {


    }
    /////////////////////


    //15
    @Given("qty value query is prepared")
    public void qty_value_query_is_prepared() {

        manage.getQtyQuery();
    }

    @Given("A query is sent to the author data from the book table and the qty results are validated.")
    public void a_query_is_sent_to_the_author_data_from_the_book_table_and_the_qty_results_are_validated() throws SQLException {
        rs15 = DB_Utils.getStatement().executeQuery(manage.getQtyQuery());
        while (rs15.next()) {
            System.out.println(rs15.getInt("id"));
        }
    }


}






