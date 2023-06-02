package get_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDateTekrar;
import pojos.BookingTekrarPojo;

import static io.restassured.RestAssured.given;

public class Get11tekrar extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/535
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
 		              {
                        "firstname": "John",
                        "lastname": "Smith",
                        "totalprice": 111,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2018-01-01",
                            "checkout": "2019-01-01"
                        },
                        "additionalneeds": "Breakfast"
                    }
     */

    @Test
    public void test01() {
        //sett the url
        spec.pathParams("first","booking","second",535);
        //set the expected data
        BookingTekrarPojo bookingTekrarPojo=new BookingTekrarPojo("2018-01-01","2019-01-01");
        BookingDateTekrar expectedData=new BookingDateTekrar("Smith",111,true,bookingTekrarPojo,"Breakfast");

        //send the request and get the response
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();
        //do asserttion
        BookingDateTekrar actualData=response.as(BookingDateTekrar.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(expectedData.getLastname(),actualData.getLastname());
        Assert.assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        Assert.assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        Assert.assertEquals(expectedData.isDepositpaid(),actualData.isDepositpaid());
        Assert.assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        Assert.assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());




    }
}
