package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class Post01 extends JsonPlaceHolderBaseUrl {

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
    public void post01() {

        //Set the url
        spec.pathParam("first","todos");

        //Set the expected data ==> Json dataya stringe cevirerek Java objesi olarak kullaniyoruz
        String payload = "{\n" +//String ile post yapmak kolay yontemdir fakat assert islemi icin tavsiye edilmez
                "\"userId\": 55,\n" +
                "\"title\": \"Tidy your room\",\n" +
                "\"completed\": false\n" +
                "}";

        //Send the request and get the response
        Response response = given(spec).body(payload).post("{first}");
        response.prettyPrint();

        //Do assertion
        assertEquals(201,response.statusCode());

        JsonPath jsonPath = response.jsonPath();
        assertEquals(55,jsonPath.getInt("userId"));
        assertEquals("Tidy your room",jsonPath.getString("title"));
        assertFalse(jsonPath.getBoolean("completed"));

    }


    @Test
    public void postMap() {

        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response=given(spec).body(expectedData).post("{first}");//Serialization işlemi yapıldı: Java objesi Jackson vasıtasıyla Json dataya çevrildi.
        response.prettyPrint();

        //Do assertion
        Map<String,Object>actualData=response.as(HashMap.class);//De-Serialization işlemi yapıldı: Json datayı Jackson vasıtasıyla Java objesi Map'e çevirdik.
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
    }
}
