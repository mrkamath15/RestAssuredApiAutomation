package testCases;

import baseRequest.BaseRequest;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MultipleHeaders extends BaseRequest {
    @Test
    public void headersAsString() {
        given().headers("H1", "V1", "H2", "V2")
                .spec(spec)
                .log().headers()
                .when().get("user")
                .then()
                .statusCode(200);
    }

    @Test
    public void headersAsMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("H3", "V3");
        map.put("H4", "V4");

        given().headers(map).log().headers().spec(spec)
                .when().get("user")
                .then().statusCode(200);
    }

    @Test
    public void headersAsClass() {
        Header h1 = new Header("H5", "V5");
        Header h2 = new Header("H6", "V6");
        Headers headers = new Headers(h1, h2);

        given().spec(spec).headers(headers).log().headers()
                .when().get("user")
                .then().statusCode(200);
    }
}
