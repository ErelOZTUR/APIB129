package practice;

import base_urls.RegresInAppBaseUrl;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Practice05 extends RegresInAppBaseUrl {
    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void test05() {
        //set the url
        spec.pathParam("first","users");
        //set the expected data
        Map<String,Object> expecteddata=new HashMap<>();
        expecteddata.put("name","morpheus");
        expecteddata.put("job","leader");
        expecteddata.put("id","496");
        expecteddata.put("createdAt","2023-05-29T10:16:03.059Z");
        System.out.println("expecteddata = " + expecteddata);

        //send the request and get the response
        Response response=given(spec).body(expecteddata).post("{first}");
        response.prettyPrint();

        //do assertion
        Map<String,Object> actualdata=response.as(HashMap.class);
        System.out.println("actualdata = " + actualdata);

        assertEquals(201, response.statusCode());
        assertEquals(expecteddata.get("completed"), actualdata.get("completed"));
        assertEquals(expecteddata.get("title"), actualdata.get("title"));
        assertEquals(expecteddata.get("userId"), actualdata.get("userId"));
      //  assertEquals(expecteddata.get("createdAt"), actualdata.get("createdAt"));
    }
}
