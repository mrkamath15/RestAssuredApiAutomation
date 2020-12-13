package testCases;

import baseRequest.BaseRequest;
import org.testng.annotations.Test;
import responsePojo.Data;
import responsePojo.UserDetails;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllData extends BaseRequest {

    @Test
    public void getAllDetails() {
        UserDetails details = given().spec(spec)
                .log().method()
                .log().uri()
                .when()
                .get("user")
                .then()
                .statusCode(200)
                .log().status()
                .log().body()
                .extract().response().as(UserDetails.class);

        System.out.println(details.getPer_page());
        System.out.println(details.getSupport().getUrl());

        for (Data data : details.getData()) {
            System.out.println(data.getName());
        }
    }

    @Test
    public void getAsArray() {
        Data[] data = given()
                .spec(spec)
                .when()
                .get("user")
                .then()
                .extract().jsonPath().getObject("data", Data[].class);

        for (Data eachData : data) {
            System.out.println(eachData.getColor());
        }
    }

    @Test
    public void getAsList() {
        List<Data> data = given()
                .spec(spec)
                .when().get("user")
                .then()
                .extract().jsonPath().getList("data", Data.class);
        for (Data eachData : data) {
            System.out.println(eachData.getYear());
        }
    }
}
