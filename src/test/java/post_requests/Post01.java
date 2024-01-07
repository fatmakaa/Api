package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;


public class Post01 extends JsonPlaceHolderBaseUrl {

       /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
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
    public void post() {
        //Set URL
        spec.pathParam("first", "todos");

        //Set expected data:

        String payLoad = "{ \n" +
                "         \"userId\": 55, \n" +
                "         \"title\": \"Tidy your room\",\n" +
                "         \"completed\": false \n" +
                "          }";


        //Sent Req and Get Resp
        Response response = given(spec).body(payLoad).when().post("{first}");
        response.prettyPrint();


        //Do Assertions:
        JsonPath json = response.jsonPath();
        assertEquals(201, response.statusCode());
        assertEquals("Tidy your room", json.getString("title"));
        assertEquals(false, json.getBoolean("completed"));
        assertEquals(201, json.getInt("id"));


    }

    @Test
    public void postMap() {
        //Set URL
        spec.pathParam("first", "todos");

        //Set expected data:
        Map<String, Object> payLoad = new HashMap<>();

        payLoad.put("userId", 55);
        payLoad.put("title", "Tidy your room");
        payLoad.put("completed", false);
        System.out.println("payLoad = " + payLoad);


        //Sent Req and Get Resp
        Response response = given(spec).body(payLoad).when().post("{first}"); //At this stage Serialization is taking place
        response.prettyPrint();                                                   //Serialization: process of converting Java Object to Json Object


        //Do Assertions:
//        JsonPath json =  response.jsonPath();
//        assertEquals(201,response.statusCode());
//        assertEquals("Tidy your room",json.getString("title"));
//        assertEquals(false,json.getBoolean("completed"));
//        assertEquals(201,json.getInt("id"));



        //Do Assertions:
        Map<String,Object> actualData = response.as(HashMap.class);  //De-serialization is taking place: process of converting Json Object to Java Object

        assertEquals(payLoad.get("title"), actualData.get("title"));
        assertEquals(payLoad.get("userId"), actualData.get("userId"));

    }
}