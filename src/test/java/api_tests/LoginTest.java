package api_tests;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import properties.ProjectProperties;

import static constants.ApiConstants.Paths.LOGIN;
import static constants.ApiConstants.Paths.VERSION_V1;
import static constants.ApiConstants.ResponseCodes.CODE_200;
import static io.restassured.RestAssured.given;

public class LoginTest extends BaseApiTest {
    String token;

    @BeforeClass
    public void init() {
        token = given().auth()
                .preemptive()
                .basic(ProjectProperties.getProperties().getProperty("name"), ProjectProperties.getProperties().getProperty("password"))
                .contentType(ContentType.JSON)
                .post(VERSION_V1 + LOGIN)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("token");
    }


    @Test
    public void basicPreemptiveAuthTest() {
        given().auth()
                .preemptive()
                .basic(ProjectProperties.getProperties().getProperty("name"), ProjectProperties.getProperties().getProperty("password"))
                .contentType(ContentType.JSON)
                .post(VERSION_V1 + LOGIN)
                .then()
                .statusCode(CODE_200);
    }

    @Test
    public void tokenAuthTest() {
        given().auth()
                .oauth2(token)
                .when()
                .get()
                .then()
                .statusCode(CODE_200);
    }
}
