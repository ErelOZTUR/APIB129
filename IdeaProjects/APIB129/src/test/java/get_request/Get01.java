package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

      /*
       Given
           https://restful-booker.herokuapp.com/booking/23
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Content type should be "application/json"
       And
           Status Line should be "HTTP/1.1 200 OK"

       */

    @Test
    public void test01() {
        //Set the Url
        String url="https://restful-booker.herokuapp.com/booking/23";

        //Set the expected data --> bu kisim post ve put gibi body gerekekn ileriki testlerde yapilacak

        //Send the request and get the response...
        Response response =given().get(url);
        response.prettyPrint();

        //Do assertion
        response.then().//methodu ile response dogrular
                statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

        //yeni






























    }
}
