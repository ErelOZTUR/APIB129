package get_request;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class Get05 extends HerOkuAppBaseUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET request to the URL
    Then
        Status code is 200
And
   Among the data there should be someone whose firstname is "Sally" and last name is "Brown"
        (Data içerisinde firstname değeri "Sally", lastname değeri "Brown" olan biri olmalı)
 */

    @Test
    public void test01() {
        //Set the url
        spec.pathParam("first", "booking").
                queryParams("firstname", "Jhon", "lastname", "Smith");

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(200).body("bookingid",hasSize(greaterThan(0)));

        //yada
        Assert.assertTrue( response.asString().contains("bookingid"));


    }

}
