package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Get02 {
    /*
    Given
    https://restful-booker.herokuapp.com/booking/0
When
    User send a GET Request to the url
Then
    HTTP Status code should be 404
And
    Status Line should be HTTP/1.1 404 Not Found
And
    Response body contains "Not Found"
And
    Response body does not contain "TechProEd"
And
    Server is "Cowboy"
     */


    @Test
    public void get(){
    // i) Set the Url
        String url = "https://restful-booker.herokuapp.com/booking/0";

     //   ii) Set the expected data
    //   iii) Send request and get response
       Response response = given().when().get(url);
       response.prettyPrint();
    //   iv) Do assertions
        response.
                then().statusCode(404).
                statusLine("HTTP/1.1 404 Not Found").header("server","Cowboy");

        // Response body contains "Not Found"
        assertTrue(response.asString().contains("Not Found"));


        // Response body does not contain "TechProEd"
        assertFalse(response.asString().contains("TechProEd"));

        // Server is "Cowboy"
        assertEquals("Cowboy",response.header("server"));



    }

}
