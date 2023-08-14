package emreTestData;

import org.json.JSONObject;

import static org.testng.AssertJUnit.assertEquals;

public class TestData_US001 {

    public JSONObject data_US001(){

        JSONObject data = new JSONObject();
        data.put("id","1");
        data.put("visitors_purpose", "Marketing ");
        data.put("description", "");
        data.put("created_at","2023-01-18 01:07:12");

        return data;

    }

    public JSONObject expData_US001(){

        JSONObject expData = new JSONObject();
        expData.put("status",200);
        expData.put("message","Success");
        expData.put("Token_remaining_time",1143);
        expData.put("lists",data_US001());

        return expData;
    }



}
