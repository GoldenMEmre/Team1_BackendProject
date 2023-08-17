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


















}
