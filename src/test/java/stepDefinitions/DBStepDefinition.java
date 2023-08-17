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
    String query17;
    String query18;
    ResultSet rs16;
    ResultSet rs17;
    ResultSet rs18;
    ResultSet rs13;
    ResultSet rs14;
    ResultSet rs15;
    ResultSet rs;
    Statement st;

    List<Object> UserEmailList= new ArrayList<>();
    Manage manage=new Manage();

    @Given("Database connection established")
    public void database_connection_established() {
        createConnection();
    }
    @Given("From the Users table,{string} data of the user whose {string} and {string} information is entered are retrieved")
    public void from_the_users_table_data_of_the_user_whose_and_information_is_entered_are_retrieved(String email, String firstName, String lastName) {
        String query= "SELECT email FROM u480337000_tlb_training.users where first_name='"+firstName+"' and last_name= '"+lastName+"';";
        UserEmailList=getColumnData(query,email);
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
        query16="SELECT * FROM wonderworld_qa2.online_admissions ORDER BY admission_date DESC LIMIT 10;";
    }
    @Given("The query is sent to online_admissions table and results are validated")
    public void the_query_is_sent_to_online_admissions_table_and_results_are_validated() throws SQLException {
        rs16 = DB_Utils.getStatement().executeQuery(manage.getQuery16());
        while (rs16.next()) {
            int id = rs16.getInt("id");
            String name=rs16.getNString("firstname");
            System.out.println(id +" "+ name);
        }

    }



        //---------------------------------------------------------


    @Given("Query17  is being prepared")
    public void query17_is_being_prepared() {
       query17 ="SELECT AVG(passing_percentage) FROM wonderworld_qa2.onlineexam;";
    }
    @Given("The query is sent to onlineexam and results are valıidated")
    public void the_query_is_sent_to_onlineexam_and_results_are_valıidated() throws SQLException {
        rs17 = DB_Utils.getStatement().executeQuery(manage.getQuery17());
        int expeceted17 =34;
        rs17.next();
        int actualRS17=rs17.getInt(1);
        assertEquals(expeceted17,actualRS17);
        System.out.println(actualRS17);

    }
     //---------------------------------------------------------------------------------------------------


    @Given("Query18 is being prepared")
    public void query18_is_being_prepared() {
         query18 ="SELECT COUNT(DISTINCT student_session_id) FROM wonderworld_qa2.onlineexam_students;";
    }
    @Given("The query is sent to onlineexam_students and results are validated.")
    public void the_query_is_sent_to_onlineexam_students_and_results_are_validated() throws SQLException {

        rs18 = DB_Utils.getStatement().executeQuery(manage.getQuery18());
        int expeceted18 =266;
        rs18.next();
        int actualRS18=rs18.getInt(1);
        assertEquals(expeceted18,actualRS18);

        System.out.println(actualRS18);
        }



    //13
    @Given("Online admission table query is prepared")
    public void online_admission_table_query_is_prepared() {
        manage.getEmailFirstNameQuery();
    }
    @Given("A query is sent to the admission table table and  tehe results are validated.")
    public void a_query_is_sent_to_the_admission_table_table_and_tehe_results_are_validated() throws SQLException {
       rs13=DB_Utils.getStatement().executeQuery(manage.getEmailFirstNameQuery());
       while (rs13.next()){
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
        rs14=DB_Utils.getStatement().executeQuery(manage.getBookTitleQuery());
        while (rs14.next()){
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
       rs15 =DB_Utils.getStatement().executeQuery(manage.getQtyQuery());
       while (rs15.next()){
           System.out.println(rs15.getInt("id"));
       }
    }



}






