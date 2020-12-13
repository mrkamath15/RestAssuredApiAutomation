package testCases;

import baseRequest.BaseClassForLogging;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class LoggingTest extends BaseClassForLogging {

    @Test
    public void logFromBaseClassTest() {
        given().spec(spec)
                .when().get("user")
                .then().statusCode(200);
    }

    @Test
    public void logTest() {
        given().log().headers()
                .log().method()
                .log().uri()
                .log().ifValidationFails()
                .when().get("https://reqres.in/api/user")
                .then().statusCode(200).log().status().log().ifStatusCodeIsEqualTo(400);
    }
}
