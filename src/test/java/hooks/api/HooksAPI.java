package hooks.api;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.Authentication;
import utilities.ConfigReader;

public class HooksAPI {

    public static RequestSpecification spec;
    public static String token;

    @Before (order=0)
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

    }



}
