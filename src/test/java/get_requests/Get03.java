package get_requests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class Get03 {
   /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
		And
		    Response format should be “application/json”
		And
		    “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		And
		    “completed” is false
		And
		    “userId” is 2
 */

    @Test
    public void get(){

        //  i) Set the Url
        String url = "https://jsonplaceholder.typicode.com/todos/23";

        //  ii) Set the Expected Data
        //  iii) Send Request And Get Response
        Response response = given().when().get(url);
        response.prettyPrint();
        //  iv)  Do Assertions

        // If we want our test to stop execution when it encounters a wrong assertion use "Hard Assertiom
        // If you write seperate body() method for each assertion ----> "hard assertion
//        response.then().
//                statusCode(200).
//                contentType(ContentType.JSON).
//                body("title",equalTo("etu itaque necessitatibus maxime molestiae qui quas velit")).
//                body("completed",equalTo(true)).
//                body("userId",equalTo(21));

        // If you want your test to continue execution even after finding wrong assertion, use "Soft Assertion"
        // If you write single body() method for each assertion ---------> "Soft Assertion"

        
        response.then().
                statusCode(200).
                contentType(ContentType.JSON) .
                body("title",equalTo("etu itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(true),
                        "userId",equalTo(2));

    }


}