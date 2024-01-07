package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

    @Before  // "Before" makes the method to be executed before every @Test method
    public void setUp(){
        String url = "https://jsonplaceholder.typicode.com";
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(url).build();


  }
}