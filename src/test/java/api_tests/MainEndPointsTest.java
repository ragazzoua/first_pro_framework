package api_tests;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import properties.ProjectProperties;

import static constants.CosmosIdApiConstants.Paths.*;
import static constants.CosmosIdApiConstants.ResponseCodes.CODE_200;
import static constants.CosmosIdApiConstants.ValueFromResponse.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utils.ApiQueryParamsUtils.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class MainEndPointsTest extends BaseApiTest {
    public static final String SUCCESS = "Success";
    public static final int FILES_COUNT = 58;
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
                .statusCode(CODE_200)
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/authorizationSchema.json"));
    }

    @Test
    public void getFilesCountFromFolderTest() {
        given().header(X_TOKEN, token)
                .queryParams(getCountQueryParams())
                .when()
                .get(FILES_PATH_V2 + COUNT)
                .then()
                .statusCode(CODE_200)
                .body(TOTAL, equalTo(FILES_COUNT))
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/countSchema.json"));
    }

    @Test
    public void getFilesFromRootFolderTest() {
        given().header(X_TOKEN, token)
                .queryParams(getQueryFilesParams())
                .when()
                .get(FILES_PATH_V2)
                .then()
                .statusCode(CODE_200)
                .body(ITEMS_NAME_0, equalTo("Example_Datasets"))
                .and()
                .body(NAME, equalTo("ROOT"))
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/rootFolderSchema.json"));
    }

    @Test
    public void getRunsTest() {
        given().header(X_TOKEN, token)
                .queryParams(getRunQueryParams())
                .when()
                .get(FILES_PATH_V1 + RUNS_VALUE + RUNS)
                .then()
                .statusCode(CODE_200)
                .body(RUNS_STATUS_0, equalTo(SUCCESS))
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/runsSchema.json"));
    }

    @Test
    public void getAnalysisTest() {
        given().header(X_TOKEN, token)
                .queryParams(getAnalysisQueryParams())
                .when()
                .get(RUNS_PATH + ARTIFACTS_VALUE + ANALYSIS)
                .then()
                .statusCode(CODE_200)
                .body(ANALYSIS_STATUS_0, equalTo(SUCCESS))
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/analysisSchema.json"));
    }

    @Test
    public void getArtifactsTest() {
        given().header(X_TOKEN, token)
                .queryParams(getArtifactsQueryParams())
                .when()
                .get(RUNS_PATH + ARTIFACTS_VALUE + ARTIFACTS)
                .then()
                .statusCode(CODE_200)
                .body(ARTIFACTS_ARTIFACT_TYPE_0, equalTo("ura"))
                .and()
                .body(ARTIFACTS_ARTIFACT_TYPE_1, equalTo("fastqc"))
                .and()
                .body(matchesJsonSchemaInClasspath("schemas/artifactsSchema.json"));

    }
}