package api_tests;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import properties.ProjectProperties;

import static constants.CosmosIdApiConstants.Paths.*;
import static constants.CosmosIdApiConstants.ResponseCodes.CODE_200;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MainEndPointsTest extends BaseApiTest {

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
    public void getFilesCountFromFolderTest() {
        given().header("x-token", token)
                .when()
                .get(METAGENID + VERSION_V2 + FILES + COUNT + FOLDER_ID + "84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622828908054")
                .then()
                .statusCode(CODE_200)
                .body("total", equalTo(58));
    }

    @Test
    public void getFilesFromRootFolderTest() {
        given().header("x-token", token)
                .when()
                .get(METAGENID + VERSION_V2 + FILES + QUESTION_MARK + BREADCRUMBS + "=1&offset=0&limit=1000&_=1622700773180")
                .then()
                .statusCode(CODE_200)
                .body("items.name[0]", equalTo("Example_Datasets"));
    }
}