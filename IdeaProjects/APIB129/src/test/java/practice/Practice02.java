package practice;

import base_urls.RegresInAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Practice02 extends RegresInAppBaseUrl {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    @Test
    public void test02() {
        //set the url
        spec.pathParams("first","users","second","23");
        //set the ecpected data
        //send the request and get the response
       Response response= given(spec).get("{first}/{second}");
       response.prettyPrint();
        //do assertion
        Assert.assertEquals(404,response.statusCode());
        Assert.assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        Assert.assertEquals("cloudflare", response.getHeader("Server"));
        assertTrue(response.as(HashMap.class).isEmpty());//Gelen body'yi map'e çevirip boş olduğunu doğruluyoruz.

    }
}
