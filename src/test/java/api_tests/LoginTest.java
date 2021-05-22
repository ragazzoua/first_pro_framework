package api_tests;

import org.testng.annotations.Test;
import properties.ProjectProperties;

import static constants.ApiConstants.EndPoints.*;
import static io.restassured.RestAssured.given;

public class LoginTest {

    @Test
    public void basicPreemptiveAuthTests() {
        String s = given().auth().preemptive()
                .basic(ProjectProperties.getProperties().getProperty("name"),
                        ProjectProperties.getProperties().getProperty("password"))
                .when()
                .get(BASE_URI + BASE_PATH + VERSION + LOGIN)
                .then()
                .statusCode(200).extract().asString();
        System.out.println(s);
    }

}
