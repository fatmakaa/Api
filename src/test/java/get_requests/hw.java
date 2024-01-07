package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;


public class hw extends JsonPlaceHolderBaseUrl {
      /*
            Given
            https://jsonplaceholder.typicode.com/users/1
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be "application/json"
		And
		    "name" is "Leanne Graham",
		And
		    "email" is "Sincere@april.biz"
        And
		    "city" is "Gwenborough"
		And
		    "lat" is "-37.3159"
        And
		    Company name  is "Romaguera-Crona"
     */



    @Test
    public void get(){

        //Set
        spec.pathParams("first","users",
                "second","1");

        // Set Expected Data
        // Send Request Get Response:
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();
        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertEquals("Leanne Graham",json.getString("name"));
        assertEquals("Sincere@april.biz",json.getString("email"));
        assertEquals("Gwenborough",json.getString("address.city"));
        assertEquals("-37.3159",json.getString("address.get[0]"));
        assertEquals("Romaguera-Crona",json.getString("company.name"));


    }

}
