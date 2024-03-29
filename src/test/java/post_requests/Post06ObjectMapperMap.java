package post_requests;

import TestData.JsonPlaceHolderTestData;
import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static TestData.JsonPlaceHolderTestData.jsonPlaceHolderMapper;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Post06ObjectMapperMap extends JsonPlaceHolderBaseUrl {
       /*
   Given
     1) https://jsonplaceholder.typicode.com/todos
     2) {
         "userId": 55,
         "title": "Tidy your room",
         "completed": false
         }


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
    public void post() throws JsonProcessingException {
        // Set Url
        spec.pathParam("first","todos");


        // Set Expected Data
     Map<String,Object> payLoad = jsonPlaceHolderMapper(55,"Tidy your room",false);



     // Send request and get response
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();

      // Do assertion
        System.out.println("response.asString() = " + response.asString());
        Map<String,Object> actualData = new ObjectMapper().readValue(response.asString(), HashMap.class);
      //  Map<String , Object> actualData = response.as(HashMap.class);
        System.out.println("actualData = " + actualData);



        assertEquals(payLoad.get("userId"),actualData.get("userId"));
        assertEquals(payLoad.get("title"),actualData.get("title"));
        assertEquals(payLoad.get("completed"),actualData.get("completed"));

    }

}
