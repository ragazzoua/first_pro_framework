package api_tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static constants.ApiConstants.Paths.BASE_PATH;
import static constants.ApiConstants.Paths.BASE_URI;
import static constants.ApiConstants.ResponseCodes.CODE_200;
import static org.hamcrest.Matchers.lessThan;

public class BaseApiTest {
    private static RequestSpecification projectRequestSpecification;
    private static ResponseSpecification projectResponseSpecification;

    @BeforeClass
    public void setup() {
        projectRequestSpecification = new RequestSpecBuilder().setBaseUri(BASE_URI)
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RestAssured.requestSpecification = projectRequestSpecification;

        projectResponseSpecification = new ResponseSpecBuilder().expectStatusCode(CODE_200)
                .expectResponseTime(lessThan(4000L))
                .build();

        RestAssured.requestSpecification = projectRequestSpecification;
        RestAssured.responseSpecification = projectResponseSpecification;
    }
}
