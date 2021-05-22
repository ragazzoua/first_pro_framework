package api_tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import properties.ProjectProperties;

import static constants.ApiConstants.EndPoints.BASE_PATH;
import static constants.ApiConstants.EndPoints.BASE_URI;
import static constants.ApiConstants.ResponseCodes.CODE_200;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BaseApiTest {
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        requestSpecification = given().auth()
                .preemptive()
                .basic(ProjectProperties.getProperties().getProperty("name"), ProjectProperties.getProperties().getProperty("password"))
                .baseUri(BASE_URI)
                .basePath(BASE_PATH);

        RestAssured.requestSpecification = requestSpecification;

        responseSpecification = new ResponseSpecBuilder().expectStatusCode(CODE_200)
                .expectResponseTime(lessThan(4000L))
                .build();

        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;
    }
}
