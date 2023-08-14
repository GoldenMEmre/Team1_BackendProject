package emreTestData;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

public class TestData {

    TestData testData= new TestData();

    public HashMap dataBodyOlusturMap() {

        HashMap<String, Object> data = new HashMap<>();
        data.put("id", "1");
        data.put("visitors_purpose", "Marketing ");
        data.put("created_at", "2023-01-18 01:07:12");

        return data;

    }



}
