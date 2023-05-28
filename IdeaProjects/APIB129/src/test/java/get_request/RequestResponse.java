package get_request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {

        //Get Request nasil yapilir
        String endPoint = "https://petstore.swagger.io/v2/pet/1456567";
        Response response = given().get(endPoint);
        response.prettyPrint();//methodu response i console yazdirir

        //Status code nasil yazilir
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        //Content type nasil yazdirilir
        System.out.println("response.contentType() = " + response.contentType());

        //Status Line nasil yazdirilir
        System.out.println("response.statusLine() = " + response.statusLine());

        //Header nasil yazdirilir
        System.out.println("response.headers() = " + response.headers());
        System.out.println("response.header(\"server\") = " + response.header("server"));
        System.out.println("response.header(\"server\") = " + response.header("Access-Control-Allow-Headers"));

        //Time nasil yazdirilir
        System.out.println("response.getTime() = " + response.getTime());


    }

}
