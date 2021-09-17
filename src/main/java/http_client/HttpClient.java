package http_client;

import static io.restassured.RestAssured.given;


public class HttpClient {

    public static void sendGetRequest(String url) {
        given().get(url)
                .then()
                .extract()
                .response();
    }

    public static void sendPostRequest(String url, String body) {
        given().body(body)
                .when()
                .post(url);
    }

    public static void sendDeleteRequest(String url, String body) {
        given().body(body)
                .when()
                .delete(url);
    }

    public static void sendPutRequest(String url, String body) {
        given().body(body)
                .when()
                .put(url);
    }

    public static void sendOptionsRequest(String url, String body) {
        given().body(body)
                .when()
                .options(url);
    }
}
