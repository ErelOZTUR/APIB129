package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class post01tekrar extends JsonPlaceHolderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void map() {
        //set the url
        spec.pathParam("first","todos");
        //set the expected data
        Map<String,Object> expecteddata=new HashMap<>();
        expecteddata.put("userId",55);
        expecteddata.put("title","Tidy your room");
        expecteddata.put("completed",false);
        expecteddata.put("id",201);
        System.out.println("expecteddata = " + expecteddata);
        //send the request and get the response
        Response response=given(spec).body(expecteddata).post("{first}");
        response.prettyPrint();
    }
}
