package get_requests;

import TestData.HerokuAppTestData;
import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static TestData.HerokuAppTestData.herokuAppMapper;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
            I send GET Request to the url
        Then
            Response body should be like that;
                {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
     */

    @Test
    public void get(){

        //Set Url
        spec.pathParams("first","booking",
                "second","77");



        //Set Expected Data:
        Map<String, String> bookingMap = HerokuAppTestData.bookingDatesMapper("2018-01-01","2019-01-01");
        Map<String, Object> expectedData = herokuAppMapper("Jane","Doe",111, true,bookingMap,"Extra pillows please");


        System.out.println(expectedData);

        //Sent request and Get Response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do Assertions:
        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        //1. way
       // assertEquals(bookingMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        //assertEquals(bookingMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));


        //2. way
        JsonPath json = response.jsonPath();
        assertEquals(bookingMap.get("checkin"), json.getString("bookingdates.checkin"));
        assertEquals(bookingMap.get("checkout"),json.getString("bookingdates.checkout"));


    }
}
