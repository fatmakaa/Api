package practice;

import base_urls.PracticeBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


public class get_practice extends PracticeBaseUrl {


    @Test
    public void get(){
        spec.pathParam("first","productsList");

        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();

        // Assertion
        response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);


    }



//    API URL: https://automationexercise.com/api/productsList
//    Request Method: POST
//    Response Code: 405
//    Response Message: This request method is not supported.
//
//{
//    "id": 9,
//        "name": "ABC ABC",
//        "price": "Rs. 1900",
//        "brand": "Madame",
//        "category": {
//    "usertype": {
//        "usertype": "Women"
//    },
//    "category": "Dress"
//}
//},
//


    @Test
    public void get2(){
        spec.pathParam("first","productsList");

        String payLoad = "{\n" +
                "    \"id\": 9,\n" +
                "    \"name\": \"ABC ABC\",\n" +
                "    \"price\": \"Rs. 1900\",\n" +
                "    \"brand\": \"Madame\",\n" +
                "    \"category\": {\n" +
                "        \"usertype\": {\n" +
                "            \"usertype\": \"Women\"\n" +
                "        },\n" +
                "        \"category\": \"Dress\"\n" +
                "    }\n" +
                "}";


       Response response = given(spec).body(payLoad).when().post("{first}");
       response.prettyPrint();


        // Assertion
       response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);


        JsonPath json = response.jsonPath();

      //  assertTrue(response.body().asString().contains("This request method is not supported."));

        assertEquals("This request method is not supported.",json.getString("message"));
        assertEquals(405,json.getInt("responseCode"));








   }




   //    API URL: https://automationexercise.com/api/brandsList
//    Request Method: GET
//    Response Code: 200
//    Response JSON: All brands list


    @Test
    public void get03(){


        spec.pathParam("first","brandsList");

        Response response =  given(spec).when().get("{first}");

        response.prettyPrint();

        //Assertion

        response.then()
                .statusCode(200)
                .contentType(ContentType.HTML);


    }

//    API URL: https://automationexercise.com/api/searchProduct
//    Request Method: POST
//    Request Parameter: search_product (For example: top, tshirt, jean)
//    Response Code: 200
//    Response JSON: Searched products list
//
//

    @Test
    public void test04(){


        spec.pathParam("first","searchProduct");

        Response response = given(spec).when().post();



    }

}
