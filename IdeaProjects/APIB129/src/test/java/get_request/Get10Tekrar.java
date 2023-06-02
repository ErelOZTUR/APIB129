package get_request;
import base_urls.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get10Tekrar extends GoRestBaseUrl {

      /*
   Given

https://gorest.co.in/public/v1/users

   When
       User send GET Request
   Then
       The value of "pagination limit" is 10
   And
       The "current link" should be "
https://gorest.co.in/public/v1/users?page=1
"
   And
       The number of users should  be 10
   And
       We have at least one "active" status
   And
       "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Rev. Jay Shukla" are among the users
   And
       The female users are less than or equals to male users
       (Kadın kullanıcı sayısı erkek kullanıcı sayısından küçük yada eşit olamlı)
*/

    @Test
    public void test01() {
        //Set the url
        spec.pathParam("first","users");
        //Set the expected data

        //set the request and get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(200).body("meta.pagination.limit",equalTo(10),
                "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
        "data.id",hasSize(10),"data.status",hasItem("active"),"data.name ",hasItems("Chandira Agarwal", "Saroja Prajapat", "Abhirath Mehra VM"));


        JsonPath jsonPath = response.jsonPath();
        List<String> cinsiyet = jsonPath.getList("data.gender");
        System.out.println("cinsiyet = " + cinsiyet);

        int kadinSayisi=0;
        for (String w:cinsiyet) {
            if (w.equalsIgnoreCase("female")){
                kadinSayisi++;
            }
        }
        System.out.println("kadinSayisi = " + kadinSayisi);

        assertTrue(kadinSayisi<=cinsiyet.size()-kadinSayisi);


    }

    @Test
    public void test02() {
        //Set the url
        spec.pathParam("first","users");
        //Set the expected data

        //set the request and get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPath jsonPath = response.jsonPath();
       int kadinsayisi = jsonPath.getList("data.findAll{it.gender=='female'}").size();
        System.out.println(kadinsayisi);
        int erkeksayisi = jsonPath.getList("data.findAll{it.gender=='male'}").size();
        System.out.println(erkeksayisi);
        Assert.assertTrue(kadinsayisi<=erkeksayisi);

    }
}
