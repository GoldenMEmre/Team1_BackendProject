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



















}
