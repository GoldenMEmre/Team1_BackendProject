package utilities;

public class Manage {
    private String query16="SELECT * FROM wonderworld_qa.online_admissions ORDER BY admission_date DESC LIMIT 10";

    public String getQuery16(){
        return query16;
    }

    private String query17="SELECT AVG(passing_percentage) FROM wonderworld_qa.onlineexam";

    public String getQuery17(){
        return query17;
    }



    private String query18="SELECT COUNT(DISTINCT student_session_id) FROM wonderworld_qa.onlineexam_students;";

    public String getQuery18(){
        return query18;
    }


    private String query19="SELECT email FROM wonderworld_qa.students ORDER BY LENGTH(email) DESC LIMIT 5;";

    public String getQuery19(){return query19;}

    private String query20="SELECT name FROM wonderworld_qa.expenses ORDER BY amount DESC LIMIT 1;";

    public String getQuery20(){return query20;}

    private String query21= "INSERT INTO wonderworld_qa.general_calls VALUES (150,'team1sumeyra','21234512','2023-08-16','successed test','2023-08-15','50','olsun artik','the coming','2023-08-15');";

    public String getQuery21(){return query21;}



















}
