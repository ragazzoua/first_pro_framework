package api_tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.ApiConstants.ResponseCodes.CODE_400;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BaseApiTest {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        requestSpecification = given().auth().preemptive().basic("gl-procamp-2021@globallogic.com", "DXdUVEFNpHA8LXm");

        RestAssured.requestSpecification = requestSpecification;

        responseSpecification = new ResponseSpecBuilder().expectStatusCode(CODE_400)
                .expectResponseTime(lessThan(3000L))
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

    }
}
