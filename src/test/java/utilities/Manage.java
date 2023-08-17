package utilities;

public class Manage {
    private String query16="SELECT * FROM wonderworld_qa2.online_admissions ORDER BY admission_date DESC LIMIT 10;";

    public String getQuery16(){
        return query16;
    }

    private String query17="SELECT AVG(passing_percentage) FROM wonderworld_qa2.onlineexam;";

    public String getQuery17(){
        return query17;
    }



    private String query18="SELECT COUNT(DISTINCT student_session_id) FROM wonderworld_qa2.onlineexam_students;";

    public String getQuery18(){
        return query18;
    }


    private String query04 = "SELECT firstname AND lastname FROM wonderworld_qa3.students WHERE admission_no BETWEEN 18001 AND 18010;";
    public String getQuery04(){
        return query04;
    }
    private String query05="SELECT mother_name, mother_occupation\n" +
            "FROM wonderworld_qa3.students\n" +
            "WHERE lastname LIKE 'T%'";
    public String getQuery05(){
        return query05;
    }

    private String query06 = "SELECT roll_no\n" +
            "FROM wonderworld_qa3.students\n" +
            "WHERE father_occupation IN ('Doctor', 'Police')\n" +
            "ORDER BY roll_no DESC;";
    public  String getQuery06(){
        return query06;
    }

    private String query12 = "SELECT * FROM wonderworld_qa2.staff ORDER BY work_exp ASC LIMIT 5;";
public String getQuery12(){
        return query12;
}

        ///13
    private String emailFirstNameQuery ="SELECT email FROM wonderworld_qa2.online_admissions WHERE firstname LIKE '%a%'";
    public  String getEmailFirstNameQuery(){return emailFirstNameQuery;}

    private String query19="SELECT email FROM wonderworld_qa.students ORDER BY LENGTH(email) DESC LIMIT 5;";

    public String getQuery19(){return query19;}

    private String query20="SELECT name FROM wonderworld_qa.expenses ORDER BY amount DESC LIMIT 1;";

    public String getQuery20(){return query20;}

    private String query21= "INSERT INTO wonderworld_qa.general_calls VALUES (150,'team1sumeyra','21234512','2023-08-16','successed test','2023-08-15','50','olsun artik','the coming','2023-08-15');";

    public String getQuery21(){return query21;}





         //14

    private String bookTitleQuery = "SELECT book_title FROM wonderworld_qa2.books WHERE author IN ('Rubina Malik','Mien  Ali')";
     public String getBookTitleQuery(){return bookTitleQuery;}

    private String qtyQuery ="SELECT id FROM wonderworld_qa2.books WHERE qty BETWEEN 100 AND 500";

     public String getQtyQuery(){return qtyQuery;}

    private String us_22 ="Select name,id from income order by amount desc LIMIT 10";

     public String getUs_22(){return us_22;}







}
