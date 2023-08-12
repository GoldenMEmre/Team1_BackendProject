package utilities;

public class Manage {
    private String query16="SELECT * FROM wonderworld_qa.online_admissions ORDER BY admission_date DESC LIMIT 10";

    public String getQuery16(){
        return query16;
    }
}
