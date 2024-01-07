package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PracticeBaseUrl {


    protected RequestSpecification spec;

    @Before
    public void setUp(){
        String url =  "https://automationexercise.com/api";
        spec = new RequestSpecBuilder().setBaseUri(url).build();

    }
}
