package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;

public class Post04 extends JsonPlaceHolderBaseUrl {
     /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post(){

        //Set Url
        spec.pathParam("first","todos");


        // Set Expected Data:

        JsonPlaceHolderPojo payLoad = new JsonPlaceHolderPojo(55,"Tidy your room",false);

        System.out.println("payLoad = " + payLoad);


        //Send Request And Get Response:
      Response response = given(spec).body(payLoad).when().post("{first}");
      response.prettyPrint();

      //



    }

}
