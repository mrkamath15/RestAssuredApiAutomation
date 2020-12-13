package testCases;

import baseRequest.BaseRequest;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import requestPojo.CreateUser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostTest extends BaseRequest {

    @Test
    public void postAsStringTest() {
        given()
                .spec(spec).log().body()
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\",\n" +
                        "    \"id\": \"890\",\n" +
                        "    \"createdAt\": \"2020-10-25T04:15:21.918Z\"\n" +
                        "}")
                .when()
                .post("users")
                .then().statusCode(201).log().body()
        .body("name", equalTo("morpheus"));
    }

    @Test
    public void postAsObject() {
        CreateUser createUser = new CreateUser();
        createUser.setName("Rajendra");
        createUser.setJob("Marketing expert");
        createUser.setId("345");
        createUser.setCreatedAt("2020-10-20T04:15:21.918Z");

        given().spec(spec).log().uri().log().body().body(createUser)
        .when().post("users").then().statusCode(201).body("name", equalTo("Rajendra")).log().status().log().body();
    }

    @Test
    public void postAsFile() throws IOException{
        FileInputStream create= null;
        try {
            create = new FileInputStream(new File("./src/test/resources/createUser.json"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        given().spec(spec).body(IOUtils.toString(create, "UTF-8")).log().body()
                .when().post("users")
                .then().statusCode(201).body("name", equalTo("Ambade"));
    }
}
