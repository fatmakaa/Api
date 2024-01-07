import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class ApiRequest {


    public static void main(String[] args) {
        
            Response response =  given().when().get("https://petstore.swagger.io/v2/pet/1");

        // How to print response on console:
            // System.out.println("response = " + response);  // Prints reference of the response
               response.prettyPrint();

            // How to get Status Code:
            System.out.println("statusCode = " + response.statusCode());

            // How to get status line

            System.out.println("response.statusLine() = " + response.statusLine());

            // How to get Content Type:
            System.out.println("contentType = " + response.contentType());

            // How to get headers one by one:
            System.out.println("response.header Date = "   + response.header("Date"));
            System.out.println("response.header(\"server\") = " + response.header("server"));

            // How to get all headers:
            System.out.println();
            System.out.println("-----------Headers---------------");
            System.out.println( response.headers());

         // How to get response time:
            System.out.println("response time = " + response.time());


        }

    }