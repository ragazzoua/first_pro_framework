package api_tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseApiTest {

    @Test
    public void basicPreemptiveAuthTests() {
        String s = given()
                .when()
                .get()
                .then()
                .statusCode(200).extract().asString();
        System.out.println(s);
    }

}
