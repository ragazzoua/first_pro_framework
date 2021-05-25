package constants;

public class ApiConstants {

    public static final class ResponseCodes {
        public static final int CODE_200 = 200;
        public static final int CODE_201 = 201;
        public static final int CODE_400 = 400;
        public static final int CODE_500 = 500;
    }

    public static final class Paths {
        public static final String BASE_URI = "https://app.cosmosid.com";
        public static final String BASE_PATH = "/api";
        public static final String VERSION_V1 = "/v1";
        public static final String VERSION_V2 = "/v2";
        public static final String LOGIN = "/login";
        public static final String PROFILE = "/profile";
    }
}
