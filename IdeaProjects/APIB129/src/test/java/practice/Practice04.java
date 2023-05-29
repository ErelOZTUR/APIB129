package practice;

import base_urls.RegresInAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Practice04 extends RegresInAppBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    @Test
    public void test01() {
        //set the url
        spec.pathParam("first","unknown");
        //set the expected data
        //send the request and get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();
        //do assertion
        Assert.assertEquals(200,response.statusCode());

        //Print all pantone_values
        JsonPath jsonPath=response.jsonPath();
        List<Object> pantonelist=jsonPath.getList("data.pantone_value");
        System.out.println(pantonelist);

        //Print all ids greater than 3 on the console
        List<Object> greaterthan=jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println(greaterthan);

        //Assert that there are 3 ids greater than 3
        Assert.assertEquals(3,greaterthan.size());

        //Print all names whose ids are less than 3 on the console
        List<Object> smallerthan=jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println(smallerthan);

        //Assert that the number of names whose ids are less than 3 is 2
        Assert.assertEquals(2,smallerthan.size());
    }
}
