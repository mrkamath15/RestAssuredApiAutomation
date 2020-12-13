package testCases;

import baseRequest.BaseRequest;
import org.testng.annotations.Test;
import responsePojo.Support;
import responsePojo.Data;
import responsePojo.SingleUserData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest extends BaseRequest {

    @Test
    public void getUser() {
        given()
                .spec(spec)
                .log().everything()
                .when()
                .get("/user/2")
                .then()
                .log().everything()
                .statusCode(200);
    }

    @Test
    public void getUser1() {
        given()
                .spec(spec)
                .log().uri()
                .log().method()
                .log().parameters()
                .when()
                .get("/user/2")
                .then()
                .log().body()
                .statusCode(200)
                .body("data.id", equalTo(2));
    }

    @Test
    public void getData() {
        Data data = given().spec(spec)
                .when().get("user/2")
                .then()
                .statusCode(200)
                .body("data.year", equalTo(2001))
                .extract().jsonPath().getObject("data", Data.class);

        System.out.println(data.getId());
        System.out.println(data.getPantone_value());
    }

    @Test
    public void getSupport() {
        Support support = given()
                .spec(spec)
                .when()
                .get("user/2")
                .then()
                .statusCode(200)
                .body("support.url", startsWith("https://"))
                .extract().jsonPath().getObject("support", Support.class);

        System.out.println(support.getUrl());
        System.out.println(support.getText());

    }

    @Test
    public void getAllDataSingleUser() {
        SingleUserData  singleUserData = given()
                .spec(spec)
                .when()
                .get("user/2")
                .then()
                .statusCode(200)
                .extract().response().as(SingleUserData.class);
        System.out.println(singleUserData.getData().getName());
        System.out.println(singleUserData.getSupport().getText());
    }
}
