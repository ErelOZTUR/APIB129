package get_request;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {
     /*
 Given
     https://jsonplaceholder.typicode.com/todos
 When
     I send GET Request to the URL == > URL'e Get Request gonderin
 Then
     1)Status code is 200 == > Status kodu 200 olmali
     2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
       Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
     3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
       Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
     4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
       Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
       basliginin "delectus aut autem" icerdigini dogrulayin
*/

    @Test
    public void test01() {
        //Set the url
        spec.pathParam("first", "todos");


        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        Assert.assertEquals(200,response.statusCode());

        //Print all ids greater than 190 on the console
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getList("id"));
        List<Object> list= jsonPath.getList("findAll{it.id>190}.id");//Groovy language ==> Java temelli proglamlama dili
        System.out.println("list = " + list);

        //Assert that there are 10 ids greater than 190
        assertEquals(10,list.size());

       //Print all userIds whose ids are less than 5 on the console
        List<Object> userIdList=jsonPath.getList("findAll{it.id<5}.userId");
       System.out.println("userIdList = " + userIdList);

        //Assert that the number of userIds whose ids are less than 5 is 4
       assertEquals(4,userIdList.size());

        //Print all titles whose ids are less than 5
        List<Object> titleList=jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);
        //Exstra Ornek
      List<String> tit=  jsonPath.getList("findAll{it.title=='ipsam aperiam voluptates qui'}.id");
        System.out.println(tit);

        // Assert that "delectus aut autem" is one of the titles whose id is less than 5
      //  assertTrue(titleList.contains("delectus aut autem"));

    }

}
