package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjg1OTA3NTA0fQ.HA-zTF9SmAbzJcZfjpK2zgOWPegxXlr3qqTBURKD-4JN_uJDXBQRKXBlsmxqtVeRhDwGoTMgrStie-FKdE9KJQ").setBaseUri("https://gmibank.com").build();
    }
}
