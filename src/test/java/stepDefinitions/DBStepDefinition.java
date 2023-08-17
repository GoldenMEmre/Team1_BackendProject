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
    ResultSet rs16;
    ResultSet rs04;
    ResultSet rs17;
    ResultSet rs18;
    Statement st;

    ResultSet rs05;
    ResultSet rs06;

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
        query16="SELECT * FROM wonderworld_qa.online_admissions ORDER BY admission_date DESC LIMIT 10";
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
       query17 ="SELECT AVG(passing_percentage) FROM wonderworld_qa.onlineexam";
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
         query18 ="SELECT DISTINCT student_session_id  FROM wonderworld_qa.onlineexam_students;";
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

        //**************************** Ogün *****************************
        @Given("Query04  is being prepared")
        public void query04_is_being_prepared() {
            query04 = "SELECT firstname AND lastname FROM wonderworld_qa3.students WHERE admission_no BETWEEN 18001 AND 18010;";
        }

    @Given("The query is sent to student table and results are validated")
    public void the_query_is_sent_to_student_table_and_results_are_validated() throws SQLException {
        rs04 = DB_Utils.getStatement().executeQuery(manage.getQuery04());

    }

    @Given("Query05  is being prepared")
    public void query05_is_being_prepared() {
        query05 = "SELECT mother_name, mother_occupation\n" +
                "FROM wonderworld_qa3.students\n" +
                "WHERE lastname LIKE 'T%'";
    }
    @Given("The query is sent to students mother_name mother_occupation table and results are validated")
    public void the_query_is_sent_to_students_mother_name_mother_occupation_table_and_results_are_validated() throws SQLException {
        rs05 = DB_Utils.getStatement().executeQuery(manage.getQuery05());
    }
    @Given("Query06  is being prepared")
    public void query06_is_being_prepared() {
        query06 = "SELECT roll_no\n" +
                "FROM wonderworld_qa3.students\n" +
                "WHERE father_occupation IN ('Doctor', 'Police')\n" +
                "ORDER BY roll_no DESC;";
    }
    @Given("The query is sent to father_occupation students table and results are validated")
    public void the_query_is_sent_to_father_occupation_students_table_and_results_are_validated() throws SQLException {
        rs06 = DB_Utils.getStatement().executeQuery(manage.getQuery06());
    }
    }






