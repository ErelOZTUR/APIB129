package post_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02tekrar extends HerOkuAppBaseUrl {
    /*
    Given
        1) https://restful-booker.herokuapp.com/booking
        2) {
             "firstname": "John",
             "lastname": "Doe",
             "totalprice": 11111,
             "depositpaid": true,
             "bookingdates": {
                 "checkin": "2021-09-09",
                 "checkout": "2021-09-21"
              }

           }
    When
        I send POST Request to the Url
    Then
        Status code is 200
        And response body should be like {
                                            "bookingid": 5315,
                                            "booking": {
                                                "firstname": "John",
                                                "lastname": "Doe",
                                                "totalprice": 11111,
                                                "depositpaid": true,
                                                "bookingdates": {
                                                    "checkin": "2021-09-09",
                                                    "checkout": "2021-09-21"
                                                }
                                            }
                                         }
 */

    @Test
    public void testpost02() {
        //set the url
        spec.pathParam("first","booking");
        //set the expected data
            HerOkuAppTestData obj=new HerOkuAppTestData();
        Map<String,String> bookingdatesMap=obj.bookingdatesMapMethod("2021-09-09","2021-09-21");
        Map<String,Object> expectedData=obj.expectedDataMapMethod("John","Doe",11111,true,bookingdatesMap,"");
        System.out.println("expectedData = " + expectedData);
        // send the request and get the responce
        Response response=given(spec).body(expectedData).contentType(ContentType.JSON).post("{first}");
        response.prettyPrint();
        //do assertion
        Map<String,Object> actualdata=response.as(HashMap.class);
        System.out.println("actualdata = " + actualdata);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.get("firstname"), ((Map)actualdata.get("booking")).get("firstname"));


    }
}
