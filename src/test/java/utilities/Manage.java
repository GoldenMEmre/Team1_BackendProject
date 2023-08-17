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


        ///13
    private String emailFirstNameQuery ="SELECT email FROM wonderworld_qa2.online_admissions WHERE firstname LIKE '%a%'";
    public  String getEmailFirstNameQuery(){return emailFirstNameQuery;}

         //14

    private String bookTitleQuery = "SELECT book_title FROM wonderworld_qa2.books WHERE author IN ('Rubina Malik','Mien  Ali')";
     public String getBookTitleQuery(){return bookTitleQuery;}

    private String qtyQuery ="SELECT id FROM wonderworld_qa2.books WHERE qty BETWEEN 100 AND 500";

     public String getQtyQuery(){return qtyQuery;}

    private String us_22 ="Select name,id from income order by amount desc LIMIT 10";

     public String getUs_22(){return us_22;}







}
