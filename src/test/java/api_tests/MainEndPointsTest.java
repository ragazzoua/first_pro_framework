package api_tests;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import properties.ProjectProperties;

import static constants.CosmosIdApiConstants.Paths.*;
import static constants.CosmosIdApiConstants.ResponseCodes.CODE_200;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utils.ApiFilesUtils.ROOT_FOLDER;
import static utils.ApiFilesUtils.getQueryFilesParams;

public class MainEndPointsTest extends BaseApiTest {

    private String token;

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
        given().header(X_TOKEN, token)
                .when()
                .get(FILES_PATH + COUNT + FOLDER_ID + "84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622828908054")
                .then()
                .statusCode(CODE_200)
                .body("total", equalTo(58));
    }
//GET https://app.cosmosid.com/api/metagenid/v2/files/count?folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773179
    @Test
    public void getFilesFromRootFolderTest() {
        given().header(X_TOKEN, token)
                .queryParams(getQueryFilesParams())
                .when()
                .get(FILES_PATH)
                .then()
                .statusCode(CODE_200)
                .body("items.name[0]", equalTo("Example_Datasets"))
                .and()
                .body("name", equalTo(ROOT_FOLDER));
    }

    @Test
    public void getRunsTest() {
        given().header(X_TOKEN, token)
                .when()
                .get(METAGENID + VERSION_V1 + FILES + "/7f4c7326-0a4e-4b56-a8d0-8ce002191672/runs?_=1622700773181")
                .then()
                .statusCode(CODE_200)
                .body("runs.status[0]", equalTo("Success"));
    }

    @Test
    public void getAnalysisTest() {
        given().header(X_TOKEN, token)
                .when()
                .get(RUNS_PATH + "/437ef8e4-b595-4fd8-a2f5-64221831e925/analysis?filter=total&_=1622700773184")
                .then()
                .statusCode(CODE_200)
                .body("analysis.status[0]", equalTo("Success"));
    }

    @Test
    public void getArtifactsTest() {
        given().header(X_TOKEN, token)
                .when()
                .get(RUNS_PATH + "/437ef8e4-b595-4fd8-a2f5-64221831e925/artifacts?_=1622700773185")
                .then()
                .statusCode(CODE_200)
                .body("artifacts.artifact_type[0]", equalTo("ura"))
                .and()
                .body("artifacts.artifact_type[1]", equalTo("fastqc"));

    }
}