package baseRequest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BaseRequest {
    public static RequestSpecification spec;
    RequestSpecBuilder builder;

    @BeforeTest
    public void setUp() {
        builder = new RequestSpecBuilder();
        builder.setContentType("application/json");
        builder.setBaseUri("https://reqres.in/");
        builder.setBasePath("api");

        spec = builder.build();
    }
}
